public class Coordinate {
	private double x;
	private double y;
		
	Coordinate(double x, double y){
		this.x = x;
		this.y = y;				
	}
	
	Coordinate(){
						
	}
	
	public double getX() {
		
		return x;		
	}
	
	public double getY() {
		
		return y;		
	}
	
	public void setX(double x) {

		this.x = x;
	}
	
	public void setY(double y) {
		
		this.y = y;		
	}
		
	public static double scale(double point) {
		/*
		 * количество знаков после запятой
		 */
		double scale = Math.pow(10, 2);
		double result = Math.ceil(point * scale) / scale;
		
		return result;
	}
	
	public static double calculating(Coordinate a, Coordinate b) {
		/*
		 * Calculating the distance between two points based on the coordinates of these points
		 */
		double xA = a.x;
		double yA = a.y;
		double xB = b.x;
		double yB = b.y;		
		
		double distance = Math.sqrt(Math.pow((xA-xB), 2)+Math.pow((yA-yB), 2));		
		
		return distance;
	}

}