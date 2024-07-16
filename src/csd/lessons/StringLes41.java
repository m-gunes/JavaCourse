/*----------------------------------------------------------------------------------------------------------------------	 
	Bir String nesnesine ilişkin yazının karakterlerinin her birine sıfırdan başlayarak bir indeks numarası verilmiş
	gibi yani bir dizi gibi düşünebiliriz. Bu durumda bir yazının herhangi bir indeksteki karakterine charAt isimli
	metot ile erişilebilir. Bu metot aldığı indeks numarasına ilişkin karaktere geri döner. Metoda pozitif ya da 
	negatif bakımdan sınırlar dışında bir indeks numarası verildiğinde exception oluşur. Yazının uzunluğu yani kaç tane
	karakterden oluştuğu bilgisi length metodu ile elde edilebilir (printIndexOfString)
	
	String sınıfı immutable bir sınıftır. Yani, bir String nesnesine ilişkin yazı değiştirilemez. Bu durumda yazı üzerinde
	değişiklik yapan metotlar değiştirilmiş yazıyı tutan yeni bir String referansına geri dönerler. Örneğin, toLowerCase
	metotları yazının tüm karakterlerini küçük harfe çeviren metottur. Metot ilgili yazıyı değiştiremeyeceğinden tamamı
	küçük harflerden oluşan bir yazıya ilişkin yeni bir String referansına geri döner. Benzer şekilde toUpperCase metotları
	yazının tüm karakterlerini büyük harfe çevirir. Şüphesiz küçük/büyük harf karşılığı olmayan karakterlerin aynıları
	alınır. Bu metotların bu bölümde yalnızca parametresiz overload'ları ele alınacaktır (isImmutable)
	
	
	Derleyici özdeş string literal'lar için aynı adresin verileceği kodu üretir. Yani özdeş string'lere ilişkin bir tane
	nesne yaratılmış olur. Zaten sınıf immutable olduğundan iki referansın aynı nesneyi göstermesi durumunda nesnenin
	içeriği değiştirelemezdir, bu da herhangi bir probleme yol açmaz. Bu durumda bellek efektif olarak kullanılmış olur.
	Aşağıdaki örnekte yine referans karşılaştırması yapılmıştır (isEqualStringLiteral)
-----------------------------------------------------------------------------------------------------------------------*/

package csd.lessons;


public class StringLes41 {

	public static void run() {
		isEqualStringLiteral();
	}

	public static void printIndexOfString() { // charAt
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
	
	public static void isImmutable() { // String is immutable class
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Enter uppercase and lower text: ");
		String s = kb.nextLine();
		String lower = s.toLowerCase();
		String upper = s.toUpperCase();
		System.out.printf("s = %s%nlower = %s%nUpper = %s%n", s, lower, upper);
	}
	
	public static void changeAddress() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Enter lower text: ");
		String s = kb.nextLine(); // s is a referance variable. s hold to the referans of String object which is created in here by compiler.
		s = s.toUpperCase(); // uppercase method create a new String object. After assigning, s point new reference(address) of String object which was created by toUpperCaseMethod
		System.out.printf("s = %s%n", s);
	}
	
	public static void isDifferentObject() { // different object will be created
		Sample s1 = new Sample(10);
		Sample s2 = new Sample(10);
		System.out.println(s1 == s2 ? "Same object" : "Different object");
		System.out.println(s1 != s2 ? "Different object" : "Same object");
	}
	
	public static void isSameObject() { // reference variables(s1,s2) point to the same object 
		Sample s1 = new Sample(10);
		Sample s2 = s1;
		System.out.println(s1 == s2 ? "Same object" : "Different object");
		System.out.println(s1 != s2 ? "Different object" : "Same object");
	}
	
	public static void isEqual() { // reference comparison
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Enter first text: ");
		String s1 = kb.nextLine();

		System.out.print("Enter the same text as a second text: ");
		String s2 = kb.nextLine();
		
		System.out.println(s1 == s2 ? "Same text" : "Different text"); // == compare to their reference(address) that they hold. Not text comparison.
	}
	
	public static void isExactEqual() { // String comparison
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Enter first text: ");
		String s1 = kb.nextLine();

		System.out.print("Enter the same text as a second text: ");
		String s2 = kb.nextLine();
		System.out.println(s1.equals(s2) ? "Same text" : "Different text"); // for comparing strings. case-sensitive. Compares this string to the specified object.
		System.out.println(s1.equalsIgnoreCase(s2) ? "Same test" : "Different text"); // Compares this String to another String, ignoring case considerations. Case-insensitive.
		
	}
	
	public static void isEqualStringLiteral() {
		String s1 = "ankara";
		String s2 = "ankara";
		System.out.println(s1 == s2 ? "Same Object" : "Different Object"); // s1 and s2 point to the same object address.
		// compiler doesn't create new String object for same string literal. That's why s1 and s2 have same reference.
		// It means one object created. This indicates memory optimization.
		// Same reference doesn't lead to a problem since Strings are immutable.
	}
}


class Sample {
	public int x;
	
	public Sample(int a) {
		x = a;
	}
}
