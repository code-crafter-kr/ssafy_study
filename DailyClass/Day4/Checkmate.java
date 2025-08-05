
import java.util.Scanner;

/**
 * 체크메이트 판별하기
 */

public class Checkmate {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            
            int wRow = sc.nextInt();
            int wCol = sc.nextInt();
            int bRow = sc.nextInt();
            int bCol = sc.nextInt();

            if (wRow == bRow || wCol == bCol || diagCheck(wRow, wCol, bRow, bCol)){
                System.out.printf("#%d 1", i+1);
            } else{
                System.out.printf("#%d 0", i+1);
            }
            System.out.println();   
        }

    }

    public static boolean diagCheck(int wRow, int wCol, int bRow, int bCol){
        return (Math.abs(wRow - bRow) == Math.abs(wCol - bCol));
    }
}
