package Sort;
import java.util.*;
import java.io.*;


// Integer[][]를 조건 정렬


public class SortB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        int n = Integer.parseInt(br.readLine());
        Integer[][] arr = new Integer[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator // Integer라는 오브젝트에는 Comparator의 .comparing사용가능
                .comparing((Integer[] a) -> a[0])
                .thenComparing(a -> a[1])
        );

        StringBuilder sb = new StringBuilder();
        for (Integer[] point : arr) {
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }
        System.out.print(sb);
    }
}
