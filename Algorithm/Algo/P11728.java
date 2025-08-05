import java.io.*;

public class P11728 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        String line;

        while ((line = br.readLine()) != null) { // EOF까지
            System.out.println(line);
        }
    }
}