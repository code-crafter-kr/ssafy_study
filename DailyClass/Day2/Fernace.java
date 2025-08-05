import java.util.Scanner;

public class Fernace {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int answer = Math.abs(A - B);

		for (int i = 0; i < N; i++) {
			answer = Math.min(answer, Math.abs(arr[i] - B) + 1);	
		}

		if (answer > 600){
			System.out.println(-1);
		} else{
			System.out.println(answer);
		}
 

	}

}
