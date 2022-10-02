
public class Fraction {
	
	int p; //���������
	int q; //�����������
	
	Fraction(int p, int q){
		this.p = p;
		this.q = q;
	}
	
	public boolean equals(Object obj)
	 {
	  if (obj==null)
	   return false;

	  if (obj.getClass() != this.getClass() )
	   return false;

	  Fraction other = (Fraction) obj;
	  return this.p* other.q == this.q * other.p;
	 }	
	
	 // Get max of the two fractions
	static Fraction maxFraction(Fraction first, Fraction sec)
	{
	    // Declare nume1 and nume2 for get the value of
	    // first numerator and second numerator
	    int a = first.p;
	    int b = first.q;
	    int c = sec.p;
	    int d = sec.q;
	  
	    /*
	     *  Compute ad-bc 
	     *  ����� �������� ��� �����, ��� ����� ������� �� ����������� �����������. 
	     *  �� ����� ������� ���, ������� ��������� �� �����������.
	     */
	    int Y = a * d - b * c; 
	    /*
	     * Y = (a / b - c / d)  = (ad - bc) / (bd)
	     * ������, ���� Y> 0, �� a / b > c / d 
	     * ���� Y = 0, �� a / b = c / d
	     * ���� Y < 0, �� a / b < c / d 
	     * ��������� bd ������ ������������, ���� Y ������� ������ �� ��������� (ad-bc). ����, ��� ����� ������ ��������� (ad-bc).
	     */	     
	  
	    return (Y > 0) ? first : sec;
	}
	
	
	static int lcm(int p, int q, int gcdValue)
	/**
	 * ��� - P � Q - ��� ���������� �����, ������� ����� ��������� ��� �� P, ��� � �� Q, �������� ������� 0 � ������ ������.
	 * ��� ���� ����� ����� ��������� � ������� �������, ��������� ��� ��� A � B	 * 
	 * @gcdValue - ���
	 * @abs - ������ �����	 * 
	 * @return lcm() method returns the LCM of p and q
	 */
	{
		return Math.abs(p * q) / gcdValue;
	}
	
	static int gcd(int p, int q) {
		/**
		 * �������� �������� ���������� ���: ��� ���� ����� P � Q �������� ����������, ���� ���� ������� ����� ���������� ������� P � Q.
		 * 
		 * ��������� �������� ��� ��� P � Q ��������� ���, ������� P �� Q � Q �� ������ P � Q, ���� ������ �� ������ 0.
		 * 
		 * @return gcd method returns the GCD of p and q
		 */
		
		if (q == 0 ) //if q=0, a is the GCD
			return p;
		else
			return gcd(q, p % q); 
			/*
			 * call the gcd() method recursively by, replacing p with q and q with modulus(p,q) as long as q != 0
			 */
	}
	
	static int [] addMult(int q1, int q2, int lcmValue) {
		/**
		 * additional multiplier (�������������� ���������)
		 */		
		
		return new int[] {lcmValue/q1, lcmValue/q2};
	}
	
	static int [] multiply(int p, int q, int gcdValue) {
		/**
		 * �������� ��������� � ����������� ����� �� ����� ��������� 
		 */		
		
		return new int [] {p*gcdValue, q*gcdValue};
	}

}
