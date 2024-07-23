package csd.lessons;

public class StringLes43 {
	
	public static void run() {
		FileNameTest.run();
	}
	
	public static void lastIndexOf() {
		String text = "Bugün hava çok güzel, çok çok güzel";
		String s = "çok";
		System.out.println(text.lastIndexOf(s));
		System.out.println(text.indexOf(s));
		System.out.println(text.lastIndexOf(s, 22));
//		System.out.println(text.lastIndexOf(s, 27));
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


































