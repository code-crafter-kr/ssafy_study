import java.io.*;

public class P10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

        char[][] arr = new char[5][15]; // 최대 15까지 가능

        for (int i = 0; i < 5; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                arr[i][j] = word.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 15; j++) { // 세로 읽기
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] != '\0') { // 빈칸이면 건너뛰기
                    sb.append(arr[i][j]);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
