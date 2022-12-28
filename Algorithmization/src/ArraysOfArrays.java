import java.util.Arrays;
import java.util.Scanner;

public class ArraysOfArrays extends TaskSelection {
	
	static int height; // matrix height
	static int width; // matrix width
	static int [][] matrix;
	

	public void createMatrix() {
		/**
		 * Creating a matrix of numbers
		 * @param height
		 * @param width
		 */
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the height of the matrix: ");
				height = in.nextInt();
			} while(height <= 0);
			
			do {
				System.out.print("Input the width of the matrix: ");
				width = in.nextInt();
			} while(width <= 0);			
			
		matrix = new int[height][width]; // create matrix
	}
	
	@Override
	public void taskOne() {
		/*
		 * Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
		 */
		
		createMatrix();
		/**
		 * Creating a matrix of numbers
		 * @param height
		 * @param width
		 */	
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				matrix[i][j]= (int)(Math.random()*130)-30; // random numbers
			}
		}
		
		System.out.println("Original matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}	
		
		int count = 0;
		
		System.out.println("Converted matrix:");		
		for(int i=0; i<height; i++) {			
			for(int j=0; j<width; j+=2) {				
				if(matrix[0][j]>matrix[height-1][j]) {
					if(count==0) {
						System.out.print("[");
						count++;
					}
					System.out.print(matrix[i][j]+" \t");					
				} 				
			}	
			if(count>0) {
				System.out.print("]\n");
				count = 0;
			}
			
		}

	}

	@Override
	public void taskTwo() {
		/*
		 *  Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
		 */
		System.out.println("Create a square matrix!");
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the dimension of the matrix: ");
				height = in.nextInt();
			} while(height <= 0);
			
			width = height;		
			
		matrix = new int[height][width]; // create matrix
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				matrix[i][j]= (int)(Math.random()*130)-30; // random numbers
			}
		}
		
		System.out.println("Original matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}	
		
		System.out.println("Elements located on the diagonal of the matrix: ");
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {				
				System.out.print(matrix[i][i]+" \t");
				i++;
				/*if(i==j) {
					System.out.print(matrix[i][j]+" \t");	
				}*/				
			}
		}
	}

	@Override
	public void taskThree() {
		/*
		 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
		 * @param row - k
		 * @param column - p
		 */
		createMatrix();
		/**
		 * Creating a matrix of numbers
		 * @param height
		 * @param width
		 */	
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				matrix[i][j]= (int)(Math.random()*130)-30; // random numbers
			}
		}
		
		System.out.println("Original matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}	
		
		int row;
		int column;
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the row number of the matrix: ");
				row = in.nextInt();				
			} while(row <= 0 || row > height);
						
			do {
				System.out.print("Input the column number of the matrix: ");
				column = in.nextInt();
			} while(column <= 0 || column > width);		
				
		System.out.println("Row "+row+":");
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(i==row-1) {
					System.out.print(matrix[i][j]+" \t");	
				}				
			}
		}
		
		System.out.println("\nColumn "+column+":");		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {				
				if(j==column-1) {
					System.out.print(matrix[i][j]+" \t");	
				}	
			}
		}
	}

	@Override
	public void taskFour() {
		/*
		 *  Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
		 *  1	2	3	...	n
		 *  n-1	n-2	n-3	...	1  
		 */

		System.out.println("Create a square matrix!");
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the dimension of the matrix (only an even number): ");
				height = in.nextInt();
			} while(height <= 0 || height%2 != 0);
			
			width = height;		
			
		matrix = new int[height][width]; // create matrix
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {				
				if(i%2==0) {
					matrix[i][j] = j+1; // from 1 to even number	
				} else {
					matrix[i][j] = width-j; // from even number to 1
				}
			}
		}
		
		System.out.println("Matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	@Override
	public void taskFive() {
		/*
		 *  Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
		 *  1	1	1	...	1
		 *  2	2	2	...	0
		 *  3	3	0	...	0
		 *  n-1	n-1	0	...	0
		 *  n	0	0	...	0  
		 */

		System.out.println("Create a square matrix!");
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the dimension of the matrix (only an even number): ");
				height = in.nextInt();
			} while(height <= 0 || height%2 != 0);
			
			width = height;		
			
		matrix = new int[height][width]; // create matrix
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {				
				if(j>=width-i) {
					matrix[i][j] = 0; 	
				} else {
					matrix[i][j] = i+1; // 111 or 222 or 333
				}
			}
		}
		
		System.out.println("Matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

	}

	@Override
	public void taskSix() {
		/*
		 *  Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
		 *  1	1	1	...	1
		 *  0	1	1	...	0
		 *  0	0	1	...	0
		 *  0	1	1	...	0
		 *  1	1	1	...	1  
		 */

		System.out.println("Create a square matrix!");
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the dimension of the matrix (only an even number): ");
				height = in.nextInt();
			} while(height <= 0 || height%2 != 0);
			
			width = height;		
			
		matrix = new int[height][width]; // create matrix
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {	
				if(i<width/2) {
					if(j<i || width-i<=j) {
						matrix[i][j] = 0; 	
					} else {
						matrix[i][j] = 1; 
					}
				} else if(j>i || j<(width-i)-1) { 
					matrix[i][j] = 0; 
				} else {
					matrix[i][j] = 1;
				}
			}
		}
		
		System.out.println("Matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

	}

	@Override
	public void taskSeven() {
		/*
		 * Сформировать квадратную матрицу порядка N по правилу:
		 * A[I,J]=sin((I^2-J^2)/N)
		 * и подсчитать количество положительных элементов в ней
		 */		
		
		double [][] matrix;
		
		System.out.println("Create a square matrix!");
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the dimension of the matrix (only an even number): ");
				height = in.nextInt();
			} while(height <= 0);
			
			width = height;		
			
		matrix = new double[height][width]; // create matrix
		
		double value;
		double scale; //10^n, n is equal to the number of required decimal places
		double count = 0;
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {	
				value = (double) Math.sin((Math.pow(i, 2)-Math.pow(j, 2))/height);
				scale = Math.pow(10, 3);
				matrix[i][j] = Math.ceil(value * scale) / scale;
				if(value>0) count++;
				
			}
		}
		
		System.out.println("Matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}	
		System.out.println("The count of positive numbers in the matrix: "+count);
	}

	@Override
	public void taskEight() {
		/*
		 * В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
		 * на соответствующие им позиции другого, а его элементы второго переместить в первый. 
		 * Номера столбцов вводит пользователь с клавиатуры.
		 */
		
		createMatrix();
		/**
		 * Creating a matrix of numbers
		 * @param height
		 * @param width
		 */	
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				matrix[i][j]= (int)(Math.random()*130)-30; // random numbers
			}
		}
		
		System.out.println("Original matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}	
		
		int columnX;
		int columnY;
				
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the column number to replace: ");
				columnX = in.nextInt();
			} while(columnX <= 0 || columnX > width);
			
			do {
				System.out.print("Replace with: ");
				columnY = in.nextInt();
			} while(columnY <= 0 || columnY > width);
		
		//int[][] copy = Arrays.copyOf(matrix, matrix.length);	ссылка на объект не копия
		//int[][] copy = new int[matrix.length][matrix[0].length];
		int[][] copy = new int[height][width];		
		for ( int i = 0 ; i < matrix.length; i++)
	    {	        
	        System.arraycopy(matrix[i], 0, copy[i], 0, matrix[i].length);
	    }
		
		columnX--;
		columnY--;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				//matrix[i][columnX] = copy[i][columnY];
				//matrix[i][columnY] = copy[i][columnX];
				System.arraycopy(copy[i], columnX, matrix[i], columnY, 1); 
				System.arraycopy(copy[i], columnY, matrix[i], columnX, 1);				
			}
		}		
		
		System.out.println("The matrix converted: ");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	@Override
	public void taskNine() {
		/*
		 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. 
		 * Определить, какой столбец содержит максимальную сумму.
		 */
		
		createMatrix();
		/**
		 * Creating a matrix of numbers
		 * @param height
		 * @param width
		 */	
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				matrix[i][j]= (int)(Math.random()*100); // matrix of positive numbers
			}
		}
		
		System.out.println("Original matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}	
		
		int [] sumColumn = new int [width];
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				sumColumn[j] += matrix[i][j];							
			}
		}		
		
		System.out.print("The sum of the elements in each column: ");
		System.out.print(Arrays.toString(sumColumn));
		
		int max = sumColumn[0]; //maximum number		
		int index = 1;		
		
		for (int i=1; i<sumColumn.length; i++) {
			if(sumColumn[i]>max) {
				max = sumColumn[i];
				index = i+1;
				
			}					
		}
		System.out.println("\nMax element " + max + " column #: " + index);
	}

	@Override
	public void taskTen() {
		/*
		 * Найти положительные элементы главной диагонали квадратной матрицы.
		 */
		
		System.out.println("Create a square matrix!");
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the dimension of the matrix: ");
				height = in.nextInt();
			} while(height <= 0);
			
			width = height;		
			
		matrix = new int[height][width]; // create matrix
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				matrix[i][j]= (int)(Math.random()*130)-30; // random numbers
			}
		}
		
		System.out.println("Original matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}			
		
		System.out.println("Positive elements located on the diagonal of the matrix: ");
		for(int i=0; i<matrix.length; i++) {			
			if(matrix[i][i]>0) {
				System.out.print(matrix[i][i]+" ");
			}			
		}
	}
	
	@Override
	public void taskEleven() {
		/*
		 * Матрицу 10x20 заполнить случайными числами от 0 до 15. 
		 * Вывести на экран саму матрицу и номера строк, в которых число 5 встречается три и более раз.
		 */
		height = 10;
		width = 20;
		matrix = new int[height][width];		
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				matrix[i][j]= (int)(Math.random()*16); // random numbers				
			}
		}		
		
		System.out.println("Matrix:");
		for (int i = 0; i<matrix.length; i++) {			
			System.out.println(Arrays.toString(matrix[i]));
		}
		
		int n = 0;//the number of digits equal to five		
		int count=0;//number of line
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {				
				if (matrix[i][j]==5) {
					n++;
					if(n==3) {						
						count++;						
					}					
				}
			}	
			n=0;
		}		
		
		int [] line = new int [count]; // line number
		int nline= 0;
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {				
				if (matrix[i][j]==5) {
					n++;
					if(n==3) {
						line[nline] = i+1;
						nline++;						
					}					
				}
			}
			n=0;
		}		
		
		System.out.print("The line number is #: "+Arrays.toString(line)+" ");		
	}
	
	@Override
	public void taskTwelve() {
		/*
		 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
		 */
		
		createMatrix();
		/**
		 * Creating a matrix of numbers
		 * @param height
		 * @param width
		 */	
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				matrix[i][j]= (int)(Math.random()*130)-30; // random numbers
			}
		}
		
		System.out.println("Original matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}	
		
		
		int[][] copy = new int[height][width];		
		for ( int i = 0; i < matrix.length; i++)
	    {	        
	        System.arraycopy(matrix[i], 0, copy[i], 0, matrix[i].length); //copy of the matrix
	    }
		
		int count=0;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width-1; j++) {				
				int row=j;//the number to work 
				while(count<=width-1) {//iterate through all the numbers
					do {
						if(matrix[i][row]>matrix[i][row+1]) {//compare							
							matrix[i][row] = copy[i][row+1];//replacement						
							matrix[i][row+1] = copy[i][row];//replacement						
							for ( int y = 0 ; y < matrix.length; y++)
						    {	        
						        System.arraycopy(matrix[y], 0, copy[y], 0, matrix[y].length); //copy of the matrix
						    }
						}	
						row++;//next number
					}while(row<=width-2);//берем число и сравниваем с каждым числом в строке
					count++;
					row=j;//get next number for compare
				}
				count=0;								
			}
		}	
		
		System.out.println("The matrix converted: ");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
	@Override
	public void taskThirteen() {
		/*
		 * Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
		 */
		createMatrix();
		/**
		 * Creating a matrix of numbers
		 * @param height
		 * @param width
		 */	
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				matrix[i][j]= (int)(Math.random()*130)-30; // random numbers
			}
		}
		
		System.out.println("Original matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}	
		
		
		int[][] copy = new int[height][width];		
		for ( int i = 0 ; i < matrix.length; i++)
	    {	        
	        System.arraycopy(matrix[i], 0, copy[i], 0, matrix[i].length); //copy of the matrix
	    }
		
		int count=0;
		for(int i=0; i<height-1; i++) {
			for(int j=0; j<width; j++) {				
				int column=i;//the number to work 
				while(count<=height-1) {//iterate through all the numbers
					do {
						if(matrix[column][j]>matrix[column+1][j]) {//compare							
							matrix[column][j] = copy[column+1][j];//replacement						
							matrix[column+1][j] = copy[column][j];//replacement						
							for ( int y = 0 ; y < matrix.length; y++)
						    {	        
						        System.arraycopy(matrix[y], 0, copy[y], 0, matrix[y].length); //copy of the matrix
						    }
						}	
						column++;//next number
					}while(column<=height-2);//берем число и сравниваем с каждым числом в столбце
					count++;
					column=i;//get next number for compare
				}
				count=0;								
			}
		}	
		
		System.out.println("The matrix converted: ");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		
	}
	
	@Override
	public void taskFourteen() {
		/*
		 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, 
		 * причем в каждом столбце число единиц равно номеру столбца.
		 */
		height = (int)(Math.random()*100)+1; // random numbers
		width = (int)(Math.random()*40)+1;
		matrix = new int[height][width]; // create matrix		
			
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(i==0||i<=j) {
					matrix[i][j]= (int)(Math.random()*1)+1; // random numbers
				} else {
					matrix[i][j]= (int)(Math.random()*1);
				}				
			}
		}
		
		System.out.println("Original matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}	
	}
	
	@Override
	public void taskFiveteen() {
		/*
		 * Найдите наибольший элемент матрицы и заменить все нечетные элементы на него
		 */
		createMatrix();
		/**
		 * Creating a matrix of numbers
		 * @param height
		 * @param width
		 */	
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				matrix[i][j]= (int)(Math.random()*130)-30; // random numbers
			}
		}
		
		System.out.println("Original matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		
		int max = Integer.MIN_VALUE; //maximum number
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {				
				if(matrix[i][j]>max) {
					max = matrix[i][j];
				}
			}
		}		
		
		System.out.println(max);
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {				
				if(matrix[i][j]<0) {
					matrix[i][j]=max;
				}
			}
		}
		
		System.out.println("Converted matrix:");
		for (int i = 0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}	
	}
	
	@Override
	public void taskSixteen() {
		/*
		 * Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3, ...,n^2
		 *  так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между собой. 
		 *  Построить такой квадрат. Пример магического квадрата порядка 3:
		 *  
		 *  6	1	8
		 *  7	5	3
		 *  2	9	4
		 */
		
		int n;
		System.out.println("Creating a magic square!!!");
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			do {
				System.out.print("Input the dimension of the matrix 3 or 4: ");
				n = in.nextInt();
			} while(n <= 2 || n>4);
		
		while(true) {
			boolean flag = true;
	        
			int[] matrixOne = new int[n*n]; //array to store N random integers       
	        for (int i = 0; i < matrixOne.length; ++i) // initialize each value at index i to the value i+1 (1-N) 
	        {
	            matrixOne[i] = i+1;
	        }
	        
			int index;
			int value;		
			double max=n*n;
			double min=1;	
			//Random random = new Random();
			for(int i=0; i<matrixOne.length; i++) {			
				index = (int)(Math.random() * ((max - min)+1) + min);
				value=matrixOne[index-1];
				matrixOne[index-1]=matrixOne[i];
				matrixOne[i]=value;					
					
				/*index = random.nextInt(i + 1);
				matrixOne[i] = matrixOne[index];
				matrixOne[index] = i + 1;*/			
			}
			
			System.out.println(Arrays.toString(matrixOne));
			
			matrix = new int[n][n];
	        int count = 0;
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[i].length; j++) {
	                matrix[i][j] = matrixOne[count];
	                count++;
	            }
	        }
					
			int magicConst = (n * (n * n + 1)) / 2;
			int [] sumLine = new int[n];			
			for (int i = 0; i < matrix.length; i++) { //сумма чисел в строках
	            for (int j = 0; j < matrix[i].length; j++) {
	                sumLine[i] += matrix[i][j]; 	                
	            }
	            if (sumLine[i] != magicConst) {	
	            	flag = false;
	            	break;
	            } 
	        }
			
			if (!flag) {	        	
	        	continue;
	        }						
			
	        for (int i = 0; i < matrix.length; i++) {
	            int sumColumn = 0;
	            for (int j = 0; j < matrix.length; j++) {	                
	                sumColumn += matrix[j][i];
	            }	            
	            if ((sumLine[i] != magicConst) || (sumColumn != magicConst)) {
	                flag = false;
	                break;
	            }
	        }      
	        	        
	        if (!flag) {	        	
	        	continue;
	        }
	        
	        int diagonalLeft = 0;
	        int diagonalRight = 0;
	        for (int i = 0; i < matrix.length; i++) { 
                diagonalLeft += matrix[i][i];            
                diagonalRight += matrix[i][matrix.length - 1 - i];
            }
	            
	        if (diagonalLeft == magicConst && diagonalRight==magicConst) {
	            for (int i = 0; i < matrix.length; i++) {
	                for (int j = 0; j < matrix.length; j++) {
	                    System.out.print(matrix[i][j] + "\t");
	                }
	                System.out.println();
	            }
	            break;
	        }
		}        
		
	}
	
	
}
