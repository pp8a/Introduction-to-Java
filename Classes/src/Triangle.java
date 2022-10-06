import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author MVA
 * a, b, c - sides of triangle
 */
public class Triangle {	
		
	double sideA;
	double sideB;
	double sideC;
	
	public Triangle(Point a, Point b, Point c) {
		super();
		this.sideA = side(a, b);
		this.sideB = side(b, c);
		this.sideC = side(c, a);
	}	

	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public void setSideC(double sideC) {
		this.sideC = sideC;
	}

	public static double scale(double point) {
		Supplier<Double> scale = ()->{
			double sc = Math.pow(10, 2);			
			return Math.ceil(point * sc) / sc;
		};	
		return scale.get();
	}
	
	public static double side(Point x, Point y) {		
		BiFunction<Point, Point, Double> f = (u, t) -> scale(Math.sqrt(Math.pow((x.getX()-y.getX()), 2)+Math.pow((x.getY()-y.getY()), 2)));	
		
		return f.apply(x, y);
	}

	@Override
	public String toString() {
		return "Triangle side [A=" + sideA + ", B=" + sideB + ", C=" + sideC + "]";
	}
	
	
}
