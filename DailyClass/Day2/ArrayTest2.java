import java.util.Scanner;

public class ArrayTest2 {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		for (int x : arr) {
			System.out.print(x);
		}
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();
		String[] str_arr = new String[choice];

		for (int i = 0; i < choice; i++){
			str_arr[i] = sc.nextLine();
		}

		for (String word : str_arr){
			System.out.println(word);
		}
	}
}
