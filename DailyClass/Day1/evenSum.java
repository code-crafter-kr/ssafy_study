package Day1;
import java.util.Scanner;

public class evenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("숫자 입력 >> ");
        int num = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < num + 1; i++) {
            if (i % 2 == 0){
                ans += i;
            }
        }
        System.out.printf("1부터 %d까지 수 중 짝수의 합 = %d", num, ans);
    }
}
