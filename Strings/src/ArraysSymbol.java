import java.util.Arrays;

public class ArraysSymbol extends TaskSelection{
	
	@Override
	public void taskOne() {
		/*
		 * ��� ������ �������� ���������� � camelCase. ������������� �������� � snake_case.
		 */
		String[] array = {"systemEpam", "worldWorld", "noWar", "aleksMikhalchuk"};
		System.out.println("Array of data: "+Arrays.toString(array));
		
		for(int i = 0; i<=array.length-1; i++) {
			int j = 0;
			while(j!=array[i].length()) {
				if(Character.isUpperCase(array[i].charAt(j))) {//���� ������ � ������ � ������� ��������
					StringBuilder sb = new StringBuilder(array[i]);//����� ������
					sb.insert(j, "_");//��������� ������ �������������
					
					//String str = String.valueOf(array[i].charAt(j));//����������� ������ ������ � ������
					//sb.replace(j+1, j+2, str.toLowerCase());//��������� ��� �� ���� ����� ������������ � ������ �������
					//OR
					String str = Character.toString(Character.toLowerCase(array[i].charAt(j)));//����������� ������ � ������ ������� � � ������						
					sb.replace(j+1, j+2, str);//�������� ������ � ������� �������� �� ��� �� ������ � ������ ��������
					
					array[i] = sb.toString();//��������������� StringBuilder ������� � ������
				}
				j++;
			}
		}		
		System.out.println("Converted array: "+Arrays.toString(array));		
	}
	
	@Override
	public void taskTwo() {
		/*
		 * �������� � ������ ��� ��������� 'word' �� 'letter'.
		 */
		String str = "What is wordcounter? Apart from counting words and characters, our online editor can help you to improve word choice and writing style, "
				+ "\nand, optionally, help you to detect grammar mistakes and plagiarism. To check word count, simply place your cursor "
				+ "\ninto the text box above and start typing. You'll see the number of characters and words increase or decrease as you type, delete, "
				+ "\nand edit them. You can also copy and paste word-text from another program over into the online editor above. "
				+ "\nTip: word.\r\n";
		System.out.println("The data:\n"+str);
		
		//System.out.println(str.replaceAll("word", "letter"));
		
		String word = "word";//������� �����
		String letter = "letter";//������ �� ������ �����
		int n = word.length();//���������� ��������		
		
		for(int i=0; i<str.length(); i++) {//�������� �� ������
			if(str.charAt(i)==word.charAt(0)) { //������� 1-� ������				
				char[] chars = new char[n];//������ �������� 
				try {
					str.getChars(i, i+n, chars, 0);	//����� ����� 				
					String strW = new String(chars);//���������� � ������ ��� ���������
					if(strW.equals(word)) {//���������� ��������� �����
						StringBuilder sb = new StringBuilder(str);//��� ��������� ������
						sb.delete(i, i+n);
						sb.insert(i, letter);
						str = sb.toString();//������� � ������
					}
					
				} catch (Exception ex) {
			        System.out.println("��������� ����������...");
			    }
			}
		}
		
		System.out.println("Result:\n"+str);		
	}
	
	@Override
	public void taskThree() {
		/*
		 * � ������ ����� ���������� ����.
		 */
		
		String str = "8 02�� �37��� 23�� � �46��24� �4 ����3, �4� 283 2380��� ��94�� �4 �3��3, "
				+ "\n0�� 20��0 79�2�����, �790� �3��4��� 34�0� � 64�����, ��9�7��� �90�024�� � �0�74��.";		
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
		 * � ������ ����� ���������� �����.
		 */
		
		String str = "8 02�� �37��� 23�� � �46��24� �4 ����3, �4� 283 2380��� ��94�� �4 �3��3, "
				+ "\n0�� 20��0 79�2�����, �790� �3��4��� 34�0� � 64�����, ��9�7��� �90�024�� � �0�74��.";		
		System.out.println("The data:\n"+str);
		
		int count = 0;
		for(int i=0; i<str.length(); i++) {			
			if(Character.isDigit(str.charAt(i))) {
				while(Character.isDigit(str.charAt(i))) {//���� �����...					
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
		 * ������� � ������ ��� ������ �������, 
		 * �� ���� ����� ������ ������ �������� �������� �� ��������� �������. ������� ������� � ������ �������.
		 */
		
		String str = " 8 02�� �37��� 23�� � �46��24� �4 ����3, �4� 283 2380��� ��94�� �4 �3��3, "
				+ "\n0�� 20��0 79�2�����, �790�  2�������    4������� � 64�����, ��9�7��� �90�024�� � �0�74��. "; 
		System.out.println("The data:\n"+str);		
		
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length-1; i++) {
			if(Character.isWhitespace(chars[i])) {				
				StringBuilder sb = new StringBuilder(new String(chars));//������ char � string
				sb.deleteCharAt(i);
				chars = sb.toString().toCharArray();//�������  � char				
			}	
		}
		
		str = new String(chars);//��� ������ ������� � ������!
		System.out.println("No space: \n"+str);		
	}

}
