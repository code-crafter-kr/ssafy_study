import java.io.*;
public class P27866 {
    public static void main(String args[]) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        String word = br.readLine();
        int idx = Integer.parseInt(br.readLine());

        System.out.println(word.charAt(idx-1));

    }
}
