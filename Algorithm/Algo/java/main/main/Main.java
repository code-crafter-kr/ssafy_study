package main;

import java.util.*;
import java.io.*;

public class Main {

	public static int[][] move = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	public static int[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visited = new int[N][M][2];
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = word.charAt(j) - '0';
			}
		}
		if ((N == 1) & (M ==1)) System.out.println(1); // 시작하자마자 도착이면?
		else bfs(map, N, M); // 도착점만 도달하면 끝

	}

	public static void bfs(int[][] map, int N, int M) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.addLast(new int[] {0, 0, 0, 1}); // 현재 row, 현재 col, 현재 벽을 부순적 있는지, 현재 이동한 거리)
		
		while(!(dq.isEmpty())) {
			int[] nextInfo = dq.pollFirst();
			int currentRow = nextInfo[0];
			int currentCol = nextInfo[1];
			int isBreak = nextInfo[2];
			int currentMove = nextInfo[3];
			
			if (visited[currentRow][currentCol][isBreak] == 1)  {
				continue;
			}
			
			visited[currentRow][currentCol][isBreak] = 1;

			for (int[] next : move) {
				int nextRow = currentRow + next[0];
				int nextCol = currentCol + next[1];
				if ((nextRow == N-1) && (nextCol == M-1)) {
					System.out.println(currentMove + 1);
					return;
				}

				if ((nextRow < 0) || (nextCol < 0) || (nextRow >= N) || (nextCol >= M)) {
					continue;
				}
				
				if ((isBreak == 1) && (map[nextRow][nextCol]) == 1) { // 벽을 만났는데 못부술때..
					continue;
				}
				

				if ((isBreak == 0) && (map[nextRow][nextCol] == 1)){ // 벽을 부술 수 있을 때..
					dq.addLast(new int[] {nextRow, nextCol, 1, (currentMove + 1)});
					continue; // 벽을 부수고 난 후면 이후는 마킹하지 않아도 된다.
				}
				// 그 외의 경우 .. 유효성 통과 후 벽을 만나지 않았을 때.
				dq.addLast(new int[] {nextRow, nextCol, isBreak, (currentMove + 1)});
				
				
					
			}	
			
		}
		System.out.println(-1);
	} // 도착점만 도달하면 끝

}