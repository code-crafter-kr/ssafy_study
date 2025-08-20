
import java.io.*;
import java.util.*;

public class SW1873_BattleField_장세현 {
	static int H;
	static int W;
	static int N;
	static int row;
	static int col;

	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];
			String word;
			for (int i = 0; i < H; i++) {
				word = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = word.charAt(j);
					if (map[i][j] == '^' || map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v') {
						row = i;
						col = j;
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			word = br.readLine();
			for (int i = 0; i < N; i++) {
				char command = word.charAt(i);
				update(command);
			

			}
			sb.append("#").append(tc).append(" ");

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}

	public static void update(char command) { // 명령과 전차의 위치를 줌
		switch (command) {
		case 'U':
			if (canMove(row - 1, col)) {
				map[row][col] = '.';
				row = row - 1;
			}
			map[row][col] = '^';

			break;
		case 'D':
			if (canMove(row + 1, col)) {
				map[row][col] = '.';
				row = row + 1;
			}
			map[row][col] = 'v';

			break;
		case 'L':
			if (canMove(row, col - 1)) {
				map[row][col] = '.';
				col = col - 1;
			}
			map[row][col] = '<';

			break;
		case 'R':
			if (canMove(row, col + 1)) {
				map[row][col] = '.';
				col = col + 1;
			}
			map[row][col] = '>';

			break;
		case 'S':
			shoot();
		}

	}

	public static void shoot() {
		if (map[row][col] == '>') { // 오른쪽 발사
			for (int i = col; i < W; i++) {
				if (map[row][i] == '*') {
					map[row][i] = '.';
					return;
				}

				else if (map[row][i] == '#')
					return;
			}

		} else if (map[row][col] == '<') { // 왼쪽 발사
			for (int i = col; i >= 0; i--) {
				if (map[row][i] == '*') {
					map[row][i] = '.';
					return;
				}

				else if (map[row][i] == '#')
					return;
			}

		} else if (map[row][col] == '^') { // 위 발사
			for (int i = row; i >= 0; i--) {
				if (map[i][col] == '*') {
					map[i][col] = '.';
					return;
				}

				else if (map[i][col] == '#')
					return;
			}
		} else { // 아래 발사
			for (int i = row; i < H; i++) {
				if (map[i][col] == '*') {
					map[i][col] = '.';
					return;
				}

				else if (map[i][col] == '#')
					return;

			}
		}
	}

	public static boolean canMove(int x, int y) {
		if (x >= H || y >= W || x < 0 || y < 0) { // 맵 밖
			return false;
		}

		if (map[x][y] == '.') { // 이동 가능
			return true;
		}
		return false;
	}

}
