import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Classes {

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
        int countTopic = Topic.values().length;//count values in enum
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.print("Input the topic number from 1 to "+countTopic+": ");
			number = in.nextInt();	
		}while(number<=0||number>countTopic);		
		
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
		
		Topic[] arr = Topic.values();//get array enum		
		Topic task = arr[number-1];//example: Topic task = Topic.ObjectStrings;				
			
		TaskSelection ts = task.task();//get object enum
		
		do {
			System.out.print("Input the task number from 1 to "+ task.getNumber()+": ");
			number = in.nextInt();	
		}while(number<=0||number>task.getNumber());
		
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
		case 9:
			ts.taskNine();
			break;
		case 10:
			ts.taskTen();
			break;
		default:
			System.err.println("Thanks! There is no such task #"+number);	
		}	
	}

}
