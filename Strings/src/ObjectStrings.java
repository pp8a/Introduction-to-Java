//import java.util.Locale;
import java.util.Scanner;

public class ObjectStrings extends TaskSelection{
	
	static String str = "May  �������� she live,  may she live a  �������   free       Ukrainea\r\n";
			/*+ "As in Constantinople,     the glorious Kozaks\r\n"
			+ "The ruthless          muslem, did hang them        upon a hook,\r\n"
			+ "Looking out at the end, upon this vivid world,\r\n"
			+ "In the hour of his death,   the Kozak spoken thus:\r\n";*/
	
	@Override
	public void taskOne() {
		/*
		 * ��� ����� (������). ������� ���������� ���������� ������ ������ �������� � ���.
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
		 * � ������ �������� ����� ������� ������� 'a' ������ 'b'.
		 */
		System.out.println("Data:\n"+str);
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='a') {				
				StringBuilder sb = new StringBuilder(str);//����� ������
				sb.insert(i+1, "b");//��������� ������ 
				str = sb.toString();				
			}			
		}
		
		System.out.println("Result:\n"+str);
	}
	
	@Override
	public void taskThree() {
		/*
		 * ���������, �������� �� �������� ����� �����������.
		 */
		String str = "saippuakuppinippukauppias";//��� ������� �����, ������������ �������� �����, ���� �� ����� ������� ����������� � ����		
		
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
		 * � ������� ������� ����������� � �������� ������������ ��������� �� ������ ����� ������������� ����� �����.
		 */
		
		String str = "�����������";
		
		char[] chars = str.toCharArray();
		String cake = String.valueOf(chars[7])+String.copyValueOf(chars, 3, 2)+String.valueOf(chars[7]);
		System.out.println(cake);
				
		String cake_2 = str.charAt(7)+str.substring(3, 5)+str.charAt(7);
		System.out.println(cake_2);
	}
	
	@Override
	public void taskFive() {
		/*
		 * ����������, ������� ��� ����� �������� �������� ������ ����������� ����� ���.
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
		 * �� �������� ������ �������� �����, �������� ������ ������ ������
		 */
		System.out.println("Data:\n"+str);
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isLetter(str.charAt(i))) {				
				StringBuilder sb = new StringBuilder(str);//����� ������
				sb.insert(i+1, str.charAt(i));//��������� ������ 
				str = sb.toString();	
				i++;				
			}			
		}
		
		System.out.println("It's a new string:\n"+str);
	}
	
	@Override
	public void taskSeven() {
		/*
		 * �������� ������. ��������� ������� �� ��� ������������� ������� � ��� �������. 
		 * ��������, ���� ���� ������� "abc cde def", �� ������ ���� �������� "abcdef".
		 */
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	
		String str = in.nextLine();
		
		StringBuilder sb = new StringBuilder(str);
		
		for(int i=0; i<str.length()-1; i++) {
			if(str.charAt(i)==' ') {//���� ������� �������				
				sb.deleteCharAt(i);
				str = sb.toString();
				i--;
			}
		}
		
		for(int i=0; i<str.length()-1; i++) {
			int j=i+1;//��� ��������� �� ��������� ��������
			while(j!=str.length()) {
				if(str.charAt(i)==str.charAt(j)) {					
					sb.deleteCharAt(j);
					str = sb.toString();
					j--;//����� �������� ��������� ������ �������� ������� ���������� ������� ���������� ������
				}
				j++;
			}
		}
		
		System.out.println("Result: "+str);		
	}	
	
	@Override
	public void taskEight() {
		/*
		 * �������� ������ ����, ����������� ���������. ����� ����� ������� ����� � ������� ��� �� �����. 
		 * ������, ����� ����� ������� ���� ����� ���� ���������, �� ������������.
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
		 * ��������� ���������� �������� (���������) � ��������� (�������) ���� � ��������� ������. 
		 * ��������� ������ ���������� �����.
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
		 * ������ X ������� �� ���������� �����������, ������ �� ������� ��������� ������, 
		 * ��������������� ��� �������������� ������. ���������� ���������� ����������� � ������ X.
		 */
		String X = "�� �� ������ ������ � �����, � ����,\r\n"
				+ "�� ���, ������ ����䳿, ���������� ����.\r\n"
				+ "������� ���� ����������, �� ���� �� �����,\r\n"
				+ "�������� ��, ������, � ���� ��������.\r\n"
				+ "\r\n"
				+ "���� � ��� �� ������� �� ���� �������,\r\n"
				+ "� ��������, �� ��, ������, ���������� ����!\r\n"
				+ "\r\n"
				+ "������, ������, �� �� ����, �� ���� �� ����,\r\n"
				+ "� ���� ���� �������� �� ���� �����.\r\n"
				+ "����� ���� �� ����������, �� ����� ���䳺,\r\n"
				+ "�� � ����� ����� �������� ���ﳺ!\r\n"
				+ "\r\n"
				+ "���� � ��� �� ������� �� ���� �������\r\n"
				+ "� ��������, �� ��, ������, ���������� ����.\r\n"
				+ "\r\n"
				+ "� ��������, ����� ���� ����� �� ������,\r\n"
				+ "�� �� ��� � ����� ���� ����� �������.\r\n"
				+ "�� ������� ��ᒺ����, ��������� �������,\r\n"
				+ "������ ����� ����� ���� ��������.\r\n"
				+ "\r\n"
				+ "���� � ��� �� ������� �� ���� �������\r\n"
				+ "� ��������, �� ��, ������, ���������� ����.";
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
