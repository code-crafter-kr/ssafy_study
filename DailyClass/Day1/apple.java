package Day1;
import java.util.Scanner;

public class apple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int[][] lst = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                lst[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = 0;

        int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        // int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 가능
        // int[][] dir = new int[4][2] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 불가능

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = lst[i][j];
                for (int[] d : dir) {
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                        value += lst[ni][nj];
                    }
                }
            result = Math.max(result, value);

            }
        }
        System.out.println(result);
        sc.close();
    }
    
}