package csd.homework.three;


/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-3.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/

public class Third {
	public static void run() {
		CalculateDigitalRootTest.run();
	}
}

class CalculateDigitalRootTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Bir sayi giriniz:");
			int a = Integer.parseInt(kb.nextLine());
			System.out.printf("%d sayisinin basamaksal koku = %d%n", a, NumberUtil2.calculateDigitalRoot(Math.abs(a)));
		}
	}
}

class NumberUtil2 {
	public static int calculateDigitalRoot(int val) {
		
		while(val > 9) {
			int total = sumOfDigitsOfANumber(val);
			val = total;
		}

		return val;
	}

	public static int sumOfDigitsOfANumber(int number) {

		int total = 0;

		while(number != 0) {
			total += number % 10;
			number /= 10;
		}

		return total;
	}
}
