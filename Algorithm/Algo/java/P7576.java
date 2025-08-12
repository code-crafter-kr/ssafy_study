import java.util.*;
import java.io.*;

public class P7576 {
    public static int[][] nextPos = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    public static int goal;
    public static int current;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        goal = M * N;
        current = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    dq.addLast(new int[] { i, j, 0 });
                    current++;
                }
                if (map[i][j] == -1) {
                    goal -= 1;
                }
            }
        }
        // bfs를 굳이 안해도 토마토가 다 차있는 경우..
        if (current == goal) {
            System.out.println(0);
        } else {
            bfs(dq, goal, map, N, M);
        }
    }

    public static void bfs(ArrayDeque<int[]> dq, int goal, int[][] map, int N, int M) {

        while (!(dq.isEmpty())) {
            int[] currentPos = dq.pollFirst(); // 항상 토마토만 들어옴
            int currentRow = currentPos[0];
            int currentCol = currentPos[1];
            int currentDay = currentPos[2];

            for (int[] next : nextPos) {
                int nextRow = currentRow + next[0];
                int nextCol = currentCol + next[1];

                // 유효성 검사
                if ((nextRow < 0) || (nextCol < 0) || (nextRow >= N) || (nextCol >= M))
                    continue; // 유효성 빗나가면 다음

                if (map[nextRow][nextCol] == 1) { // 이미 토마토면 상관없음
                    continue;
                }

                if (map[nextRow][nextCol] == -1) { // 토마토가 없는곳이여도 패스
                    continue;
                }

                map[nextRow][nextCol] = 1; // 토마토 번짐
                current++; // 익은 토마토 증가
                if (goal == current) { // 익은 토마토가 증가했는데 goal과 같으면 끝.
                    System.out.println(currentDay + 1);
                    return;
                }

                dq.addLast(new int[] { nextRow, nextCol, currentDay + 1 });
            }

        }
        System.out.println(-1);
    }
}