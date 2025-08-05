
import java.io.FileInputStream;
import java.util.Scanner;

public class BuildingTest {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));  //
        Scanner sc = new Scanner(System.in);
        // Also, can use the code as below:
        // Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i < T + 1; i++) {
            int answer = 0;

            int n = sc.nextInt();
            sc.nextLine();

            String[][] lst = new String[n][n];
            for (int j = 0; j < n; j++) {
                String[] line = sc.nextLine().split(" ");
                for (int t = 0; t < n; t++) {
                    lst[j][t] = line[t];
                }
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int value = 0;
                    if (lst[row][col].equals("G")) {
                        continue;
                    } else if (lst[row][col].equals("B")) {
                        if (checker(row, col, lst, n)) { // 주변이 G면
                            value = 2;
                        } else {
                            value = counter(row, col, lst, n); // 주변에 G가 없으면 해당 row와 col에 있는 B개수의 합
                        }
                    }

                    answer = Math.max(answer, value);
                }
            }

            System.out.printf("\n#%d %d", i, answer);
        }
    }

    public static boolean checker(int x, int y, String lst[][], int n) {
        int[][] dir = { { 1, 0 }, { 1, 1 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, 0 }, { -1, -1 } };

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (!(nx < 0 || nx >= n || ny < 0 || ny >= n)) {
                if (lst[nx][ny].equals("G")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int counter(int x, int y, String lst[][], int n){
        int return_value = 0;

        for (int i = 0; i < n; i++) {
            if (lst[x][i].equals("B")) return_value++;            
        }

        for (int i = 0; i < n; i++) {
            if (lst[i][y].equals("B")) return_value++;
        }

        return return_value - 1;
    }
}