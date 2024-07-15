/*----------------------------------------------------------------------------------------------------------------------	 
Homework-002-1. soru ve çözümü

Soru: klavyeden bir n sayisi okuyunuz ve asagidaki deseni olusturan programi yaziniz. (Asagidaki ornekte n = 6'dir). 

     *
    ***
   *****
  *******
 *********
***********
 *********
  *******
   *****
    ***
     *
 
-----------------------------------------------------------------------------------------------------------------------*/

package csd.homework.two;

public class First {

	public static void main() {
		PrintDiamondApp.run();
	}
}


// yildizlar ikise ikiser artiyor ve azaliyor 

class PrintDiamondApp {
	
	public static void printAbove(int n) {
		for(int i = 1; i < n; ++i) {
			for(int k = 0; k < n - i; ++k)
				System.out.print(" ");

			for(int k = 0; k < 2 * i - 1; ++k)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	public static void printBelow(int n) {
		for(int i = 0; i < n; ++i) {
			for(int k = 0; k < i; ++k)
				System.out.print(" ");

			for(int k = 0; k < 2 * (n - i) - 1; ++k)
				System.out.print("*");
			
			System.out.println();
		}
	}

	public static void printDiamond(int n) {
		printAbove(n);
		printBelow(n);
	}

	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayi giriniz:");
		int n = kb.nextInt();
		printDiamond(n);
	}
}


// Old version
class PrintDiamondApp_old {
	
	public static void printDiamond(int n) {
		
		if(n <= 0)
			return;
		
		int rowLen = n * 2 - 1;
		int asteriskCount = 1;
		boolean isIncreasedAsterisk = true;
		
		for(int i = 0; i < rowLen; ++i) {
			
			for(int j = 0; j < rowLen; ++j) {
				int leftSpace = (rowLen - asteriskCount) / 2;
				if(j < leftSpace)
					System.out.print(" ");
				else if(j < leftSpace + asteriskCount)
					System.out.print("*");
				else {
					System.out.print(" ");
				}
			}

			System.out.println();

			if(isIncreasedAsterisk) {
				asteriskCount += 2;
				if(asteriskCount == rowLen)
					isIncreasedAsterisk = false;
			} else {
				asteriskCount -= 2;
			}

		}
	}
	
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("0'dan büyük bir sayı giriniz:");
		int n = kb.nextInt();
		printDiamond(n);
	}
}
