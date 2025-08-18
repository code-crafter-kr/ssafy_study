import java.io.*;
import java.util.*;

public class SW5215_HamburgerDiet_DFS {

    static int N, limit;
    static int best;
    static int tastes[];
    static int cals[];

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

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                tastes[i] = Integer.parseInt(st.nextToken());
                cals[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, 0); // 재료의 스타트 0번, 현재의 칼로리 점수 0점, 현재의 맛 점수 0점- 내부에서 재료를 넣었다 뺐다. best를 기록
            sb.append("#").append(tc).append(" ").append(best).append("\n");
        }
        System.out.print(sb);
    }

    // 이문제는 visited가 필요한가..? 분기점은 2의 20승 아닌가?
    public static void dfs(int idx, int currentCal, int currentTaste) {
        // 종료 조건 바로 달아주기 모든 재료 순회시
        if (currentCal > limit) {return;} // 만약 재료 넣고 왔는데 더이상 채울 수 없으면 그건 유효조차 하지 않음

        if (idx == N) {
            best = Math.max(currentTaste, best);
            return;
        }

        // 재료를 넣었을 때. 근데 재료 넣기 유효성 검사가 필요함
        dfs(idx + 1, currentCal + cals[idx], currentTaste + tastes[idx]);
        // 재료를 넣지 않았을 때.
        dfs(idx + 1, currentCal, currentTaste); // 칼로리도 업데이트 x 맛도 업데이트 x

    }

}
