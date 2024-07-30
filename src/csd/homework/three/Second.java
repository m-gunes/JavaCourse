package csd.homework.three;

/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-2.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/
public class Second {

	public static void run() {
		PrimeXTest.run();
	}
}

class PrimeXTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Bir sayi giriniz:");
			long a = Long.parseLong(kb.nextLine());
			if(PrimeUtil.isPrimeX(a))
				System.out.printf("%d sayisi ve sayinin basamaklari toplamlarinin hepsi Asal sayidir.%n", a);
			else
				System.out.printf("%d sayisi veya sayinin basamaklari toplamlarinin hepsi Asal sayi degildir.%n", a);
		}
	}
}

class PrimeUtil {
	public static boolean isPrimeX(long val) {
		
		while(val > 9) {
			int total = sumOfDigitsOfANumber(val);
			if(isPrime(total)) {
				val = total;
			} else 
				return false;
		} 
		
		return isPrime(val);
	}
	
	public static int sumOfDigitsOfANumber(long number) {
		int total = 0;
		while(number != 0) {
			total += number % 10;
			number /= 10;
		}
		return total;
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
