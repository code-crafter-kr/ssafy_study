import java.util.Scanner;

public class MinerGame {
    static int brokenCount = 0;  // 전역 변수처럼 사용 가능

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 행 개수
        int[][] lst = new int[n][n];

        int posR = 0;
        int posC = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lst[i][j] = sc.nextInt();
                if (lst[i][j] == 0) {
                    posR = i;
                    posC = j;
                }
            }
        }
        int c = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < c; i++) {
            String command = sc.nextLine();
            if (command.equals("X")) {
                update(posR, posC, lst);
            } else {
                int[] newPosition = move(posR, posC, command, lst);
                posR = newPosition[0];
                posC = newPosition[1];
            }
        }

        System.out.printf("광부 위치: (%d, %d)\n", posR, posC);
        System.out.printf("부순 암석 개수 : %d", brokenCount);
    }

    public static void update(int i, int j, int[][] lst) {
        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

        for (int[] d : dir) {
            int nRow = i + d[0];
            int nCol = j + d[1];

            if (nRow >= 0 && nCol >= 0 && nRow < lst.length && nCol < lst.length) {
                if (lst[nRow][nCol] >= 1) brokenCount++;
                lst[nRow][nCol] = 0;
            }

        }
    }

    public static int[] move(int i, int j, String command, int[][] lst) {
        int[] position = new int[2];
        int nx = i;
        int ny = j;

        switch (command) {
            case "U":
                nx--;
                break;
            case "D":
                nx++;
                break;
            case "L":
                ny--;
                break;
            case "R":
                ny++;
                break;
        }
        if (nx >= 0 && ny >= 0 && nx < lst.length && ny < lst.length) {
            if (lst[nx][ny] == 0){
                position[0] = nx;
                position[1] = ny;
            } else if (lst[nx][ny] == 1){
                position[0] = nx;
                position[1] = ny;
                brokenCount++;
                lst[nx][ny] = 0;
            } else{
                lst[nx][ny]--;
                position[0] = i;
                position[1] = j;
            }
        } else{
            position[0] = i;
            position[1] = j;
        }
        return position;

    }
}