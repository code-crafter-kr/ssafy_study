import java.util.Scanner;

public class AirCrashes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int last = arr[n - 1];
        int globalMax = Integer.MIN_VALUE;
        int smallerMax = Integer.MIN_VALUE;

        for (int x : arr) {
            globalMax = Math.max(globalMax, x);
            if (x < last) {
                smallerMax = Math.max(smallerMax, x);
            }
        }

        if (smallerMax == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(globalMax - smallerMax);
        }

    }
}