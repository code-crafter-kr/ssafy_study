import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for (int i = 0; i < TC; i++) {
            ArrayDeque<String> deque = new ArrayDeque<>();
            String word = br.readLine();
            boolean valid = true;
            for (int j = 0; j < word.length(); j++) {
                String next = word.charAt(j) + "";
                if (next.equals("("))
                    deque.addLast("(");
                else {
                    if (deque.size() > 0)
                        deque.pollLast();
                    else {
                        valid = false;
                        sb.append("NO");
                        sb.append("\n");
                        break;
                    }
                }
            }
            if (!valid) continue;
            if (deque.isEmpty()) sb.append("YES");
            else sb.append("NO");

            sb.append("\n");

        }
        System.out.println(sb);
    }


}
