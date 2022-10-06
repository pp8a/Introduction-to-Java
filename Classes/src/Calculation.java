import java.util.function.Supplier;

public enum Calculation {
	
	SQUARE() {
		@Override
		public double calculation() {
			Supplier<Double> square = ()-> {				
				double p =((triangle.sideA+triangle.sideB+triangle.sideC)/2);				
				return Math.sqrt(p*(p-triangle.sideA)*(p-triangle.sideB)*(p-triangle.sideC));
			};
			System.out.print(this+"=");
			return Triangle.scale(square.get());
		}
	}, PERIMETER() {
		@Override
		public double calculation() {
			Supplier<Double> perimeter = ()-> triangle.sideA+triangle.sideB+triangle.sideC;
			System.out.print(this+"=");
			return Triangle.scale(perimeter.get());
		}
	}, MEDIAN() {
		@Override
		public double calculation() {
			Supplier<Double> median = ()-> (0.5)*(Math.sqrt((2*Math.pow(triangle.sideA, 2))+(2*Math.pow(triangle.sideB, 2))+(2*Math.pow(triangle.sideC, 2))));
			System.out.print(this+"=");
			return Triangle.scale(median.get());			
		}
	};
	
	private static Triangle triangle;	
		
	public abstract double calculation();

	public static Triangle getTriangle() {
		return triangle;
	}

	public static void setTriangle(Triangle triangle) {
		Calculation.triangle = triangle;
	}	
	
}
