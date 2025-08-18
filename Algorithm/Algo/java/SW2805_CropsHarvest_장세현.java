import java.util.*;
import java.io.*;

public class SW2805_CropsHarvest_장세현 {
	static int answer;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= TC; t++) {
			answer = 0;
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				String word = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = word.charAt(j) - '0';
				}
			}
			int idx = n / 2; // 시작은 2
			for (int i = 0; i < n; i++) { // row control
				
				if (i < n / 2) {
					for (int j = n - idx - 1; j <= idx; j++) {
						answer += map[i][j];
					}
					idx++;
				}
				
				if (i > n / 2) {
					for (int j = n - idx - 1; j <= idx; j++) {
						answer += map[i][j];
					}
					idx--;
				}
				
				if (i == n / 2) {
					for (int j = 0; j < n; j++) {
						answer += map[i][j];
					}
					idx--;
				}
				
			}

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
