package Sort;
import java.util.*;
import java.io.*;

// 원시타입의 int[][]를 조건 정렬

public class SortA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // x
            arr[i][1] = Integer.parseInt(st.nextToken()); // y
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // a[0]이랑 b[0]이 같지 않으면 a[0]과 b[0]을 기준으로 
            // 만약 양수면 a[0]이 더 크다는 말이므로 뒤로 가고 b[0]은 앞으로감
            return a[1] - b[1]; // 마찬가지로.. a[0]이랑 b[0]이랑 같으면 두번째 요소로 비교해야함
        });

        StringBuilder sb = new StringBuilder();
        for (int[] point : arr) {
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }
        System.out.print(sb);
    }
}
