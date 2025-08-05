import java.io.*;
import java.util.*;

public class P3003 {
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] standard = {1, 1, 2, 2, 2, 8};

        for (int i = 0; i < 6; i++){
            int current = Integer.parseInt(st.nextToken());
            System.out.print(standard[i] - current);
            System.out.print(" ");
        }
    }
}
