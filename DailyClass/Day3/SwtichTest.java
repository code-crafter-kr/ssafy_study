import java.util.Scanner;

public class SwtichTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < M; i++) {
            int idx =sc.nextInt();
            int mul = 1;
            while(idx * mul - 1 < N){
                if (arr[idx * mul - 1] == 0){
                    arr[idx * mul - 1] = 1;
                } else{
                    arr[idx * mul - 1] = 0;
                }
                mul++;
            }
        }

        for (int a : arr){
            System.out.print(a + " ");
        }
        
    }

}
