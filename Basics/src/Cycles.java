import java.util.Scanner;

public class Cycles extends TaskSelection{
	
	public static int input() {		
		int number;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	
		
		do {				
		    while (!in.hasNextInt()) {
		        System.err.println("It's not an integer number! ... Input:");
		        in.next(); 
		    }
		    number = in.nextInt();
		    if(number<=0) {
		    	System.out.println("Input only positive number! ... Input:");
		    }
		} while (number<=0);
		
		return number;
	}
	
	public static double inputDouble() {		
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	
						
		while (!in.hasNextDouble()) {
			System.err.println("It's not an double number! ... Input:");
			in.next(); 
		}
		
		return in.nextDouble();
	}
	
	@Override	
	public void taskOne() {
		/*
		 * Напишите программу, где пользователь вводит любое целое положительное число. 
		 * А программа суммирует все числа от 1 до введенного пользователем числа.
		 */
		System.out.println("Input a positive integer: ");
		int x = input();
		
		int sum=0;		
		for(int i=0; i<=x; i++) {
			sum+=i;
		}
		System.out.println("The sum of number "+x+" = "+sum);
	}
	
	@Override	
	public void taskTwo() {
		/*
		 * Вычислить значения функции на отрезке [а,b] c шагом h:
		 * y= x, x>2 = -x, x<=2
		 */
		System.out.print("Input the beginning of the segment: ");
		double a = inputDouble();
		
		double b;
		System.out.print("Input the end of the segment: ");		
		do {
			b = inputDouble();
			if(b<a) {
		    	System.err.println("Input a number greater than "+a+"\nInput...");
		    }
		}while(b<a);
		
		double h;
		System.out.print("Input the step of the segment: ");		
		do {
			h = inputDouble();
			if(h<=0) {
		    	System.err.println("Input only positive number ... \nInput:");
		    }
		}while(h<=0);		
		
		double y = 0;
		for(double x=a; x<=b; x+=h) {
			if(x<=2) {
				y = -x;
			}else {
				y = x;
			}
		}
		
		System.out.print("The value of the function in the interval from "+a+" to "+b+" = "+y);
	}
	
	@Override	
	public void taskThree() {
		/*
		 * Найти сумму квадратов первых ста чисел
		 */
		int sum = 0;
		for(int i = 1; i<=100; i++) {
			sum += Math.pow(i, 2);			
		}
		System.out.print("The sum of the squares of the first 100 numbers: "+sum);
	}
	
	@Override	
	public void taskFour() {
		/*
		 * Составить программу нахождения произведения квадратов первых двухсот чисел.
		 */
		long sum = 1;
		for(int i = 1; i<=200; i++) {
			sum *= Math.pow(i, 2);			
		}
		System.out.print("The product of the squares of the first 200 numbers: "+sum);
	}
	
	@Override	
	public void taskFive() {
		/*
		 * Даны числовой ряд и некоторое число е. 
		 * Найти сумму тех членов ряда, модуль которых больше или равен заданному е. Общий член ряда имеет вид:
		 * an = 1/2^n+1/3^n
		 */
		System.out.print("Input the number: ");//0 or 0.2 or 0.3 :)
		double e = inputDouble();
		
		double sum = 0;
		for(int n = 1; n<100; n++) {
			double a = (1/Math.pow(2, n))+(1/Math.pow(3, n));
			
			if(Math.abs(a)>=e) {
				sum+=a;
				System.out.printf("%.3f sum is %f\n", a, sum);
			}			
		}
	}
	
	@Override	
	public void taskSix() {
		/*
		 * Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
		 */
		for (int i = 33; i <=183; i++) {
            System.out.println("Number " + i + " corresponds to the symbol " + (char) i);
        }
	}
	
	@Override	
	public void taskSeven() {
		/*
		 * Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
		 * m и n вводятся с клавиатуры.
		 */
		
		System.out.println("Input a range of numbers from n to m.");
		System.out.print("n = ");
		int n = input();
		System.out.print("m = ");
		int m;
		do {
			m = input();
			if(m<n) {
		    	System.err.println("Input a number greater than "+n+"\nInput...");
		    }
		}while(m<=n);
		
		for(int i=n; i<=m; i++) {
			int count = 1;//если делителей больше 1-го...
			for(int j=2; j<m; j++) {				
				if(i%j==0 && j!=i) {
					if(count==1) {
						System.out.print("\nThe number "+i+" it's divisors ");	
					}
					System.out.print(j+" ");
					count=0;
				}
			}
		}
	}
	
	@Override	
	public void taskEight() {
		/*
		 * Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
		 */
		int x = (int)(Math.random() * 100000)-30000;	
		int y = (int)(Math.random() * 100000)-30000;
		System.out.print("Data: "+x+" and "+y+"\n");
		
		int cX = count(x);
		int cY = count(y);
		
		System.out.print("Result: ");
		for(int i=0; i<cX; i++) {
			while(x!=0) {				
				for(int j=0, y1=y; j<cY; j++) {
					if(equal(x%10, y1%10)){
						System.out.print(Math.abs(x%10)+" ");
					}
					y1 = y1/10;
				}				
				x = x/10;			
			}			
		}
	}
	
	public static int count (int n) {//количество цифр в числе
		
		int count = 0;
		while(n!=0) {			
			n = n / 10;			
			count++;
		}
		
		return count;
	}
	
	public static boolean equal(int x, int y) {//сумма цифр числа		
		boolean num = false;
		
		if(Math.abs(x)==Math.abs(y)) {
			num = true;
		}		
		
		return num;
	}

}
