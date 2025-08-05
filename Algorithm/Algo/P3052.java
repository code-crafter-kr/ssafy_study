import java.io.*;
import java.util.*;


public class P3052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // StringTokenizer st;
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(br.readLine());
            set.add(number % 42);
        }

        System.out.println(set.size());
    }
}
