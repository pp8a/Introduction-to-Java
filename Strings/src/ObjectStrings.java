//import java.util.Locale;
import java.util.Scanner;

public class ObjectStrings extends TaskSelection{
	
	static String str = "May  кирилица she live,  may she live a  Символы   free       Ukrainea\r\n";
			/*+ "As in Constantinople,     the glorious Kozaks\r\n"
			+ "The ruthless          muslem, did hang them        upon a hook,\r\n"
			+ "Looking out at the end, upon this vivid world,\r\n"
			+ "In the hour of his death,   the Kozak spoken thus:\r\n";*/
	
	@Override
	public void taskOne() {
		/*
		 * Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
		 */
		
		System.out.println("Data:\n"+str);
		
		int spaceCount = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==' ') {
				spaceCount++;
			}else {
				spaceCount = 0;
			}
			if(spaceCount>max) {
				max = spaceCount;				
			}			
		}
		
		System.out.println("Max space: "+max);
		
	}
	
	@Override
	public void taskTwo() {
		/*
		 * В строке вставить после каждого символа 'a' символ 'b'.
		 */
		System.out.println("Data:\n"+str);
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='a') {				
				StringBuilder sb = new StringBuilder(str);//берем строку
				sb.insert(i+1, "b");//вставляем символ 
				str = sb.toString();				
			}			
		}
		
		System.out.println("Result:\n"+str);
	}
	
	@Override
	public void taskThree() {
		/*
		 * Проверить, является ли заданное слово палиндромом.
		 */
		String str = "saippuakuppinippukauppias";//Это финское слово, обозначающее торговца мылом, один из самых длинных палиндромов в мире		
		
		int len = str.length()/2;
		int count = 0;
		for(int i=0; i<len; i++) {			
			if(str.charAt(i)==str.charAt((str.length()-1)-i)) {				
				count++;
			}else {
				i=str.length()/2;
			}			
		}
		if(count==len) {
			System.out.println("The word \'"+str+"\' is a palindrome.");
		}else {
			System.out.println("The word \'"+str+"\' isn't a palindrome.");
		}
		
	}
	
	@Override
	public void taskFour() {
		/*
		 * С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
		 */
		
		String str = "информатика";
		
		char[] chars = str.toCharArray();
		String cake = String.valueOf(chars[7])+String.copyValueOf(chars, 3, 2)+String.valueOf(chars[7]);
		System.out.println(cake);
				
		String cake_2 = str.charAt(7)+str.substring(3, 5)+str.charAt(7);
		System.out.println(cake_2);
	}
	
	@Override
	public void taskFive() {
		/*
		 * Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
		 */
		System.out.println("Data:\n"+str);
		
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='a') {
				count++;
			}
		}		
		
		System.out.println("In this string the symbol \'a\' occurs "+count+" times.");		
	}
	
	@Override
	public void taskSix() {
		/*
		 * Из заданной строки получить новую, повторив каждый символ дважды
		 */
		System.out.println("Data:\n"+str);
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isLetter(str.charAt(i))) {				
				StringBuilder sb = new StringBuilder(str);//берем строку
				sb.insert(i+1, str.charAt(i));//вставляем символ 
				str = sb.toString();	
				i++;				
			}			
		}
		
		System.out.println("It's a new string:\n"+str);
	}
	
	@Override
	public void taskSeven() {
		/*
		 * Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. 
		 * Например, если было введено "abc cde def", то должно быть выведено "abcdef".
		 */
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	
		String str = in.nextLine();
		
		StringBuilder sb = new StringBuilder(str);
		
		for(int i=0; i<str.length()-1; i++) {
			if(str.charAt(i)==' ') {//если пробелы удаляем				
				sb.deleteCharAt(i);
				str = sb.toString();
				i--;
			}
		}
		
		for(int i=0; i<str.length()-1; i++) {
			int j=i+1;//для сравнения со следующим символом
			while(j!=str.length()) {
				if(str.charAt(i)==str.charAt(j)) {					
					sb.deleteCharAt(j);
					str = sb.toString();
					j--;//после удаления следующий символ занимает позицию удаленного поэтому возвращаем индекс
				}
				j++;
			}
		}
		
		System.out.println("Result: "+str);		
	}	
	
	@Override
	public void taskEight() {
		/*
		 * Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. 
		 * Случай, когда самых длинных слов может быть несколько, не обрабатывать.
		 */
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	
		String str = in.nextLine();
		
		String strCount = "";
		String strMax = "";
		int max = Integer.MIN_VALUE;
		int count = 0;		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)!=' ') {
				strCount+=str.charAt(i);
				count++;				
			}
			if (str.charAt(i)==' ' || i == str.length()-1) {	
				if(count>max) {
					max = count;
					strMax = strCount;
				}				
				strCount = "";
				count = 0;	
			}
		}		
		System.out.println("Result: "+strMax);			
	}
	
	@Override
	public void taskNine() {
		/*
		 * Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. 
		 * Учитывать только английские буквы.
		 */
		System.out.println("Data:\n"+str);
		int lower = 0;
		int upper = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)>='a' && str.charAt(i)<='z') {
				lower++;
			}
			if(str.charAt(i)>='A' && str.charAt(i)<='Z') {
				upper++;
			}			
		}
		
		System.out.println("Lower = "+lower+"\nUpper = "+upper);
	}
	
	@Override
	public void taskTen() {
		/*
		 * Строка X состоит из нескольких предложений, каждое из которых кончается точкой, 
		 * восклицательным или вопросительным знаком. Определить количество предложений в строке X.
		 */
		String X = "Ще не вмерла України і слава, і воля,\r\n"
				+ "Ще нам, браття молодії, усміхнеться доля.\r\n"
				+ "Згинуть наші вороженьки, як роса на сонці,\r\n"
				+ "Запануємо ми, браття, у своїй сторонці.\r\n"
				+ "\r\n"
				+ "Душу й тіло ми положим за нашу свободу,\r\n"
				+ "І покажемо, що ми, браття, козацького роду!\r\n"
				+ "\r\n"
				+ "Станем, браття, всі за волю, від Сяну до Дону,\r\n"
				+ "В ріднім краю панувати не дамо нікому.\r\n"
				+ "Чорне море ще всміхнеться, дід Дніпро зрадіє,\r\n"
				+ "Ще у нашій Україні доленька наспіє!\r\n"
				+ "\r\n"
				+ "Душу й тіло ми положим за нашу свободу\r\n"
				+ "І покажемо, що ми, браття, козацького роду.\r\n"
				+ "\r\n"
				+ "А завзяття, праця щира свого ще докаже,\r\n"
				+ "Ще ся волі в Україні піснь гучна розляже.\r\n"
				+ "За Карпати відіб’ється, згомонить степами,\r\n"
				+ "України слава стане поміж народами.\r\n"
				+ "\r\n"
				+ "Душу й тіло ми положим за нашу свободу\r\n"
				+ "І покажемо, що ми, браття, козацького роду.";
		System.out.println("Data:\n"+X);
		
		char [] chars = {'.', '!', '?'}; 
		
		int count = 0;
		for(int i=0; i<X.length(); i++) {
			if(X.charAt(i)==chars[0] || X.charAt(i)==chars[1] || X.charAt(i)==chars[2]) {
				count++;
			}
		}
		
		System.out.println("\nThe number of sentences in the text is "+count);
	}

}
