import java.util.Scanner;

public class EmergencyEscape {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] speed = new int[n];
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            speed[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int[][] speed_recording = new int[3][n];
        int[][] height_recording = new int[3][n];

        for (int b = 2; b <= 4; b++) {
            for (int i = b; i < n; i++) {
                int sum = 0;
                for (int j = i - b; j < i; j++) {
                    sum += speed[j];
                }
                speed_recording[b - 2][i] = sum / b; // 정수 평균
            }
        }

        for (int b = 2; b <= 4; b++) {
            for (int i = b; i < n; i++) {
                height_recording[b - 2][i] = height[i - b] - height[i];
            }
        }

        int escapeTime = -1;

        for (int i = 2; i < n; i++) { // 2분 조건은 i >= 2부터 체크 가능
            if (i >= 4 && height_recording[2][i] >= 4000 && speed_recording[2][i] >= 900) {
                escapeTime = i;
                break;
            }
            if (i >= 3 && height_recording[1][i] >= 3000 && speed_recording[1][i] >= 1000) {
                escapeTime = i;
                break;
            }
            if (height_recording[0][i] >= 2000 && speed_recording[0][i] >= 1100) {
                escapeTime = i;
                break;
            }
        }
        System.out.println(escapeTime == -1 ? -1 : escapeTime + 1);
    }
}
