import java.util.Scanner;
public class ArrayInfo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		// insertion sort
		for (int i=1; i<n; i++) {
			int key = arr[i];
			int j = i-1;
			while (j >= 0 && key < arr[j]) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
		System.out.print("The sorted array: ");
		for (int i=0; i<n; i++) {
			sum += arr[i];
			if (i < arr.length - 1) {
				System.out.print(arr[i] + " ");
			} else {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
		System.out.println("Sum: " + sum);
		System.out.println("Avg: " + (sum / arr.length));
	}
}
