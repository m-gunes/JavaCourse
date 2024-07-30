/*----------------------------------------------------------------------------------------------------------------------	 
Homework-002-4.sorunun çözümü

Soru: Klavyeden bir height ve width değişkenleri için sayılar okuyunuz ve aşağıdaki deseni oluşturunuz:

|*    |
| *   |
|  *  |
|   * |
|    *|
|   * |
|  *  |
| *   |
|*    |
| *   |
|  *  |
|   * |
|    *|


Burada height tooplam satırların sayısı width ise | karakterlerinin arasındaki karakter alanı sayısıdır. 

-----------------------------------------------------------------------------------------------------------------------*/
package csd.homework.two;

public class Fourth {

	public static void main() {
		BallFallApp.run();
	}
}


class BallFallApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Genişliği giriniz:");
			int width = Integer.parseInt(kb.nextLine());
			
			System.out.print("Yüksekliği giriniz:");
			int height = Integer.parseInt(kb.nextLine());
			
			if (width <= 0 || height <= 0)
				break;
			
			BallFall.play(width, height);
		}
	}
}

class BallFall {
	
	public static void writeSpace(int begin, int end) {
		for(int i = begin; i < end; ++i)
			System.out.print(" ");
	}
	
	public static void writeBall(int ballPosition, int end) {
		writeSpace(0, ballPosition);
		System.out.print("*");
		writeSpace(ballPosition + 1, end);
	}
	
	public static boolean updateRightFlagIfNecessary(boolean currentStatus, int ballPositon, int width) {
		if(ballPositon == 0)
			currentStatus = true;
		else if(ballPositon == width - 1)
			currentStatus = false;
		return currentStatus;
	}
	
	public static int updateBallPositon(int currentPosition, boolean right) {
		if(right)
			return currentPosition + 1;
		return currentPosition - 1;
//		return currentPositon + (right ? 1 : -1);
	}
	
	
	public static void play(int width, int height) {
		boolean right = false;
		int ballPosition = 0;

		for(int i = 0; i <= height; ++i) {
			System.out.print('|');
			writeBall(ballPosition, width);
			if(width != 1) {
				right = updateRightFlagIfNecessary(right, ballPosition, width);
				ballPosition = updateBallPositon(ballPosition, right);
			}
			System.out.println('|');
		}
	}
}



// old version 
class SnakePatternTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("1'den büyük width ve height değeri giriniz:");
		int width = kb.nextInt();
		int height = kb.nextInt();
		Pattern.snakePattern(width, height);
	}
}


class Pattern {
	public static void snakePattern(int width, int height) {
		if(width < 2 || height < 2)
			return;
		
		int asteriskCount = 1;
	    boolean isIncreasedAsterisk = true;
	    
	    
	    for(int i = 0; i < height; ++i) {
	        System.out.print("|");

	        for(int j = 1; j <= width; ++j) {
	            if(j == asteriskCount) {
	                System.out.print("*");
	            } else {
					System.out.print(" ");
	            }
	        }
	        
	        if(isIncreasedAsterisk){
	            ++asteriskCount;
	            if(asteriskCount == width)
	                isIncreasedAsterisk = false;
	        } else {
	            --asteriskCount;
	            if(asteriskCount == 1) 
	            	isIncreasedAsterisk = true;
	        }
	        System.out.printf("|%n");
	    }
	}
}
