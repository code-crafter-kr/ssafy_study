import java.util.*;
import java.io.*;

public class P12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> list = new ArrayDeque<>();
        ArrayDeque<Integer> wait = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list.addLast(Integer.parseInt(st.nextToken()));
        }

        int target = 1;
        while (target <= N) { // 둘 다 비어있지 않는 한..
            if (list.isEmpty()) break;

            Integer listNext = list.peekFirst();
            Integer waitNext = wait.peekLast();

            if (waitNext == null) waitNext = 1000;

            if (listNext == target) {
                target++;
                list.pollFirst();
                continue;
            }

            if (waitNext == target) {
                target++;
                wait.pollLast();
                continue;
            }

            if (listNext > waitNext) {
                System.out.println("Sad");
                return;
            }

            wait.addLast(listNext);
            list.pollFirst();
        }

        System.out.println("Nice");
    }

}
