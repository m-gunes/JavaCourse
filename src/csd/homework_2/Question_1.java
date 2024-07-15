package csd.homework_2;

public class Question_1 {
	public static void main() {
		BaklavaPatternTest.run();
	}

}

class BaklavaPatternTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("0'dan büyük bir sayı giriniz:");
		int n = kb.nextInt();
		Patterns.baklavaPattern(n);
	}
}

class Patterns {
	
	public static void baklavaPattern(int n) {
		
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
	
}
