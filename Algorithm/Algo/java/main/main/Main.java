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
		if ((N == 1) & (M ==1)) System.out.println(1); // �������ڸ��� �����̸�?
		else bfs(map, N, M); // �������� �����ϸ� ��

	}

	public static void bfs(int[][] map, int N, int M) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.addLast(new int[] {0, 0, 0, 1}); // ���� row, ���� col, ���� ���� �μ��� �ִ���, ���� �̵��� �Ÿ�)
		
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
				
				if ((isBreak == 1) && (map[nextRow][nextCol]) == 1) { // ���� �����µ� ���μ���..
					continue;
				}
				

				if ((isBreak == 0) && (map[nextRow][nextCol] == 1)){ // ���� �μ� �� ���� ��..
					dq.addLast(new int[] {nextRow, nextCol, 1, (currentMove + 1)});
					continue; // ���� �μ��� �� �ĸ� ���Ĵ� ��ŷ���� �ʾƵ� �ȴ�.
				}
				// �� ���� ��� .. ��ȿ�� ��� �� ���� ������ �ʾ��� ��.
				dq.addLast(new int[] {nextRow, nextCol, isBreak, (currentMove + 1)});
				
				
					
			}	
			
		}
		System.out.println(-1);
	} // �������� �����ϸ� ��

}