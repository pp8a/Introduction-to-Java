import java.util.Arrays;
import java.util.Scanner;

public class Decomposition extends TaskSelection {
	
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
	
	
	@Override	
	public void taskOne() {
		/*
		 * �������� �����(������) ��� ���������� ����������� ������ �������� 
		 * � ����������� ������ �������� ���� ����������� �����: (���(A,B)=A*B/���(A,B)
		 */
		int A;
		int B;		
		
		System.out.println("Input the two natural numbers!");					
		System.out.println("Number 1:");
		A = input();		
		
		System.out.println("Number 2:");
		B = input();
		
		System.out.println("Data: "+A+", "+B);
		
		int gcdValue; //���
		gcdValue = Fraction.gcd(A, B);
		System.out.println("GCD: "+gcdValue);
		
		int lcmValue; //���
		lcmValue = Fraction.lcm(A, B, gcdValue);
		System.out.println("LCM: "+lcmValue);		
	}
	
	@Override	
	public void taskTwo() {
		/*
		 * �������� �����(������) ��� ���������� ����������� ������ �������� ������� ����������� �����.
		 */		
		
		int max=20;//Integer.MAX_VALUE;
		int min=1;
		int number = 4;	
		
		int [] array = new int [number];		
		for(int i=0; i<number; i++)
		{
			array[i] = (int)(Math.random() * ((max - min)+1) + min);			
		}
		System.out.println("Data: "+Arrays.toString(array));
		
		int gcdValue;		
		gcdValue = Fraction.gcd(Fraction.gcd(array[0], array[1]), Fraction.gcd(array[2], array[3]));
		System.out.println("GCD: "+gcdValue);
	}
	
	@Override	
	public void taskThree() {
		/*
		 * ��������� ������� ����������� �������������� �� �������� �, 
		 * ��������� ����� ���������� ������� ������������.
		 * S=3 sqrt(3apow(2))/2
		 */
		
		int a;
		double S;
		
		System.out.println("Input the length of the hexagon side:");
		a = input();
		
		S = 3 * (Math.sqrt(3)*Math.pow(a, 2))/2;
		/**
		 * ������� ��� ���������� ������� ����������� �������������� ����� �������
		 */		
		//���������� ������ ����� �������
		double scale = Math.pow(10, 3);
		double result = Math.ceil(S * scale) / scale;		
		System.out.println("S = "+result);
		
		double p = 3*a/2; //������������
		S = (Math.sqrt(p*(p-a)*(p-a)*(p-a)))*6;//���������� ������������� 6 
		/**
		 * ������� ������ ��� ���������� ������� ������������
		 */				
		result = Math.ceil(S * scale) / scale;				
		System.out.println("S = "+result);		
				
		S = ((Math.sqrt(3)*Math.pow(a, 2))/4)*6;//���������� ������������� 6
		/**
		 * ������� ��������������� ������������ ����� �������
		 */
		result = Math.ceil(S * scale) / scale;				
		System.out.println("S = "+result);
	}
	
	@Override	
	public void taskFour() {
		/*
		 * �� ��������� ������ ������ ������������ n �����. 
		 * �������� �����(������), ������������, ����� ������ �� ��� ����� ����� ������� ����������. 
		 * ��������. ���������� ����� ������� � ������.
		 */
		
		int n; //number of point		
		System.out.println("Input the number of points:");
		n = input();
		
		int max=10;
		int min=-10;
		
		Coordinate [] points = new Coordinate[n];//initialization null		
		for(int i=0; i<points.length; i++)
		{
			/*points[i] = new Coordinate(Coordinate.scale((Math.random() * ((max - min)+1) + min)), 
					Coordinate.scale((Math.random() * ((max - min)+1) + min))); */
			
			points[i] = new Coordinate(); 
			points[i].setX(Coordinate.scale((Math.random() * ((max - min)+1) + min)));			
			points[i].setY(Coordinate.scale((Math.random() * ((max - min)+1) + min)));			
		}	
		
		System.out.println("Data of points:");
		for(int i=0; i<points.length; i++)
		{
			System.out.println("\t\t"+(i+1)+": "+points[i].getX()+" "+points[i].getY());
		}
		
		double maxDistance = Double.MIN_VALUE;
		int indexA = 0;
		int indexB = 0;
		for(int i=0; i<points.length-1; i++) {
			for(int k=i+1; k<points.length; k++) {
				Coordinate pointA = points[i];
				Coordinate pointB = points[k];
					
				double res = Coordinate.scale(Coordinate.calculating(pointA, pointB));// Calculating
				if(res>maxDistance) {
					maxDistance=res;
					indexA = i;
					indexB = k;						
				}				
			}
		}
		
		System.out.println("Result:");
		System.out.println("Point "+(indexA+1)+": x="+points[indexA].getX()+" y="+points[indexA].getY());
		System.out.println("Point "+(indexB+1)+": x="+points[indexB].getX()+" y="+points[indexB].getY());
		System.out.println("Distance: "+maxDistance);	
		
	}
	
	@Override	
	public void taskFive() {
		/*
		 * ��������� ���������, ������� � ������� A[N] ������� ������ �� �������� ����� 
		 * (������� �� ������ �����, ������� ������ ������������� �������� �������, �� ������ ���� ������ ���������).
		 */
		
		System.out.println("Input the dimension of the arrays!");		
		int dim = input();
		int [] array = new int[dim];
		for(int i=0; i<array.length; i++)
		{
			array[i] = (int)(Math.random()*130)-30; // random numbers			
		}
		
		System.out.println("Data: "+Arrays.toString(array));
		
		int max = Integer.MIN_VALUE; // max number		
		for(int i=0; i<array.length; i++) {
			if(array[i]>max) {
				max = array[i];
			}
		}
		
		int max2 = Integer.MIN_VALUE; //second max number
		for(int i=0; i<array.length; i++) {
			if(array[i]>max2&&array[i]<max) {
				max2 = array[i];
			}						
		}
		
		for(int i=0; i<array.length; i++) {
			if(array[i]!=max && array[i]!=max2) {
				System.out.print(array[i]+" ");
			}
		}
		
		System.out.println(" < "+max2+" < "+max);
		System.out.println("Result: "+max2);
	}
	
	@Override	
	public void taskSix() {
		/*
		 * �������� �����(������), �����������, �������� �� ������ ��� ����� ������� ��������.
		 */
		int max=20;//Integer.MAX_VALUE;
		int min=1;
		int number = 3;	
		
		int [] array = new int [number];		
		for(int i=0; i<number; i++)
		{
			array[i] = (int)(Math.random() * ((max - min)+1) + min);			
		}
		System.out.println("Data: "+Arrays.toString(array));
		
		int gcdValue;		
		gcdValue = Fraction.gcd(Fraction.gcd(array[0], array[1]), array[2]);
		System.out.println("GCD: "+gcdValue);
		
		if(gcdValue==1) {
			System.out.println("Mutually prime numbers: "+Arrays.toString(array));
		} else {
			System.out.println("NO mutually prime numbers: "+Arrays.toString(array));
		}		
	}
	
	@Override	
	public void taskSeven() {
		/*
		 * �������� �����(������) ��� ���������� ����� ����������� ���� �������� ����� �� 1 �� 9
		 */
		int n = 9;
		int [] array = new int [n];
		for(int i=0; i<n; i++)
		{
			array[i] = i+1;			
		}
		System.out.println("Data: "+Arrays.toString(array));
		System.out.println("n = sum");
		
		int sum = 1;
		for(int i=0; i<n; i++)
		{
			if(array[i]%2 != 0) {
				System.out.print(array[i]+" = ");
				for(int j=1; j<=array[i]; j++) {
					sum *=j;
				}
				System.out.print(sum+"\n");
			}	
			sum = 1;
		}		
	}
	
	@Override	
	public void taskEight() {
		/*
		 * ����� ������ D. ���������� ��������� �����: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
		 * ���������. ��������� �����(������) ��� ���������� ����� ���� ��������������� ������������� ���������
		 * ������� � �������� �� k �� m
		 */
		
		int dim;
		System.out.println("Input the dimension of the array, no less 5!");	
		do {
			dim = input();	
		}while(dim<=4);
		
		
		int [] array = new int[dim];
		for(int i=0; i<array.length; i++)
		{
			array[i] = (int)(Math.random()*25); // random numbers			
		}
		
		System.out.println("Data: "+Arrays.toString(array));
		
		int max=dim;
		int min=5;
		int k, m;
		m = (int)(Math.random() * ((max - min)+1) + min);//
		k = m-5;
		
		System.out.println("From "+(k+1)+" to "+m+":");
		
		for(int i=k; i<m-2; i++) {
			int sum = calculate(array, i+1);
			System.out.print(" = "+sum+"\n");			
		}
	}
	
	static int calculate(int[] array, int n) {
		/*
		 * array from k to m, n - 3 elements
		 */
		int sum = 0;
		for(int i=n-1; i<n+2; i++)
		{
			sum +=array[i];	
			System.out.print(array[i]+" ");
		}	
		
		return sum;		
	}
	
	@Override	
	public void taskNine() {
		/*
		 * ���� ����� X, Y, Z, � � ����� ������ ����������������. 
		 * �������� �����(������) ���������� ��� �������, ���� ���� ����� ��������� ������ X � Y� ������.
		 */		
		double max = 10;
		double min = 1;
		
		double [] array = new double[4];
		for(int i=0; i<array.length; i++)
		{
			array[i] = scale(Math.random() * ((max - min)+1) + min); // random numbers			
		}		
		
		System.out.println("Data sides of the quadrilateral: "+Arrays.toString(array));
		
		double x = array[0];
		double y = array[1]; 
		double z = array[2];		
		double t = array[3];		
		
		double c = hypotenuse(x, y);
		System.out.println("Hypotenuse: "+c);
		
		double cxy = rightTriangle(c, x);
		System.out.println("The square of rectangular triangle: "+cxy);		
			
		double czt = triangle(c, z, t);
		System.out.println("The square of triangle: "+czt); 
		
		System.out.println("The square of quadrangle: "+scale(cxy+czt));
		
    }
	
	static double hypotenuse(double x, double y) {
		
		return scale(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));
	}
	
	
	static double rightTriangle(double c, double x) {
		//return scale((x*y)/2); 
		return scale(0.5*x*(Math.sqrt(Math.pow(c, 2)-Math.pow(x, 2))));
	}	
	
	static double triangle(double c, double z, double t) {
		
		double s = ((c+z+t)/2); // the semi-perimeter of the triangle
		
		return scale(Math.sqrt(s*(s-c)*(s-z)*(s-t)));		
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
	public void taskTen() {
		/*
		 * ���� ����������� ����� N. 
		 * �������� �����(������) ��� ������������ �������, ���������� �������� �������� ����� ����� N.
		 */
		int N;
		System.out.println("Input a number: ");	
		N = input();//������ �����
		int  size  = sizeArray(N);//����������� ���������� ���� � �����, ������ �������		
		System.out.println("Array: "+Arrays.toString(creatingArray(size, N)));
	}
	
	public static int sizeArray(int N) {
				
		int size = 0;
		while(N!=0) {			
			N = N / 10;
			size++;			
		}
		
		return size;
	}
	
	public static int[] creatingArray(int size, int N) {
		
		int[] array = new int[size];		
		for(int i=array.length-1; i>=0; i--) {
			int n = N % 10;
			N = N / 10;
			array[i]=n;
		}
		
		return array;
	}
	
	@Override	
	public void taskEleven() {
		/*
		 * �������� �����(������), ������������, � ����� �� ������ ���� ����� ������ ����.
		 */
		int n1, n2;
		System.out.println("input the first number: ");	
		n1 = input();//������ �����
		System.out.println("input the second number: ");	
		n2 = input();//������ �����
		
		if(sizeArray(n1)>sizeArray(n2)){
			System.out.println("more digits in the number "+n1+" than in the number "+n2);
		}else if(sizeArray(n1)<sizeArray(n2)){
			System.out.println("more digits in the number "+n2+" than in the number "+n1);
		}else{
			System.out.println("the number "+n1+" and "+n2+" have the same number of digits");
		};
	}
	
	@Override	
	public void taskTwelve() {
		/*
		 * ���� ����������� ����� � � N. 
		 * �������� �����(������) ������������ ������� �, ���������� �������� �������� �����, ����� ���� ������� ����� � � ������� �� ������� N.
		 */
		
		int K, N;
		System.out.println("Input the first number: ");	
		K = input();//������ �����
		do {
			System.out.println("Input the second number: ");	
			N = input();//������ �����
			if(N<=K) {
				System.err.println("The second number must be more than first number");
			}
		}while(N<=K);
			
		
		int count = 0;
		for(int i=0; i<N; i++) {
			if(sum(i)==K) {
				count++;//������� ���������� ����� ���� 				
			}
		}
		
		int array [] = new int [count];	
		int j=0;
		for(int i=0; i<N; i++) {
			if(sum(i)==K) {				
				array[j++]=i;//��������� ������ ������� ����� ������� ����� � � ������ ����� �� ������ ����� N
			}
		}
		
		System.out.println("The array is formed: "+Arrays.toString(array));
	}
	
	public static int sum(int n) {//����� ���� �����		
		int sum = 0;
		while(n!=0) {			
			sum += n % 10;
			n = n / 10;			
		}
		
		return sum;
	}
	
	@Override	
	public void taskThirteen() {
		/*
		 * ��� ������� ����� ���������� �����������, ���� ��� ���������� ���� �� ����� �� 2 (��������, 41 � 43).
		 * ����� � ���������� ��� ���� ���������� �� ������� [n,2n], 
		 * ��� n - �������� ����������� ����� ������ 2. 
		 * ��� ������� ������ ������������ ������������. 
		 */	
		System.out.println("Input the dimension of the segment:");		
		int n = input();
		int [] array = new int[n];
		for(int i=0; i<array.length; i++)
		{
			array[i] =i+3; //�������� ����������� ����� ������ 2.		
		}
		
		System.out.println("Data: "+Arrays.toString(array));
		
		array=simple(array);
		System.out.println("Simple number: "+Arrays.toString(array));
		
		System.out.println("Twins: ");
		for(int i=0; i<array.length-1; i++)
		{			
			if(twins(array[i], array[i+1])) {
				System.out.println(array[i]+" and "+array[i+1]);	
			}		
		}
		
	}
	
	public static int [] simple(int [] array){	
		
		int count=0;
		int n = 0;//���������� ������� �����
		for (int i=0; i<array.length; i++) {			
			for(int j = 1; j<array[i]; j++) {
				if(array[i]%j == 0) {
					count++;
				}
			}
			if(count==1) {				
				array[n]=array[i];
				n++; 
				count--;
			} 
			if(count>=2) {
				count=0;
			}
			
		}			
			
		int [] simpleArray = new int[n]; //������� ������ �� ������� �����
		System.arraycopy(array, 0, simpleArray, 0, n);		
		
		return simpleArray;		
	}
	
	public static boolean twins(int x, int y) {
		//������� "���������"
		return x+2==y;	
	}
	
	@Override	
	public void taskFourteen() {
		/*
		 * ����������� �����, � ������ �������� n ����, ���������� ������ ����������, ���� ����� ��� ����,
		 * ����������� � ������� n, ����� ������ �����. ����� ��� ����� ���������� �� 1 �� k. 
		 * ��� ������� ������ ������������ ������������.
		 */
		
		System.out.println("Input the number from 1 to: ");		
		Integer n = input();
		Integer [] array = new Integer[n];
		for(int i=0; i<array.length; i++)
		{
			array[i] =i+1; //�������� ����������� ����� ������ 2.		
		}
		
		//System.out.println("Data: "+Arrays.toString(array));
		
		int sum = 0;
		System.out.println("Armstrong numbers: ");
		for(int i=0; i<array.length; i++)
		{				
			sum=sum(array[i], degree(array[i]));
			if(array[i]==sum) {
				System.out.print(array[i]+" ");
			}
			
		}
		
	}
	
	public static int degree (int n) {//�������		
		
		int count = 0;
		while(n!=0) {			
			n = n / 10;			
			count++;
		}
		
		return count;
	}
	
	public static int sum(int number, int n) {//����� ���� ����� number � n-�������		
		int sum = 0;
		while(number!=0) {				
			sum += Math.pow((number % 10), n);			
			number = number / 10;			
		}
		
		return sum;
	}	
	
	@Override	
	public void taskFiveteen() {
		/*
		 * ����� ��� ����������� n-������� �����, ����� � ������� �������� ������ ������������ ������������������ (��������, 1234, 5789). 
		 * ��� ������� ������ ������������ ������������.
		 */
		
		Integer [] array = new Integer[] {132, 456, 258, 123, 879, 789, 123456, 654, 12, 3};		
		System.out.println("Data: "+Arrays.toString(array));
		
		System.out.print("Result: ");
		for(int i=0; i<array.length; i++)
		{
			if(search(array[i], count(array[i]))) {
				System.out.print(array[i]+" ");
			};		
		}		
		
	}
	
	public static boolean search(int n, int count) {		
		boolean num = true;		
		if(count==1) {//���� ����� �� ����� �����
			num = false;
		}
		while(n!=0 && num) {			
			int m = n % 10;	//last number		
			n = n / 10;	//decrement number
			
			if((m-1)!=(n%10) && count>1) {//compare the number and checking the last digit				
				num = false;				
			}
			count--;
		}
		
		return num;
	}
	
	public static int count (int n) {//���������� ���� � �����
		
		int count = 0;
		while(n!=0) {			
			n = n / 10;			
			count++;
		}
		
		return count;
	}
	
	@Override	
	public void taskSixteen() {
		/*
		 * �������� ���������, ������������ ����� n - ������� �����, ���������� ������ �������� �����.
		 * ���������� �����, ������� ������ ���� � ��������� �����. ��� ������� ������ ������������ ������������.
		 */
		int max = 1000000;
		int min = 1;		
		int [] array = new int[500];
		for(int i=0; i<array.length; i++)
		{
			array[i] = (int)(Math.random() * ((max - min)+1) + min); // random numbers			
		}		
		
		System.out.println("Data: "+Arrays.toString(array));	
		
		for(int i=0; i<array.length; i++)
		{
			if(odd(array[i], count(array[i]))) {
				System.out.print("����� �� �������� �����: "+array[i]+
						" �� ����� = "+sum(array[i])+" ������ ���� � ��� - "+countEven(sum(array[i]))+"\n");
			}	
		}
	}
	
	public static boolean odd(int n, int count) {		
		//���������� ����� ���������� �������� �����
		boolean num = true;
		while(n!=0 && num) {			
			if((n%10)%2 == 0 && count>=1) {
				num = false;
			};
				n = n / 10;	
				count--;
		}
		 return num;		
	}
	
	public static int countEven(int n) {
		//���������� ������ �����
		int count=0;
		while(n!=0){
			if((n%10)%2==0) {
				count++;
			}
			n /=10; 
		}		
		
		return count;
	}
	
	@Override	
	public void taskSeventeen() {
		/*
		 * �� ��������� ����� ����� ����� ��� ����. �� ���������� ����� ����� ����� ��� ���� � �.�. 
		 * ������� ����� �������� ���� ����������, ����� ��������� ����? ��� ������� ������ ������������ ������������.
		 */
		
		int max = 1000;
		int min = 1;		
		int [] array = new int[10];
		for(int i=0; i<array.length; i++)
		{
			array[i] = (int)(Math.random() * ((max - min)+1) + min); // random numbers			
		}		
		
		System.out.println("Data: "+Arrays.toString(array));
		
		for(int i=0; i<array.length; i++)
		{
			System.out.println("Number: "+array[i]+", number of actions = "+countOperation(array[i]));
		}
	}
	
	static public int countOperation(int n) {
		//���������� �������� ���������� �� ����� ����� ��� ����
		int count = 0;		
		do {				
			n=n-sum(n);				
			count++;				
		}while(n!=0);
		
		return count;
	}
	
}
