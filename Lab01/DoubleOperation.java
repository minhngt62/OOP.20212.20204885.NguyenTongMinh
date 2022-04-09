import java.util.Scanner;
public class DoubleOperation {
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double num1 = sc.nextDouble();
		double num2 = sc.nextDouble();
		
		System.out.println("Sum: " + (num1 + num2));
		System.out.println("Difference: " + (num1 - num2));
		System.out.println("Product: " + (num1 * num2));
		if (num2 == 0) {
			System.out.println("None");
		} else {
			System.out.println("Quotient: " + (num1 / num2));
		}
	}
}