/*----------------------------------------------------------------------------------------------------------------------	 
Homework-002-3. soru ve çözümü

Bir sayının asal çarpanlarını yazdıran programı yazınız. Örneğin: 
Sayı: 12
2 2 3 

-----------------------------------------------------------------------------------------------------------------------*/
package csd.homework.two;

public class Third {

	public static void main() {
		PrintPrimeFactorsApp.run();
	}
}


class PrintPrimeFactorsApp {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Bir sayi giriniz:");
			int a = Integer.parseInt(kb.nextLine());;
			if(a <= 0)
				break;

			NumberUtil.printPrimeFactors(a);
		}
	}
}

class NumberUtil {
	public static void printPrimeFactors(int a) {
		if(a == 0)
			return;
		a = Math.abs(a);
		int val = 2;

		while(a != 1) {
			if(a % val == 0) {
				System.out.printf("%d ", val);
				a /= val;
			}
			else
				++val;
				// val = 4 oldugunda 4 asal bir sayi olmadigi icin bunu bolmemiz dogru olmaz.
				// 4'ten once 2 geldigi icin ve 2 ler 4'e bolunme ihtimalini tukettiginden, val = 4 olsa bile if kosulunu saglamayacaktir ve else girip val = 5 olacaktir.
				// 6 da da yine durum benzerdir. Asal olan 3 ve 2, asal olmayan 6 nin sayiyi bolme olasiliklarini bitirmistir.
				// Bir sayi hem 2'ye hem 3'e bolunuyorsa 6'ya da bolunur.
				// Sonuc itibariyle her zaman asal sayilara bolunme olasiligi olacaktir. 
				// Asal olan sayilar asal olmayan sayilara o sayiyi bolme olasiligini hic bir zaman vermiyor bu durumda..
		}
		System.out.println();
	}
}






//// old version. Actually no need to use isPrime method.
class NumberUtilPrimeFactorisationTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Bir sayi giriniz:");
			long n = kb.nextLong();
			NumberUtils.primeFactorisation(n);
			System.out.println();
		}
	}
}

class NumberUtils {
	
	public static void primeFactorisation(long n) {
		if(isPrime(n))
			System.out.printf("%d sayısının asal çarpanı %d dır.", n, n);
		
		for(long i = 2; i <= n; i = nextClosestPrime(i)) {
			while(n % i == 0) {
				System.out.printf("%d ", i);
				n /= i;
			}
		}

		System.out.printf("Asal çarpanlardır.");
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
