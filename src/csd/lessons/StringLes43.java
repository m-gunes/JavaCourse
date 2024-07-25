package csd.lessons;

public class StringLes43 {
	
	public static void run() {
		StringUtilTrimMethodsTest.run();
	}
	
	public static void lastIndexOf() {
		String text = "Bugün hava çok güzel, çok çok güzel";
		String s = "çok";
		System.out.println(text.lastIndexOf(s));
		System.out.println(text.indexOf(s));
		System.out.println(text.lastIndexOf(s, 22));
//		System.out.println(text.lastIndexOf(s, 27));
	}
	
	public static void stringWithNumber() {
		System.out.println("Java" + 10 + 11); //Java1011
		System.out.println(10 + 11 + "Java"); //21Java
	}
	
	public static void stripAndTrim(){		
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		
		while (true) {
			System.out.print("Input string:");
			String s = kb.nextLine();
			
			System.out.printf("(%s)%n", s);
			System.out.printf("(%s)%n", s.trim());
			System.out.printf("(%s)%n", s.strip());
			System.out.printf("(%s)%n", s.stripLeading());
			System.out.printf("(%s)%n", s.stripTrailing());
			
			if ("exit".equals(s))
				break;
		}
	}
}


/*----------------------------------------------------------------------------------------------------------------------	 
Sınıf Çalışması: Parametresi ile aldığı iki yazıdan birinci içerisinde ikincisinden kaç olduğuna geri dönen ve
case insensitive olarak çalışan countStringIgnoreCase isimli metodu yazınız ve aşağıdaki kod ile test ediniz	
-----------------------------------------------------------------------------------------------------------------------*/
class StringUtilCountStringIgnoreCaseTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Birinci yazıyı giriniz:");
			String s1 = kb.nextLine();
			
			if ("quit".equals(s1))
				break;
			
			System.out.print("İkinci yazıyı giriniz:");
			String s2 = kb.nextLine();
			
			System.out.printf("Count:%d%n", StringUtil2.countStringIgnoreCase(s1, s2));
		}
	}
}


class StringUtil2 {

	public static int countStringIgnoreCase(String s1, String s2) {
		return countString(s1.toLowerCase(), s2.toLowerCase());
	}

	public static int countString(String s1, String s2) {
		int count = 0;
		int idx = -1;

		while((idx = s1.indexOf(s2, idx + 1)) != -1)
			++count;
		
		return count;
	}
}



/*----------------------------------------------------------------------------------------------------------------------	 
Sınıf Çalışması: Aşağıdaki açıklamalara göre parametresi ile aldığı bir yol ifadesine (path) ilişkin dosyanın yalnızca 
ismine geri dönen getFileName isimli metodu yazınız.
Açıklamalar: 
- Metot yol ifadesi geçerliliği yapmayacaktır.
- Metot yol ifadesine / veya \ karakterlerini kabul edecektir.
- Yol ifadesi / ya da \ içermiyorsa doğrudan yol ifadesini döndürecektir.
- Örneğin yol ifadesi C:/test/mest.dat için elde edilen dosya ismi mest.dat olarak elde edilecektir. Ya da örneğin
test gibi bir ifadesi için dosya ismi test olarak elde edilecektir.
- Metodu FileUtil isimli bir sınıf içerisinde yazınız.
- Bu işlemi JavaSE'de yapan türler ve metotlar kullanılmayacaktır.
- Metodu klavyeden alınan yol ifadeleri ile test edebilirsiniz.

Not: İleride daha iyisi yazılacaktır
-----------------------------------------------------------------------------------------------------------------------*/

class FileNameTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Input file path:");
			String path = kb.nextLine();

			System.out.println(FileUtil.getFileName(path));

			if("quit".equals(path))
				break;
				
		}
	}
}


class FileUtil {
	public static String getFileName(String path) {
		int idx = path.lastIndexOf('\\');
		return idx != -1 ? path.substring(idx + 1) : path.substring(path.lastIndexOf('/') + 1);
	}
}




/*----------------------------------------------------------------------------------------------------------------------
IntegerDecimalOccurence 
String pattern matching in decimal representations of ints.

Task description
Two integers A and B are given. We are interested in positions at which decimal representation of A occurs as a substring 
in the decimal representation of B (counting from 0) For example:

	- 53 occurs in 1953786 at position 2.
	- 78 occurs in 1953786786 at positions 4 and 7
	- 57 does not occur in 153786.

Decimal representations are assumed to be big-endian and without leading zeros (the only exception being the number 0, whose 
decimal representation is "0")

Write function
	
	class Solution { public int solution(int A, int B); }

that, given two integers A and B, returns the leftmost position at which A occurs in B the function should return -1 
if A does not occur in B. 
For example, given A = 53 and B = 195378653, the function should return 2, as explained above.
Assume that:
	
	- A and B are integers within the range [0..999,999,999].
	
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
---------------------------------------------------------------------------------------------------------------------*/


class SolutionTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Input first number:");
			int a = Integer.parseInt(kb.nextLine());
			
			System.out.print("Input second number:");
			int b = Integer.parseInt(kb.nextLine());
			
			Solution s = new Solution();
			
			System.out.printf("Position:%d%n", s.solution(a, b));
			
			if (a == 0 && b == 0)
				break;
		}
	}
}


class Solution { 
	public int solution(int A, int B) {
		return (B + "").indexOf(A + "");
	}
}



//////// Character

class StringCharactersReportApp {
	public static void printReport(String s) {
		int len = s.length();
		int whitespaceCount = 0;
		int letterCount = 0;
		int digitCount = 0;
		
		for(int i = 0; i < len; ++i) {
			char c = s.charAt(i);
			
			if(Character.isWhitespace(c))
				++whitespaceCount;
			else if(Character.isLetter(c))
				++letterCount;
			else if(Character.isDigit(c))
				++digitCount;
		}

		System.out.printf("Whitespace count:%d%n", whitespaceCount);
		System.out.printf("Letter count:%d%n", letterCount);
		System.out.printf("Digit count:%d%n", digitCount);
		System.out.printf("Others:%d%n", len - whitespaceCount - letterCount - digitCount);		
	}
	
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Input string:");
			String s = kb.nextLine();
			printReport(s);
			
			if("quit".equals(s))
				break;
		}
	}
}




/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: parametresi ile aldığı bir yazının ilk karakteri büyük diğer karakterleri küçük harf olan 
	biçimine geri dönen capitalize isimli metodu StringUtil sınıfı içerisinde yazınız ve test ediniz. Örneğin yazı 
		bugün hava ÇOK güzel
	ise elde edilecek yazı	
		Bugün hava çok güzel
	olacaktır.
---------------------------------------------------------------------------------------------------------------------*/

class StringUtilCapitalizeTest {	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Input string:");
			String s = kb.nextLine();
			
			System.out.printf("(%s)%n", StringUtil3.capitalize(s));
			
			if ("quit".equals(s))
				break;
		}
	}
}

class StringUtil3 {
	public static String capitalize(String s) {
		return s.isEmpty() ? s : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
	}
}





/*----------------------------------------------------------------------------------------------------------------------
Sınıfı Çalışması: Aşağıda belirtilen metotları StrigUtil sınıfı içerisinde açıklamalara yazınız ve test ediniz.
Açıklamalar:
- Metotların prototipleri şunlardır:
	public static String trim(String s);
	public static String trimLeading(String s);
	public static String trimTrailing(String s);
	
- Metotlar sırasıyla yazının başındaki ve sonundaki, yalnızca başındaki ve yalnızca sonundaki whitespace karakterleri
atacaklardır.

- Metotlar Java 11 öncesi için yazılacaktır. Yani stripXXX metotları kullanılmayacaktır
---------------------------------------------------------------------------------------------------------------------*/


class StringUtilTrimMethodsTest {	
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Input string:");
			String s = kb.nextLine();
			
			System.out.printf("(%s)%n", s);
			System.out.printf("(%s)%n", StringUtil4.trim(s));			
			System.out.printf("(%s)%n", StringUtil4.trimLeading(s));
			System.out.printf("(%s)%n", StringUtil4.trimTrailing(s));
			
			if ("exit".equals(s))
				break;
		}
	}
}

class StringUtil4 {
	
	public static String trim(String s) {
		return trimTrailing(trimLeading(s));
	}
	
	public static String trimLeading(String s) {
		
		int i = 0;
		for(; i < s.length() && Character.isWhitespace(s.charAt(i)); ++i)
			;
		
		return s.substring(i);

		// alternative
//		int idx = 0;
//		while(idx < s.length() && Character.isWhitespace(s.charAt(idx)))
//			++idx;
//
//		return s.substring(idx);
	}
	
	public static String trimTrailing(String s) {
		int i = s.length() - 1;

		for(; i >= 0 && Character.isWhitespace(s.charAt(i)); --i)
			;
		
		return s.substring(0, i + 1);	
	}
	
}












