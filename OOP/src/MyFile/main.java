package MyFile;

import java.io.IOException;


public class main {

	public static void main(String[] args) throws IOException {
		String file = "/text.txt";		
		String catalog = "/catalog";
		String directory = "src/path";
		String text = "\tВ отличие от большинства классов ввода/вывода, класс File работает не с потоками, а непосредственно с файлами.\n"
				+ "\tДанный класс позволяет получить информацию о файле: права доступа, время и дата создания, путь к каталогу. "
				+ "А также осуществлять навигацию по иерархиям подкаталогов.";
		
		MyFile myFile = new MyFile(file);
		MyDirectory myDirectory = new MyDirectory(catalog, directory, new MyFile[] {myFile});	
		
		myDirectory.createDirectory();//создаем каталог
		myFile.createFile(myDirectory);//создаем файл
		
		myDirectory.createDirectory("catalog_1");//новые каталоги
		myDirectory.createDirectory("catalog_2");
		
		myFile.createFile("file_1.txt", myDirectory);//новые файлы
		myFile.createFile("file_2.txt", myDirectory);		
			
		System.out.println("--------------------------");
		myFile.print(myDirectory);//информация о файле
		System.out.println("--------------------------");		
		
		String[] list = myDirectory.printGetFile();//список файлов в каталоге	
		myDirectory.initMyFiles(list);//инициализируем массив MyFiles	
		
		myFile.reName(myDirectory, "file_1.txt", "newFile_1.txt");//переименование файла
		myFile.reName(myDirectory, "file_2.txt", "newFile_2.txt");		
		
		list = myDirectory.printGetFile();//список файлов в каталоге	
		myDirectory.initMyFiles(list);//инициализируем массив MyFiles		
		
		MyText myText = new MyText(text, myDirectory, myDirectory.getMyFiles());
		myText.writeText(file);//запись текста в файл
		myText.readText(file);//чтение текста из файла и вывод в консоль
		
		myText.writeAddText(file);//дозаписать в файл текст		
		myText.readText(file);
		
		myText.deleteText(file);
		myText.readText(file);
		
//		System.out.println(myText.getMyDirectory().getPath());
//		for (MyFile fileName : myText.getMyFiles()) {			
//		System.out.println(fileName.getFileName());
//		}
		
	}
}
