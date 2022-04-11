import java.util.Scanner;
public class DoubleOperation {
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		
		System.out.println("x + y = " + (x + y));
		System.out.println("x * y = " + (x * y));
		System.out.println("x - y = " + (x - y));
		System.out.println("y - x = " + (y - x));
		if (y == 0) {
			System.out.println("ZeroDivisor x / y: y = 0");
		} else {
			System.out.println("x / y = " + (x / y));
		}
		if (x == 0) {
			System.out.println("ZeroDivisor y / x: x = 0");
		} else {
			System.out.println("y / x = " + (y / x));
		}
	}
}