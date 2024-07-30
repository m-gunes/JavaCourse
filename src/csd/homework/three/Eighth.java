package csd.homework.three;

/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-8.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/

public class Eighth {

	public static void run() {
		CollatzTest.run();
	}
}

class CollatzTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayi giriniz:");
		int a = kb.nextInt();
		PrintUtilll.printCollatz(a);
	}
}

class PrintUtilll {
	public static void printCollatz(int n) {
		
		if(n < 1)
			return;
		
		while(n != 1) {
			
			if(n % 2 == 0)
				n /= 2;
			else
				n = 3 * n + 1;

			System.out.println(n);
		}
	}
}
