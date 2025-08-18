import java.io.*;

public class P10026 {
    static int n;
    static char[][] boardA, boardB;

    static boolean dfs(int x, int y, char z, char[][] board) {
        if (x < 0 || y < 0 || x >= n || y >= n) return false;
        if (board[x][y] != z) return false;

        board[x][y] = '#'; // 방문 표시
        dfs(x + 1, y, z, board);
        dfs(x - 1, y, z, board);
        dfs(x, y + 1, z, board);
        dfs(x, y - 1, z, board);
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());
        boardA = new char[n][n];
        boardB = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                boardA[i][j] = c;
                boardB[i][j] = (c == 'R') ? 'G' : c; // 적록색약 보드
            }
        }

        int cntA = 0, cntB = 0;
        char[] colors = {'R', 'G', 'B'};

        for (char color : colors) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(i, j, color, boardA)) cntA++;
                    if (dfs(i, j, color, boardB)) cntB++;
                }
            }
        }

        System.out.println(cntA + " " + cntB);
    }
}
