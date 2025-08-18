import java.io.*;
import java.util.*;

public class SW5215_HamburgerDiet_장세현 {

    static int N, L;
    static int[] score, cal;
    static int best;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            score = new int[N];
            cal   = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i]   = Integer.parseInt(st.nextToken());
            }

            best = 0;
            dfs(0, 0, 0); 
            sb.append("#").append(tc).append(" ").append(best).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int idx, int curScore, int curCal) {
        if (curCal > L) return;

        if (idx == N) {
            if (curScore > best) best = curScore;
            return;
        }

        // 1) idx 음식을 고른다
        dfs(idx + 1, curScore + score[idx], curCal + cal[idx]);

        // 2) idx 음식을 고르지 않는다
        dfs(idx + 1, curScore, curCal);
    }
}
