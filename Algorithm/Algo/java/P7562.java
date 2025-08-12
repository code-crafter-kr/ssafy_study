import java.util.*;
import java.io.*;

public class P7562 {
    public static boolean[][] visited;
    public static int answer;
    public static int[][] move = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 },
            { -2, -1 } };

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(new
        // FileInputStream("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            visited = new boolean[300][300];
            answer = 0;
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int goalRow = Integer.parseInt(st.nextToken());
            int goalCol = Integer.parseInt(st.nextToken());

            bfs(startRow, startCol, goalRow, goalCol, N);
        }

    }

    public static void bfs(int startRow, int startCol, int goalRow, int goalCol, int n) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] { startRow, startCol, 0 });

        while (!(dq.isEmpty())) {
            int[] currentPos = dq.pollFirst();
            int currentRow = currentPos[0];
            int currentCol = currentPos[1];

            if ((currentRow == goalRow) && (currentCol == goalCol)) {
                System.out.println(currentPos[2]);
                return;
            }

            if (visited[currentRow][currentCol])
                continue;

            visited[currentRow][currentCol] = true;

            for (int[] next : move) {
                int nextRow = currentRow + next[0];
                int nextCol = currentCol + next[1];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n) {
                    dq.add(new int[] { nextRow, nextCol, currentPos[2] + 1 });
                }
            }

        }

    }
}
