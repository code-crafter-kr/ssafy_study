package Day1;
import java.util.Scanner;

public class GameTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
        System.out.println("1. 5판 3승");
        System.out.println("2. 3판 2승");
        System.out.println("3. 1판 1승");

        System.out.print("\n번호를 입력하세요: ");
        int choice = sc.nextInt();
        sc.nextLine(); // 버퍼 정리

        switch (choice) {
            case 1 -> playGame(5, 3, sc);
            case 2 -> playGame(3, 2, sc);
            case 3 -> playGame(1, 1, sc);
            default -> System.out.println("잘못된 선택입니다.");
        }

        sc.close();
    }

    public static void playGame(int totalRounds, int winCondition, Scanner sc) {
        int computer_win = 0;
        int user_win = 0;

        for (int i = 0; i < totalRounds; i++) {
            int computer_choice = (int)(Math.random() * 3) + 1;
            int user_choice = get_user_choice(sc);
            int result = battle(computer_choice, user_choice);

            switch (result) {
                case 0 -> {
                    System.out.println("졌습니다!!!");
                    computer_win++;
                }
                case 1 -> {
                    System.out.println("이겼습니다!!!");
                    user_win++;
                }
                case 2 -> System.out.println("비겼습니다!!!");
            }

            if (computer_win == winCondition || user_win == winCondition) {
                break;
            }
        }

        if (computer_win > user_win) {
            System.out.println("### 컴퓨터 승!!!");
        } else if (computer_win < user_win) {
            System.out.println("### 유저 승!!!");
        } else {
            System.out.println("무승부");
        }
    }

    public static int get_user_choice(Scanner sc) {
        while (true) {
            System.out.print("가위바위보 중 하나를 입력: ");
            String input = sc.nextLine();
            switch (input) {
                case "가위": return 1;
                case "바위": return 2;
                case "보": return 3;
                default:
                    System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
            }
        }
    }

    // 0: 유저 패배, 1: 유저 승리, 2: 무승부
    public static int battle(int com, int user) {
        if ((com == 1 && user == 3) || (com == 2 && user == 1) || (com == 3 && user == 2)) {
            return 0;
        } else if ((com == 1 && user == 2) || (com == 2 && user == 3) || (com == 3 && user == 1)) {
            return 1;
        } else {
            return 2;
        }
    }
}
