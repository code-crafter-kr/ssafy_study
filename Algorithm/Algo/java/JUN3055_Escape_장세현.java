import java.util.*;
import java.io.*;

public class JUN3055_Escape_장세현 {
	static int answer;
	static int N;
	static int M;
	static int startRow;
	static int startCol;
	static int min;
	static int[][] move = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean visited[][];
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		map = new char[N][M];
		visited = new boolean[N][M];
		min = 0;

		for (int i = 0; i < N; i++) {

			String word = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = word.charAt(j);
				if (map[i][j] == 'S') {
					startRow = i;
					startCol = j;
				}
			}
		}
		updateMap();
		if (!bfs(startRow, startCol))
			System.out.println("KAKTUS");

	}

	public static boolean bfs(int row, int col) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { row, col, 0 });

		while (!dq.isEmpty()) {
			int[] pos = dq.pollFirst();
			int currentRow = pos[0];
			int currentCol = pos[1];
			int currentCount = pos[2];

			if (min + 1 == currentCount) {
				updateMap();

				min++;
			}
			if (visited[currentRow][currentCol])
				continue;

			visited[currentRow][currentCol] = true;

			for (int[] next : move) {
				int nextRow = currentRow + next[0];
				int nextCol = currentCol + next[1];

				if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M)
					continue;
				
				if (map[nextRow][nextCol] == '*' || map[nextRow][nextCol] == 'X')
					continue;

				if (map[nextRow][nextCol] == 'D') {
					System.out.println(nextRow + " " +  nextCol + " " + (currentCount + 1));

					System.out.println(currentCount + 1);
					return true;
				}

				dq.add(new int[] { nextRow, nextCol, currentCount + 1 });
				System.out.println(nextRow + " " +  nextCol + " " + (currentCount + 1));
			}
		}
		return false;
	}

	public static void updateMap() {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '*') {
					dq.add(new int[] { i, j });
				}
			}
		}

		while (!dq.isEmpty()) {
			int[] pos = dq.pollFirst();
			int i = pos[0];
			int j = pos[1];
			for (int[] next : move) {
				int nextRow = i + next[0];
				int nextCol = j + next[1];

				if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M)
					continue;
				if (map[nextRow][nextCol] == '*' || map[nextRow][nextCol] == 'X' || map[nextRow][nextCol] == 'D')
					continue;

				map[nextRow][nextCol] = '*';
			}
		}
	}

}
