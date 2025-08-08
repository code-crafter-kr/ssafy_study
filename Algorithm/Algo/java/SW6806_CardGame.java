import java.util.*;
import java.io.*;

public class SW6806_CardGame {

    static int win, lose;
    static ArrayList<Integer> my_list = new ArrayList<>();
    static ArrayList<Integer> op_list = new ArrayList<>();
    static boolean[] visited = new boolean[9];
    static int temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for (int t = 1; t < TC + 1; t++) {
            st = new StringTokenizer(br.readLine());

            // 테케마다 이니셜라이징 해줌
            visited = new boolean[9];
            my_list.clear();
            op_list.clear();
            win = 0;
            lose = 0;


            for (int x = 0; x < 9; x++) {
                my_list.add(Integer.parseInt(st.nextToken()));
            }

            for (int x = 1; x < 19; x++) {
                op_list.add(x);
            }

            for (int x : my_list) {
                op_list.remove(Integer.valueOf(x));
            }

            // 9! 만큼의 제작
            // 9 * 8 * 7 * 6 .. 식으로 감 recursive나 dfs 사용하고 싶음..

            dfs(0, 0);

            System.out.printf("#%d %d %d", t, win, lose);
            System.out.println();
        }
    }

    public static void dfs(int n, int score) { // 기준은 my_card
        if (n == 9) { // 종료 조건 카드가 9개가 모였을 때.
            if (score > 0) win++;
            else lose++;
            return;
        }

        for (int i = 0; i < 9; i++){
            if (visited[i]) continue; // 현재 몇개의 카드를 비교했는지 측정해줌
            
            visited[i] = true;

            int op_card = op_list.get(n);
            int my_card = my_list.get(i);

            if (my_card > op_card){
                temp = my_card + op_card;
            } else{
                temp = (my_card + op_card) * -1;
            }

            dfs(n+1, score + temp);

            visited[i] = false;
        }
    }

}