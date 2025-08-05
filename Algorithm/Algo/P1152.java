    import java.io.*;
    import java.util.*;

    public class P1152 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 공백 기준 분리

            System.out.println(st.countTokens()); // 단어 개수 출력


        }
    }
