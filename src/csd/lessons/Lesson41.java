/*----------------------------------------------------------------------------------------------------------------------	 
	Bir String nesnesine ilişkin yazının karakterlerinin her birine sıfırdan başlayarak bir indeks numarası verilmiş
	gibi yani bir dizi gibi düşünebiliriz. Bu durumda bir yazının herhangi bir indeksteki karakterine charAt isimli
	metot ile erişilebilir. Bu metot aldığı indeks numarasına ilişkin karaktere geri döner. Metoda pozitif ya da 
	negatif bakımdan sınırlar dışında bir indeks numarası verildiğinde exception oluşur. Yazının uzunluğu yani kaç tane
	karakterden oluştuğu bilgisi length metodu ile elde edilebilir (ex1)
	
	String sınıfı immutable bir sınıftır. Yani, bir String nesnesine ilişkin yazı değiştirilemez. Bu durumda yazı üzerinde
	değişiklik yapan metotlar değiştirilmiş yazıyı tutan yeni bir String referansına geri dönerler. Örneğin, toLowerCase
	metotları yazının tüm karakterlerini küçük harfe çeviren metottur. Metot ilgili yazıyı değiştiremeyeceğinden tamamı
	küçük harflerden oluşan bir yazıya ilişkin yeni bir String referansına geri döner. Benzer şekilde toUpperCase metotları
	yazının tüm karakterlerini büyük harfe çevirir. Şüphesiz küçük/büyük harf karşılığı olmayan karakterlerin aynıları
	alınır. Bu metotların bu bölümde yalnızca parametresiz overload'ları ele alınacaktır (ex2)
-----------------------------------------------------------------------------------------------------------------------*/

package csd.lessons;


public class Lesson41 {

	public static void run() {
		Lesson41Ex.ex3();
	}
}


class Lesson41Ex {

	public static void ex1() { // charAt
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir yazi giriniz:");
		String s = kb.nextLine();
		int len = s.length();

		System.out.printf("%s length is %d%n",s.toUpperCase(), len);
		
		for(int i = 0; i < len; ++i)
			System.out.printf("%c ", s.charAt(i));
		
		System.out.println();
		char c = s.charAt(5);    
		System.out.printf("c = %c%n", c); // s.length() - 1 < 5 ? ERROR : 5th char of s
	}
	
	public static void ex2() { // String is immutable class
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Enter uppercase and lower text: ");
		String s = kb.nextLine();
		String lower = s.toLowerCase();
		String upper = s.toUpperCase();
		System.out.printf("s = %s%nlower = %s%nUpper = %s%n", s, lower, upper);
	}
	
	public static void ex3() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Enter lower text: ");
		String s = kb.nextLine(); // s is a referance variable. s hold to the referans of String object which is created in here by compiler.
		s = s.toUpperCase(); // uppercase method create a new String object. After assigning, s point new reference(address) of String object which was created by toUpperCaseMethod
		System.out.printf("s = %s%n", s);
	}
}
