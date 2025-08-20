import java.io.*;
import java.util.*;

// 테케가 초기 적고 나무 높이가 적으니까 전부 탐색하면서 진행 visited(비교연산 한번이랑 큰 차이는 없을 것 같기는 함.)이용해서 같아진 나무는 탐색 x 
public class Solution {
	private static int[] trees;
	private static boolean[] visited;
	private static int[][] table;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int result = 0;
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			trees = new int[N];
			visited = new boolean[N];
			for(int i = 0; i < N; i++)trees[i] = Integer.parseInt(st.nextToken());
			
			int maxTreeIndex = -1;
			int maxTreeHeight = 0;
			for(int i = 0; i < N; i++) {
				if(trees[i] > maxTreeHeight) {
					maxTreeHeight = trees[i];
					maxTreeIndex = i;
				}
			}
			visited[maxTreeIndex] = true;
			int restNum = -1;
			if(trees[maxTreeIndex]%2==1)restNum = 1;
			else restNum = 0;
			
			table = new int[maxTreeHeight][N];
			
			for(int d = 0; d < maxTreeHeight; d++) {
				int day = d + 1;
				
				for(int i = 0; i < N; i++) {
					if(trees[i] == maxTreeHeight) continue;
					
					if(day%2 == 1 && (trees[i] < maxTreeHeight - 2)) {
						trees[i] += 0;
						table[d][i] = 0;
					}
					else{
						if(day%2 ==0) {
							trees[i] += 2;
							table[d][i] = 2;
						}
						else {
							trees[i] += 1;
							table[d][i] = 1;
							}
					}
					
				}
				
			}
			for(int d = 0; d < maxTreeHeight; d++)
				System.out.println(Arrays.toString(table[d]));
				
			System.out.println(maxTreeHeight);
			System.out.println(Arrays.toString(trees));
			int day2 = 0;
			int day1 = 0;
			for(int d = 0; d < maxTreeHeight; d++) {
				for(int i = 0; i < N; i++) {
					if(table[d][i] == 1) day1++;
					if(table[d][i] == 2) day2++;
				}
			}
			System.out.println(day1 + " " + day2);
			if(day1 == day2) result = day1*2;
			if(day1 > day2) {
				if(day1 == day2 + 1) result = day1 + day2;
				else result = day1*2 - 1;
			}
			if(day1 < day2) {
				result = day2*2 - 1;
			}
		
			
			System.out.println("#" + t + " " + result);
		}
			
		}
		
}


/*
5
2
5 5
2
4 2
2
3 4
4
2 3 10 5
4
1 2 3 4
 
 */


