import java.util.Scanner;
public class TriangleDisplay {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		
		for (int i=0; i<n; i++) {
			for (int j=n-i; j>1; j--) {
				System.out.print(" ");
			}
			for (int j=0; j<=i; j++) {
				System.out.print("*");
			}
			for (int j=i+1; j<=2*i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		keyboard.close();
	}
}
