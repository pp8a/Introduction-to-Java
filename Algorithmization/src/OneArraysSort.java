import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class OneArraysSort extends TaskSelection {
		
	@Override	
	public void taskOne() {
		/*
		 * Заданы два одномерных массива с различным количеством элементов и натуральное число k. 
		 * Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами первого, 
		 * при этом не используя дополнительный массив.
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
		
		if(dimX==dimY) {// Заданы два одномерных массива с различным количеством элементов
			dimY++;
		}
		if(number>dimX) {//k-м и (k+1) - м элементами первого
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
		
		//Первый вариант решения
		//number = number-1;
		//System.arraycopy(arrayX, number, arrayX, shift_y+number, shift_x-shift_y-number);
		//System.arraycopy(arrayY, 0, arrayX, number, shift_y);
		
		//Второй вариант решения
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
		 * Даны две последовательности a1 <= a2 <=...<= an и b1 <= b2 <=...<= bm
		 * Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей. 
		 * Примечание. Дополнительный массив не использовать.
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
		 * Сортировка выбором. Дана последовательность чисел a1 <= a2 <=...<= an.
		 * Требуется переставить элементы так, чтобы они были расположены по убыванию. 
		 * Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится на первое место, 
		 * а первый - на место наибольшего. Затем, начиная со второго, эта процедура повторяется. Написать алгоритм сортировки выбором.
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
		 * Сортировка обменами. Дана последовательность чисел a1 <= a2 <=...<= an.
		 * Требуется переставить числа в порядке возрастания. Для этого сравниваются два соседних числа ai и ai+1.
		 * Если ai > ai+1, то делается перестановка. 
		 * Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
		 * Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
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
		 * Сортировка вставками. Дана последовательность чисел a1, a2, ... an
		 * Требуется переставить числа в порядке возрастания. Делается это следующим образом. 
		 * Пусть a1, a2, ... ai  - упорядоченная последовательность, т. е. a1 <= a2 <=...<= an.
		 * Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая последовательность была тоже возрастающей. 
		 * Процесс производится до тех пор, пока все элементы от i +1 до n не будут перебраны. 
		 * Примечание. Место помещения очередного элемента в отсортированную часть производить с помощью двоичного поиска. 
		 * Двоичный поиск оформить в виде отдельной функции.
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
		
		// сортируем элементы массива, так как для бинарного поиска элементы массива должны быть отсортированными        
        Arrays.sort(array);
        System.out.println("Sorted array: \n"+Arrays.toString(array));
		
        int first = 0;//first index
        int last = dim-1;//last index
        
        int item;//number to search for
        int pos=0; //Location of the next element
        int [] newArray = new int [dim*2];
        int count=0;//
        for(int i=0; i<array.length-1;) {
        	item = array[i];//берем число
        	pos = binarySearch(array, first, last, item);//находим позицию числа item+1, т.к. следующее число вставляется на позицию дальше
        	if(array[i]==array[i+1]) {//если это не крайнее число, и число ai == ai+1
        		while(i<pos) {//если одинаковых чисел несколько получаем индекс pos максимальный из всех
        			newArray[i+count]=item;
        			i++;
            		newArray[i+count]=item+1;
            		count++;
        		}        		
        	}else {
        		newArray[i+count]=item;//вставляем числа из существующего массива array
            	newArray[pos+count]=item+1;//вставляем следующее число ai+1 в ее position + count массив увеличился вдвое из-за расширения
            	count++;//увеличиваем для добавленного числа ai+1
            	i++;
        	}
        }
		
        System.out.println("Converted array:");
        System.out.println(Arrays.toString(newArray));        
	}
	
	public static int binarySearch(int[] array, int first, int last, int item) {
		/*
		 * Поиск элементов в отсортированном массиве чисел. 
		 * Поиск происходит путем деления элементов массива на половины.
		 * ищем индекс (position) существующего числа, прибавляем +1 так как следующее число ai+1
		 * возвращаем позицию числа ai+1
		 */
		int position;
		position = (first + last) / 2;
		
		//while ((array[position] != item) && (first <= last)) { 
		while (first <= last) {            
            if (array[position] > item) {  // если число заданного для поиска
                last = position - 1; // уменьшаем позицию на 1.
            } else {
                first = position + 1;    // иначе увеличиваем на 1
            }
            position = (first + last) / 2;
        }		
			
		return position+1;
	}	
	
	@Override	
	public void taskSix() {
		/*
		 * Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
		 * Делается это следующим образом: сравниваются два соседних элемента ai и ai+1. 
		 * Если ai <= ai+1, то продвигаются на один элемент вперед. 
		 * Если ai > ai+1, то производится перестановка и сдвигаются на один элемент назад. 
		 * Составить алгоритм этой сортировки.
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
		 * Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <=...<= an и b1 <= b2 <=...<= bm.
		 * Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <=...<= bm 
		 * в первую последовательность так, чтобы новая последовательность оставалась возрастающей.
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
		
		//по условию задачи: даны две неубывающие последовательности действительных чисел
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
		for (int i=0, j=0; i<length; i++) {//работаем по размеру самого длинного массива
			
			if(j!=index.length) {//чтобы не трогать мелкий массив когда из него по индексам уже все выбрали
				if(index[j]==i && j<index.length) {//вставляем по индексу
					array[p++] = arrayY[j];//вставка элемента по отобранным индексам (нужное место)
					j++;
					i--;//проходим по длинному массиву
				}
				else {
					array[p++] = arrayX[i];//заполняем данные с длинного массива
				}
			}else {
				if(p!=array.length) {//а это пиздец иначе переполнение
					array[p++] = arrayX[i];//далее заполняем все что осталось....
				}				
			}
		}
		
		System.out.println("The resulting array: ");
		System.out.println(Arrays.toString(array));
	}
	
	@Override	
	public void taskEight() {
		/*
		 * Даны дроби p1/q1, p2/q2,...pn/qn (pi, qi - натуральные числа). 
		 * Составить программу, которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.
		 */
			
		
		System.out.println("Input the number of fractions:");
		int number = input();	
		if(number%2!=0) {//сравниваем минимум две дроби
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
			
		int gcdValue; //НОД
		int [] gcdArray = new int[number];
		//System.out.println("\nGCD: ");		
		for(int i=0; i<number; i+=2) {
			gcdValue = Fraction.gcd(arrayQ[i], arrayQ[i+1]);
			gcdArray[i]=gcdValue;
			//System.out.println(arrayQ[i]+" and "+arrayQ[i+1]+" == "+gcdValue);			
		}
		
		int lcmValue; //НОК
		int [] lcmArray = new int[number];
		//System.out.println("\nLCM: ");		
		for(int i=0; i<number; i+=2) {
			lcmValue = Fraction.lcm(arrayQ[i], arrayQ[i+1], gcdArray[i]);
			lcmArray[i]=lcmValue;
			//System.out.println(arrayQ[i]+" and "+arrayQ[i+1]+" == "+lcmValue);			
		}
		
		int []addMultArray = new int[number]; //дополнительный множитель				
		for(int i=0; i<number; i+=2) {
			int [] addMultValue = Fraction.addMult(arrayQ[i], arrayQ[i+1], lcmArray[i]);			
			addMultArray[i] = addMultValue[0];
			addMultArray[i+1] = addMultValue[1];
		}
		//System.out.println("Множители: "+Arrays.toString(addMultArray));
		
		
		
		int [] arrayPnew = new int[number];
		int [] arrayQnew = new int[number];	//наименьший общий знаменатель			
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
		
		
		/*System.out.println("\nСompare: ");		
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
			
			Fraction res = Fraction.maxFraction(first, sec);//получаем наибольшую дробь 
						
			if(res.equals(first)) { // если первая дробь является наибольшей и стоит перед меньшей в массиве то меняем их местами			
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
}
