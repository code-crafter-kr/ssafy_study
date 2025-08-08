import java.util.*;
import java.io.*;

public class P10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int t = 1; t < TC+1; t++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());

            if (number == 0){
                deque.pollLast();
            } else{
                deque.addLast(number);
            }
        }

        int answer = 0;
        for (int n : deque){
            answer += n;
        }
        sb.append(answer);
        System.out.println(sb);
    }
}
