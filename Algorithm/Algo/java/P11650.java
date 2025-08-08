import java.util.*;
import java.io.*;

public class P11650{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(st.nextToken());

        int[][] lst = new int[number][2]; 

        for(int i = 0; i < number; i++){
            st = new StringTokenizer(br.readLine());
            lst[i][0] = Integer.parseInt(st.nextToken());
            lst[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lst, (a, b)->{
            if (a[0]==b[0]) return Integer.compare(a[1], b[1]); // 각 첫 요소가 같으면 두번째 요소로 정렬하겠다.
            return Integer.compare(a[0], b[0]); // 첫 요소가 같지 않으면 그걸로 그냥 비교한다.
        });

        for (int i = 0; i < number; i++){
            sb.append(lst[i][0]).append(" ").append(lst[i][1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}