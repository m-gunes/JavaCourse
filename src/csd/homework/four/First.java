package csd.homework.four;

/*----------------------------------------------------------------------------------------------------------------------	 
Homework-004'ün çözümü
-----------------------------------------------------------------------------------------------------------------------*/
public class First {

	public static void run() {
		PrintUtil.detailOfInput();
	}
}

class PrintUtil {
	
	public static void detailOfInput() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		int total=0, max = 0, min=100, count = 0;;
		double average=0;

		while(true) {
			System.out.print("Yeni bir değer girmek istiyor musunuz? [Evet için 1(bir) Hayır için 0(sıfır) değerlerinden birini giriniz]:");
			int a = kb.nextInt();

			if(a == 1) {
				System.out.print("Bir tamsayı giriniz:");
				while(true) {
					int b = kb.nextInt();

					if(b > 0 && b < 100) {
						++count;
						total += b;
						max = b > max ? b : max;
						min = b < min ? b : min;
						average = (double)total / count;
						break;
					} else {
						System.out.println("Geçersiz bir değer girdiniz!...");
						System.out.println("Yeni bir değer giriniz:");
						continue;
					}
				}
			}

			if(a == 0) {
				System.out.printf("Toplam %d değer girildi.%n Max = %d%n Min = %d%n Ortalama = %f%n", count, max, count > 0 ? min : 0, average);
				break;
			}
		}
	}
}
