import java.io.*;
import java.util.*;

public class P10810 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")))) {
            // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 첫 인풋
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] lst = new int[N];
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int ballNumber = Integer.parseInt(st.nextToken());
                
                for (int j = start - 1; j < end; j++){
                    lst[j] = ballNumber;
                }
            }
            
            for (int x : lst){
                System.out.print(x + " ");
            }
        }
    }
}
