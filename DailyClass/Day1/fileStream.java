package Day1;
import java.io.*;
import java.util.Scanner;

public class fileStream {
    public static void main(String[] args) throws Exception {

        // 1. 입력을 파일로 변경 (System.in → input.txt)
        FileInputStream fis = new FileInputStream("input.txt");
        System.setIn(fis); // System.in 변경

        // 2. 출력을 파일로 변경 (System.out → output.txt)
        PrintStream psOut = new PrintStream("output.txt");
        System.setOut(psOut); // System.out 변경

        // 3. 에러 출력을 파일로 변경 (System.err → error.txt)
        PrintStream psErr = new PrintStream("error.txt");
        System.setErr(psErr); // System.err 변경

        // 4. Scanner로 입력 읽기
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if (line.equalsIgnoreCase("error")) {
                System.err.println("⚠️ 에러 발생! 입력값: " + line); // 에러 출력
            } else {
                System.out.println("입력값: " + line); // 일반 출력
            }
        }

        // 5. 스트림 닫기
        sc.close();
        fis.close();
        psOut.close();
        psErr.close();

        // white space = 띄어쓰기, \t, \n
        // nextInt, nextDobule, next() 와 같은 메소드들은 white space 만나기 전까지 처리 (즉 아직 file에는 white space가 남아있는 상태임)
        // nextLine의 경우에는 개행문자까지 처리한다.
    }
}
