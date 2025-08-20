import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11053 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 0; i < N; i++){
            for (int j = i; j < N; j++){
                if (arr[j] > arr[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++){
            if (dp[i] > answer) answer = dp[i];
        }
        System.out.println(answer);

    }
}
