import java.io.*;
import java.util.*;

public class P1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = 0; i < testCase; i++) {
            int[] alphaArr = new int[26];
            String word = br.readLine();
            char prev = word.charAt(0);
            alphaArr[prev - 'a'] = 1; // 초기 알파벳 마킹 

            for (int j = 1; j < word.length(); j++) {
                char current = word.charAt(j); // 현재 알파벳 2번부터 시작
                if (prev != current && alphaArr[current - 'a'] != 0) {
                    answer -= 1;
                    break;
                } else
                    alphaArr[current - 'a'] += 1; // 그게 아니라면 그 숫자 추가해주기
                prev = current;
            }
            answer += 1;
        }

        System.out.println(answer);
    }
}
