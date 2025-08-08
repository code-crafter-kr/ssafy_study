import java.util.*;
import java.io.*;

public class P11650_copy{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(st.nextToken());

        Integer[][] lst = new Integer[number][2]; 

        for(int i = 0; i < number; i++){
            st = new StringTokenizer(br.readLine());
            lst[i][0] = Integer.parseInt(st.nextToken());
            lst[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lst, Comparator.comparing((Integer[] a) -> a[0]).thenComparing(a -> a[1]));


        for (int i = 0; i < number; i++){
            sb.append(lst[i][0]).append(" ").append(lst[i][1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}