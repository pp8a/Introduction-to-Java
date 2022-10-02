import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		
		String str = "src\\topic\\topic.txt";
		Path path = Path.of(str).toAbsolutePath();
		
		String topicText = String.valueOf(path);
        try (BufferedReader readerTopic = new BufferedReader(new FileReader(topicText))) {
			String lineTopic = readerTopic.readLine();
			while (lineTopic != null) {
			    System.out.println("\t"+lineTopic.trim()); 
			    lineTopic = readerTopic.readLine();
			}
		}
        int number;	//issue number				
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.print("Input the topic number from 1 to 3: ");
			number = in.nextInt();	
		}while(number<=0||number>3);
		
		str = "src\\topic\\"+number+".txt";
		path = Path.of(str).toAbsolutePath();
		
		String taskText = String.valueOf(path);
        try (BufferedReader readerTask = new BufferedReader(new FileReader(taskText))) {
			String lineTask = readerTask.readLine();
			while (lineTask != null) {
			    System.out.println("\t"+lineTask.trim()); 
			    lineTask = readerTask.readLine();
			}
		}
        enum TaskArrays {
			Linear(6), Branching(5), Cycles(8);

			private int number;//number of tasks in the topic

			TaskArrays(int number) {
				this.number = number;
			}
	    }
		
		TaskArrays task = null;
		
		switch(number) {		
		case 1: 
			task = TaskArrays.Linear;			
			break;
		case 2:
			task = TaskArrays.Branching;	
			break;
		case 3:
			task = TaskArrays.Cycles;	
			break;		
		default:
            System.err.println("Task not found. " + number);
		}		
		
		TaskSelection ts = null;
		
		
		switch (task) {
        case Linear:
        	ts = new Linear(); 
            break;
        case Branching:
        	ts = new Branching();
            break;  
        case Cycles:
        	ts = new Cycles();
            break;        
        }		
		
		do {
			System.out.print("Input the task number from 1 to "+task.number+": ");
			number = in.nextInt();	
		}while(number<=0||number>task.number);
		
		switch(number) {		
		case 1: 
			ts.taskOne();
			break;
		case 2:
			ts.taskTwo();	
			break;
		case 3:
			ts.taskThree();
			break;
		case 4:
			ts.taskFour();
			break;
		case 5:
			ts.taskFive();
			break;
		case 6:
			ts.taskSix();
			break;
		case 7:
			ts.taskSeven();
			break;
		case 8:
			ts.taskEight();
			break;		
		default:
			System.err.println("Thanks! There is no such task #"+number);	
		}							
	}	

}
