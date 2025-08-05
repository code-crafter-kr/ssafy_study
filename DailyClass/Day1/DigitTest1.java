package Day1;
public class DigitTest1 {

    public static void main(String[] args) {
        int ex = 1;
        int count = 5;
        
        for (int i = 0; i < 5; i++) {
            // 들여쓰기
            System.out.print("    ".repeat(i)); // 네 칸씩 들여쓰기
            
            for (int j = 0; j < count; j++) {
                System.out.printf("%-4d", ex); // 왼쪽 정렬로 4칸 확보
                ex++;
            }
            System.out.println();
            count--;
        }
    }
}
