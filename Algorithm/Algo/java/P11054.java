import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11054 {
	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(new
		// FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int answer = 0;
		int[] arr = new int[N];
		int[] dp = new int[N];
		int[] dp2 = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			dp2[i] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] < arr[j]) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
					dp2[j] = dp[j];
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] > arr[j]) {
					dp2[j] = Math.max(dp2[j], dp2[i] + 1);
				}
			}
		}
		
		System.out.println(Arrays.toString(dp2));
		
		for (int i = 0; i < N; i ++) {
			answer = Math.max(dp2[i], answer);
		}

		System.out.println(answer);

	}
}
