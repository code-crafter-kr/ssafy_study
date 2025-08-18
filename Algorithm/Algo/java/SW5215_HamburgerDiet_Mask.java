import java.io.*;
import java.util.*;

public class SW5215_HamburgerDiet_Mask {

    static int N, L;
    static int best;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());



            sb.append("#").append(tc).append(" ").append(best).append("\n");
        }
        System.out.print(sb);
    }
}
