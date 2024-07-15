package csd.lessons;

public class lesson41 {

	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir yazi giriniz:");
		String s = kb.nextLine();
		System.out.printf("%s length is %d%n",s.toUpperCase(), s.length());
		int len = s.length();
		
		char c = s.charAt(5);
		System.out.printf("c = %c%n", c);
		
	}
}
