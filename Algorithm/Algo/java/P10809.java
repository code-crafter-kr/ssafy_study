import java.io.*;

public class P10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        // StringTokenizer st = new StringTokenizer(br.readline());

        String word = br.readLine();

        int[] lst = new int[26];
        
        for (int i = 0; i < 26; i++) {
            lst[i] = -1;
        }

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 97;
            if (lst[idx] == -1) lst[idx] = i;
        }

        for (int x : lst){
            System.out.print(x + " ");
        }
    }
}
