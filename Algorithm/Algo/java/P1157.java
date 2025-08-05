import java.io.*;

public class P1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();

        int[] counts = new int[26];

        for (int i = 0; i < word.length(); i++) {
            counts[word.charAt(i) - 'A']++;
        }

        int max = 0;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (counts[i] > max) {
                max = counts[i];
                result = (char) (i + 'A');
            } else if (counts[i] == max) { // 기존 맥스와 같은게 발견된다면 ? 출력..
                result = '?';
            }
        }
        System.out.println(result);
    }
}
