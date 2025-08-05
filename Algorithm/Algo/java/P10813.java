import java.io.*;
import java.util.StringTokenizer;

public class P10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 백준용
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lst = new int[N];

        for (int i = 0; i < N; i++){
            lst[i] = i+1;
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int temp = lst[start - 1];
            lst[start - 1] = lst[end - 1];
            lst[end - 1] = temp;
        }

        for (int a : lst){
            System.out.print(a + " ");
        }

    }
}
