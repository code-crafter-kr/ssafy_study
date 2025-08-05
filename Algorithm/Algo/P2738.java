import java.io.*;
import java.util.*;

public class P2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] result = new int[N][M];

        for (int x = 0; x < 2; x++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    result[i][j] += Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }
}
