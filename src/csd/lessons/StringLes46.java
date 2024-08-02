package csd.lessons;

/*----------------------------------------------------------------------------------------------------------------------
Anahtar Notlar: JavaSE'de her temel türe ilişkin sınıflar bulunur. Bu sınıflara "sarmalayan sınıflar (wrapper classes)"
denir. Sarmalayan sınıfların ilişkin oldukları temel türe yönelik pek çok yardımcı metotları vardır. Temel tür ve 
ilgili sarmalayan sınıflar şunlardır:
	
	Temel Tür				Sarmalayan sınıf
	short						Short
	int							Integer
	long						Long
	byte						Byte
	
	float						Float
	double						Double
	
	char						Character
	boolean						Boolean				

Sarmalayan sınıflara ilişkin kullanım detayları ileride ele alınacaktır.

Character sınıfı dışında kalan sınıfların (yani nümerik türlere ilişkin sarmalayan sınıfların) parseXXX metotları 
aldıkları yazıyı ilgili temel türe dönüştürme işleminde kullanılır. Booleasn sınıfının parseBoolean metodu dışındaki
diğer parseXXX metotları aldıkları yazı ilgili türe dönüştürülemiyorsa exception oluştururlar (fırlatırlar). parseBoolean
metodu aldığı yazı case-insensitive olarak true değilse false değerine geri döner.

Aşağıdaki demo örneği inceleyiniz
---------------------------------------------------------------------------------------------------------------------*/

public class StringLes46 {
	public static void run() {
		System.out.println(StringUtil12.repeat(5, 'c'));
	}

	public static void wrapperClasses() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Bir tamsayı giriniz:");
			int a = Integer.parseInt(kb.nextLine());
			
			System.out.print("Bir gerçek sayı giriniz:");
			double b = Double.parseDouble(kb.nextLine());
			
			System.out.printf("tamsayi: %d, gercek sayi: %f%n", a,b);
			
			System.out.printf("Çıkmak etmek için büyük küçük harf duyarsız true giriniz:");
			boolean exitFlag = Boolean.parseBoolean(kb.nextLine());
			if(exitFlag)
				break;
		}
	}
	
	public static void startWith() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Enter a web url:");
			String address = kb.nextLine();

			if("exit".equals(address))
				break;

			if(!address.startsWith("http://"))
				address = "http://" + address;
			
			System.out.println(address);
		}
	}
	
	public static void endsWith() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Enter a mail address:");
			String address = kb.nextLine();
			
			if("exit".equals(address))
				break;
			
			if(!address.endsWith(".com"))
				address = address + ".com";
			
			System.out.println(address);
		}
	}
	
	public static void format() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Enter a mail address:");
			String address = kb.nextLine();
			
			if("exit".equals(address))
				break;
			
			if(!address.endsWith(".com"))
				address = address + ".com";
			
			String message = String.format("Email: %s", address);
			
			System.out.println(message);
		}
	}
	
	public static void formatted() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Enter a mail address:");
			String email = kb.nextLine();
			
			if("exit".equals(email))
				break;
			
			if(!email.endsWith(".com"))
				email = email + ".com";
			
			String message = "Email: %s".formatted(email);
			
			System.out.println(message);
		}
	}
	
	public static void replace() {
		String s1 = "ankara";
		String s2 = "Bugün hava çok sıcak. Bu sıcak havada ders mi yapılır!...";	
		System.out.println(s1.replace('a', 'b'));
		System.out.println(s2.replace("sıcak", "soguk"));

	}
	
	public static void compareTo() {
		System.out.println("ankara".compareTo("Ankara")); // 65:A, 97:a => 97 - 65 = 32
		System.out.println("Ankara".compareTo("ankara")); // 65:A, 97:a => 65 - 97 = -32
		System.out.println("ankara".compareTo("ankara"));
		System.out.println("bursa".compareTo("izmir"));
		System.out.println("ozan".compareTo("oğuz"));
		System.out.println("ozan".compareTo("oguz"));
	}

	public static void compareToIgnoreCase() {
		System.out.println("ankara".compareToIgnoreCase("Ankara")); // = 0 
		System.out.println("Ankara".compareToIgnoreCase("ankara")); // = 0
	}
}


/*----------------------------------------------------------------------------------------------------------------------
Sınıf Çalışması: Aşağıdaki metodu açıklamalara göre yazınız.
 	public static String repeat(int count, char ch);
Açıklamalar:
	- Metot StringUtil sınıfı içerisinde yazılacaktır.
	- Metot yazılırken döngü kullanılmayacaktır.
	- String sınıfının repeat metodu kullanılmayacaktır.
---------------------------------------------------------------------------------------------------------------------*/

class StringUtil12 {
	
	public static String repeat(int count, char ch) {
//		return String.format("%0%dd",count, 0);
//		return String.format("%0" + count + "d", 0).replace('0', ch);//%05d
//		return String.format("%" + count + "c", ' ').replace(' ', ch);
		return ("%0" + count + "d").formatted(0).replace('0', ch);
		
	}
}
