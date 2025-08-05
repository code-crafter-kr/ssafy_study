import java.io.*;
import java.util.*;
public class P2563 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        int[][] lst = new int[100][100]; 

        for (int i = 0; i < testCase; i++){
            st = new StringTokenizer(br.readLine());
            int posX = Integer.parseInt(st.nextToken());
            int posY = Integer.parseInt(st.nextToken());

            for (int y = posY-1; y < posY + 9; y++){ // 로우 스타트
                for (int x = posX-1; x < posX + 9; x++){ // 칼럼 스타트
                    lst[y][x] = 1;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                ans += lst[i][j];
            }
        }

        System.out.println(ans);
    }
}
