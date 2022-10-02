import java.util.Arrays;

public class ArraysSymbol extends TaskSelection{
	
	@Override
	public void taskOne() {
		/*
		 * Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
		 */
		String[] array = {"systemEpam", "worldWorld", "noWar", "aleksMikhalchuk"};
		System.out.println("Array of data: "+Arrays.toString(array));
		
		for(int i = 0; i<=array.length-1; i++) {
			int j = 0;
			while(j!=array[i].length()) {
				if(Character.isUpperCase(array[i].charAt(j))) {//если символ в строке в верхнем регистре
					StringBuilder sb = new StringBuilder(array[i]);//берем строку
					sb.insert(j, "_");//вставляем символ подчеркивания
					
					//String str = String.valueOf(array[i].charAt(j));//преобразуем данный символ в строку
					//sb.replace(j+1, j+2, str.toLowerCase());//вставляем его на тоже место преобразовав в нижний регистр
					//OR
					String str = Character.toString(Character.toLowerCase(array[i].charAt(j)));//преобразуем символ в нижний регистр и в строку						
					sb.replace(j+1, j+2, str);//заменяем символ в верхнем регистре на тот же символ в нижнем регистре
					
					array[i] = sb.toString();//преобразовываем StringBuilder обратно в строку
				}
				j++;
			}
		}		
		System.out.println("Converted array: "+Arrays.toString(array));		
	}
	
	@Override
	public void taskTwo() {
		/*
		 * Замените в строке все вхождения 'word' на 'letter'.
		 */
		String str = "What is wordcounter? Apart from counting words and characters, our online editor can help you to improve word choice and writing style, "
				+ "\nand, optionally, help you to detect grammar mistakes and plagiarism. To check word count, simply place your cursor "
				+ "\ninto the text box above and start typing. You'll see the number of characters and words increase or decrease as you type, delete, "
				+ "\nand edit them. You can also copy and paste word-text from another program over into the online editor above. "
				+ "\nTip: word.\r\n";
		System.out.println("The data:\n"+str);
		
		//System.out.println(str.replaceAll("word", "letter"));
		
		String word = "word";//искомое слово
		String letter = "letter";//меняем на данное слово
		int n = word.length();//количество символов		
		
		for(int i=0; i<str.length(); i++) {//проходим по строке
			if(str.charAt(i)==word.charAt(0)) { //находим 1-й символ				
				char[] chars = new char[n];//массив символов 
				try {
					str.getChars(i, i+n, chars, 0);	//берем слово 				
					String strW = new String(chars);//возвращаем в строку для сравнения
					if(strW.equals(word)) {//сравниваем найденное слово
						StringBuilder sb = new StringBuilder(str);//для изменения строки
						sb.delete(i, i+n);
						sb.insert(i, letter);
						str = sb.toString();//обратно в строку
					}
					
				} catch (Exception ex) {
			        System.out.println("Возникает исключение...");
			    }
			}
		}
		
		System.out.println("Result:\n"+str);		
	}
	
	@Override
	public void taskThree() {
		/*
		 * В строке найти количество цифр.
		 */
		
		String str = "8 02ИН Л37НИЙ 23НЬ Я Н46ЛЮ24Л Н4 ПЛЯЖ3, К4К 283 2380ЧКИ ИГ94ЛИ Н4 П3СК3, "
				+ "\n0НИ 20ЛГ0 79У2ИЛИСЬ, С790Я П3СЧ4НЫЙ 34М0К С 64ШНЯМИ, СК9Ы7ЫМИ П90Х024МИ И М0С74МИ.";		
		System.out.println("The data:\n"+str);
		
		int count_s = 0;
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				count_s++;								
			}
		}
		System.out.println("Number of digits: "+count_s);
		
		int count_ch=0;
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(Character.isDigit(chars[i])) 
				count_ch++;
		}
		System.out.println("Number of digits: "+count_ch);
	}
	
	@Override
	public void taskFour() {
		/*
		 * В строке найти количество чисел.
		 */
		
		String str = "8 02ИН Л37НИЙ 23НЬ Я Н46ЛЮ24Л Н4 ПЛЯЖ3, К4К 283 2380ЧКИ ИГ94ЛИ Н4 П3СК3, "
				+ "\n0НИ 20ЛГ0 79У2ИЛИСЬ, С790Я П3СЧ4НЫЙ 34М0К С 64ШНЯМИ, СК9Ы7ЫМИ П90Х024МИ И М0С74МИ.";		
		System.out.println("The data:\n"+str);
		
		int count = 0;
		for(int i=0; i<str.length(); i++) {			
			if(Character.isDigit(str.charAt(i))) {
				while(Character.isDigit(str.charAt(i))) {//пока цифры...					
					i++;													
				}
				count++;
			}
			
		}
		System.out.println("Number of numbers: "+count);		
	}
	
	@Override
	public void taskFive() {
		/*
		 * Удалить в строке все лишние пробелы, 
		 * то есть серии подряд идущих пробелов заменить на одиночные пробелы. Крайние пробелы в строке удалить.
		 */
		
		String str = " 8 02ИН Л37НИЙ 23НЬ Я Н46ЛЮ24Л Н4 ПЛЯЖ3, К4К 283 2380ЧКИ ИГ94ЛИ Н4 П3СК3, "
				+ "\n0НИ 20ЛГ0 79У2ИЛИСЬ, С790Я  2пробела    4пробела С 64ШНЯМИ, СК9Ы7ЫМИ П90Х024МИ И М0С74МИ. "; 
		System.out.println("The data:\n"+str);		
		
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length-1; i++) {
			if(Character.isWhitespace(chars[i])) {				
				StringBuilder sb = new StringBuilder(new String(chars));//массив char в string
				sb.deleteCharAt(i);
				chars = sb.toString().toCharArray();//обратно  в char				
			}	
		}
		
		str = new String(chars);//для вывода обратно в строку!
		System.out.println("No space: \n"+str);		
	}

}
