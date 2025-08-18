import java.io.*;
import java.util.*;

public class SW5215_HamburgerDiet_DP {

    static int N, limit;
    static int best;
    static int tastes[];
    static int cals[];
    static int dp[];
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            best = 0;
            tastes = new int[N];
            cals = new int[N];
            dp = new int[limit + 1]; // 칼로리에 정확히 닿는 경우를 위해서 dp를 구성한다.
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                tastes[i] = Integer.parseInt(st.nextToken());
                cals[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++){ //음식을 끼워 맞추기 준비한다.
                for (int j = limit; j >= cals[i]; j--){ // 칼로리를 역순으로 달려준다
                    // 리밋에 올 수 있는 계산한다 (현재 음식 + 그 음식과 조합으로.)
                    dp[j] = Math.max(dp[j], tastes[i] + dp[j - cals[i]]);
                }

            }

            for (int i = 1; i < limit + 1; i++){
                best = Math.max(dp[i], best);
            }

            sb.append("#").append(tc).append(" ").append(best).append("\n");
        }
        System.out.print(sb);
    }
}
