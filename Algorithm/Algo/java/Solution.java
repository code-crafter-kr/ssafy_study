import java.util.*;
import java.io.*;

public class Solution {
    static int answer;
    static int roomNumber;
    static int N;
    static boolean[][] visited;
    static int[][] map;
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= TC; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            sb.append("#").append(t).append(" ").append(roomNumber).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int row, int col){

    }
    
}
