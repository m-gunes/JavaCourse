package csd.homework.three;


/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-5.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/

public class Fifth {
	public static void run() {
		SuperPrimeTest.run();
	}
}

class SuperPrimeTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Bir sayi giriniz:");
			long a =  Long.parseLong(kb.nextLine());
			System.out.printf("%d sayisi super asal sayidir %b%n", a, NumberUtil3.isSuperPrime(a));
		}
	}
}

class NumberUtil3 {
	public static boolean isSuperPrime(long val) {
		
		if(!isPrime(val))
			return false;
		
		int index = 1;
		
		for(int i = 3; i <= val; i += 2) {
			if(isPrime(i))
				++index;
		}
		return isPrime(index);
				
		/*
		 *
		 * i1: i=3 index=2
		 * i2: i=5 index=3
		 * i3: i=7 index=4
		 * i4: i=9
		 * i5: i=11 index=5
		 * i6: i=13 index=6
		 * i7: i=17 index=7
		 * 
		 * */

		// 1. 2
		// 2. 3  *
		// 3. 5  * 
		// 4. 7
		// 5. 11 *
		// 6. 13
		// 7. 17 *
	}
	public static boolean isPrime(long val) {
		if(val <= 1)
			return false;

		if(val % 2 == 0)
			return val == 2;
		
		if(val % 3 == 0)
			return val == 3;
		
		if(val % 5 == 0)
			return val == 5;
		
		if(val % 7 == 0)
			return val == 7;
		
		// eger bir sayi(19) karakokunden (4.35) kucuk olan hic bir asal sayiya tam olarak bolunemiyorsa asaldir.
		// If a number is not divisible by a prime number less than its square root, then it is a prime number.
		for(int i = 11; i * i <= val; i +=2) {
			if(val % i == 0)
				return false;
		}
		
		return true;
		
		
	}
}