import java.util.*;
import java.io.*;

public class SW1952_SwimmingPool_장세현 {
	static int answer;
	static int[] prices;
	static int[] schedule;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int TC = Integer.parseInt(st.nextToken());
        
        for (int t = 1; t <= TC; t++) {
        	
        	st = new StringTokenizer(br.readLine());
        	
        	prices = new int[4];
        	for (int i = 0; i < 4; i++) {
        		prices[i] = Integer.parseInt(st.nextToken());
        	}
        	answer = prices[3]; // 항상 1년 고정권을 디폴트로 잡고 가버리기
        	
        	st = new StringTokenizer(br.readLine());
        	schedule = new int[12];
        	for (int i = 0; i < 12; i++) {
        		schedule[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	dfs(0, 0); // 1번달과 0 코스트로 전달
        	
        	
        	sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

    	System.out.println(sb);
    }
    
    public static void dfs(int idx, int currentCost) {
    	if (idx > 11) { // 모든 달 도달 시점
    		answer = Math.min(currentCost, answer);
    		return;
    	}
    	
    	// 1달권 or 1일권을 사는 경우
    	if (prices[0] * schedule[idx] > prices[1]) { // 한달 권 사는게 이득임
    		dfs(idx + 1, currentCost + prices[1]);
    	} else {
    		dfs(idx + 1, currentCost + prices[0] * schedule[idx]); // 1일 권 사는게 이득임
    	}
    	// 분기점 2 3달권 사는경우
    	dfs(idx + 3, currentCost + prices[2]); // 한번에 세달을 건너 뛰고 큰 가격을 더해서 넘겨버림
    }
}
