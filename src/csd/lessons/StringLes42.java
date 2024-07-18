package csd.lessons;

public class StringLes42 {
	public static void run() {
		concatWithHyphenApp.run();
	}
	
	public static void concateStrings() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Enter a text:");
			String s1 = kb.nextLine();

			if("elma".equals(s1))
				break;
			
			System.out.print("Enter another text:");
			String s2 = kb.nextLine();
			
			String str1 = s1.concat(" ").concat(s2);
			System.out.println(str1);

			String str2 = s1.concat(" ".concat(s2));
			System.out.println(str2);

			String str3 = s1 + " " + s2;
			System.out.println(str3);
		}
	}
	
	public static void addition() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("What is the temperature outside?: ");
			int degree = Integer.parseInt(kb.nextLine());
			String message = "The teperatue is " + degree + " degrees.";
			System.out.println(message);

			System.out.println("The teperatue is " + degree + " degrees.");
			
			if(degree == 0)
				break;
		}
	}
	
	public static void emptyCheck() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Enter a string:");
			String s = kb.nextLine();
			
			if(s.isEmpty()) {
				System.out.println("You enter empty string!");
				continue;
			}
			
			if("elma".equals(s))
				break;
			
			System.out.printf("Entering string is %s%n", s);
		}
	}
	
	public static void subString() {
		String s = "ankara";
		
		System.out.printf("(%s)%n", s.substring(2)); // kara
		System.out.printf("(%s)%n", s.substring(2,5)); // kar
	}
	
	public static void substringLength() {
		String s = "ankara"; // len: 6
		int index = s.length();
		String str = s.substring(index); //index=6. this is special case for substring method with one parameter. Because last index 5=a.
//		String str = s.substring(index + 1); // Exception: Range [7, 6) out of bounds for length 6
		
		System.out.println(str.isEmpty() ? "Empty string" : "String: " + str);
		
	}
}




/*----------------------------------------------------------------------------------------------------------------------	 
Sınıf Çalışması: Klavyeden elma girilene kadar alınan yazıları aralarına - koyacak şekilde birleştirilmiş yeni bir
yazı (yani String referansı) elde eden programı yazınız.
Açıklamalar:
	- Programda dizi kullanılmayacaktır. Zaten gerek de yoktur
	- Girilen boş string'ler yazıya dahil edilmeyecektir
Not: İleride daha iyisi yazılacaktır
-----------------------------------------------------------------------------------------------------------------------*/

// classwork
class concatWithHyphenApp {
	public static void run () {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		String str = "";
		
		while(true) {
			System.out.print("Enter a string:");
			String s = kb.nextLine();
			
			if(s.isEmpty())
				continue;

			if("elma".equals(s))
				break;

			str += "-" + s;
		}

		str = str.isEmpty() ? str : str.substring(1);
		System.out.println(str);
	}
}

