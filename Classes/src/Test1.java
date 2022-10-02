
public class Test1 {
	public int a;
	public int b;
	
	public void print() {
		System.out.println("à = "+this.a+", b = "+this.b);
	}
	
	public int sum() {	
		return this.a+this.b;		
	}
	
	public int max() {	
		int a = this.a;
		int b = this.b; 
		return a>b ? a : b;
	}
}
