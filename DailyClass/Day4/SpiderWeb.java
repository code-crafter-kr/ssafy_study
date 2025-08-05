import java.util.Scanner;

public class SpiderWeb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] lst = new int[n][n];

        int final_row = 0;
        int final_col = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lst[i][j] = sc.nextInt();
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lst[i][j] != 1) { // 장애물에서 시작할 순 없음
                    int checked_area = checker(i, j, lst, n);
                    if (maxArea < checked_area){
                        final_row = i;
                        final_col = j;
                        maxArea = Integer.max(maxArea, checked_area);
                    }
                }
            }
        }

        System.out.println(maxArea);
        System.out.printf("%d,%d", final_row, final_col);
    }

    public static int checker(int row, int col, int[][] lst, int n) {
        int count = 1;

        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        int[] block_count = new int[8];

        for (int y = 0; y < 8; y++) {
            int nRow = row + dir[y][0];
            int nCol = col + dir[y][1];
            while (nRow >= 0 && nCol >= 0 && nRow < n && nCol < n && block_count[y] != 2) {
                if (lst[nRow][nCol] == 1) {
                    block_count[y]++;
                } else {
                    count++;
                    block_count[y] = 0;
                }
                if (block_count[y] == 2) break;
                nRow += dir[y][0];
                nCol += dir[y][1];
            }

        }
        return count;

    }
}
