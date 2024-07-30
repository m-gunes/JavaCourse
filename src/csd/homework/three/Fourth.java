package csd.homework.three;


/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-4.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/

public class Fourth {

	public static void run() {
		FactorianTest.run();
	}
}

class FactorianTest {
	public static void run() {
		for(int i = 1; i < 100_000; i++) {
			if(NumberUtillsss.isFactorian(i))
				System.out.printf("%d sayisi factorian sayidir %n", i);
		}
	}
}

class NumberUtillsss {
	public static boolean isFactorian(int val) {
		return val == sumOfFactorialOfDigitsOfANumber(val);
	}

	public static long sumOfFactorialOfDigitsOfANumber(int number) {

		long total = 0;

		while(number != 0) {
			total += factorial(number % 10);
			number /= 10;
		}

		return total;
	}
	
	public static long factorial(int val) { 

		int result = 1;
		for(int i = 2; i <= val; ++i) {
			result *= i;
		}

		return result;
	}
}
