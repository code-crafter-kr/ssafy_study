package main;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[][] dp;
	static int answer = 0;
	static int[][] move = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(answer);

	}

	public static void dfs(int row, int col) {
		if (row == N - 1 && col == M - 1) {
			answer++;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nx = row + move[i][0];
			int ny = col + move[i][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			if (map[row][col] > map[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

}
