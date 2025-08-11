import java.util.*;
import java.io.*;

public class P1325 {
    public static int maximum = -1;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a); // A가 B를 신뢰 → B 해킹 시 A도 해킹 (역방향 저장)
        }

        for (int start = 1; start <= N; start++) {
            boolean[] vis = new boolean[N + 1];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            int cnt = 1;

            vis[start] = true;
            q.addLast(start);

            while (!q.isEmpty()) {
                int cur = q.pollFirst();
                for (int nxt : graph[cur]) {
                    if (vis[nxt]) continue;
                    vis[nxt] = true;
                    cnt++;
                    q.addLast(nxt);
                }
            }

            if (maximum < cnt) {
                maximum = cnt;
                sb = new StringBuilder().append(start).append(" ");
            } else if (maximum == cnt) {
                sb.append(start).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
