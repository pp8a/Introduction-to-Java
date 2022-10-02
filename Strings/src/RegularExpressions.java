import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions extends TaskSelection{
	
	@Override
	public void taskOne() {
		/*
		 * (Pattern, Matcher)
		 * C������ ����������, ����������� ����� (����� �������� � ������) � ����������� ��������� � ������� ��� ��������� ��������: 
		 * ������������� ������ �� ���������� �����������; 
		 * � ������ ����������� ������������� ����� �� �����; 
		 * ������������� ������� � ����������� �� �������� ���������� ��������� ��������� �������, � � ������ ��������� � �� ��������.
		 */
			
		
		int number;
		do {
			String str=pText();//����� �� �����
			
			System.out.print("������� ����� �������� �� 1 �� 4: ");
			number = input();
			
			switch(number) {	
			case 1:
				System.out.println("C��������� ������� �� ���������� �����������:\n"
						+sorted(paragraph(str)));			
				break;
			case 2:				
				System.out.println("C��������� ���� �� ����� � ������ �����������:\n"
						+word(str));	
				break;
			case 3:				
				char ch = '�';
				System.out.println("���������� ������ � ����������� �� �������� ���������� ��������� ������� '"+ch+"' (� ������ ��������� � �� ��������):\n"
						+lexeme(str, ch));	
				break;
			case 0:	
				System.out.println("�� ����� �� ���������� :(");
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
		String str = "\t���������� ��������� � (���, ���, ���), ����, ������� ������������, ���� �������, ����������� �������� �� �����. "
				+ "������ ����������� Java-������������� ���� ��� ������ ������� ����������� � ���������� ��������� ����������. "
				+ "���� ����� � � ���������� ������ � ������ � ���������������. 4 ����������� �����!\n"
				+ "\t��� ���������� ��������� ������������ � ���������� ����������� ���, ��������� � ���������� �������, "
				+ "�������� ��������. ��� ��� ������ �����������, ��������� � ������������ ����� ������. "
				+ "��� �� ����� �� � ������� ������. �����-�� �����. 5 ����������� ����!\n \t��� ����� ���������� ��������� RegEx? ������ ��������?\r\n"
				+ "\t�� ����� ���� ���������� ��������� (RegEx) � ��� ������ ��� ������ ������ � ������. "
				+ "� Java �������� �������������� ����� ������� ������ �������� ������. �� ���� ������ ������ String. "
				+ "������ �� ����� ������ ����� ���� �������������� � ���������� ���������. ������ ��, "
				+ "������� ������������� �������� ��������� ����������� ��������� � ����������, ������������� � ������������ �����. 6 ����������� �����!\r\n"
				+ "\t��� ��������� ����������� ��������� ������������ ��������� � �������� �������! � ����� ����������� � �������, "
				+ "������� ����������� �������� � ���������� ���������� ���������. ������� ������ 3 ����������� � ��� �����!\n";
		
		System.out.println("1. ������������� ������ �� ���������� �����������.");			
		System.out.println("2. � ������ ����������� ������������� ����� �� �����.");		
		System.out.println("3. ������������� ������� � ����������� �� �������� ���������� ��������� ��������� �������, "
				+ "� � ������ ��������� � �� ��������.");
		System.out.println("0. ����� �� ����������.");
		
		System.out.println("��� �����:\n"+str);
		
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
		
		final String WORD = "[a-zA-Z�-��-�0-9-��]+";
		
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
			result+=(matrix[i][0]+" ");//(matrix[i][0]+"\r\n") - ���� ����������� �� \t
		}
		
		return result;
	}
	
	
	public static String[][] paragraph(String str) {			
		/**
		 * get matrix [paragraph][count of sentence in a paragraph]
		 * mParagraph - ������� ������ ������
		 * str - text
		 * pCount - count of paragraph
		 */
		
		Matcher mParagraph = splitParagraph(str);
		
		int pCount = paragraphCount(str);//���������� �������
		
		String [][] matrix = new String[pCount][2];
		
		int i = 0;
		while(mParagraph.find() && i<pCount) {
			int start=mParagraph.start();
	        int end=mParagraph.end();	        
	        
	        String paragraph = str.substring(start,end);
	        //System.out.println("�����: " + paragraph);
	        int sCount = sentenceCount(paragraph);//���������� ����������� � ������
	        
	        //��������� ������� ����� + ���������� ����������� � ���
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
		//System.out.println("���������� �������: " + pCount);
		
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
        	//System.out.println("���������� �����������: " + count);
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
	        //System.out.println("�����������: " + sentence);
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
		//System.out.println("���������� ����: " + count);
		
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
	        
	        int cChar = 0;//���������� ��������
	        for(int �=0; �<word.length(); �++) {
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
		
		//int sCount = sentenceCount(str);//���������� �����������
		//System.out.println("���������� �����������: " + sCount);
		
		Matcher mSentence = splitSentence(str);		
		String sStr= "";
		int wCount;
		while(mSentence.find()) {
			int start=mSentence.start();
	        int end=mSentence.end();
	        String sentence = str.substring(start,end);
	        //System.out.println("�����������: " + sentence);
	        
	        wCount = wordCount(sentence);//���������� ����
	        String [][] matrix = new String[wCount][2];
			//System.out.println("���������� ����: " + wCount);	        
	        
	        Matcher mWord = splitWord(sentence);
	        int i=0;
	        
	        while(mWord.find()) {				        
		        
		        String word = sentence.substring(mWord.start(),mWord.end());		        
		        
		        int cChar = 0;//���������� ��������
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
		
		String [] lArrays = new String [wCount];//������� ��� ���������� ������ �����������	[count word]		
		
		for (int i = 0; i<matrix.length-1; i++) {
			
			int x = Integer.valueOf(matrix[i][1]);
			int y = Integer.valueOf(matrix[i+1][1]);
			if(x==y) {
				int j=i;//��� ����� ���� � ����������� ����������� �������� �������
				while(j<wCount && Integer.valueOf(matrix[j][1])==x) {//���� �� ����� ����������� � ���������� ��������� ������� ���������
					lArrays[j]=matrix[j][0];//��������� ����� � ��������					
					j++;
				}
				String [] copy = new String [j-i];//������� ������ ������ ���������� ��������� ���� � ��������
				System.arraycopy(lArrays, i, copy, 0, j-i);//������ ��������� ������� �������� � ������ copy
								
				Arrays.sort(copy);//��������� �������
				
				System.arraycopy(copy, 0, lArrays, i, copy.length);//�������� ��������������� ������� �������
				
				i=j-1;
				
			}else {//���� ����� ������� � ������������ �����
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
		 * ���� ������, ���������� ��������� ����� (xml-��������):
		 * �������� ����������, ����������� ��������������� ���������� ���������� ����� xml-��������� 
		 * � ��� ��� (����������� ���, ����������� ���, ���������� ����, ��� ��� ����). 
		 * ������������ �������� ��������� XML ��� ������� ������ ������ ������.
		 */
		
		String xml = "<notes>\r\n"
				+ " <note id = \"1\">\r\n"
				+ " <to>����</to>\r\n"
				+ " <from>�����</from>\r\n"
				+ " <heading>�����������</heading>\r\n"
				+ " <body>������� ��� ������!</body>\r\n"
				+ " </note>\r\n"
				+ " <note id = \"2\">\r\n"
				+ " <to>����</to>\r\n"
				+ " <from>����</from>\r\n"
				+ " <heading>������ �����������</heading>\r\n"
				+ " <body/>\r\n"
				+ " </note>\r\n"
				+ "</notes>\r\n";	
		
		System.out.println("���� ������, ���������� ��������� ����� (xml-��������):\n"+xml);
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
	    
	    Pattern pattern = Pattern.compile("\\r\\n");//��������� �� �������
	    String[] strings = pattern.split(xml);
	    for (String s : strings) {//���������� ������ ������ � ���� �� ���
	    	
		    Matcher mOpen = pOpen.matcher(s);
		    Matcher mClose = pClose.matcher(s);
		    Matcher mContent = pContent.matcher(s);
		    Matcher mWithOutCont = pWithOutCont.matcher(s);
		    
		    int start;
	        int end;
	        
	        if (mWithOutCont.find()) {
		    	start=mWithOutCont.start();
		        end=mWithOutCont.end();
		        System.out.println(s.substring(start, end)+" - ��� ��� ����");
		    }	        
	        else if (mOpen.find()) {
		        start=mOpen.start();
		        end=mOpen.end();
		        System.out.println(s.substring(start,end)+" - ������������� ���");
		    }
		    
		    if (mContent.find()) {
		    	start=mContent.start(2);
		        end=mContent.end(2);	  
		    	System.out.println(s.substring(start, end)+" - ���������� ����");
		    }
		    
		    if (mClose.find()) {
		    	start=mClose.start();
		        end=mClose.end();
		        System.out.println(s.substring(start, end)+" - ������������� ���");
		    }	
	    }        
	}
}
