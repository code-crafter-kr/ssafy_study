import java.io.*;
import java.util.StringTokenizer;


public class P10988 {
    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = st.nextToken();

        if (checker(word)) System.out.println("1");
        else System.out.println("0");

    }

    public static boolean checker(String word){
        for (int i = 0; i < word.length() / 2; i++){
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) return false;
        }
        return true;
    }
}
