import java.io.*;
import java.util.*;

public class P1149 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        
        for (int i = 1; i < N; i++){
            for (int j = 0; j < 3; j++){
                if (j == 0){
                    dp[i][j] = Math.min(dp[i-1][j+1] + arr[i][j], dp[i-1][j+2] + arr[i][j]);
                } else if (j == 1){
                    dp[i][j] = Math.min(dp[i-1][j-1] + arr[i][j], dp[i-1][j+1] + arr[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + arr[i][j], dp[i-1][j-2] + arr[i][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++){
            if (dp[N-1][i] < answer) answer = dp[N-1][i];
        }
        System.out.println(answer);

    }
}
