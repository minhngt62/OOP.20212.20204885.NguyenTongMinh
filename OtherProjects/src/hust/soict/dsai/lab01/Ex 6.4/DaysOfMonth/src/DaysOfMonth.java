import java.util.Scanner;
public class DaysOfMonth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int month = 0;
		while (month == 0) {
			System.out.println("Enter (or re-enter) a valid month: ");
			String strMonth = sc.next();
			if (strMonth.equals("1") || strMonth.equals("Jan.") || strMonth.equals("Jan") || strMonth.equals("January")) {
				month = 1;
			}
			else if (strMonth.equals("2") || strMonth.equals("Feb.") || strMonth.equals("Feb") || strMonth.equals("February")) {
				month = 2;
			}
			else if (strMonth.equals("3") || strMonth.equals("Mar.") || strMonth.equals("Mar") || strMonth.equals("March")) {
				month = 3;
			}
			else if (strMonth.equals("4") || strMonth.equals("Apr.") || strMonth.equals("Apr") || strMonth.equals("April")) {
				month = 4;
			}
			else if (strMonth.equals("5") || strMonth.equals("May")) {
				month = 5;
			}
			else if (strMonth.equals("6") || strMonth.equals("June") || strMonth.equals("Jun")) {
				month = 6;
			}
			else if (strMonth.equals("7") || strMonth.equals("Jul") || strMonth.equals("July")) {
				month = 7;
			}
			else if (strMonth.equals("8") || strMonth.equals("Aug.") || strMonth.equals("Aug") || strMonth.equals("August")) {
				month = 8;
			}
			else if (strMonth.equals("9") || strMonth.equals("Sept.") || strMonth.equals("Sep") || strMonth.equals("September")) {
				month = 9;
			}
			else if (strMonth.equals("10") || strMonth.equals("Oct.") || strMonth.equals("Oct") || strMonth.equals("October")) {
				month = 10;
			}
			else if (strMonth.equals("11") || strMonth.equals("Nov.") || strMonth.equals("Nov") || strMonth.equals("November")) {
				month = 11;
			}
			else if (strMonth.equals("12") || strMonth.equals("Dec.") || strMonth.equals("Dec") || strMonth.equals("December")) {
				month = 12;
			}
			else {
				System.out.println("Invalid month!");
			}
		}
		
		int year = -1;
		while (year == -1) {
			System.out.println("Enter (or re-enter) a valid year: ");
			String strYear = sc.next();
			try {
				year = Integer.parseInt(strYear);
			}
			catch (NumberFormatException ex) {
				System.out.println("Invalid year!");
				continue;
			}
		}
		
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
