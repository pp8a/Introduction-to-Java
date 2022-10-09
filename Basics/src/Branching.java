import java.util.Scanner;

public class Branching extends TaskSelection{
	
	public static int input() {		
		int number;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	
		
					
		while (!in.hasNextInt()) {
			System.err.println("It's not an integer number! ... Input:");
			in.next(); 
		}
		number = in.nextInt();
		if(number<=0) {
			System.out.println("Input only positive number! ... Input:");
		}		
		
		return number;
	}
	
	@Override	
	public void taskOne() {
		/*
		 * Даны два угла треугольника (в градусах). 
		 * Определить, существует ли такой треугольник, и если да, то будет ли он прямоугольным.
		 */
		
		int a, b;
		System.out.println("Input the values of the two angles of the triangle in degrees: ");
		System.out.println("angles 1: ");
		a = input();
		System.out.println("angles 2: ");
		b = input();
		
		if(a+b<180) {
			System.out.println("The triangle exists!");
			if(a==90||b==90||(180-a-b==90)) {
				System.out.println("The triangle is rectangular!");
			}
		}else {
			System.out.println("There is no such triangle :(");
		}
		
	}
	
	@Override	
	public void taskTwo() {
		/*
		 * Найти max{min(a, b), min(c, d)}.
		 */
		
		enum Coordinate {
			a, b, c, d;

			private int number;

			Coordinate(int number) {
				this.number = number;
			}
			
			Coordinate(){				
			}
	    }
		
		System.out.print("Data: ");
		for(Coordinate allCoordinate : Coordinate.values()){
			System.out.print((allCoordinate.number= (int)(Math.random() * 100)-30)+"; ");
		}
				
		System.out.println("\nMax = "+max(min(Coordinate.a.number, Coordinate.b.number), min(Coordinate.c.number, Coordinate.d.number)));
	}
	
	static public int min(int x, int y) {
		if(x<y) {
			return x;
		}else {
			return y;
		}
	}
	
	static public int max(int x, int y) {
		if(x>y) {
			return x;
		}else {
			return y;
		}
	}
	
	
	@Override	
	public void taskThree() {
		/*
		 * Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
		 */		
		enum Point {
			A, B, C;

			private double x;
			private double y;

			Point(double x, double y) {
				this.x = x;
				this.y = y;
			}
			
			Point(){				
			}
	    }
		
		System.out.print("Data: ");
		for(Point points : Point.values()){
			System.out.print(points+"(");
			System.out.print((points.x= (int)(Math.random() * 10)-10)+", ");
			System.out.print((points.y= (int)(Math.random() * 10)-10)+") ");
		}
		
		//Данные точки расположены на одной прямой
		//Point.A.x= -2; Point.A.y= 1; Point.B.x= 0; Point.B.y= 3; Point.C.x= -7; Point.C.y= -4;
		//https://belmathematics.by/stati/3533-kogda-3-tochki-lezhat-na-odnoj-pryamoj
		
		System.out.println();
		if((Point.C.x-Point.B.x)/(Point.A.x-Point.B.x)==(Point.C.y-Point.B.y)/(Point.A.y-Point.B.y))
		{
			System.out.println("These points (A, B, C) are located on the same straight line!");
		}
		System.out.println("These points aren't located on the same straight line :(");
	}
	
	@Override	
	public void taskFour() {
		/*
		 * Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. 
		 * Определить, пройдет ли кирпич через отверстие.
		 */
		System.out.println("Input the the hole dimensions: ");
		System.out.print("height: ");
		int A = input();
		System.out.print("width: ");
		int B = input();
		
		int x = 250;
		int y = 120;
		int z = 65;
		System.out.println("Brick sizes: lenght - "+x+" width - "+y+" height - "+ z);
		
		int d1 = (int) Math.sqrt(Math.pow(z, 2)+Math.pow(y, 2));//diagonal of the brick 136
		int d2 = (int) Math.sqrt(Math.pow(z, 2)+Math.pow(x, 2));//258
		int d3 = (int) Math.sqrt(Math.pow(y, 2)+Math.pow(x, 2));//277
		
		if(z<=A && y<=B || y<=A && z<=B || z<=A && x<=B || x<=A && z<=B || x<=A && y<=B || y<=A && x<=B){
			System.out.println("The brick passes through the hole");			
		} else if (d1<=A || d1<=B || d2<=A || d2<=B || d3<=A || d3<=B){
			System.out.println("The brick passes through the hole diagonally");
		}else {
			System.out.println("The brick no passes through the hole");
		}
		
	}
	
	@Override	
	public void taskFive() {
		/*
		 * Вычислить значение функции: F(x) = pow(x, 2)-3x+9, если x<=3; = 1/((pow(x,3)+6), x>3
		 */
		int x = (int)(Math.random()*20)-10;
		
		double F;
		if(x<=3) {
			F = Math.pow(x, 2)-(3*x)+9;
			System.out.println("F("+x+") = x^2-3x+9 = "+scale(F));
		}else {
			F = 1/((Math.pow(x,3)+6));
			System.out.println("F("+x+") = 1/x^3+6 = "+scale(F));
		}
	}
	
	public static double scale(double f) {
		/*
		 * количество знаков после запятой
		 */
		double scale = Math.pow(10, 3);
		double result = Math.ceil(f * scale) / scale;
		
		return result;
	}
}
