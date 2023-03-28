import java.util.Arrays;
import java.util.Scanner;

public class OneDimensionalArrays extends TaskSelection {
	
	static double [] arrDouble; // array a1, a2... an
	static int [] arrInteger; // array a1, a2... an
	static int n; // dimension of the array
		
	@Override	
	public void taskOne() {
		/*
		 * В массив A[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному K.
		 */
		
		int [] a; // array A[N]
		int n; // natural number 
		int sum = 0; // sum of number
		int k; // multiple of the number...
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input natural number: ");
			    n = in.nextInt();
			} while(n <= 0);		
			
			do {
				System.out.print("Input multiple of the number: ");
				k = in.nextInt();
			} while (k == 0);					
		
		a = new int [n]; // create one-dimensional array        		
        for (int i=0; i<a.length; i++) {        	
        	a[i] = i;
        	if(a[i] % k == 0) { //we check the availability of elements that are multiples of the number K
        		sum += a[i];
        	}
        }
        
        String sumAnswer = (sum <= 0) 
        		? "There are no such numbers that are multiples of " + k 
        		: "The sum of the numbers that are multiples of the number " + sum;

        System.out.println(sumAnswer); 
	}	
	
	@Override	
	public void taskTwo() {
		/*
		 * Дана последовательность действительных чисел а1 ,а2 ,..., an. 
		 * Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.
		 */		
		
		double z;  
		int count = 0; // number of substitutions		
		
		arrayOfRealNumbers(); 
		/** 
		 * Creating an array of real numbers
		 * @param double [] arrDouble - array a1, a2... an
		 * @param int n - dimension of the array
		 */
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input a value: ");
	    z = in.nextDouble();
		
		for(int i=0; i<arrDouble.length; i++) {			
			// function call to compare two double values
	        if (Double.compare(arrDouble[i], z) > 0) {	        	
	        	arrDouble[i] = z;
	        	count +=1;
	        }	        
		}
		
		System.out.println("Converted Array: " + Arrays.toString(arrDouble));
		System.out.println("The number of replaced numbers in the array: " + count);		
		
	}
	
	@Override
	public void taskThree() {
		/*
		 * Дан массив действительных чисел, размерность которого N. 
		 * Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.
		 */		
		
		int positiveCount = 0; // positive number
		int zeroCount  = 0; // zero element
		int negativeCount = 0; // negative element
		int zero = 0; // parity of numbers
		
		arrayOfRealNumbers();
		/** 
		 * Creating an array of real numbers
		 * @param double [] arrDouble - array a1, a2... an
		 * @param int n - dimension of the array
		 */
		
		for(int i=0; i<arrDouble.length; i++) {			
			// function call to compare double value and zero
			if (Double.compare(arrDouble[i], zero) > 0) {	        	
				positiveCount +=1;
	        } else if (Double.compare(arrDouble[i], zero) == 0) {       	 
	        	zeroCount +=1;
	        }
	        else {	 
	        	negativeCount +=1;
	        }
		}
		
		System.out.println("The number of positive: " + positiveCount);
		System.out.println("The number of zero: " + zeroCount);
		System.out.println("The number of negative: " + negativeCount);			
	}
	
	@Override
	public void taskFour() {
		/*
		 * Даны действительные числа а1 ,а2 ,..., аn.
		 * Поменять местами наибольший и наименьший элементы.
		 */
		
		double max = Double.MIN_VALUE; //maximum number
		double min = Double.MAX_VALUE; // minimum number
		int indexMax = 0;
		int indexMin = 0;
		
		arrayOfRealNumbers();
		/** 
		 * Creating an array of real numbers
		 * @param double [] arrDouble - array a1, a2... an
		 * @param int n - dimension of the array
		 */
		
		for (int i=0; i<arrDouble.length; i++) {
			if(arrDouble[i]>max) {
				max = arrDouble[i];
				indexMax = i;
				
			}	
			if(arrDouble[i]<min) {
				min = arrDouble[i];
				indexMin = i;
			}			
		}
		System.out.println("Max element: " + max + " with index: " + indexMax);
		System.out.println("Min element: " + min + " with index: " + indexMin);		
			
		double[] copy = Arrays.copyOf(arrDouble, arrDouble.length); // creating a copy of the array	
		
		System.arraycopy(copy, indexMax, arrDouble, indexMin, 1); // changing the minimum value to the maximum
		System.arraycopy(copy, indexMin, arrDouble, indexMax, 1); // changing the maximum value to the minimum		
		
		System.out.print("Converted Array: "+ Arrays.toString(arrDouble));		
		
	}
	
	@Override
	public void taskFive() {
		/*
		 * Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
		 */
		
		arrayOfIntegerNumbers();
		/** 
		 * Creating an array of real numbers
		 * @param int [] arrInteger - array a1, a2... an
		 * @param int n - dimension of the array
		 */
		
		System.out.print("Array a[i] > i: ");
		
		for (int i = 0; i<arrInteger.length; i++) {
			if (arrInteger[i] > i) {
				System.out.print(arrInteger[i]+", ");
			}
			
		}
	}
	
	@Override
	public void taskSix() {
		/*
		 * Задана последовательность N вещественных чисел. 
		 * Вычислить сумму чисел, порядковые номера которых являются простыми числами.
		 */
		
		arrayOfRealNumbers();
		/** 
		 * Creating an array of real numbers
		 * @param double [] arrDouble - array a1, a2... an
		 * @param int n - dimension of the array
		 */
		
		int count=0;
		double sum=0;
		
		for (int i=1; i<arrDouble.length; i++) {			
			for(int j = 1; j<i; j++) {				
				if(i%j == 0) {
					count ++;
				}
			}
			if(count==1) {
				System.out.print("Simple number: "+i);
				System.out.print(" match the number: "+arrDouble[i]+"\n");	
				sum += arrDouble[i];			
				count--;
			} 
			if(count>=2) {
				count=0;
			}
			
		}	
		
		System.out.print("The sum of the numbers is "+sum);		
	}
	
	@Override
	public void taskSeven() {
		/*
		 * Даны действительные числа a1, a2,... an Найти 
		 * max(a1 + a2n, a2 + a2n−1 ... an + an+1)
		 */
		
		arrayOfRealNumbers();
		/**
		 * * Creating an array of real numbers
		 * @param double [] arrDouble - array a1, a2... an
		 * @param int n - dimension of the array
		 */
		
		double max;
		double sumMax;
		
		max = arrDouble[0]+arrDouble[arrDouble.length-1];
		
		if (arrDouble.length%2==0) {
			for (int i = 0, j = arrDouble.length - 1; i < j; i++, j--) {
				sumMax = (arrDouble[i] + arrDouble[j]);
				if (sumMax>max) {
					max=sumMax;
				}	
		    }						
		}	else {
			
			for (int i=1; i<arrDouble.length; i++) {
				sumMax = arrDouble[i]+arrDouble[arrDouble.length-1-i];
				if (sumMax>max) {
					max=sumMax;
				}			
			}
		}			
		
		System.out.println("max(a1 + a2n, a2 + a2n−1 ... an + an+1) = "+max);				
	}
	
	@Override
	public void taskEight() {
		/*
		 * Дана последовательность целых чисел a1, a2, ... an. 
		 * Образовать новую последовательность, выбросив из исходной те члены, которые равны min (a1, a2, ... an).
		 */
		
		arrayOfIntegerNumbers();
		/** 
		 * Creating an array of real numbers
		 * @param int [] arrInteger - array a1, a2... an
		 * @param int n - dimension of the array
		 */
		int min = Integer.MAX_VALUE; // minimum number
		
		for(int i=0; i<arrInteger.length; i++) {
			if(min>arrInteger[i]) {
				min = arrInteger[i];
			}
		}		
		
		int count = 0;
		
		for(int i=0; i<arrInteger.length; i++) {
			if(arrInteger[i] == min) {
				count ++;
			}
		}
		
		System.out.println("The amount of numbers "+count+" with the minimum value: " + min);
		
		
		int newArray [] = new int [arrInteger.length-count];
		
		int j = 0;
		for(int i=0; i<arrInteger.length; i++) {
			if(arrInteger[i] != min) {				
				newArray[j] = arrInteger[i];
				j++;
				//System.out.print(arrInteger[i] + ", ");
			}
		}
		
		System.out.print(Arrays.toString(newArray));
	}
	
	@Override
	public void taskNine() {
		/*
		 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. 
		 * Если таких чисел несколько, то определить наименьшее из них.
		 */
		
		arrayOfIntegerNumbers();
		/** 
		 * Creating an array of real numbers
		 * @param int [] arrInteger - array a1, a2... an
		 * @param int n - dimension of the array
		 */
				
		int count=0;
		int countIncrease=0;		
		int number=0;		
		
		for (int i=0; i<arrInteger.length; i++) {
			for(int j=i; j<arrInteger.length; j++) {
				if(arrInteger[i]==arrInteger[j]) {
					count++;										
				}
			}
			if (count>=countIncrease) {
				if (count==countIncrease) {
					if(arrInteger[i]<number) { // determine the smallest number
						number = arrInteger[i];
					}
				} else {
					number = arrInteger[i];
				}	
				
				countIncrease=count;				
			}
			count = 0;
		}
		System.out.println("Number of times "+countIncrease+", the minimum number "+ number+" of other numbers.");		
	}
	
	@Override
	public void taskTen() {
		/*
		 * Дан целочисленный массив с количеством элементов п. 
		 * Сжать массив, выбросив из него каждый второй элемент (освободившиеся элементы заполнить нулями). 
		 * Примечание. Дополнительный массив не использовать.
		 */
		
		arrayOfIntegerNumbers();
		/** 
		 * Creating an array of real numbers
		 * @param int [] arrInteger - array a1, a2... an
		 * @param int n - dimension of the array
		 */	
		
		int count = 1;		
				
		 for (int i = 0; i < arrInteger.length; i+=2){			 
			 if (count == arrInteger.length) {				 
				 continue;
			 }
			 arrInteger[count] = arrInteger[i];
			 arrInteger[count++] = 0;
			 
			 if (count == arrInteger.length) {				 
				 continue;
			 }
			 count++;
		}
		 
		 arrInteger = Arrays.copyOf(arrInteger, count);

		 System.out.print("Compress the array, throw every second element away: "+ Arrays.toString(arrInteger));
	}
	
	public void arrayOfRealNumbers() {
		/**
		 * Creating an array of real numbers
		 * @param double [] arrDouble - array a1, a2... an
		 * @param int n - dimension of the array
		 */				
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the dimension of the array: ");
			    n = in.nextInt();
			} while(n <= 0);
			
		
			arrDouble = new double [n];
				
		for(int i=0; i<arrDouble.length; i++)
		{
			arrDouble[i] = (Math.random()*100)-30; // random numbers			
		}
		
		System.out.println("Source Array: " + Arrays.toString(arrDouble));		
		
	}
	
	public void arrayOfIntegerNumbers() {
		/**
		 * Creating an array of real numbers
		 * @param int [] arrInteger - array a1, a2... an
		 * @param int n - dimension of the array
		 */				
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the dimension of the array: ");
			    n = in.nextInt();
			} while(n <= 0);
			
		
			arrInteger = new int [n];
				
		for(int i=0; i<arrInteger.length; i++)
		{
			arrInteger[i] = (int)(Math.random()*100)-30; // random numbers			
		}
		
		System.out.println("Source Array: " + Arrays.toString(arrInteger));		
		
	}
}
