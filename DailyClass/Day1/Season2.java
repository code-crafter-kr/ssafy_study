package Day1;

import java.util.Scanner;

public class Season2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = 3;

        while (loop >= 1){
            System.out.print("월 입력 >>");
            int month = sc.nextInt();
            String result;
            switch (month){
                case 3, 4, 5:
                    result = "봄"; break;
                case 6, 7, 8:
                    result = "여름"; break;
                case 9, 10, 11:
                    result = "가을"; break;
                default:
                    result = "겨울";
            }
            System.out.printf("%d월은 %s입니다.\n", month, result);
            loop--;
        }
    }
}
