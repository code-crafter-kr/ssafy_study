
import java.util.*;
import java.io.*;

public class P2231 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(br.readLine());


        for (int i = 1; i < number + 1; i++){
            int result = i;
            int target = i;
            int div = 1000000;
            while (div != 0){
                result += target / div;
                target %= div;
                div /= 10;
            }
            // i를 분해해서 더해서 result가 number와 같으면 i를 출력
            if (number == result){
                System.out.println(i);
                return;
            }
    }
    System.out.println(0);

    }
}