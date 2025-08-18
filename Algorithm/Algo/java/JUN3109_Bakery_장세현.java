import java.util.*;
import java.io.*;

public class JUN3109_Bakery_장세현 {
	static int answer;
	static int R;
	static int C;
	static boolean find;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String word = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = word.charAt(j);
			}
		}
		
		
		for (int i = 0; i < R; i++) {
			find = false;
			dfs(i, 0); // row와 col이 될 것. 항상 col은 0부터 시작하니까.
		}
		System.out.println(answer);
	}

	public static void dfs(int row, int col) {
		if (find)
			return; // 찾는 순간 그 dfs는 폐기하여서 뒤로 돌리지 말고 x를 찍은걸 그대로 두고 나와야함

		if (col == C - 1) { // 끝 열 도달 시점에서 더이상 샐 필요 없음. dfs조차 필요 없음 ...
			answer += 1;
			find = true;
			return;
		}

		// 우 상단 재끼는 경우 - 일단 row가 0만 아니면 체크는 가능
		if ((row != 0) && (map[row - 1][col + 1] == '.')) {
			map[row - 1][col + 1] = 'x';
			dfs(row - 1, col + 1);
			if (find) return;
//			map[row - 1][col + 1] = '.'; // 길 원상복구를 해야하는가? 안해도 된다. 폐기된 길이 하나의 가이드라인으로 사용됨.
		}
		// 정면 돌파하는 경우 -- 근데 위로 갈 수 있으면 그냥 무조건 위 아닌가? => 아님 else if를 쓰면..
		if (map[row][col + 1] == '.') {
			map[row][col + 1] = 'x';
			dfs(row, col + 1);
			if (find) return;
//			map[row][col + 1] = '.';
		}
		// 아래로 재끼는 경우
		if ((row != R - 1 && map[row + 1][col + 1] == '.')) {
			map[row + 1][col + 1] = 'x';
			dfs(row + 1, col + 1);
			if (find) return;
//			map[row + 1][col + 1] = '.';

		}
	}

}
