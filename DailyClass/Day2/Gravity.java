import java.util.Scanner;

public class Gravity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i + 1; j < n; j++){
                if (arr[i] > arr[j]) temp++;
            }
            answer = Integer.max(answer, temp);
        }

        System.out.println(answer);

    }
}
