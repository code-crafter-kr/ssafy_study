package Day1;
public class DigitTest2 {

    public static void main(String[] args) {
        int ex = 1;
        int[] lst = new int[] {5, 3, 1, 3 ,5};
        
        for (int i = 0; i < 5; i++) {
            // 들여쓰기
            if (i < 3){
                System.out.print("    ".repeat(i)); // 네 칸씩 들여쓰기
            } else{
                System.out.print("    ".repeat(4-i)); // 네 칸씩 들여쓰기
            }
            for (int j = 0; j < lst[i]; j++) {
                System.out.printf("%-4d", ex); // 왼쪽 정렬로 4칸 확보
                ex++;
            }
            System.out.println();
        }
    }
}
