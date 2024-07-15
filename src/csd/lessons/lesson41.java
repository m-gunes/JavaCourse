package csd.lessons;

public class lesson41 {

	public static void run() {
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
}