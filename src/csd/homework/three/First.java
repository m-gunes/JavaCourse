package csd.homework.three;
/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-1.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/

public class First {
	public static void run() {
		PrimeAbcTest.run();
	}

}


class PrimeAbcTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		for(int i = 100; i < 1000; ++i) {
			if(NumberUtil.abc(i))
				System.out.println(i);
		}
	}
}

class NumberUtil {
	public static boolean abc(int abc) {
		
		int cba = reverseNumber(abc);

		// todo: switch icerisinde yazilabilir.
		return cba > abc && isPrime(abc) && isPrime(cba) && isPrime(abc / 10) && isPrime(abc % 100) && isPrime(cba / 10) && isPrime(cba % 100);
	}
	
	
	public static int reverseNumber(int abc) { // todo: look again
		int a = abc / 100; 
		int c = abc % 10;
		int b = abc / 10 % 10;
		int cba = c * 100 + b * 10 + a;
		return cba;
	}
	
	public static boolean isPrime(long a) {
		if(a <= 1)
			return false;
		if(a % 2 == 0)
			return a == 2;
		if(a % 3 == 0)
			return a == 3;
		if(a % 5 == 0)
			return a == 5;
		if(a % 7 == 0)
			return a == 7;
		
		// Bir sayi karakokunden kucuk olan hic bir asal sayiya tam olarak bolunemiyorsa asaldir
		// If a number is not divisible by a number less than its square root, then it is a prime number. 
		for(long i = 11; i * i <= a; i += 2) { 
			if(a % i == 0)
				return false;
		}

		return true;
	}
	
}

