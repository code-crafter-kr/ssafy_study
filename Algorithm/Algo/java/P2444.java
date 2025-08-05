import java.io.*;

public class P2444 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1; // 초기 별 개수는 1개


        for (int i = 0; i < n; i++) { // n이 5일때 9번반복 
            StringBuilder output = new StringBuilder();
            for (int j = 0; j < n - 1 - (count/2); j++){ // 공백 추가
                output.append(" ");
            }  

            for (int j = 0; j < count; j++){ // 별 추가
                output.append("*");
            }


            count += 2; // 별 개수 두개씩 늘림
            System.out.println(output.toString());
        }

        count -= 4; // 카운트 보정 줄이기

        for (int i = 0; i < n - 1; i++) { // 추후 4번
            StringBuilder output = new StringBuilder();
            for (int j = 0; j < n - 1 - (count/2); j++){ // 공백 추가
                output.append(" ");
            }  

            for (int j = 0; j < count; j++){ // 별 추가
                output.append("*");
            }


            System.out.println(output.toString());
            count -= 2; // 별 개수 두개씩 줄임
        }
    }
}
