package csd.homework.three;

/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-7.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/

public class Seventh {

	public static void run() {
		DecimalHarshadTest.run();
	}
}

class DecimalHarshadTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Bir sayi giriniz:");
			int a = Integer.parseInt(kb.nextLine());
			System.out.printf("%d sayisi harshad sayisidir %b%n", a, NumberUtills.isDecimalHarshad(a));
			if(a == 0)
				break;
		}
	}
}

class NumberUtills {
	public static boolean isDecimalHarshad(int val) {

		if(val < 1)
			return false;
		
		return val % sumOfDigitsOfNumber(val) == 0;
	}
	
	public static int sumOfDigitsOfNumber(int val) {

		int total = 0;

		while(val != 0) {
			total += val % 10;
			val /= 10;
		}

		return total;
	}
}
