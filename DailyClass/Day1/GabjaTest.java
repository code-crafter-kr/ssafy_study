package Day1;
import java.util.Scanner;

public class GabjaTest {
    public static void main(String[] args) {
        String[] lst = {"갑", "을", "병", "정", "무", "기", "경", "신", "임", "계"};
        String[] lst2 = {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};
        Scanner sc = new Scanner(System.in);
        
        while (true) { 
            System.out.print("60갑자를 입력하세요: ");
            String choice = sc.nextLine();
            if (choice.equals("종료")){
                break;
            }

            if (choice.length() < 2 || choice.length() > 2){
                System.out.println("잘못된 입력");
            }


        }

    }
}
