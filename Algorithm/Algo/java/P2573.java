import java.io.*;
import java.util.StringTokenizer;

public class P2573 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] updatedMap;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		updatedMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				updatedMap[i][j] = map[i][j];
			}
		}

		// 빙산의 세션이 몇개인지 확인한다.
		for (int year = 1; year <= 500; year++) { // 사실 10년은 명목상일 뿐,
			visited = new boolean[N][M];
			update(); // nextYear는 현재의 맵을 그저 1년 뒤로 보낸다
			int temp = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) continue;
					
					if (visited[i][j]) continue;
					
					temp++;
					
					if (temp == 2) {
						System.out.println(year);
						return;
					}
					
					dfs(i, j);
				}
			}
		}
		System.out.println(0);
	}

	public static void dfs(int row, int col) {
		visited[row][col] = true;
		for (int[] next : new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }) {
			int nx = row + next[0];
			int ny = col + next[1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			if (map[nx][ny] == 0 || visited[nx][ny])
				continue;

			visited[nx][ny] = true;

			dfs(nx, ny);

		}

	}

	public static void update() {
		// 내 주위의 0 개수 세기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] == 0)
					continue; // 이미 녹은곳이면 확인 할 필요 없음

				int temp = 0;

				for (int[] next : new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }) {
					int nx = i + next[0];
					int ny = j + next[1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}

					if (map[nx][ny] == 0)
						temp++;

				}

				if (updatedMap[i][j] <= temp)
					updatedMap[i][j] = 0;
				else
					updatedMap[i][j] = updatedMap[i][j] - temp;

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = updatedMap[i][j];
			}
		}
	}

}
