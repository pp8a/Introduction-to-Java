import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Student {
	
	private String fullName;	
	private String numberGroup;
	private int [] progress;		
	
	public Student(String fullName, String numberGroup, int[] progress) {
		super();
		this.fullName = fullName;
		this.numberGroup = numberGroup;
		this.progress = progress;
	}

	public Student() {
		super();
		progress = new int [5];
	}
	
	public String getFullName() {
		return fullName;
	}

	public String getNumberGroup() {
		return numberGroup;
	}

	public int[] getProgress() {
		return progress;
	}

	public void setProgress(int[] progress) {
		int max = 10;
		int min = 2;
		Random random = new Random();		
		for(int i=0; i<progress.length; i++) {			
			progress[i] = random.nextInt((max - min) + 1) + min;
		}
		
		this.progress = progress;
	}

	public Student createStudent() {
		System.out.println("Input the student's last name and initials:");
		fullName = inputName();
		numberGroup = numberGroup();			
		setProgress(progress);
		
		return new Student(fullName, numberGroup, progress);
	}
	
		
	@Override
	public String toString() {
		return "Last name=" + fullName + ", number group=" + numberGroup + ", progress="
				+ Arrays.toString(progress);
	}

	public static String inputName() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String line = null;
		while((line = sc.nextLine()).isEmpty()) {		  
		  System.out.println("You didn't input the student's last name. Input ... ");			
		}
			
		return line;		
	}	
		
	public static String numberGroup() {
		String str = "ABC";
		int max = 5;
		int min = 1;
				
		Random random = new Random();
		char s = str.charAt(random.nextInt(str.length()));
		int n = random.nextInt((max - min) + 1) + min;		
			
		return String.valueOf(n)+String.valueOf(s);
	}
	
}
