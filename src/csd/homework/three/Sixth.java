package csd.homework.three;

/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-6.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/

public class Sixth {
	public static void run() {
		HardyRamanujanTest.run();
	}
}

class HardyRamanujanTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		for(int i = 10; i <= 100_000; ++i) {
			if(NumberUtil4.isHardyRamanujan(i))
				System.out.printf("%d hardy ramanujan sayısıdır%n", i);
		}
	}
}

class NumberUtil4 {
	
	public static boolean isHardyRamanujan(int n) {
		
		double cubeRootOfN = Math.cbrt(n);
		
		for(int a = 1; a < cubeRootOfN; ++a) { 
			int b = (int) Math.cbrt(n - cube(a));
			if(n == cube(a) + cube(b)) {
				for(int c = a + 1; c < cubeRootOfN; ++c) {
					int d = (int) Math.cbrt(n - cube(c));
					if(n == cube(c) + cube(d) && a != d && c != b ) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static int cube(int val) {
		return val * val * val;
	}
}
