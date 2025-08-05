package Day1;
import java.util.Scanner;

public class Season1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("월 입력 >>");
            int month = sc.nextInt();
            String result;
            if (3 <= month && month <= 5){
                result = "봄";
            } else if (6 <= month && month <= 8){
                result = "여름";
            } else if (9 <= month && month <= 11){
                result = "가을";
            } else{
                result = "겨울";
            }
            System.out.printf("%d월은 %s입니다.\n", month, result);
        }
    }
}
