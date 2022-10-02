import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class OneArraysSort extends TaskSelection {
	
	
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
		 * ������ ��� ���������� ������� � ��������� ����������� ��������� � ����������� ����� k. 
		 * ���������� �� � ���� ������, ������� ������ ������ ����� k-� � (k+1) - � ���������� �������, 
		 * ��� ���� �� ��������� �������������� ������.
		 */		
		int dimX;
		int dimY;
		int number;
		
		System.out.println("Input the dimension of the arrays!");					
		System.out.println("Array 1:");
		dimX = input();		
		
		System.out.println("Array 2:");
		dimY = input();
		
		System.out.println("Input the number of the element of the first array where the second array will be inserted: ");
		number = input();
		
		if(dimX==dimY) {// ������ ��� ���������� ������� � ��������� ����������� ���������
			dimY++;
		}
		if(number>dimX) {//k-� � (k+1) - � ���������� �������
			number = dimX;
		}
		
		int [] arrayX = new int[dimX+dimY];
		int [] arrayY = new int[dimY];
		
		Random random = new Random();		
		for(int i=0; i<dimX; i++)
		{
			arrayX[i] = random.nextInt(100); // random numbers			
		}
		for(int i=0; i<dimY; i++)
		{
			arrayY[i] = random.nextInt(100); // random numbers			
		}
		
		System.out.println("Source arrays:");
		System.out.print("X: ");
		for(int i = 0; i<dimX; i++) {			
			System.out.print(arrayX[i]+" ");			
		}
		
		System.out.print("\nY: ");		
		for(int i = 0; i<dimY; i++) {			
			System.out.print(arrayY[i]+" ");			
		}	
		System.out.println();
		
		int shift_x = arrayX.length;
		int shift_y = arrayY.length;
		
		//������ ������� �������
		//number = number-1;
		//System.arraycopy(arrayX, number, arrayX, shift_y+number, shift_x-shift_y-number);
		//System.arraycopy(arrayY, 0, arrayX, number, shift_y);
		
		//������ ������� �������
		int count = 1;
		int j = 0;
		for(int i=0; i<shift_x-1; i++) {			
			if((count)==number) 
			{	
				for(int y=0; y<shift_x-shift_y-(number-1); y++) {
					arrayX[shift_x-1-y]=arrayX[(shift_x-shift_y-1)-y];
				}				
			}			
			count++;
			
			if(count>number&&j<shift_y) {
				arrayX[i]=arrayY[j++];
			}			
		}
		
		System.out.println("Converted array:");
		System.out.println(Arrays.toString(arrayX));
	}
	
	@Override	
	public void taskTwo() {
		/*
		 * ���� ��� ������������������ a1 <= a2 <=...<= an � b1 <= b2 <=...<= bm
		 * ���������� �� ��� ����� ������������������ ����� ���, ����� ��� ���� ���� �����������. 
		 * ����������. �������������� ������ �� ������������.
		 */
		int dimX;
		int dimY;		
		
		System.out.println("Input the dimension of the arrays!");					
		System.out.println("Array 1:");
		dimX = input();		
		
		System.out.println("Array 2:");
		dimY = input();
		
		int [] arrayX = new int[dimX+dimY];
		int [] arrayY = new int[dimY+dimX];
		
		for (int i = 0, j = 0; i < arrayX.length; ++i, ++j) 
        {
			if(i<dimX) {
				arrayX[i] = i+1;
			}
			
			if(j<dimY) {
				arrayY[j] = j+i+1;
			}			
        }
		
		System.out.println("Source arrays:");
		System.out.println(Arrays.toString(arrayX));
		System.out.println(Arrays.toString(arrayY));
		
		System.arraycopy(arrayY, 0, arrayX, dimX, dimY);
						
		arrayY = Arrays.copyOf(arrayX, arrayX.length); 		
		
		for (int i = 0; i<arrayX.length-1; i++) {
			int line=i;			
			do {
				if(arrayX[i]>arrayX[line+1]) {
					arrayX[line+1]=arrayY[i];
					arrayX[i]=arrayY[line+1];
					System.arraycopy(arrayX, 0, arrayY, 0, arrayY.length);
				}				
				line++;
			}while(line<arrayX.length-1);			
		}
		System.out.println("Converted array:");
		System.out.println(Arrays.toString(arrayX));		
	}
	
	@Override	
	public void taskThree() {
		/*
		 * ���������� �������. ���� ������������������ ����� a1 <= a2 <=...<= an.
		 * ��������� ����������� �������� ���, ����� ��� ���� ����������� �� ��������. 
		 * ��� ����� � �������, ������� � �������, ���������� ���������� ������� � �������� �� ������ �����, 
		 * � ������ - �� ����� �����������. �����, ������� �� �������, ��� ��������� �����������. �������� �������� ���������� �������.
		 */
		int dim;
		System.out.println("Input the dimension of the arrays!");
		dim = input();		
		
		int [] array = new int[dim];
		for(int i=0; i<array.length; i++)
		{
			array[i] = (int)(Math.random()*130)-30; // random numbers			
		}
		
		System.out.println("Source array:");
		System.out.println(Arrays.toString(array));	
		
		int index = 0;
		int count = 0;
		do {	
			int max = Integer.MIN_VALUE; //maximum number
			for (int i = count; i<array.length; i++) {
				if(array[i]>max) {
					max = array[i];
					index = i;				
				}
			}
			
			int value;			
			value = array[count];
			array[count]=array[index];
			array[index]=value;
			
			count++;
		}while(count<array.length);
		
		System.out.println("Converted array:");
		System.out.println(Arrays.toString(array));		
	}
	
	@Override	
	public void taskFour() {
		/*
		 * ���������� ��������. ���� ������������������ ����� a1 <= a2 <=...<= an.
		 * ��������� ����������� ����� � ������� �����������. ��� ����� ������������ ��� �������� ����� ai � ai+1.
		 * ���� ai > ai+1, �� �������� ������������. 
		 * ��� ������������ �� ��� ���, ���� ��� �������� �� ������ ����������� � ������� �����������.
		 * ��������� �������� ����������, ����������� ��� ���� ���������� ������������.
		 */
		
		int dim;			
		
		System.out.println("Input the dimension of the arrays!");
		dim = input();		
		
		int [] array = new int[dim];
		for(int i=0; i<array.length; i++)
		{
			array[i] = (int)(Math.random()*130)-30; // random numbers			
		}
		
		System.out.println("Source array:");
		System.out.println(Arrays.toString(array));
		
				
		//int [] copy = Arrays.copyOf(array, array.length);
		int nPermutations=0;
		for (int i = 0; i<array.length-1; i++) {
			int line=i;
			do {
				if(array[i]>array[line+1]) {	
					int value;			
					value = array[line+1];
					array[line+1]=array[i];
					array[i]=value;
					//OR
					/*array[line+1]=copy[i];
					array[i]=copy[line+1];
					System.arraycopy(array, 0, copy, 0, copy.length);*/
					nPermutations++;
				}				
				line++;
			}while(line<array.length-1);				
				
		}
		System.out.println("Converted array:");
		System.out.println(Arrays.toString(array)+"\nThe number of permutations "+nPermutations);		
	}
	
	@Override	
	public void taskFive() {
		/*
		 * ���������� ���������. ���� ������������������ ����� a1, a2, ... an
		 * ��������� ����������� ����� � ������� �����������. �������� ��� ��������� �������. 
		 * ����� a1, a2, ... ai  - ������������� ������������������, �. �. a1 <= a2 <=...<= an.
		 * ������� ��������� ����� ai+1 � ����������� � ������������������ ���, ����� ����� ������������������ ���� ���� ������������. 
		 * ������� ������������ �� ��� ���, ���� ��� �������� �� i +1 �� n �� ����� ���������. 
		 * ����������. ����� ��������� ���������� �������� � ��������������� ����� ����������� � ������� ��������� ������. 
		 * �������� ����� �������� � ���� ��������� �������.
		 */
		
		int dim;
		System.out.println("Input the dimension of the arrays!");
		dim = input();		
		
		int [] array = new int[dim];
		for(int i=0; i<array.length; i++)
		{
			array[i] = (int)(Math.random()*130)-30; // random numbers			
		}
		
		System.out.println("Source array:");
		System.out.println(Arrays.toString(array));
		
		// ��������� �������� �������, ��� ��� ��� ��������� ������ �������� ������� ������ ���� ����������������        
        Arrays.sort(array);
        System.out.println("Sorted array: \n"+Arrays.toString(array));
		
        int first = 0;//first index
        int last = dim-1;//last index
        
        int item;//number to search for
        int pos=0; //Location of the next element
        int [] newArray = new int [dim*2];
        int count=0;//
        for(int i=0; i<array.length-1;) {
        	item = array[i];//����� �����
        	pos = binarySearch(array, first, last, item);//������� ������� ����� item+1, �.�. ��������� ����� ����������� �� ������� ������
        	if(array[i]==array[i+1]) {//���� ��� �� ������� �����, � ����� ai == ai+1
        		while(i<pos) {//���� ���������� ����� ��������� �������� ������ pos ������������ �� ����
        			newArray[i+count]=item;
        			i++;
            		newArray[i+count]=item+1;
            		count++;
        		}        		
        	}else {
        		newArray[i+count]=item;//��������� ����� �� ������������� ������� array
            	newArray[pos+count]=item+1;//��������� ��������� ����� ai+1 � �� position + count ������ ���������� ����� ��-�� ����������
            	count++;//����������� ��� ������������ ����� ai+1
            	i++;
        	}
        }
		
        System.out.println("Converted array:");
        System.out.println(Arrays.toString(newArray));        
	}
	
	public static int binarySearch(int[] array, int first, int last, int item) {
		/*
		 * ����� ��������� � ��������������� ������� �����. 
		 * ����� ���������� ����� ������� ��������� ������� �� ��������.
		 * ���� ������ (position) ������������� �����, ���������� +1 ��� ��� ��������� ����� ai+1
		 * ���������� ������� ����� ai+1
		 */
		int position;
		position = (first + last) / 2;
		
		//while ((array[position] != item) && (first <= last)) { 
		while (first <= last) {            
            if (array[position] > item) {  // ���� ����� ��������� ��� ������
                last = position - 1; // ��������� ������� �� 1.
            } else {
                first = position + 1;    // ����� ����������� �� 1
            }
            position = (first + last) / 2;
        }		
			
		return position+1;
	}	
	
	@Override	
	public void taskSix() {
		/*
		 * ���������� �����. ��� ������ n �������������� �����. ��������� ����������� ��� �� �����������.
		 * �������� ��� ��������� �������: ������������ ��� �������� �������� ai � ai+1. 
		 * ���� ai <= ai+1, �� ������������ �� ���� ������� ������. 
		 * ���� ai > ai+1, �� ������������ ������������ � ���������� �� ���� ������� �����. 
		 * ��������� �������� ���� ����������.
		 */
		
		int dim;
		System.out.println("Input the dimension of the arrays!");
		dim = input();		
		
		int [] array = new int[dim];
		for(int i=0; i<array.length; i++)
		{
			array[i] = (int)(Math.random()*130)-30; // random numbers			
		}
		
		System.out.println("Source array:");
		System.out.println(Arrays.toString(array));
				
		for(int i=0; i<array.length-1; i++) {
			if(array[i]>array[i+1]) {
				var value = array[i];
				array[i] = array[i+1];
				array[i+1]=value;
				i=-1;
			}
		}
		
		 System.out.println("Converted array:");
	     System.out.println(Arrays.toString(array));		
	}
	
	@Override	
	public void taskSeven() {
		/*
		 * ����� ���� ��� ����������� ������������������ �������������� ����� a1 <= a2 <=...<= an � b1 <= b2 <=...<= bm.
		 * ��������� ������� �� �����, �� ������� ����� ��������� �������� ������������������ b1 <= b2 <=...<= bm 
		 * � ������ ������������������ ���, ����� ����� ������������������ ���������� ������������.
		 */
		
		int dimX;
		int dimY;		
		
		System.out.println("Input the dimension of the arrays!");					
		System.out.println("Array 1:");
		dimX = input();		
		
		System.out.println("Array 2:");
		dimY = input();
		
		int [] arrayX = new int[dimX];
		int [] arrayY = new int[dimY];
		
		int length = Math.max(arrayX.length, arrayY.length);
		for(int i=0; i<length; i++)
		{
			if (i < arrayX.length) arrayX[i] = (int)(Math.random()*130)-30; // random numbers			
			if (i < arrayY.length) arrayY[i] = (int)(Math.random()*130)-30; // random numbers			
		}
		
		System.out.println("Source arrays:");
		System.out.println(Arrays.toString(arrayX));
		System.out.println(Arrays.toString(arrayY));
		
		//�� ������� ������: ���� ��� ����������� ������������������ �������������� �����
		for(int i=0; i<arrayX.length-1; i++) {
			if(arrayX[i]>arrayX[i+1]) {
				var value = arrayX[i];
				arrayX[i] = arrayX[i+1];
				arrayX[i+1]=value;
				i=-1;
			}
		}
		for(int i=0; i<arrayY.length-1; i++) {
			if(arrayY[i]>arrayY[i+1]) {
				var value = arrayY[i];
				arrayY[i] = arrayY[i+1];
				arrayY[i+1]=value;
				i=-1;
			}
		}
		
		System.out.println("Sorted arrays:");
		System.out.println(Arrays.toString(arrayX));
		System.out.println(Arrays.toString(arrayY));
				
		int [] index = new int [arrayY.length];//places (index) where you need to insert array elements b1 <= b2 <=...<= bm
		for (int i = 0; i<arrayY.length; i++) {
			for (int j = 0; j<arrayX.length; j++) {
				if(arrayY[i]<arrayX[j]) {
					index[i] += j;
					break;
				}else if (j==arrayX.length-1){
					index[i] += j+1;
				}				
			}
		}
		
		System.out.println("Index: "+Arrays.toString(index));
		
		int [] array = new int[arrayX.length+arrayY.length];
		
		int p = 0;
		for (int i=0, j=0; i<length; i++) {//�������� �� ������� ������ �������� �������
			
			if(j!=index.length) {//����� �� ������� ������ ������ ����� �� ���� �� �������� ��� ��� �������
				if(index[j]==i && j<index.length) {//��������� �� �������
					array[p++] = arrayY[j];//������� �������� �� ���������� �������� (������ �����)
					j++;
					i--;//�������� �� �������� �������
				}
				else {
					array[p++] = arrayX[i];//��������� ������ � �������� �������
				}
			}else {
				if(p!=array.length) {//� ��� ������ ����� ������������
					array[p++] = arrayX[i];//����� ��������� ��� ��� ��������....
				}				
			}
		}
		
		System.out.println("The resulting array: ");
		System.out.println(Arrays.toString(array));
	}
	
	@Override	
	public void taskEight() {
		/*
		 * ���� ����� p1/q1, p2/q2,...pn/qn (pi, qi - ����������� �����). 
		 * ��������� ���������, ������� �������� ��� ����� � ������ ����������� � ������������� �� � ������� �����������.
		 */
			
		
		System.out.println("Input the number of fractions:");
		int number = input();	
		if(number%2!=0) {//���������� ������� ��� �����
			number++;
		}
		
		int [] arrayP = new int[number];
		int [] arrayQ = new int[number];
		
		int max=20;//Integer.MAX_VALUE;
		int min=1;
		int p = 0;
		int q = 0;
		
		System.out.println("Fraction: ");
		for(int i=0; i<number; i++)
		{
			p = (int)(Math.random() * ((max - min)+1) + min);
			q = (int)(Math.random() * ((max - min)+1) + min);
			arrayP[i]=p;
			arrayQ[i]=q;
		}	
			
		int gcdValue; //���
		int [] gcdArray = new int[number];
		//System.out.println("\nGCD: ");		
		for(int i=0; i<number; i+=2) {
			gcdValue = Fraction.gcd(arrayQ[i], arrayQ[i+1]);
			gcdArray[i]=gcdValue;
			//System.out.println(arrayQ[i]+" and "+arrayQ[i+1]+" == "+gcdValue);			
		}
		
		int lcmValue; //���
		int [] lcmArray = new int[number];
		//System.out.println("\nLCM: ");		
		for(int i=0; i<number; i+=2) {
			lcmValue = Fraction.lcm(arrayQ[i], arrayQ[i+1], gcdArray[i]);
			lcmArray[i]=lcmValue;
			//System.out.println(arrayQ[i]+" and "+arrayQ[i+1]+" == "+lcmValue);			
		}
		
		int []addMultArray = new int[number]; //�������������� ���������				
		for(int i=0; i<number; i+=2) {
			int [] addMultValue = Fraction.addMult(arrayQ[i], arrayQ[i+1], lcmArray[i]);			
			addMultArray[i] = addMultValue[0];
			addMultArray[i+1] = addMultValue[1];
		}
		//System.out.println("���������: "+Arrays.toString(addMultArray));
		
		
		
		int [] arrayPnew = new int[number];
		int [] arrayQnew = new int[number];	//���������� ����� �����������			
		for(int i=0; i<number; i++) {
			int [] addMultiplyValue = Fraction.multiply(arrayP[i], arrayQ[i], addMultArray[i]);			
			arrayPnew[i] = addMultiplyValue[0];
			arrayQnew[i] = addMultiplyValue[1];			
		}
		
		for(int i=0; i<number; i+=2)
		{					
			System.out.print(arrayP[i]+"/"+arrayQ[i]+" and "+arrayP[i+1]+"/"+arrayQ[i+1]+";"); 
			System.out.print("\t answer cdf: "); //the common denominator of fractions
			System.out.print(arrayPnew[i]+"/"+arrayQnew[i]+" and "+arrayPnew[i+1]+"/"+arrayQnew[i+1]+";\n");
		}
		
		
		/*System.out.println("\n�ompare: ");		
		for(int i=0; i<number; i+=2) {
			Fraction one = new Fraction(arrayP[i], arrayQ[i]);
			Fraction two = new Fraction(arrayP[i+1], arrayQ[i+1]);
			if(one.equals(two)) {
				System.out.println(arrayP[i]+"/"+arrayQ[i]+" equal "+arrayP[i+1]+"/"+arrayQ[i+1]);
			}else {
				System.out.println(arrayP[i]+"/"+arrayQ[i]+" unequal "+arrayP[i+1]+"/"+arrayQ[i+1]);
			}			
		}*/
		
		for(int i=0; i<number-1; i++) {	
			Fraction first = new Fraction(arrayPnew[i], arrayQnew[i]);
			Fraction sec = new Fraction(arrayPnew[i+1], arrayQnew[i+1]);
			
			Fraction res = Fraction.maxFraction(first, sec);//�������� ���������� ����� 
						
			if(res.equals(first)) { // ���� ������ ����� �������� ���������� � ����� ����� ������� � ������� �� ������ �� �������			
				var valuePnew = arrayPnew[i];
				var valueQnew = arrayQnew[i];
				arrayPnew[i] = arrayPnew[i+1];
				arrayQnew[i] = arrayQnew[i+1];
				arrayPnew[i+1]=valuePnew;
				arrayQnew[i+1]=valueQnew;
				i=-1;
			}
		}
		
		System.out.println("In ascending order:");
		for(int i=0; i<number; i++) {
			System.out.print(" -> "+arrayPnew[i]+"/"+arrayQnew[i]);
		}
		
	}
	
	
}