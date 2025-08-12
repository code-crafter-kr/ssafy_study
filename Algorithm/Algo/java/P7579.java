import java.util.*;
import java.io.*;

public class P7579 {
    public static int[][] nextPos = { { 1, 0, 0 }, { 0, 1, 0 }, { -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
    public static int goal;
    public static int current;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[H][N][M];
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        goal = M * N * H;
        current = 0;

        for (int x = 0; x < H; x++) { // 2
            for (int j = 0; j < N; j++) { // 3
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < M; i++) { // 5

                    map[x][j][i] = Integer.parseInt(st.nextToken());
                    if (map[x][j][i] == 1) {
                        current++;
                        dq.addLast(new int[] { x, j, i, 0 });

                    } else if (map[x][j][i] == -1) {
                        goal--;
                    }

                }
            }
        }

        // bfs를 굳이 안해도 토마토가 다 차있는 경우..
        if (current == goal) {
            System.out.println(0);
        } else {
            bfs(dq, goal, map, N, M, H);
        }
    }

    public static void bfs(ArrayDeque<int[]> dq, int goal, int[][][] map, int N, int M, int H) {

        while (!(dq.isEmpty())) {
            int[] currentPos = dq.pollFirst(); // 항상 토마토만 들어옴
            int currentHeight = currentPos[0];
            int currentRow = currentPos[1];
            int currentCol = currentPos[2];
            int currentDay = currentPos[3];

            for (int[] next : nextPos) {
                int nextRow = currentRow + next[0];
                int nextCol = currentCol + next[1];
                int nextHeight = currentHeight + next[2];

                // 유효성 검사
                if ((nextRow < 0) || (nextCol < 0) || (nextHeight < 0) || (nextRow >= N) || (nextCol >= M) || (nextHeight >= H)) 
                    continue; // 유효성 빗나가면 다음

                if (map[nextHeight][nextRow][nextCol] == 1) { // 이미 토마토면 상관없음
                    continue;
                }

                if (map[nextHeight][nextRow][nextCol] == -1) { // 토마토가 없는곳이여도 패스
                    continue;
                }

                map[nextHeight][nextRow][nextCol] = 1; // 토마토 번짐
                current++; // 익은 토마토 증가
                if (goal == current) { // 익은 토마토가 증가했는데 goal과 같으면 끝.
                    System.out.println(currentDay + 1);
                    return;
                }

                dq.addLast(new int[] { nextHeight, nextRow, nextCol, currentDay + 1 });
            }

        }
        System.out.println(-1);
    }
}