import java.io.*;
import java.util.*;

public class P2908 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String numberA = st.nextToken();
        String numberB = st.nextToken();

        StringBuilder newA = new StringBuilder();
        StringBuilder newB = new StringBuilder();

        for (int i = numberA.length() - 1; i > -1; i--){// 어차피 3이긴해
            newA.append(numberA.charAt(i));
            newB.append(numberB.charAt(i));
        }

        int newIntegerA = Integer.parseInt(newA.toString());
        int newIntegerB = Integer.parseInt(newB.toString());

        System.out.println(Math.max(newIntegerA, newIntegerB));
    }
}
