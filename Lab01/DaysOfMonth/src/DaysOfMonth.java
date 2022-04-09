import java.util.Scanner;
public class DaysOfMonth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int month = sc.nextInt();
		int year = sc.nextInt();
		
		int numberOfDays = 0;
		
		if (month == 2) {
			if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
				numberOfDays = 29;
			} else {
				numberOfDays = 28;
			}
		} else {
			if (month <= 7) {
				if (month % 2 != 0) {
					numberOfDays = 31;
				} else {
					numberOfDays = 30;
				}
			} else {
				if (month % 2 != 0) {
					numberOfDays = 30;
				} else {
					numberOfDays = 31;
				}
			}
		}
		
		System.out.println("The number of days is " + numberOfDays);
	}
}
