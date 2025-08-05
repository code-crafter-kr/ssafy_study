import java.util.Scanner;

public class DayCount {

	public static void main(String[] args) {
        System.out.println("월과 일을 입력하세요");
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        int answer = check(month, day);

        System.out.printf("%d월 %d일은 %d번째 날입니다.", month, day, answer);
    }

    public static int check(int m, int d){
        int[] day_lst = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int answer = 0;
        for (int i = 1; i < m; i++){
            answer += day_lst[i];
        }
        return answer + d;
    }

}
