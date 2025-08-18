import java.util.*;
import java.io.*;

public class SW1486_TopShelf_장세현 {
	static int answer;
	static int[] list;
	static int goal;
	static int N;
	static int B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			list = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			answer = Integer.MAX_VALUE;
			dfs(0, 0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int idx, int current) {
		if (idx == N && current >= B) {
			answer = Math.min(answer, current-B);
			return;
		}
		
		if (idx == N) return;
		
		dfs(idx + 1, current + list[idx]);
		dfs(idx + 1, current);
	}

}
