import java.util.*;
import java.io.*;

public class SW3421_BurgerMaster_장세현 {
    static int answer;
    static boolean[] visited;
    static HashSet<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            answer = 0;
            map = new HashSet[N + 1];
            for (int i = 0; i <= N; i++)
                map[i] = new HashSet<>(); // 반드시 초기화 필요

            for (int z = 0; z < M; z++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[a].add(b);
                map[b].add(a);
            }

            dfs(1, N); // 재료를 넣었다가 말았다가 넣었다가 말았다가 하기..

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int i, int N) {
        if (i > N) { // 재료 탐색 결과가 나왔을때
            answer++;
            return;
        }
        // 재료를 안넣는 경우는 visited를 등록하지 않고
        dfs(i + 1, N);

        // 재료를 넣는 경우는 일단 유효성을 체크하고 ...
        boolean ok = true;
        for (int j = 1; j < i; j++) {
            if (visited[j] && map[i].contains(j)) { // i와 j가 금지쌍이면
                ok = false;
                break;
            }
        }

        if (ok) {
            visited[i] = true;
            dfs(i + 1, N);
            visited[i] = false; // 해당 재료를 백트래킹 되어 다시 빼줘야함
        }
    }
}
