import java.io.*;

public class P5597 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 백준 제출용
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"))); // 로컬 테스트용

        boolean[] submitted = new boolean[30]; // 제출 여부 체크

        for (int i = 0; i < 28; i++) {
            int student = Integer.parseInt(br.readLine()) - 1;
            submitted[student] = true;
        }

        for (int i = 0; i < 30; i++) {
            if (!submitted[i]) {
                System.out.println(i + 1);
            }
        }
    }
}
