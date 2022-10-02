import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions extends TaskSelection{
	
	@Override
	public void taskOne() {
		/*
		 * (Pattern, Matcher)
		 * Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции: 
		 * отсортировать абзацы по количеству предложений; 
		 * в каждом предложении отсортировать слова по длине; 
		 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
		 */
			
		
		int number;
		do {
			String str=pText();//текст на экран
			
			System.out.print("Введите номер операции от 1 до 4: ");
			number = input();
			
			switch(number) {	
			case 1:
				System.out.println("Cортировка абзацев по количеству предложений:\n"
						+sorted(paragraph(str)));			
				break;
			case 2:				
				System.out.println("Cортировка слов по длине в каждом предложении:\n"
						+word(str));	
				break;
			case 3:				
				char ch = 'а';
				System.out.println("Сортировка лексем в предложении по убыванию количества вхождений символа '"+ch+"' (в случае равенства – по алфавиту):\n"
						+lexeme(str, ch));	
				break;
			case 0:	
				System.out.println("Вы вышли из приложения :(");
				System.exit(0);
			default:
	            System.err.println("Operation " +number+" not found.");
			}	
		}while(number<0||number>4||number != '\n');
		
	}
	
	public static int input() {		
		int number;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	
		
					
		while (!in.hasNextInt()) {
			System.err.println("It's not an integer number! ... Input:");
			in.next(); 
		}
		number = in.nextInt();
		if(number<0||number>4) {
			System.out.println("Input only positive number! And number < 4.");
		}		
		
		return number;
	}
	
	public static String pText() {
		String str = "\tРегулярные выражения — (вар, дар, бар), тема, которую программисты, даже опытные, откладывают зачастую на потом. "
				+ "Однако большинству Java-разработчиков рано или поздно придётся столкнуться с обработкой текстовой информации. "
				+ "Чаще всего — с операциями поиска в тексте и редактированием. 4 предложения норма!\n"
				+ "\tБез регулярных выражений продуктивный и компактный программный код, связанный с обработкой текстов, "
				+ "попросту немыслим. Так что хватит откладывать, разберёмся с «регулярками» прямо сейчас. "
				+ "Это не такая уж и сложная задача. Какой-то текст. 5 предложений есть!\n \tЧто такое регулярное выражение RegEx? Сейчас разберем?\r\n"
				+ "\tНа самом деле регулярное выражение (RegEx) – это шаблон для поиска строки в тексте. "
				+ "В Java исходным представлением этого шаблона всегда является строка. То есть объект класса String. "
				+ "Однако не любая строка может быть скомпилирована в регулярное выражение. Только та, "
				+ "которая соответствует правилам написания регулярного выражения – синтаксису, определенному в спецификации языка. 6 предложений много!\r\n"
				+ "\tДля написания регулярного выражения используются буквенные и цифровые символы! А также метасимволы – символы, "
				+ "имеющие специальное значение в синтаксисе регулярных выражений. Парарам пампам 3 предложения и так далее!\n";
		
		System.out.println("1. Отсортировать абзацы по количеству предложений.");			
		System.out.println("2. В каждом предложении отсортировать слова по длине.");		
		System.out.println("3. Отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, "
				+ "а в случае равенства – по алфавиту.");
		System.out.println("0. Выйти из приложения.");
		
		System.out.println("Дан текст:\n"+str);
		
		return str;
	}
	
	private static Matcher splitParagraph(String str) {
		
		final String PARAGRAPH = "(.+\\r?\\n)"; /*(\\t.+)  (.+\\r?\\n)*/
		
		Pattern pParagraph = Pattern.compile(PARAGRAPH);		
		Matcher mParagraph = pParagraph.matcher(str);
		
		return mParagraph;		
	}
	
	private static Matcher splitSentence(String str) {
		
		final String SENTENCE = ".+?[.!?]";
		
		Pattern pSentence = Pattern.compile(SENTENCE);		
		Matcher mSentence = pSentence.matcher(str);
		
		return mSentence;		
	}
	
	private static Matcher splitWord(String sentence) {
		
		final String WORD = "[a-zA-Zа-яА-Я0-9-ёЁ]+";
		
		Pattern pWord = Pattern.compile(WORD);		
		Matcher mWord = pWord.matcher(sentence);
		
		return mWord;		
	}
	
	public static String sorted(String[][] matrix) {
		/**
		 * matrix[search elements][parameters for sorting] 
		 */
		for (int i = 0; i<matrix.length-1; i++) {
			if(Integer.valueOf(matrix[i][1])>Integer.valueOf(matrix[i+1][1])) {
				String[] s = matrix[i];
				matrix[i]=matrix[i+1];
				matrix[i+1]=s;	
				i=-1;
			};
			
		}	
		
		String result="";		
		for(int i=0; i<matrix.length; i++) {
			result+=(matrix[i][0]+" ");//(matrix[i][0]+"\r\n") - если сортировать по \t
		}
		
		return result;
	}
	
	
	public static String[][] paragraph(String str) {			
		/**
		 * get matrix [paragraph][count of sentence in a paragraph]
		 * mParagraph - условие отбора абзаца
		 * str - text
		 * pCount - count of paragraph
		 */
		
		Matcher mParagraph = splitParagraph(str);
		
		int pCount = paragraphCount(str);//количество абзацев
		
		String [][] matrix = new String[pCount][2];
		
		int i = 0;
		while(mParagraph.find() && i<pCount) {
			int start=mParagraph.start();
	        int end=mParagraph.end();	        
	        
	        String paragraph = str.substring(start,end);
	        //System.out.println("Абзац: " + paragraph);
	        int sCount = sentenceCount(paragraph);//количество предложений в абзаце
	        
	        //заполняем матрицу абзац + количество предложений в нем
	        int j = 0;
	        matrix[i][j++]=paragraph;	        
	        matrix[i++][j]=String.valueOf(sCount);	 	        
		}
				
		return matrix;
	}
			
	public static int paragraphCount(String str) {		
		/*
		 *count of paragraph
		 */
		Matcher mParagraph = splitParagraph(str);
		
		int pCount  = 0;
		while(mParagraph.find()) {				        
	        pCount++;
		}
		//System.out.println("Количество абзацев: " + pCount);
		
		return pCount;
	}	
		
	public static int sentenceCount(String paragraph) {
		/*
		 * count of sentence in a paragraph
		 */
		Matcher mSentence = splitSentence(paragraph);	
		
        int count = 0;
        while(mSentence.find()) {
        	count++;
        	//System.out.println("Количество предложений: " + count);
        }
		
		return count;
	}
	
	public static String word(String str) {
		/**
		 * the returned sentence, sorted by word length
		 */
		Matcher mSentence = splitSentence(str);		
		
		String sStr= "";
		while(mSentence.find()) {
			int start=mSentence.start();
	        int end=mSentence.end();
	        String sentence = str.substring(start,end);
	        //System.out.println("Предложение: " + sentence);
	        int wCount = wordCount(sentence);//count of words in a sentence
	       
	        String[][] matrix = charCount(sentence, wCount);//matrix[word][count chars]
	        sStr +="\t"+sorted(matrix)+"\n";
        }
		
		return sStr;
	}
	
	
	public static int wordCount(String sentence) {
		/**
		 * @return word count in sentence
		 */
		
		Matcher mWord = splitWord(sentence);
		
		int wCount = 0;
		while(mWord.find()) {
			wCount++;
		}
		//System.out.println("Количество слов: " + count);
		
		return wCount;
	}
	
	public static String[][] charCount(String sentence, int wCount) {
		/**
		 * @return matrix[word][count chars]
		 */
		
		Matcher mWord = splitWord(sentence);
		
		String [][] matrix = new String[wCount][2];
		
		int i=0;
		while(mWord.find()) {
			int start=mWord.start();
	        int end=mWord.end();	        
	        
	        String word = sentence.substring(start,end);
	        
	        int cChar = 0;//количество символов
	        for(int с=0; с<word.length(); с++) {
	        	cChar++;
	        }
	        
	        int j = 0;
	        matrix[i][j++]=word;	        
	        matrix[i++][j]=String.valueOf(cChar);
	        //System.out.println(word+" "+cChar);
		}	
				
		return matrix;
	}
	
	public static String lexeme(String str, char ch) {
		
		//int sCount = sentenceCount(str);//количество предложений
		//System.out.println("Количество предложений: " + sCount);
		
		Matcher mSentence = splitSentence(str);		
		String sStr= "";
		int wCount;
		while(mSentence.find()) {
			int start=mSentence.start();
	        int end=mSentence.end();
	        String sentence = str.substring(start,end);
	        //System.out.println("Предложение: " + sentence);
	        
	        wCount = wordCount(sentence);//количество слов
	        String [][] matrix = new String[wCount][2];
			//System.out.println("Количество слов: " + wCount);	        
	        
	        Matcher mWord = splitWord(sentence);
	        int i=0;
	        
	        while(mWord.find()) {				        
		        
		        String word = sentence.substring(mWord.start(),mWord.end());		        
		        
		        int cChar = 0;//количество символов
		        for(int c=0; c<word.length(); c++) {
		        	if(word.charAt(c)==ch||word.charAt(c)=='a') {
		        		cChar++;
		        	}		        	
		        }
		        
		        int j = 0;
		        matrix[i][j++]=word;	        
		        matrix[i++][j]=String.valueOf(cChar);
		        //System.out.println(word+" - "+cChar);
		        
			}
	        sStr +="\t"+sortedA(matrix, wCount)+"\n";
        }
		
		return sStr;
		
	}
	
	public static String sortedA(String[][] matrix, int wCount) {
		/**
		 * matrix[search elements][parameters for sorting] 
		 */
		for (int i = 0; i<matrix.length-1; i++) {
			if(Integer.valueOf(matrix[i][1])<Integer.valueOf(matrix[i+1][1])) {
				String[] s = matrix[i];
				matrix[i]=matrix[i+1];
				matrix[i+1]=s;	
				i=-1;
			};			
		}	
		
		String [] lArrays = new String [wCount];//создаем для сортировки одного предложения	[count word]		
		
		for (int i = 0; i<matrix.length-1; i++) {
			
			int x = Integer.valueOf(matrix[i][1]);
			int y = Integer.valueOf(matrix[i+1][1]);
			if(x==y) {
				int j=i;//для сбора слов с однинаковым количеством искомого символа
				while(j<wCount && Integer.valueOf(matrix[j][1])==x) {//пока не конец предложения и количество заданного символа одинаково
					lArrays[j]=matrix[j][0];//заполняем слова с символом					
					j++;
				}
				String [] copy = new String [j-i];//создаем массив равным количеству найденных слов с символом
				System.arraycopy(lArrays, i, copy, 0, j-i);//только найденные лексемы копируем в массив copy
								
				Arrays.sort(copy);//сортируем лексемы
				
				System.arraycopy(copy, 0, lArrays, i, copy.length);//копируем отсортированные лексемы обратно
				
				i=j-1;
				
			}else {//если такая лексема в единственном числе
				lArrays[i]=matrix[i][0];
			}
		}
		
		String result="";		
		for(int i=0; i<lArrays.length; i++) {
			result+=(lArrays[i]+" ");		
		}		
		
		return result;
	}	
	
	
	
	@Override
	public void taskTwo() {
		/*
		 * Дана строка, содержащая следующий текст (xml-документ):
		 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа 
		 * и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела). 
		 * Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
		 */
		
		String xml = "<notes>\r\n"
				+ " <note id = \"1\">\r\n"
				+ " <to>Вася</to>\r\n"
				+ " <from>Света</from>\r\n"
				+ " <heading>Напоминание</heading>\r\n"
				+ " <body>Позвони мне завтра!</body>\r\n"
				+ " </note>\r\n"
				+ " <note id = \"2\">\r\n"
				+ " <to>Петя</to>\r\n"
				+ " <from>Маша</from>\r\n"
				+ " <heading>Важное напоминание</heading>\r\n"
				+ " <body/>\r\n"
				+ " </note>\r\n"
				+ "</notes>\r\n";	
		
		System.out.println("Дана строка, содержащая следующий текст (xml-документ):\n"+xml);
		parseXML(xml);
		
	}
	
	static void parseXML(String xml) {
		
		final String OPENTAG = "<\\w.+?>";
		final String CLOSETAG = "</\\w+?>";
		final String CONTENTTAG = "(<\\w+>)(.+)(</\\w+>)";
		final String WITHOUTCONTENTTAG = "<\\w+/>";		
			    
	    Pattern pOpen = Pattern.compile(OPENTAG);
	    Pattern pClose = Pattern.compile(CLOSETAG);
	    Pattern pContent = Pattern.compile(CONTENTTAG);
	    Pattern pWithOutCont = Pattern.compile(WITHOUTCONTENTTAG);
	    
	    Pattern pattern = Pattern.compile("\\r\\n");//разбиваем по строчно
	    String[] strings = pattern.split(xml);
	    for (String s : strings) {//перебираем каждую строку и даем ей тип
	    	
		    Matcher mOpen = pOpen.matcher(s);
		    Matcher mClose = pClose.matcher(s);
		    Matcher mContent = pContent.matcher(s);
		    Matcher mWithOutCont = pWithOutCont.matcher(s);
		    
		    int start;
	        int end;
	        
	        if (mWithOutCont.find()) {
		    	start=mWithOutCont.start();
		        end=mWithOutCont.end();
		        System.out.println(s.substring(start, end)+" - тег без тела");
		    }	        
	        else if (mOpen.find()) {
		        start=mOpen.start();
		        end=mOpen.end();
		        System.out.println(s.substring(start,end)+" - открывающийся тег");
		    }
		    
		    if (mContent.find()) {
		    	start=mContent.start(2);
		        end=mContent.end(2);	  
		    	System.out.println(s.substring(start, end)+" - содержимое тега");
		    }
		    
		    if (mClose.find()) {
		    	start=mClose.start();
		        end=mClose.end();
		        System.out.println(s.substring(start, end)+" - закрывающийся тег");
		    }	
	    }        
	}
}
