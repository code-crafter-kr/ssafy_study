import java.util.Scanner;

public class ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[] lst = new int[50001];
        lst[0] = 0;

        for (int i = 1; i < 50001; i++) {
            lst[i] = (int)Math.pow(10, 9);
        }

        for (int i = 0; i < 50001; i++) {
            for (int j = 0; j < 50001; j++) {
                if (j * j > i){
                    break;
                }

                if (j * j == i){
                    lst[i] = 1;
                    break;
                }

                int temp = lst[i - j*j] + 1;
                lst[i] = Math.min(temp, lst[i]);

            }   
        }

        System.out.println(lst[n]);
        
    }
}
