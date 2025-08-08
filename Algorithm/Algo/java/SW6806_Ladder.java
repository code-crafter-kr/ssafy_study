import java.util.*;
import java.io.*;

public class SW6806_Ladder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc < 11; tc++) {
            int[][] ladderMap = new int[100][100];
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 위로 거슬러서 올라가기. ? 그냥 사다리를 뒤집어서 만들어버리기
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladderMap[99 - i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int currentRow = 0;
            int currentCol = 0;
            for (int i = 0; i < 100; i++) {
                if (ladderMap[0][i] == 2)
                    currentCol = i; // 타겟 인덱스 추적 해두기
            }

            // start는 0, i로 출발
            while (true) {
                if (currentRow == 99)
                    break; // 도달 지점
                // 좌우 탐색
                // 좌 탐
                // 현재 왼쪽에 길이 있는지

                if (currentCol != 0 && ladderMap[currentRow][currentCol - 1] == 1) {
                    currentCol = goLeft(ladderMap, currentRow, currentCol);
                    currentRow++;
                    continue;
                }

                // 현재 오른쪽에 길이 있는지
                if (currentCol != 99 && ladderMap[currentRow][currentCol + 1] == 1) {
                    currentCol = goRight(ladderMap, currentRow, currentCol);
                    currentRow++;
                    continue;
                }
                // 둘다 길이 없으면 아래밖에 없음
                currentRow++;
            }

            sb.append("#").append(tc).append(" ").append(currentCol).append("\n");
        }
        System.out.println(sb);
    }

    public static int goLeft(int[][] ladderMap, int row, int col) {
        while (true) {
            col--;
            if (col == -1 || ladderMap[row][col] == 0)
                break;
        }
        col++;
        return col;
    }

    public static int goRight(int[][] ladderMap, int row, int col) {
        while (true) {
            col++;
            if (col == 100 || ladderMap[row][col] == 0)
                break;
        }
        col--;
        return col; 
    }
}