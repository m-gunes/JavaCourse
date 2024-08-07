package csd.lessons;

/*----------------------------------------------------------------------------------------------------------------------
Anahtar Notlar: java.util.Scanner sınıfının çalışma sistemi gereği bazı sistemlerde aynı nesne ile nextLine ve
temel türlere ilişkin nextXXX metotları peşpeşe kullanılmamalıdır. Bu Scanner açısından bir problem değildir, 
Scanner'ın içsel çalışması ile ilgili sistemin içsel yapısı gereği oluşan bir sonuçtur. Detayının önemi yoktur.
Programcı bu tip durumlarda hep nextLine metoduyla değerleri alması ve temel türler için ilgili parseXXX metotlarını
çağırmalıdır
---------------------------------------------------------------------------------------------------------------------*/

public class StringLes45 {
	public static void run() {
//		StringUtilPalindromeTest.run();
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Input a name:");
			String name = kb.nextLine();
			
			if("exit".equals(name))
				break;
			
			System.out.print("Input a no:");
//			int no = kb.nextInt(); // Error: java.util.InputMismatchException
			int no = Integer.parseInt(kb.nextLine());
			
			System.out.printf("no:%d name:%s%n", no, name);
		}
	}
}



/*----------------------------------------------------------------------------------------------------------------------
Sınıf Çalışması: Aşağıdaki metotları açıklamalara göre StringUtil sınıfı içerisinde yazınız ve test ediniz.
	public static String padLeading(String s, int n, char ch);
	public static String padLeading(String s, int n);
	public static String padTrailing(String s, int n, char ch);
	public static String padTrailing(String s, int n);
Açıklamalar: 
	- padLeading metodunun üç parametreli overload'u parametresi ile aldığı yazıyı ikinci parametresi ile aldığı
	uzunluk kadar baştan ch karakteri ile besleyecektir. İkinci parametresi ile aldığı uzunluk bilgisi ilgili 
	yazının uzunluğundan küçük veya eşit aynı yazıya geri dönecektir. 
	Örneğin: 
		padLeading("ankara", 8, 'x');
	çağrısı ile
		xxankara 
	yazısı elde edilecektir.
	Örneğin:
		padLeading("ankara", 5, 'x');
	çağrısı ile 
		ankara
	yazısı elde edilecektir.
	- padLeading metodunun iki parametreli overload'u yazıyı space karakteri ile besleyecektir.
	- padTrailing metotları padLeading'in yaptıklarını sondan besleyecek şekilde yapacaktır.
	- Metotlar Java 11 öncesi için yazılacaktır
---------------------------------------------------------------------------------------------------------------------*/

class StringUtilPadLeadingTrailingTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Input string:");
			String s = kb.nextLine();

			if("exit".equals(s))
				break;

			System.out.print("Input count:");
//			int n = kb.nextInt(); // java.util.InputMismatchException => aynı nesne ile nextLine ve temel türlere ilişkin nextXXX metotları peşpeşe kullanılmamalıdır
			int n = Integer.parseInt(kb.nextLine());

			System.out.printf("padLeading with char: %s%n", StringUtil9.padLeading(s, n, 'x'));
			System.out.printf("padLeading with char: %s%n", StringUtil9.padLeading(s, n));

			System.out.printf("padLeading with char: %s%n", StringUtil9.padTrailing(s, n, 'x'));
			System.out.printf("padLeading with char: %s%n", StringUtil9.padTrailing(s, n));
			
		}
	}
	
}

class StringUtil7 {

	public static String repeat(int n, char ch) {

		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; ++i)
			sb.append(ch);

		return sb.toString();
	}
	
	public static String padLeading(String s, int n, char ch) {
		int len = s.length();
		
		return len < n ? repeat(n - len, ch) + s : s;
//		return s.length() > n ? (""+ ch).repeat(n) + s : s;
	}
	
	public static String padLeading(String s, int n) {
		return padLeading(s, n, ' ');
	}
	
	public static String padTrailing(String s, int n, char ch) {
		int len = s.length();
		return len < n ? s + repeat(n-len, ch) : s;
	}
	
	public static String padTrailing(String s, int n) {
		return padTrailing(s, n, ' ');
	}
	
}


/*----------------------------------------------------------------------------------------------------------------------
	- Metotlar Java 11 ve sonrasi için cozum:
---------------------------------------------------------------------------------------------------------------------*/

class StringUtil8 {
	
	public static String padLeading(String s, int n, char ch) {
		int len = s.length();
		return len < n ? (ch + "").repeat(n - len) + s : s;
	}
	
	public static String padLeading(String s, int n) {
		return padLeading(s, n, ' ');
	}
	
	public static String padTrailing(String s, int n, char ch) {
		int len = s.length();
		return len < n ? s + (ch + "").repeat(n-len) : s;
	}
	
	public static String padTrailing(String s, int n) {
		return padTrailing(s, n, ' ');
	}
}
		

/*----------------------------------------------------------------------------------------------------------------------
	- Metotlar Java 11 ve sonrasi için cozum, String.valueOf() kullanimi:
---------------------------------------------------------------------------------------------------------------------*/

class StringUtil9 {
	
	public static String padLeading(String s, int n, char ch) {
		int len = s.length();
		return len < n ? String.valueOf(ch).repeat(n - len) + s : s;
	}
	
	public static String padLeading(String s, int n) {
		return padLeading(s, n, ' ');
	}
	
	public static String padTrailing(String s, int n, char ch) {
		int len = s.length();
		return len < n ? s + String.valueOf(ch).repeat(n-len) : s;
	}
	
	public static String padTrailing(String s, int n) {
		return padTrailing(s, n, ' ');
	}
}


/*----------------------------------------------------------------------------------------------------------------------
Sınıf Çalışması: Parametresi ile aldığı bir yazının pangram olup olmadığını test eden isPangramTR ve isPangramEN 
isimli metotları yazınız ve aşağıdaki kod ile test ediniz.
Açıklamalar:
	- İlgili dilin alfadbesindeki tüm karakterler kullanılarak oluşturulan ve içerisinde özel isim olmayan anlamlı 
	cümlelere "pangram" denir. 
	Örneğin tipik bir İnglizce pangram şudur:		
		The quick brown fox jumps over the lazy dog.
		
	Örneğin tipik bir Türkçe pangram şudur:
		Pijamalı hasta yağız şoföre çabucak güvendi.
	
	- Metotlar, cümlenin anlamına ve özel isim içerip içermediğine bakmayacaktır
---------------------------------------------------------------------------------------------------------------------*/

class PangramTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		PangramTRTest.run(kb);
		PangramENTest.run(kb);
	}
}

class PangramTRTest {
	public static void run(java.util.Scanner kb) {
		while (true) {
			System.out.print("Bir yazı giriniz:");
			String s = kb.nextLine();
			
			if ("elma".equals(s))
				break;
			
			System.out.println(StringUtil10.isPangramTR(s) ? "Pangram" : "Pangram değil");			
		}
	}
}


class PangramENTest {
	public static void run(java.util.Scanner kb) {		
		while (true) {
			System.out.print("Input string:");
			String s = kb.nextLine();
			
			if ("exit".equals(s))
				break;
			
			System.out.println(StringUtil10.isPangramEN(s) ? "Pangram" : "Not a pangram");			
		}
	}
}


/*----------------------------------------------------------------------------------------------------------------------
String sınıfının contains metodu bir yazı içerisinde parmetesi ile aldığı yazının var olup olmadığını test eder.
Metodun geri dönüş değeri boolean türündendir

Anahtar Notlar: contains metodunun parmetresi Charsequence türündendir. Charsequence gereken yerlerde String referansı 
verilebilir. Detaylar ileride ele alınacaktır
---------------------------------------------------------------------------------------------------------------------*/

class StringUtil10 {

	public static boolean isPangram(String s, String alphabet) {
		for(int i = 0; i < alphabet.length(); ++i)
			if(!s.contains(String.valueOf(alphabet.charAt(i))))
				return false;
		
		return true;
	}
	
	public static boolean isPangramTR(String s) {
		return isPangram(s.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
	}

	public static boolean isPangramEN(String s) {
		return isPangram(s.toLowerCase(), "abcdefghijklmnopqrstuvwxyz");
	}
}



/*----------------------------------------------------------------------------------------------------------------------
Sınıf Çalışması: Parametresi ile aldığı bir yazının palindrome olup olmadığını test eden isPalindrome isimli
metodu StringUtil sınıfı içerisinde yazınız ve test ediniz.
Açıklamalar:
 	- Alfabetik olmayan karakterleri çıkartıldığında tersi kendisine eşit olan yazılara pandrom denir.
 	Örneğin
 		- Ey Edip Adana'da pide ye
 		- Anastas mum satsana
 		- Ali Papila
 	- Palindromlar case-insensitive'dir
---------------------------------------------------------------------------------------------------------------------*/

class StringUtilPalindromeTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Input a string:");
			String s = kb.nextLine();

			if("exit".equals(s))
				break;
			
			System.out.println(StringUtil11.isPalindrome(s) ? "Palindrome" : "Not a palindrome");
		}
	}
}


class StringUtil11 {
	public static boolean isPalindrome(String s) {
		int leftIdx = 0;
		int rightIdx = s.length() - 1;
//		s = s.toLowerCase();

		while(leftIdx < rightIdx) {
			
			char cLeft = s.charAt(leftIdx);

			if(!Character.isLetter(cLeft)) {
				++leftIdx;
				continue;
			}

			char cRight = s.charAt(rightIdx);
			
			if(!Character.isLetter(cRight)) {
				--rightIdx;
				continue;
			}

			if(Character.toLowerCase(cLeft) != Character.toLowerCase(cRight))
				return false;

			++leftIdx;
			--rightIdx;
		}

		return true;
	}
	
	
	// old version. Not efficient
	public static String getAlphabeticString(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); ++i) {
			if(Character.isAlphabetic(s.charAt(i)))
				sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}
	
	public static boolean isPalindromeV2(String s) {
		
		if(s.isBlank())
			return false;
		
		String str = getAlphabeticString(s.toLowerCase());
		return str.equals(new StringBuilder(str).reverse().toString());
	}
}



