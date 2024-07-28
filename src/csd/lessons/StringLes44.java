package csd.lessons;

public class StringLes44 {
	public static void run() {
//		StringUtilIsPangramTest.run();
char c;
		
		c = 68;
		if(68 == 'D')
			System.out.print("yes ");
		
		System.out.printf("c = %c%n %c%n", c, 'a');
		System.out.println('a');
	}
	
	public static String changeCase(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			sb.append(Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c));
		}
		
		return sb.toString();
	}

	public static String changeCase2(String s) {

		StringBuilder sb = new StringBuilder(s);

		for(int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			sb.setCharAt(i, Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c));
		}
		
		return sb.toString();
	}

	public static void changeCaseTest() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Input string:");
			String s = kb.nextLine();
			System.out.printf("%s%n", changeCase2(s));
			
			if("exit".equals(s))
				break;
		}
	}
	
	public static void stringRepeat() {
		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Input string:");
			String s = kb.nextLine();
			if("exit".equals(s))
				break;
			System.out.printf("%s%n", s.repeat(5));
		}
	}
	
	public static void blankCheck() {
		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Input string:");
			String s = kb.nextLine();
			if("exit".equals(s))
				break;
			System.out.println(s.isBlank() ? "Blank string" : "Not a blank string");
			System.out.println(s.isEmpty() ? "Empty string" : "Not a empth string");
		}
	}
}




/*----------------------------------------------------------------------------------------------------------------------
Sınıfı Çalışması: Parametresi ile aldığı yazının tersini döndüren reverse isimli metodu yazınız ve aşağıdaki kod
ile test ediniz.
Açıklamalar: Metodun yazımında performansı (ya da daha genel bir deyişle hızı) düşünmenize gerek yoktur.

Anahtar Notlar: Aşağıdaki reverse metodunda String birleştirme işlemi sırasında sürekli String nesnesi yaratılıp
referans da eski nesneden kopartılmaktadır. Burada bellek açısından bir sorun oluşmasa da nesne yaratılması bir 
maliyet oluşturur:

	str += s.charAt(i)
ifadesinin
	str = (String)(str + s.charAt(i))
ifadesine karşılık geldiğini anımsayınız

Not: Bu metodun daha hızlı olacak şekilde çözümleri ileride ele alınacaktır
---------------------------------------------------------------------------------------------------------------------*/

class StringUtilReverseTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Input string:");
			String s = kb.nextLine();
			System.out.printf("Reverse = %s%n", StringUtil5.reverse2(s));
			System.out.printf("reverse metodunun en etkin ve compact yazım: %s%n", StringUtil5.reverse3(s));
			
			if("exit".equals(s))
				break;
		}
		
	}
}

class StringUtil5 {
	public static String reverse(String s) {
		String str = "";
		
		for(int i = s.length() - 1; i >= 0; --i) {
			str += s.charAt(i);
		}
		return str;
	}
	
	public static String reverse2(String s) {

		StringBuilder sb = new StringBuilder();

		for(int i = s.length() - 1; i >= 0; --i)
			sb.append(s.charAt(i));
		
		return sb.toString();
	}
	
	public static String reverse3(String s) {
		return new StringBuilder(s).reverse().toString(); // reverse metodunun en etkin ve compact yazımı
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



class StringUtilIsPangramTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		StringUtilIsPangramTRTest.run(kb);
		StringUtilIsPangramENTest.run(kb);
	}
}

class StringUtilIsPangramTRTest {
	public static void run(java.util.Scanner kb)
	{
		while (true) {
			System.out.print("Bir yazı giriniz:");
			String s = kb.nextLine();
			
			if ("elma".equals(s))
				break;
			
			System.out.println(StringUtil6.isPangramTR(s) ? "Pangram" : "Pangram değil");			
		}
	}
}


class StringUtilIsPangramENTest {
	public static void run(java.util.Scanner kb)
	{		
		while (true) {
			System.out.print("Input string:");
			String s = kb.nextLine();
			
			if ("exit".equals(s))
				break;
			
			System.out.println(StringUtil6.isPangramEN2(s) ? "Pangram" : "Not a pangram");			
		}
	}
}

class StringUtil6 {
	public static boolean isPangram(String s, String alphabet) {
		
		for(int i = 0; i < alphabet.length(); ++i) {
			if(s.indexOf(alphabet.charAt(i)) == -1)
				return false;
		}
		
		return true;
	}

	public static boolean isPangramTR(String s) {
		return isPangram(s.toLowerCase(), "abcçdefgğhiıjklmnoöprsştuüvyz");
	}
	
	public static boolean isPangramEN(String s) {
		return isPangram(s.toLowerCase(), "abcdefghijklmnopqrstuvwxyz");
	}
	
	public static boolean isPangramEN2(String s) {
		
		s = s.toLowerCase();
		
		for(char c = 'a'; c <= 'z'; ++c)
			if(s.indexOf(c) == -1)
				return false;
		
		return true;
	}
	
	public static boolean isPrangamEN3(String s) {
		s = s.toLowerCase();
		for(int i = 0; i < 26; ++i)
			if(s.indexOf((char)('a' + i)) == -1)
				return false;
		
		return true;
	}
	
	public static boolean isPangramEN4(String s) {
		s = s.toLowerCase();
		for(int i = 0; i < 26; ++i)
			if(s.indexOf('a' + i) == -1)
				return false;
		
		return true;
	}
}
