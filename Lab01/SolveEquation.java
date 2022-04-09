import java.util.Scanner;
public class SolveEquation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if (n == 1) {
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			if (a == 0) {
				System.out.println("No solution");
			} else {
				System.out.println("x = " + (-b/a));
			}
		}
		else if (n == 2) {
			double a1 = sc.nextDouble();
			double b1 = sc.nextDouble();
			double c1 = sc.nextDouble();
			double a2 = sc.nextDouble();
			double b2 = sc.nextDouble();
			double c2 = sc.nextDouble();
			double D = a1*b2 - a2*b1;
			double Dx = c1*b2 - c2*b1;
			double Dy = a1*c2 - a2*c1;
			if (D != 0) {
				System.out.println("x = " + (Dx/D) + "\n" + "y = " + (Dy/D));
			} else {
				if (Dx != 0 || Dy != 0) {
					System.out.println("No solution");
				} else {
					System.out.println("Infinitely many solutions");
				}
			}
		}
		else if (n == 3) {
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double c = sc.nextDouble();
			double delta = b*b - 4*a*c;
			if (delta < 0) {
				System.out.println("No solution");
			}
			if (delta == 0) {
				System.out.println("x = " + (-b/(2*a)));
				
			} else {
				System.out.println("x1 = " + ((-b + Math.sqrt(delta))/(2*a)) + "\nx2 = " + ((-b - Math.sqrt(delta))/(2*a)));
			}
		}
	}
}