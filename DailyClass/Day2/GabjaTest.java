import java.util.Scanner;

public class GabjaTest {
    public static void main(String[] args) {
        char[] lst = {'갑', '을', '병', '정', '무', '기', '경', '신', '임', '계'};
        char[] lst2 = {'자', '축', '인', '묘', '진', '사', '오', '미', '신', '유', '술', '해'};
        Scanner sc = new Scanner(System.in);
        
        while (true) { 
            System.out.print("\n60갑자를 입력하세요: ");
            String choice = sc.nextLine();
            if (choice.equals("종료")){
                break;
            }

            if (choice.length() < 2 || choice.length() > 2){
                System.out.println("잘못된 입력");
            }
            
            char first = choice.charAt(0);
            char second = choice.charAt(1);
            
            int start_idx_lst = 6;
            int start_idx_lst2 = 8;

            for (int i = 1800; i < 2101; i++) {
                char check_first = lst[start_idx_lst++ % 10];
                char check_second = lst2[start_idx_lst2++ % 12];

                if ((check_first == first) && (check_second == second)){
                    System.out.print(i + " ");
                }
            }



        }

    }
}
