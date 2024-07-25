package csd.lessons;

public class StringLes44 {
	public static void run() {
		StringUtilReverseTest.run();
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