/*----------------------------------------------------------------------------------------------------------------------	 
Homework-002-5.sorunun çözümü

Soru: 2'den büyük tum çift sayılar iki asal sayının toplamı biçiminde yazılabilir (Goldbach teoremi).
Klavyeden bir çift sayı alan ve bunu iki asal sayının toplamı biçiminde yazdıran programı yazınız. Örneğin:

Sayı: 16

11 + 5 
-----------------------------------------------------------------------------------------------------------------------*/
package csd.homework.two;

public class Fifth {

	public static void main() {
		PrintGoldbachApp.run();
	}
}


class PrintGoldbachApp {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("2'den büyük çift bir sayı giriniz:");
			int a = Integer.parseInt(kb.nextLine());
			
			if (a <= 2)
				break;
			
			if (a % 2 != 0) {
				System.out.println("Hatalı giriş!...");
				continue;
			}
			
			printGoldbach(a);	
		}
	}

	public static void printGoldbach(int a) {
		
		for(int x = a - 1; x >= 2; --x) {
			int y = a - x;
			
			if(isPrime(x) && isPrime(y) && x >= y)
				System.out.printf("%d + %d = %d == %d%n", x, y, x + y, a);
		}
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
		
		for(long i = 11; i * i <= a; i += 2) {
			if(a % i == 0)
				return false;			
		}
		
		return true;
	}
}



// old version
class NumberUtilss {
	
	public static void printGoldbachConjecture(long even) {
		if(even <= 2 || even % 2 != 0)
			return;
		
		long half = even / 2;

		if(isPrime(half)) {
			System.out.printf("%d + %d = %d %n", half, half, even);
		} else {
			long a = prevClosestPrime(half);
			long b = nextClosestPrime(half);
			if(a + b < even)
				b = nextClosestPrime(b);
			if(a + b > even)
				a = prevClosestPrime(a);

			System.out.printf("%d + %d = %d %n", a, b, even);
		}
	}
	
	public static long prevClosestPrime(long a) {
		if(a < 2)
			return a;
		
		while(!isPrime(--a))
			;

		return a;
	}
	
	public static long nextClosestPrime(long a) {
		if (a < 2)
			return 2;
		
		while (!isPrime(++a))
			;
		
		return a;		
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
		
		for(long i = 11; i * i <= a; i += 2) {
			if(a % i == 0)
				return false;			
		}
		
		return true;
	}
}
