package MyFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MyText {
	private String myText;	
	private MyDirectory myDirectory;
	private MyFile[] myFiles;
	
	public MyText(String myText, MyDirectory myDirectory, MyFile[] myFiles) {
		super();
		this.myText = myText;
		this.myDirectory = myDirectory;
		this.myFiles = myFiles;
	}

	public String getMyText() {
		return myText;
	}

	public void setMyText(String myText) {
		this.myText = myText;
	}

	public MyDirectory getMyDirectory() {
		return myDirectory;
	}

	public void setMyDirectory(MyDirectory myDirectory) {
		this.myDirectory = myDirectory;
	}

	public MyFile[] getMyFiles() {
		return myFiles;
	}

	public void setMyFiles(MyFile[] myFiles) {
		this.myFiles = myFiles;
	}

	@Override
	public String toString() {
		return "MyText [myText=" + myText + ", myDirectory=" + myDirectory + ", myFiles=" + Arrays.toString(myFiles)
				+ "]";
	}
	
	public void writeText(String file) {		
		try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(getMyDirectory().getPath()+file))) { 
			System.out.println("Записываем файл "+file.substring(1)+".");
            bufferedWriter.write(getMyText());            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
	}
	
	public void readText(String file) {		
		try (BufferedReader bufferedRead = new BufferedReader(
                new FileReader(getMyDirectory().getPath()+file))) {
			System.out.println("Читаем файл "+file.substring(1)+":");
			
			File fileCheck = new File(getMyDirectory().getPath()+file);			
            if (isFileEmpty(fileCheck)) {
                System.out.println("Ошибки нет, файл пуст.");
            }else {
            	String str;
                while ((str = bufferedRead.readLine()) != null) {            	
                    System.out.println(str);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public boolean isFileEmpty(File file) throws IOException {
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			return br.readLine() == null;
		}
	}
	
	public void writeAddText(String file) {		
		try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(getMyDirectory().getPath()+file, true))) { 
			System.out.println("Дозаписываем файл "+file.substring(1)+".");
			bufferedWriter.newLine();
	        bufferedWriter.write("\tМожно добавить новый текст!\n\t:) ;) +++"); 
			bufferedWriter.newLine();
            bufferedWriter.write("\t+375 25 751-31-81"); 
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
	}
	
	public void deleteText(String file) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(getMyDirectory().getPath()+file, false))) { 
			System.out.println("Очищаем содержимое файла "+file.substring(1)+".");                     
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
	}
}
