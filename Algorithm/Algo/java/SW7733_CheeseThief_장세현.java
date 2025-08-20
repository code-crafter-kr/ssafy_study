
import java.util.*;
import java.io.*;

public class SW7733_CheeseThief_장세현 {
	static int answer;
	static int[][] map;
	static int N;
	static int maxDay;
	static boolean [][] visited;
	static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			maxDay = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, map[i][j]);
				}

			}
			answer = 1; // 무조건 초기는 1블럭~
			
			for (int i = 1; i <= maxDay; i++) {
				result = 0;
				visited = new boolean[N][N];
				updateMap();
				check();
				answer = Math.max(result, answer);
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");

		}
		System.out.println(sb);
	}
	
	public static void updateMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] -= 1;
			}
		}
	}
	public static void check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] || map[i][j] <= 0) { // 상하거나 방문한곳이면 재꼈
					continue;
				}
				result++;
				bfs(new int[] {i, j});
			}
		}
	}
	
	public static void bfs(int[] pos) {
		ArrayDeque<int []> dq = new ArrayDeque<>();
		dq.addLast(pos);
		
		while(!dq.isEmpty()) {
			int[] currentPos = dq.pollFirst();
			int currentRow = currentPos[0];
			int currentCol = currentPos[1];
			
			if (visited[currentRow][currentCol] || map[currentRow][currentCol] <= 0) {
				continue;
			}
			
			visited[currentRow][currentCol] = true;
			
			for (int[] next : move) {
				int nextRow = currentRow + next[0];
				int nextCol = currentCol + next[1];
				
				if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N){
					continue;
				}
				dq.addLast(new int[] {nextRow, nextCol});
				
			}
		}
	}

}
