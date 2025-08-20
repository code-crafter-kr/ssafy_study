import java.util.*;
import java.io.*;

public class SW1238_Contact_장세현 {
	static int[] answer;
	static int length;
	static int start;
	static boolean visited[];
	static ArrayList<Integer>[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			length = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			visited = new boolean[101];
			
			answer = new int[] {0, 0};
			
			map = new ArrayList[101];
			
			for (int i = 0; i < 101; i++) {
				map[i] = new ArrayList<Integer>();
			}

			st = new StringTokenizer(br.readLine());

			// 실제로 length의 x 2
			for (int i = 0; i < length / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a].add(b);
			}
			bfs(new int[] {start, 0});
			
			
			sb.append("#").append(t).append(" ").append(answer[0]).append("\n");
		}
		System.out.println(sb);
	}
	

	
	public static void bfs(int[] info) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(info);
				
		while(!dq.isEmpty()) {
			int[] next = dq.pollFirst();
			int currentNum = next[0];
			int currentCount = next[1];
			

			if (visited[currentNum]) continue;
			visited[currentNum] = true;
			
			if (currentCount > answer[1]) { // 무조건 업데이트 해야함
				answer[0] = currentNum;
				answer[1] = currentCount;
			} else if (currentCount == answer[1]) {
				answer[0] = Math.max(answer[0], currentNum);
			}
			
			
			for (int n : map[currentNum]) {
				dq.add(new int[] {n, currentCount+1});
			}
			
		}
	}
	

}
