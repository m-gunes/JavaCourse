/*----------------------------------------------------------------------------------------------------------------------	 
Homework-002-2. soru ve çözümü

Parametresi ile aldığı long türden saniye cinsinden süreyi saat, dakika ve saniye olarak ayrıştırarak ekrana yazdıran 
"printDuration" isimli metodu yazınız. Eğer saat, dakika ya da saniye değeri 0(sıfır) ise ekrana yazdırılmayacaktır. 

-----------------------------------------------------------------------------------------------------------------------*/

package csd.homework.two;


public class Second {

	public static void main() {
		PrintDurationTest.run();
	}
}

class PrintDurationTest{
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Saniye giriniz: ");
			long seconds = kb.nextLong();
			TimeUtil.printDuration(seconds);

			if(seconds == 0)
				break;
		}
	}
}

/*
 * 
 * All we need to know is;
 * 1m = 60s
 * 1h = 60m
 * 
 * */

class TimeUtil {
	public static void printDuration(long totalSeconds) {
		long hours = totalSeconds / 60 / 60; // totalSecond / 3600; 1m = 60s; 1h = 60m
		long minutes = totalSeconds / 60 % 60; // once 60 a bolup kac toplam dk oludugu bulunuyor. sonra 60'a bolumunden kalan ile de dk yi buluyoruz.
		long seconds = totalSeconds % 60;
		
		if(hours != 0)
			System.out.printf("%d saat ", hours);
		if(minutes != 0)
			System.out.printf("%d dakika ", minutes);
		if(seconds != 0)
			System.out.printf("%d saniye ", seconds);
		
		System.out.println();
	}
}

// old version
class DateUtils {
	
	public static void printDuration(long seconds) {

		int hour = (int) (seconds / 3600);
		int reminderOfSeconds = (int) (seconds % 3600);
		int minute = reminderOfSeconds / 60;
		int second = reminderOfSeconds % 60;

		if(hour > 0)
			System.out.printf("%d saat ", hour);
		if(minute > 0)
			System.out.printf("%d dakika ", minute);
		if(second > 0)
			System.out.printf("%d saniye", second);
	}
}
