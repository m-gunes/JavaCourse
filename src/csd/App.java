package csd;

import csd.homework.Homework;
import csd.homework_2.Question_1;
import csd.lessons.StringLes41;
import csd.lessons.StringLes42;

class App {
	public static void main(String [] args) 
	{	
//		StringUtilCountStringTest.run();
		StringLes42.run();
//		String s = StringUtil.capitalize("bugun hava COK Guzel degil mi?");
//		System.out.print(s);

		
	}
}

class StringUtil {
	
//	public static String trim(String s) {
//		
//	}
//	
//	public static String trimLeading(String s) {
//		
//	}
//	
//	public static String trimTrailing(String s) {
//		
//	}
	
	
	public static String capitalize(String s) {
		if(s.isEmpty())
			return s;
		
		char firstLetter = s.charAt(0);
		return Character.toUpperCase(firstLetter) + s.toLowerCase().substring(1);
	}
}








//			fullText = fullText.isEmpty() ? s : fullText + "-" + s; 
//		for(int i = 0; i < len; ++i)
//			System.out.printf("%c ", s.charAt(i));
//			
//		System.out.println();

//java.util.Scanner kb = new java.util.Scanner(System.in);
//		java.util.Random r = new java.util.Random();
//		
//		System.out.print("input seed value: ");
//		long seed = kb.nextLong();
//
//		for(int i = 0; i < 10; ++i) 
//			System.out.printf("%d ", r.nextInt(100));
//		
//		
//		System.out.println();
//		
//		r.setSeed(seed);
//		
//		for(int i = 0; i < 10; ++i)
//			System.out.printf("%d ", r.nextInt(100));
//		
//
//		System.out.println();
//		java.util.Random rr = new java.util.Random(100);
//		for(int i = 0; i < 10; ++i)
//			System.out.printf("%d ", rr.nextInt(100));

class DoubleProbabilityApp{
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Input count:");
		int count = kb.nextInt();
		SameDiceProbabilitySimulation simulation = new SameDiceProbabilitySimulation();
		simulation.run(count);
		System.out.printf("Probability of tail %f%n", simulation.p);
		
	}
}

class SameDiceProbabilitySimulation {
	public double p;

	public boolean areSame(java.util.Random r) {
		return r.nextInt(6) + 1 == r.nextInt(6) + 1;
	}

	public void run(int count) {
		java.util.Random r = new java.util.Random();
		int n = 0;
		for(int i = 0; i < count; ++i)
			if(areSame(r))
				++n;
		
		p = (double)n / count;
	}
}

class CoinTailProbabilitySimulationApp {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Input count:");
		int count = kb.nextInt();
		CoinTailProbabilitySimulation simulation = new CoinTailProbabilitySimulation();
		simulation.run(count);
		System.out.printf("Probability of tail %f%n", simulation.p);
		
	}
}

class CoinTailProbabilitySimulation {
	public double p;
	
	public void run(int count) {
		java.util.Random r = new java.util.Random();
		int n = 0;
		
		for(int i = 0; i < count; ++i)
			n += r.nextInt(2);
		
		p = (double)n / count;
	}
}





class Complex {
	public double real;
	public double imag;
	
	public static Complex add(double re1, double im1, double re2, double im2) //İleride sınıfı kullanan kodlardan gizleyeceğiz
	{
		return new Complex(re1 + re2, im1 + im2); // return deyimine iliskin ifade once hesaplanir sonra o ifadenin degerine geri donulur.
//		Complex result = new Complex();
//		
//		result.real = re1 + re2;
//		result.imag = im1 + im2;
//		
//		return result;
	}
	
	public static Complex subtract(double re1, double im1, double re2, double im2) //İleride sınıfı kullanan kodlardan gizleyeceğiz
	{
		return add(re1, im1, -re2, -im2);		
	}
	
	public static Complex multiplication(double re1, double im1, double re2, double im2) {
		Complex result = new Complex();
		result.real = re1 * re2;
		result.imag = im1 * im2;
		return result;
	}

	public static Complex divide(double re1, double im1, double re2, double im2) {
		Complex result = new Complex();
		result.real = re1 / re2;
		result.imag = im1 / im2;
		return result;
	}
	
	public Complex()
	{
		
	}
	
	public Complex(double a)
	{
		real = a;		
	}
	
	public Complex(double a, double b)
	{
		real = a;
		imag = b;
	}
	
	public static Complex add(double val, Complex z)
	{
		return add(val, 0, z.real, z.imag);
	}
	
	public Complex add(Complex other)
	{
		return add(real, imag, other.real, other.imag);
	}
	
	public Complex add(double val)
	{
		return add(real, imag, val, 0);
	}	

	
	
	public static Complex subtract(double val, Complex z)
	{
		return subtract(val, 0, z.real, z.imag);
	}
	
	public Complex subtract(Complex other)
	{
		return subtract(real, imag, other.real, other.imag);
	}
	
	public Complex subtract(double val)
	{
		return subtract(real, imag, val, 0);
	}
	
	
	public static Complex multiplication(double val, Complex z)
	{
		return multiplication(val, 0, z.real, z.imag);
	}
	
	public Complex multiplication(Complex other)
	{
		return multiplication(real, imag, other.real, other.imag);
	}
	
	public Complex multiplication(double val)
	{
		return multiplication(real, imag, val, 0);
	}	
	
	
	
	
	public void inc(double val)
	{
		real += val;
	}
	
	public void inc()
	{
		inc(1);
	}
	
	public void dec(double val)
	{
		inc(-val);
	}
	
	public void dec()
	{
		dec(1);
	}
	
	public Complex getConjugate()
	{
		return new Complex(real, -imag);
//		Complex result = new Complex();
//		
//		result.real = real;
//		result.imag = -imag;
//		
//		return result;
	}
	
	public double getNorm()
	{
		return Math.sqrt(real * real + imag * imag);
	}
	
	public double getLength()
	{
		return getNorm();
	}	
	
	public void display()
	{
		System.out.printf("(%.2f, %.2f)%n", real, imag);
	}
}

class Point {
	public double x;
	public double y;

	public Point()
	{		
	}

	public Point(double a)
	{
		x = a;		
	}
	
	public Point(double a, double b)
	{
		x = a;
		y = b;
	}
	
	public double distance()
	{
		return distance(0, 0);
	}
	
	public double distance(Point other)
	{
		return distance(other.x, other.y);
	}
	
	public double distance(double a, double b)
	{
		return Math.sqrt(Math.pow(x - a, 2) + Math.pow(y - b, 2));
	}	
	
	public void offset(double dxy)
	{
		offset(dxy, dxy);
	}
	
	public void offset(double dx, double dy)
	{
		x += dx;
		y += dy;
	}
	
	public void display()
	{
		System.out.printf("(%f, %f)%n", x, y);
	}
}
class DateUtil {

	public static Date create(int day, int month, int year) {

		Date date = new Date();
		date.day = day;
		date.month = month;
		date.year = year;
		return date;
	}
	public static void change(Date date, int day, int month, int year) {
		date.day = day;
		date.month = month;
		date.year = year;
	}
	
	public static void display(Date date) {
		System.out.printf("%02d/%02d/%04d%n",date.day, date.month, date.year);
	}
}
class Date {
	public int day;
	public int month;
	public int year;
}

class Oop {
	public static void run() {
		
		Person mustafa = new Person();
		Person veronica = new Person();
		mustafa.birthDate = 1989;
		mustafa.kg = 70;
		mustafa.alive = true;
		mustafa.firstLetter = 'm';
		veronica.birthDate = 1982;
		veronica.kg = 50;
//		veronica.legCount = 3; // mustafa nesnesininde legCount'u degisti.
		System.out.printf(
				"firstLetter = %c, birthDate = %d, alive = %b, kg = %f, armCount = %d, legCount = %d, count = %d%n",
				mustafa.firstLetter, mustafa.birthDate, mustafa.alive, mustafa.kg, mustafa.armCount, mustafa.legCount, mustafa.count
		);
		System.out.printf(
				"firstLetter = %c, birthDate = %d, alive = %b, kg = %f, armCount = %d, legCount = %d, count = %d%n",
				veronica.firstLetter, veronica.birthDate, veronica.alive, veronica.kg, veronica.armCount, Person.legCount, veronica.count
		);
		System.out.printf("Population = %d%n", Person.count);
		
		mustafa.setKg(5);
		System.out.printf("mustafa kg = %f, veronica kg = %f", mustafa.kg, veronica.kg);
	}
	
}

class Person {
	public char firstLetter;
	public int birthDate;
	public boolean alive;
	public double kg;
	public int armCount;
	public static int legCount; 
	public static int count;
	
	public Person() {
		++count;
	}
	public double setKg(double val) {
		return kg += val;
	}
	
}

//class BaklavaPatternTest {
//	public static void run() {
//		java.util.Scanner kb = new java.util.Scanner(System.in);
//		System.out.print("0'dan büyük bir sayı giriniz:");
//		int n = kb.nextInt();
//		Patterns.baklavaPattern(n);
//	}
//}

class Patterns {
	
	public static void baklavaPattern(int n) {
		
		if(n <= 0)
			return;
		
		int rowLen = n * 2 - 1;
		int asteriskCount = 1;
		boolean isIncreasedAsterisk = true;
		
		for(int i = 0; i < rowLen; ++i) {
			
			for(int j = 0; j < rowLen; ++j) {
				int leftSpace = (rowLen - asteriskCount) / 2;
				if(j < leftSpace)
					System.out.print(" ");
				else if(j < leftSpace + asteriskCount)
					System.out.print("*");
				else {
					System.out.print(" ");
				}
			}

			System.out.println();

			if(isIncreasedAsterisk) {
				asteriskCount += 2;
				if(asteriskCount == rowLen)
					isIncreasedAsterisk = false;
			} else {
				asteriskCount -= 2;
			}

		}
	}
	
}

class NumberUtilPrimeFactorisationTes {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Bir sayi giriniz:");
			long n = kb.nextLong();
			NumberUtilss.primeFactorisation(n);
			System.out.println();
		}
	}
}

class NumberUtilss {
	
	public static void primeFactorisation(long n) {
		if(isPrime(n))
			System.out.printf("%d sayısının asal çarpanı %d dır.", n, n);
		
		for(long i = 2; i <= n; i = nextClosestPrime(i)) {
			while(n % i == 0) {
				System.out.printf("%d ", i);
				n /= i;
			}
		}

		System.out.printf("Asal çarpanlardır.");
	}
	
	public static long nextClosestPrime(long a) {
		if (a < 2)
			return 2;
		
		while (!isPrime(++a))
			;
		
		return a;		
	}

	public static boolean isPrime(long a) {
		
		if(a <= 1)
			return false;
		
		if(a % 2 == 0)
			return a == 2;
		
		if(a % 3 == 0)
			return a == 3;
		
		if(a % 5 == 0)
			return a == 5;
		
		if(a % 7 == 0)
			return a == 7;
		
		for(long i = 11; i * i <= a; i += 2) {
			if(a % i == 0)
				return false;			
		}
		
		return true;
	}
}


/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-6.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/
class HardyRamanujanTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		for(int i = 10; i <= 100_000; ++i) {
			if(NumberUtil.isHardyRamanujan(i))
				System.out.printf("%d hardy ramanujan sayısıdır%n", i);
		}
	}
}

class NumberUtil {
	
	public static boolean isHardyRamanujan(int n) {
		
		double cubeRootOfN = Math.cbrt(n);
		
		for(int a = 1; a < cubeRootOfN; ++a) { 
			int b = (int) Math.cbrt(n - cube(a));
			if(n == cube(a) + cube(b)) {
				for(int c = a + 1; c < cubeRootOfN; ++c) {
					int d = (int) Math.cbrt(n - cube(c));
					if(n == cube(c) + cube(d) && a != d && c != b ) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static int cube(int val) {
		return val * val * val;
	}
}

/*----------------------------------------------------------------------------------------------------------------------	 
Homework-004'ün çözümü
-----------------------------------------------------------------------------------------------------------------------*/
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

/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-8.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/
class CollatzTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayi giriniz:");
		int a = kb.nextInt();
		PrintUtilll.printCollatz(a);
	}
}

class PrintUtilll {
	public static void printCollatz(int n) {
		
		if(n < 1)
			return;
		
		while(n != 1) {
			
			if(n % 2 == 0)
				n /= 2;
			else
				n = 3 * n + 1;

			System.out.println(n);
		}
	}
}

/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-7.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/
class DecimalHarshadTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Bir sayi giriniz:");
			int a = Integer.parseInt(kb.nextLine());
			System.out.printf("%d sayisi harshad sayisidir %b%n", a, NumberUtills.isDecimalHarshad(a));
			if(a == 0)
				break;
		}
	}
}


class NumberUtills {
	public static boolean isDecimalHarshad(int val) {

		if(val < 1)
			return false;
		
		return val % sumOfDigitsOfNumber(val) == 0;
	}
	
	public static int sumOfDigitsOfNumber(int val) {

		int total = 0;

		while(val != 0) {
			total += val % 10;
			val /= 10;
		}

		return total;
	}
}


/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-5.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/
class SuperPrimeTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Bir sayi giriniz:");
			long a =  Long.parseLong(kb.nextLine());
			System.out.printf("%d sayisi super asal sayidir %b%n", a, NumberUtillss.isSuperPrime(a));
		}
	}
}

class NumberUtillss {
	public static boolean isSuperPrime(long val) {
		
		if(!isPrime(val))
			return false;
		
		int index = 1;
		
		for(int i = 3; i <= val; i += 2) {
			if(isPrime(i))
				++index;
		}
		return isPrime(index);
				
		/*
		 *
		 * i1: i=3 index=2
		 * i2: i=5 index=3
		 * i3: i=7 index=4
		 * i4: i=9
		 * i5: i=11 index=5
		 * i6: i=13 index=6
		 * i7: i=17 index=7
		 * 
		 * */

		// 1. 2
		// 2. 3  *
		// 3. 5  * 
		// 4. 7
		// 5. 11 *
		// 6. 13
		// 7. 17 *
	}
	public static boolean isPrime(long val) {
		if(val <= 1)
			return false;

		if(val % 2 == 0)
			return val == 2;
		
		if(val % 3 == 0)
			return val == 3;
		
		if(val % 5 == 0)
			return val == 5;
		
		if(val % 7 == 0)
			return val == 7;
		
		// eger bir sayi(19) karakokunden (4.35) kucuk olan hic bir asal sayiya tam olarak bolunemiyorsa asaldir.
		// If a number is not divisible by a prime number less than its square root, then it is a prime number.
		for(int i = 11; i * i <= val; i +=2) {
			if(val % i == 0)
				return false;
		}
		
		return true;
		
		
	}
}

/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-4.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/
class FactorianTest {
	public static void run() {
		for(int i = 1; i < 100_000; i++) {
			if(NumberUtillsss.isFactorian(i))
				System.out.printf("%d sayisi factorian sayidir %n", i);
		}
	}
}

class NumberUtillsss {
	public static boolean isFactorian(int val) {
		return val == sumOfFactorialOfDigitsOfANumber(val);
	}

	public static long sumOfFactorialOfDigitsOfANumber(int number) {

		long total = 0;

		while(number != 0) {
			total += factorial(number % 10);
			number /= 10;
		}

		return total;
	}
	
	public static long factorial(int val) { 

		int result = 1;
		for(int i = 2; i <= val; ++i) {
			result *= i;
		}

		return result;
	}
}


/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-3.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/
class CalculateDigitalRootTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Bir sayi giriniz:");
			int a = Integer.parseInt(kb.nextLine());
			System.out.printf("%d sayisinin basamaksal koku = %d%n", a, NumberUtillls.calculateDigitalRoot(Math.abs(a)));
		}
	}
}

class NumberUtillls {
	public static int calculateDigitalRoot(int val) {
		
		while(val > 9) {
			int total = sumOfDigitsOfANumber(val);
			val = total;
		}

		return val;
	}

	public static int sumOfDigitsOfANumber(int number) {

		int total = 0;

		while(number != 0) {
			total += number % 10;
			number /= 10;
		}

		return total;
	}
}

/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-2.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/
class PrimeXTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Bir sayi giriniz:");
			long a = Long.parseLong(kb.nextLine());
			if(PrimeUtil.isPrimeX(a))
				System.out.printf("%d sayisi ve sayinin basamaklari toplamlarinin hepsi Asal sayidir.%n", a);
			else
				System.out.printf("%d sayisi veya sayinin basamaklari toplamlarinin hepsi Asal sayi degildir.%n", a);
		}
	}
}

class PrimeUtil {
	public static boolean isPrimeX(long val) {
		
		while(val > 9) {
			int total = sumOfDigitsOfANumber(val);
			if(isPrime(total)) {
				val = total;
			} else 
				return false;
		} 
		
		return isPrime(val);
	}
	
	public static int sumOfDigitsOfANumber(long number) {
		int total = 0;
		while(number != 0) {
			total += number % 10;
			number /= 10;
		}
		return total;
	}

	public static boolean isPrime(long a) {
		if(a <= 1)
			return false;
		if(a % 2 == 0)
			return a == 2;
		if(a % 3 == 0)
			return a == 3;
		if(a % 5 == 0)
			return a == 5;
		if(a % 7 == 0)
			return a == 7;
		
		// Bir sayi karakokunden kucuk olan hic bir asal sayiya tam olarak bolunemiyorsa asaldir
		// If a number is not divisible by a number less than its square root, then it is a prime number. 
		for(long i = 11; i * i <= a; i += 2) { 
			if(a % i == 0)
				return false;
		}

		return true;
	}
}

/*----------------------------------------------------------------------------------------------------------------------	 
Homework-003-1.sorunun çözümü
-----------------------------------------------------------------------------------------------------------------------*/
class PrimeAbcTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		for(int i = 100; i < 1000; ++i) {
			if(NumberUtilllss.abc(i))
				System.out.println(i);
		}
	}
}

class NumberUtilllss {
	public static boolean abc(int abc) {
		
		int cba = reverseNumber(abc);

		// todo: switch icerisinde yazilabilir.
		return cba > abc && isPrime(abc) && isPrime(cba) && isPrime(abc / 10) && isPrime(abc % 100) && isPrime(cba / 10) && isPrime(cba % 100);
	}
	
	
	public static int reverseNumber(int abc) { // todo: look again
		int a = abc / 100; 
		int c = abc % 10;
		int b = abc / 10 % 10;
		int cba = c * 100 + b * 10 + a;
		return cba;
	}
	
	public static boolean isPrime(long a) {
		if(a <= 1)
			return false;
		if(a % 2 == 0)
			return a == 2;
		if(a % 3 == 0)
			return a == 3;
		if(a % 5 == 0)
			return a == 5;
		if(a % 7 == 0)
			return a == 7;
		
		// Bir sayi karakokunden kucuk olan hic bir asal sayiya tam olarak bolunemiyorsa asaldir
		// If a number is not divisible by a number less than its square root, then it is a prime number. 
		for(long i = 11; i * i <= a; i += 2) { 
			if(a % i == 0)
				return false;
		}

		return true;
	}
	
}









class DateUtilIsLeapYearTest {
	public static void run() {
		for(int y = 1994; y < 2104; ++y) {
			if(DateUtils.isLeapYear(y))
				System.out.println(y);
		}
	}
}

class DateUtilIsValidDateTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Please enter any date day month year:"); 
			int day = kb.nextInt();
			int month = kb.nextInt();
			int year = kb.nextInt();
			
			
			if(DateUtils.isValidDate(day, month, year))
				System.out.printf("%02d/%02d/%04d is valid date %n", day, month, year);
			else
				System.out.println("Invalid date...");

			if(day == 0 && month == 0 && year == 0)
				break;

		}
	}
}

class DateUtilGetDayOfYearTest {
	
	public static boolean isPrime(long a) {
		
		if(a <= 1)
			return false;
		
		if(a % 2 == 0)
			return a == 2;
		
		if(a % 3 == 0)
			return a == 3;
		
		if(a % 5 == 0)
			return a == 5;
		
		if(a % 7 == 0)
			return a == 7;
		
		for(long i = 11; i * i <= a; i += 2) {
			if(a % i == 0)
				return false;			
		}
		
		return true;
	}
	
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Enter day, month and year:");
			int day = kb.nextInt();
			int month = kb.nextInt();
			int year = kb.nextInt();

			if(DateUtils.isValidDate(day, month, year))
				System.out.printf("%02d/%02d/%04d the %dth day of year", day, month, year, DateUtils.getDayOfYear(day, month, year) );
			else
				System.out.println("Invalid date...");
			
			if(day == 0 && month == 0 && year == 0)
				break;
		}
	}
}

class DateUtilGetDayOfWeekTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("Enter Date, day month year respectively");
			int day = kb.nextInt();
			int month = kb.nextInt();
			int year = kb.nextInt();
			
			DateUtils.printDate(day, month, year);
			
			if(day == 0 && month == 0 && year == 0)
				break;
		}
	}
}



class DateUtils {
	
	
	
 	public static void printDate(int day, int month, int year) {
	
		if(!isValidDate(day,month,year)) {
			System.out.println("Invalid date...");
			return;
		}


		int dayOfWeek = getDayOfWeek(day, month, year);
		
		switch(dayOfWeek) {
		case 0:
			System.out.printf("%02d/%02d/%04d Pazar %n", day,month,year);
			break;
		case 1:
			System.out.printf("%02d/%02d/%04d Pazartesi %n", day,month,year);
			break;
		case 2:
			System.out.printf("%02d/%02d/%04d Sali %n", day,month,year);
			break;
		case 3:
			System.out.printf("%02d/%02d/%04d Carsamba %n", day,month,year);
			break;
		case 4:
			System.out.printf("%02d/%02d/%04d Persembe %n", day,month,year);
			break;
		case 5:
			System.out.printf("%02d/%02d/%04d Cuma %n", day,month,year);
			break;
		case 6:
			System.out.printf("%02d/%02d/%04d Cumartesi %n", day,month,year);
		}
		
	}

	public static int getDayOfWeek(int day, int month, int year) {
		int totalDays = getDayOfYear(day, month, year);
		for(int y = 1990; y < year; ++y) {
			totalDays += 365;
			if(isLeapYear(y))
				++totalDays;
		}

		return totalDays % 7;
	}

	public static int getDayOfYear(int day, int month, int year) {
		int dayOfYear = day;

		switch(month - 1) {
		case 11:
			dayOfYear += 30;
		case 10:
			dayOfYear += 31;
		case 9:
			dayOfYear += 30;
		case 8:
			dayOfYear += 31;
		case 7:
			dayOfYear += 31;
		case 6:
			dayOfYear += 30;
		case 5:
			dayOfYear += 31;
		case 4:
			dayOfYear += 30;
		case 3:
			dayOfYear += 31;
		case 2:
			dayOfYear += 28;
			if(isLeapYear(year))
				++dayOfYear;
		case 1:
			dayOfYear += 31;
		}
		
		return dayOfYear;
		
	}
	
	public static int getDays(int month, int year) {
		
		int days = 31;

		switch(month) {
			case 2:
				days = 28;
				if(isLeapYear(year))
					++days;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
		}
		
		return days;
	}
	
	public static boolean isValidDate(int day, int month, int year) {
		return day > 0 && day <= 31 && month > 0 && month <= 12 && day <= getDays(month, year); 
	}

	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}


// 1. soru test
class NumberUtilSortOfThreeNums {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Üç tane sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int c = kb.nextInt();
		NumberUtilllsss.sortOfThreeNums(a,b,c);
	}
}

// 2. soru test
class NumberUtilMidTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Üç tane sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int c = kb.nextInt();
		System.out.printf("Girilen sayıların ortancası %d 'dir", NumberUtilllsss.mid(a, b, c));
	}
}

// 3. soru test
class NumberUtilSignumTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int a = kb.nextInt();
		System.out.printf("Girilen %d sayısının signum return degeri %d 'dir", a, NumberUtilllsss.signum(a));
	}
}

class NumberUtilFactorialTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int n = kb.nextInt();
		
		for(int i = 0; i <= n; i++)
			System.out.printf("%d! = %d%n", i, NumberUtilllsss.factorial(i));
	}
}

class NumberUtilIsPrimeTest {
	public static void run()
	{
		System.out.println(NumberUtilllsss.isPrime(1_000_003));
		System.out.println(NumberUtilllsss.isPrime2(1_000_003));
		
//		java.util.Scanner kb = new java.util.Scanner(System.in);
//		
//		System.out.print("Bir sayı giriniz:");
//		int n = kb.nextInt();
//		
//		for (int i = 0; i <= n; ++i)
//			if (NumberUtil.isPrime(i))
//				System.out.println(i);		
		
//		System.out.println(NumberUtil.isPrime1(1_000_003));
	}
}

class NumberUtilFibonacciNumberTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Bir sayı giriniz:");
			int n = Integer.parseInt(kb.nextLine());
			
			if (n <= 0)
				break;
			
			System.out.printf("%d. Fibonacci sayısı:%d%n", n, NumberUtilllsss.fibonacciNumber(n));
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}


class NumberUtilNextFibonacciNumberTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while (true) {
			System.out.print("Bir sayı giriniz:");
			int n = Integer.parseInt(kb.nextLine());

			System.out.printf("%d sayısından büyük ilk Fibonacci sayısı:%d%n", n, NumberUtilllsss.nextFibonacciNumber(n));
			
			if (n == 0)
				break;
		}
		
		System.out.println("Tekrar yapıyor musunuz?");
	}
}


class NumberUtilllsss {
	
	
	public static int fibonacciNumber(int n) {
		// 0 1 1 2 3 5 8 13 21 ... serisinin sayılarına Fibonacci sayıları denir
		if(n <= 2)
			return n - 1;
				
		int prev2 = 0, prev1 = 1, nextFibo = prev2 + prev1;
		
		for (int i = 3; i < n; ++i) {
			prev2 = prev1;
			prev1 = nextFibo;
			nextFibo = prev1 + prev2;
		}
		
		return nextFibo;
	}
	
	public static int nextFibonacciNumber(int val) {
		if(val < 0)
			return 0;

		int prev2 = 0, prev1 = 1, nextFibo = prev2 + prev1;

		while(nextFibo <= val) {
			prev2 = prev1;
			prev1 = nextFibo;
			nextFibo = prev1 + prev2;
		}

		return nextFibo;
		
	}
	
	public static void twoPrimeNumberForAEvenNumber(long even) {
		if(even <= 2)
			return;
		
		long half = even / 2;
		if(isPrime(half)) {
			System.out.printf("%d + %d = %d %n", half, half, even);
		} else {
			long a = prevClosestPrime(half);
			long b = nextClosestPrime(half);
			if(a + b < even)
				b = nextClosestPrime(b);
			if(a + b > even)
				a = prevClosestPrime(a);

			System.out.printf("%d + %d = %d %n", a, b, even);
		}
	}
	
	public static void primeFactorisation(long n) {
		if(isPrime(n))
			System.out.printf("%d sayınsının asal çarpanı %d dır.", n, n);
		
		for(long i = 2; i <= n; i = nextClosestPrime(i)) {
			while(n % i == 0) {
				System.out.printf("%d ", i);
				n /= i;
			}
		}
	}
	
	public static long prevClosestPrime(long a) {
		if(a < 2)
			return a;
		
		while(!isPrime(--a))
			;

		return a;
	}
	
	public static long nextClosestPrime(long a) {
		if (a < 2)
			return 2;
		
		while (!isPrime(++a))
			;
		
		return a;		
	}

	public static boolean isPrime(long a) {
		
		if(a <= 1)
			return false;
		
		if(a % 2 == 0)
			return a == 2;
		
		if(a % 3 == 0)
			return a == 3;
		
		if(a % 5 == 0)
			return a == 5;
		
		if(a % 7 == 0)
			return a == 7;
		
		for(long i = 11; i * i <= a; i += 2) {
			if(a % i == 0)
				return false;			
		}
		
		return true;
	}
	
	
	
	
	
	// yavas version
	public static boolean isPrime2(long a) {
		
		if(a <= 1)
			return false;
		
		int count = 0;
		
		for(long i = 2; i <= a / 2; i++) {
			count++;
			if(a % i == 0)
				return false;
		}
		
		System.out.printf("isPrimeSlow -> count:%d%n", count);
		
		return true;
	}
	
	// en yavas version. Hele hele long turden bir sayi icin boyle bir dongu yapilmamasi lazim.
	public static boolean isPrime1(long a) {
		
		if(a <= 1)
			return false;
		
		for(long i = 2; i < a; i++) {
			if(a % i == 0)
				return false;
		}
		
		return true;
	}
	
	
	public static int factorial2(int n) {
		// n! = 1 * 2 * ... * (n - 1) * n
		int result = 1;
		// for(int i = n; i > 0; i--) {
		for(int i = 2; i <= n; ++i) {
			result *= i;
		}
		
		return result;
	}
	
	public static int factorial(int n) {
		
		int result = 1;
		
		for(int i = 2; i <= n; ++i) {
			result *= i;
		}
		
		return result;
		
	}
	
	public static void sortOfThreeNums(int a, int b, int c) {
		
		int min = Math.min(Math.min(a, b), c);
		int max = Math.max(Math.max(a, b), c);
		int mid = (a + b + c) - (min + max);
		
		if(min == max)
			System.out.printf("%d = %d = %d", min, min, max);
		else if(mid == min)
			System.out.printf("%d = %d < %d", min, mid, max);
		else if(mid == max)
			System.out.printf("%d < %d = %d", min, mid, max);
		else
			System.out.printf("%d < %d < %d", min, mid, max);
	}
	
	public static int mid1(int a, int b, int c) {
		
		int mid;
		
		if((b <= a && a <= c) || (c <= a && a <= b))
			mid = a;
		else if((a <= b && b <= c) || (c <= b && b <= a))
			mid = b;
		else 
			mid = c;
		
		return mid;
	}
	
	public static int mid(int a, int b, int c) {
		
		if((b <= a && a <= c) || (c <= a && a <= b))
			return a;
		
		if((a <= b && b <= c) || (c <= b && b <= a))
			return b;
		
		return c;
		
	}
	
	public static int signum1(int val) {
		
		if(val > 0)
			return 1;
		else if(val < 0)
			return -1;
		else
			return 0;
	}
	
	public static int signum(int val) {
		
		if(val > 0)
			return 1;
		
		if(val < 0)
			return -1;
		
		return 0;
		
	}
}
















class NumberTotalAndCount {
	public static void printPositive(int total, int count) {
		if(count != 0)
			System.out.printf("Girilen %d tane pozitif sayının toplamı: %d%n", count, total);
		else
			System.out.println("Hiç pozitif sayı girmediniz");
			
	}
	
	public static void printNegative(int total, int count) {
		if(count != 0)
			System.out.printf("Girilen %d tane negatif sayının toplamı: %d%n", count, total);
		else
			System.out.println("Hiç negative sayı girmediniz");
			
	}

	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.println("Sayilari girmeye baslayiniz:");
		
		int posCount, posTotal, negCount, negTotal;
		posCount = posTotal = negCount = negTotal = 0;
		int val;
		
		while((val = Integer.parseInt(kb.nextLine())) != 0)
			if(val > 0) {
				++posCount;
				posTotal += val;		
			}
			else {
				++negCount;
				negTotal += val;				
			}
		
			
		
		// end of the while. now print
		printPositive(posTotal, posCount);
		printNegative(negTotal, negCount);
		
		
	}
}


class NumberUtilSumDigitsTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("bir sayi giriniz");
		int val = kb.nextInt();
		System.out.printf("%d sayisinin basamaklari toplami; %d%n", val, NumberUtil1.sumDigits(val));
	}
}

class NumberUtilPowTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
	
		while(true) {
			System.out.println("a ve b'yi giriniz:");
			int a = kb.nextInt();
			int b = kb.nextInt();
			System.out.printf("pow(%d, %d) = %d%n", a, b, NumberUtil1.pow(a, b));
			
			if(a == 0 && b == 0)
				return;
		}
		
	}
}

class NumberUtilIsArmstrongTest {
	public static void run()
	{
		for (int n = -1; n <= 999_999; ++n)
			if (NumberUtil1.isArmstrong(n))
				System.out.println(n);
	}
}

class NumberUtilReverseTest{
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.print("Bir sayi giriniz:");
			int val = Integer.parseInt(kb.nextLine());	
			System.out.printf("%d sayisinin tersi = %d%n", val, NumberUtil1.reverse(val));
			if(val == 0)
				return;
		}
		
	}
}

class NumberUtilCountDigit2{
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("bir sayi giriniz");
		int val = kb.nextInt();
		System.out.printf("%d sayisinin basamak sayisi; %d%n", val, NumberUtil1.countDigit2(val));
		
	}
	
}


class NumberUtil1 {
	
	public static int reverse(int val) {
		
		int result = 0;
		
		while(val != 0) {
			result = result * 10 + val % 10;
			val /= 10;
		}
		
		return result;
	}
	
	public static int countDigit2(int val) {
		int count = 0;
		do {
			++count;
			val /= 10;
		} while(val !=0);
		
		return count;
	}
	
	public static boolean isArmstrong(int a) {
		
		return a >= 0 && powSum(a) == a;
		
	}
	
	public static int getDigitCount(int a) {
		
		int count=0;
		do {
			++count;
			a /= 10;
		} while(a != 0);
		
		return count;
	}
	
	public static int powSum(int a) {
		int count = getDigitCount(a);
		int result=0;
		
		while(a != 0) {
			result += pow(a % 10, count);
			a /= 10;			
		}
		return result;
		
	}
	
	public static int countDigit(int a) {
		int count=0;
		
		do {
			++count;
			a /= 10;
			
		} while(a != 0);
		
		return count;
		
	}
	
	public static int pow(int a, int b) {
		int result = 1;
		
		for(int i = 0; i < b; i++)
			result *= a;
		
//		same here
//		while(b-- > 0) 
//			result *= a;

		return result;
		
	}

	public static int sumDigits(int val) {
		// Parametresi ile aldığı int türden bir sayının basamakları toplamına geri dönen 
		
		int total = 0;
		
		while(val != 0) {
			total += val % 10;
			val /= 10;
		}
		
		return Math.abs(total);
		
	}
	
	public static int reverse1(int val) {
		int result = 0;
		
		while (val != 0) {
			result = result * 10 + val % 10;
			val /= 10;			
		}
		
		return result;
		
	}
	
	public static int sumOf3Digits(int val) {
		
		int a = val / 100;
		int b = val / 10 % 10;
		int c = val % 10;
	
		return Math.abs(a + b + c);
	}
}



class Homeworks {
	
	
	// test edilecek
//	public static int mid(int a, int b, int c) {
//		// 
//		
//	}

	
	// Birinci soru
	public static void sortOfThreeNums() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Üç tane sayı giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		int c = kb.nextInt();
		
		int min = Math.min(Math.min(a, b), c);
		int max = Math.max(Math.max(a, b), c);
		int mid = (a + b + c) - (min + max);

		
		if(min == max)
			System.out.printf("%d = %d = %d", min, min, max);
		else if(mid == min)
			System.out.printf("%d = %d < %d", min, mid, max);
		else if(mid == max)
			System.out.printf("%d < %d = %d", min, mid, max);
		else
			System.out.printf("%d < %d < %d", min, mid, max);
	}
}






class Sample {
	public static boolean foo() {
		System.out.println("foo");
		return true;	
	}
	
	public static boolean bar() {
		System.out.println("bar");
		return false;
	}
	
	public static boolean tar() {
		System.out.println("tar");
		return false;
	}
}




class Operators {
	
	
	public static void comparison() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("iki sayi giriniz:");
		
		int a = kb.nextInt();
		int b = kb.nextInt();
		
		System.out.printf("%d < %d = %b%n", a, b, a < b);
		System.out.printf("%d >= %d = %b%n", a, b, a >= b);
		System.out.printf("%d > %d = %b%n", a, b, a > b);
		System.out.printf("%d <= %d = %b%n", a, b, a <= b);
		System.out.printf("%d == %d = %b%n", a, b, a == b);
		System.out.printf("%d != %d = %b%n", a, b, a != b);
	}
	
	
	
	public static void plusplas() {
		int a = 10;
		int b = 10;
		++a;
		b++; // degiskenin degeri her iki durumda da artar
		
		System.out.printf("a = %d%n", a);
		System.out.printf("b = %d%n", b);
	}
	public static void increase() {
		int a = 10;
		int b;
		b = ++a; // artirilmis deger uretir.
		System.out.printf("a = %d%n", a);
		System.out.printf("b = %d%n", b);
	}
	public static void sameVal() {
		int a = 10;
		int b;
		b = a++; // artirilmamis degeri uretir.
		
		System.out.printf("a = %d%n", a);
		System.out.printf("b = %d%n", b);
	}
	
	public static void ex1() {
		int a = 10;
		int b;
		b = a-- + a;
		// i1: 10 + 9
		System.out.printf("a = %d%n", a);
		System.out.printf("b = %d%n", b);
	}
	public static void ex2() {
		int a = 10;
		int b;
		b = a + a--;
		// i1: 10 + 10
		System.out.printf("a = %d%n", a); // 9
		System.out.printf("b = %d%n", b); // 20
	}
	public static void ex3() {
		int a = 10;
		int b;
		b = a++ + a--;
		// i1: 10 + 10
		System.out.printf("a = %d%n", a); // 10
		System.out.printf("b = %d%n", b); // 21
	}
	public static void maximalMunch() {
		int a = 3;
		int b = 4;
		int c;
		
		c = a+++b; // a++ + b
		
		System.out.printf("a = %d%n", a); // 4
	 	System.out.printf("b = %d%n", b); // 4
		System.out.printf("c = %d%n", c); // 7
	}
	public static void maximalMunch2() {
		int a = 3;
		int b = 4;
		int c;
		
//		c = a++++b; // a++ ++b
		
		System.out.printf("a = %d%n", a); // 4
	 	System.out.printf("b = %d%n", b); // 4
//		System.out.printf("c = %d%n", c); // 7
	}
	
	public static void maximalMunch3() {
		int a = 3;
		int b = 4;
		int c;
		
//		c = a+++++b; // a++ ++b
		
		System.out.printf("a = %d%n", a); // 4
	 	System.out.printf("b = %d%n", b); // 4
//		System.out.printf("c = %d%n", c); // 7
	}
	public static void maximalMunch4() {
		int a = 3;
		int b = 4;
		int c;
		
		c = a+++ +b;
		
		System.out.printf("a = %d%n", a);
		System.out.printf("b = %d%n", b); 
		System.out.printf("c = %d%n", c);
	}
	public static void maximalMunch5() {
		int a;
		
		a = - - - - - - - - - - - - - - - - - - - 2;
		
		System.out.printf("a = %d%n", a);
	}
}

class NumberUtilSumOf3DigitsTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("3 basamakli bir sayi giriniz:");
		
		int x = kb.nextInt();
		System.out.printf("%d sayisinin basamaklari toplami %d", x, NumberUtil1.sumOf3Digits(x));
		
	}
}




class EscapeSequence {
	public static void lineFeed() {
		char c;
		c = '\n';
		System.out.print("hello world");
		System.out.print(c);
		System.out.println("goodbye world");
		System.out.println("Mustafa\nGunes"); // LF 'in string literal icerisindeki kullanimi
	}
	
	public static void carriageReturn() {
		char c;
		c = '\r';
		System.out.print("Hello world");
		System.out.print(c);
		System.out.println("Mu_");
		
	}
	
	public static void escapeSequenceChars() {
		char singleQuote, doubleQuote, doubleQuote2, blackSlash;
		singleQuote = '\''; // single quote
		doubleQuote = '\"'; // double quote
		doubleQuote2 = '"'; // double quote
		blackSlash = '\\';
		
		System.out.println(singleQuote);
		System.out.println(doubleQuote);
		System.out.println(doubleQuote2);
		System.out.println(blackSlash);
	}
	
	public static void escapeSequenceInLiteralString() {
		System.out.println("C:\test\names.txt"); // tab(\t), LF(\n)
		System.out.println("C:\\test\\names.txt"); // now fixed
//		System.out.println("C:\virtual\names.txt"); // String literal icerisinde \ ile desteklenmeyen karakter error olustur. Invalid escape sequence(\v) --- error
		System.out.println("\\\\test\\names.txt"); // iki \\ koyabiliyoruz. sonra \ slash icinde \\ kez yazmis olduk.
		
		System.out.println("'Zonguldak'");
		System.out.println("\'Zonguldak\'");
		System.out.println("\"Zonguldak\"");
		System.out.println("`zonguldak`"); // backtick 'in java da extra bir anlami yok
	}
	
	public static void someDoubleConstant() {
		// 0.1 ile .1 aynidir.
		System.out.println(0.1);
		System.out.println(.1);
		
		// 1.0 ile 1. aynidir
		System.out.println(1.0);
		System.out.println(1.);
		
		System.out.println(5e1); // Sabitlerin bilimsel/üstel gösterilişi. Bu şekilde yazılan sabitler double türdendir  
		System.out.println(5e+1);
		
		// java 7 ile birlikte sabitlerin basamaklari arasina _ alttire kullanimi gelmistir. okunabilirligi artirir.
		
		int a = 1_500;
		System.out.println(a);
		double b = 12_876.345_349;
		System.out.println(b);
	}
	
	public static void otherLiterals() {
		int a = 10;
		int b = 0xA;
		int c = 012;
		int d = 0b1010;
		
		System.out.printf("a=%d, b=%d, c=%d, d=%d%n", a, b, c, d);
		
		int octal = 012;
		System.out.println(octal); // Octal a dikkat
	}
	
	
}


class MathUtil {
	
	public static void round() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayi giriniz");
		double a = kb.nextDouble();
		System.out.printf("round(%f) = %d%n", a, Math.round(a)); // Bilimsel yuvarlama. .5 in ustunu bir ust sayiya, .5 in altinida ayni sayiya yuvarliyor. 
		System.out.printf("rint(%f) = %f%n", a, Math.rint(a));
		System.out.printf("ceil(%f) = %f%n", a, Math.ceil(a));
		System.out.printf("floor(%f) = %f%n", a, Math.floor(a));
	}
	
	public static void minMax() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("iki sayi giriniz:");
		int a = kb.nextInt();
		int b = kb.nextInt();
		System.out.printf("min(%d, %d) = %d%n", a, b, Math.min(a, b));
		System.out.printf("max(%d, %d) = %d%n", a, b, Math.max(a, b));
	}
	
	public static void runAbs() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayi giriniz:");
		int a = kb.nextInt();
		System.out.printf("|%d| = %d", a, Math.abs(a));
		
	}
	
	public static void logCalc() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Bir sayi giriniz:");
		double a = kb.nextDouble();
		System.out.printf("log(%f) = %f%n", a, Math.log(a));
		System.out.printf("log10(%f) = %f%n", a, Math.log10(a));
		System.out.printf("logf1(%f + 1) = %f%n", a, Math.log1p(a));
	}
	
	public static void runLog() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("iki sayi giriniz:");
		double a = kb.nextDouble();
		double b = kb.nextDouble();
		System.out.printf("log(%f, %f) = %f%n", a, b, log(a, b));
	}
	
	public static double log(double a, double b) {
		// a tabanina gore b nin logaritmasi
		return Math.log(b) / Math.log(a);
	}
	
	
}

class PointUtilDistanceTest {
	public static void run() {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("iki noktanin koordinatlarini giriniz:");

		double x1 = kb.nextDouble();
		double y1 = kb.nextDouble();
		double x2 = kb.nextDouble();
		double y2 = kb.nextDouble();
		double d = PointUtil.distance(x1, y1, x2, y2);

		System.out.printf("distance(%f, %f, %f, %f) = %f%n", x1, y1, x2, y2, d);
	}

}

class PointUtil {
	public static double distance(double x1, double y1, double x2, double y2) {
//		double x = Math.pow(x1 - x2, 2);
//		double y = Math.pow(y1 - y2, 2);
//		return Math.sqrt(x + y);
//		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		
	}
}



//System.out.print("iki sayi giriniz:");
//
//int x = kb.nextInt();
//int y = kb.nextInt();
//
//System.out.printf("%d + %d = %d%n", x, y, x + y);
//System.out.printf("%x + %x = %x%n", x, y, x + y);
//System.out.printf("%X + %X = %X%n", x, y, x + y);
//System.out.printf("%h + %h = %h%n", x, y, x + y);
//System.out.printf("%H + %H = %H%n", x, y, x + y);
//System.out.printf("%o + %o = %o%n", x, y, x + y);

//System.out.print("Tarih giriniz:");
//
//int day = kb.nextInt();
//int month = kb.nextInt();
//int year = kb.nextInt();
//
//System.out.printf("%02d/%02d/%04d%n", day, month, year);
//System.out.printf("%2d/%2d/%04d%n", day, month, year);


//System.out.print("Bir sayı giriniz:");
//int a = kb.nextInt();
//System.out.printf("a = %d%na = %08X%n", a, a);

//System.out.print("Bir sayı giriniz:");
//int ratio = kb.nextInt();
//
//System.out.printf("Oran:%%%d%n", ratio);

//int a = kb.nextInt();
//int b = kb.nextInt();
//int c = a / b;
//System.out.printf("%d", c);

//double b = kb.nextDouble();
//double c = a / b;
//System.out.printf("%f", c);





class Util {
	public static int add(int a, int b) {
		return a + b;
	}
//	public static int add() {
//		java.util.Scanner kb = new java.util.Scanner(System.in);
//		System.out.print("iki sayi giriniz:");
//		
//		int a = kb.nextInt();
//		int b = kb.nextInt();
//		int total;
//		total = a + b;
//		return total;
//	}
}




//class App {
//	public int a = 10;// burasi neden block degil
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("Hello world");
//		Sample.foo();
//		Mample.bar();
//		System.out.println("Program End");
//		System.out.println(a);
//	}
//}



//class Sample {
//	public static void foo() {
//		tar();
//		System.out.println("foo");
//		Mample.bar();
//	}
//	
//	public static void tar() {
//		System.out.println("tar");
//	}
//}
//
//class Mample {
//	public static void bar() {
//		System.out.println("bar");
//	}
//}