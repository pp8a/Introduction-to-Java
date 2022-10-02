import java.util.Scanner;

public class Linear extends TaskSelection{
	
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
		} while (number <= 0);
		
		return number;
	}
	
	public static int inputCoordinate() {		
		int number;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while (!in.hasNextInt()) {
				System.err.println("It's not an integer number! ... Input:");
				in.next(); 
		    }
		number = in.nextInt();
		
		return number;
	}
	
	public static double scale(double point) {
		/*
		 * ���������� ������ ����� �������
		 */
		double scale = Math.pow(10, 3);
		double result = Math.ceil(point * scale) / scale;
		
		return result;
	}
	
	@Override	
	public void taskOne() {
		/*
		 * ������� �������� �������: z = ( (a � 3 ) * b / 2) + c.
		 */
		System.out.println("Input three numbers:");					
		System.out.println("Number 1:");
		int a = input();		
		
		System.out.println("Number 2:");
		int b = input();
		
		System.out.println("Number 3:");
		int c = input();
		
		int z = ((a-3)*b/2)+c;
		System.out.println("The value of the function ( (a � 3 ) * b / 2) + c = " +z);
	}
	
	@Override	
	public void taskTwo() {
		/*
		 * ��������� �������� ��������� �� ������� (��� ���������� ��������� �������������� ��������):
		 * (b+sqrt(pow(b,2)+4ac))/(2*a) - pow(a,3)*c+pow(b, -2)
		 */
		int max=20;//Integer.MAX_VALUE;
		int min=-20;
		int number = 3;	
		
		double [] array = new double [number];		
		for(int i=0; i<number; i++)
		{
			array[i] = (Math.random() * ((max - min)+1) + min);			
		}
		
		double a = scale(array[0]);
		double b = scale(array[1]);
		double c = scale(array[2]);
		
		System.out.println("Data: a="+a+" b="+b+" c="+c);
		
		double z = (b+Math.sqrt(Math.pow(b, 2)+4*a*c))/(2*a)-Math.pow(a, 3)*c+Math.pow(b, -2);
		System.out.println("The value of the function (b+sqrt(pow(b,2)+4ac))/(2*a) - pow(a,3)*c+pow(b, -2) = " +scale(z));
		
	}
	
	@Override	
	public void taskThree() {
		/*
		 *  ��������� �������� ��������� �� ������� (��� ���������� ��������� �������������� ��������):
		 *  (sin(x) + cos(y))/(cos(x)-sin(y))*tg(x*y)
		 */
		int max=20;//Integer.MAX_VALUE;
		int min=-20;
		int number = 2;	
		
		double [] array = new double [number];		
		for(int i=0; i<number; i++)
		{
			array[i] = (Math.random() * ((max - min)+1) + min);			
		}
		
		double x = scale(array[0]);
		double y = scale(array[1]);
		
		System.out.println("Data: x="+x+" y="+y);
		
		double z = (Math.sin(x) + Math.cos(y))/(Math.cos(x)-Math.sin(y))*Math.tan(x*y);
		System.out.println("The value of the function (sin(x) + cos(y))/(cos(x)-sin(y))*tg(x*y) = " +scale(z));		
	}
	
	@Override	
	public void taskFour() {
		/*
		 * ���� �������������� ����� R ���� nnn.ddd (��� �������� ������� � ������� � ����� ������). 
		 * �������� ������� ������� � ����� ����� ����� � ������� ���������� �������� �����.
		 */
		double R = 234.583;
		int n = 1000;
		System.out.println("Data: "+R);
		
		int resInt = (int)R;
		double resDouble = scale(R-resInt);
		R = (double)resInt/n+resDouble*n;
		System.out.println("Result: "+R);
	}
	
	@Override	
	public void taskFive() {
		/*
		 * ���� ����������� ����� �, ������� ������������ ������������ ���������� ������� � ��������. 
		 * ������� ������ �������� ������������ � �����, ������� � �������� � ��������� �����:
		 * ��� ����� SSc.
		 */
		
		int sec = 62_599;
		int hour = sec/3600;
		int minutes = (sec-(3600*hour))/60;
		int seconds = (sec-(3600*hour)-(60*minutes));
		
		System.out.println("����: "+sec+" seconds\n");		
		System.out.println("�����: "+hour+"� "+minutes+"��� "+seconds+"�.");		
		
	}
	
	@Override	
	public void taskSix() {
		/*
		 * ��� ������ ������� ��������� �������� ���������, ������� �������� true, 
		 * ���� ����� � ������������ (�, �) ����������� ����������� �������, � false � � ��������� ������.
		 */
		System.out.println("Input the coordinates of the point: ");
		System.out.print("x = ");
		int x = inputCoordinate();
		System.out.print("y = ");
		int y = inputCoordinate();
		
		if(x<=2 && x>=-2 && y<=4 && y >=-3) {
			System.out.println(true);
		}else if(x<=4 && x>=-4 && y<=0 && y>=-3) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}		
	}
}
