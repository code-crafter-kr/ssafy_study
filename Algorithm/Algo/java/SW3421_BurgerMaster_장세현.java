import java.util.*;
import java.io.*;


public class SW3421_BurgerMaster_장세현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(st.nextToken());
        int answer = 1; // 기본으로 1임
        
        for (int t = 1; t <= TC; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            HashSet<Integer>[] map = new HashSet[N+1];

            for (int z = 0; z < M; z++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[a].add(b);
                map[b].add(a);
            }


            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
