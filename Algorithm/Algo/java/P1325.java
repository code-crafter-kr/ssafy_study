
import java.util.*;
import java.io.*;

public class P1325 {
    public static int[] result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        result = new int[N];

        HashSet<Integer>[] graph = new HashSet[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new HashSet<>();
        }


        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b); // 일방적 신뢰관계
        }

        for (int i = 1; i <= N; i++){
            if (result[i] == 0) continue;
            bfs(i);
        } 

        // result의 맥스값을 찾은 뒤 그 맥스값으로 답 출력
        int max_num = Integer.MIN_VALUE;
        for (int x : result){
            if (max_num < x) max_num = x;
        }

        for (int i = 1; i <= N; i++){
            if (result[i] == max_num) sb.append(i + " ");
        }

        System.out.println(sb);
    }
    public static void bfs(int start){
        // bfs로 해당 노드 스타트로 나온 결과를 visited 노드에게 전부 매핑해줌.

    }
}