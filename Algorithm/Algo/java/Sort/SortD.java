package Sort;
import java.util.*;
import java.io.*;

// ArrayList안의 ArrayList

public class SortD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            List<Integer> point = new ArrayList<>();
            point.add(x);
            point.add(y);
            list.add(point);
        }

        list.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });

        StringBuilder sb = new StringBuilder();
        for (List<Integer> point : list) {
            sb.append(point.get(0)).append(" ").append(point.get(1)).append("\n");
        }
        System.out.print(sb);
    }
}
