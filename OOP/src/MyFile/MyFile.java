package MyFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class MyFile {
	private String fileName; //name file

	public MyFile(String fileName) {
		super();
		this.fileName = fileName;
	}

	
	public MyFile() {
		super();
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "File [name=" + fileName + "]";
	}
	
	public void createFile(MyDirectory myDirectory) throws IOException {
		String dir = myDirectory.getPath();		
		File theFile = new File(dir+getFileName());
		if(!theFile.exists()) {
			theFile.createNewFile();
			System.out.println("The file \""+getFileName().substring(1)+"\" was created in the directory \""+dir+"\"");			
		}else {
			System.out.println("The file \""+getFileName().substring(1)+"\" is exists in the directory \""+dir+"\"");	
		}
	}
	
	public void createFile(String name, MyDirectory myDirectory) throws IOException{
		String pathGet = myDirectory.getPath();
		Path path = Path.of(pathGet+"/"+name);		
		if(Files.isRegularFile(path)) {
			System.out.println("The file: \""+name+"\" is exists. It's in the directory: \""+pathGet+"\".");
		}else {
			Files.createFile(path);
			System.out.println("The file: \""+name+"\" created. It's in the directory: \""+pathGet+"\".");
		}		
	}
	
	public void reName(MyDirectory myDirectory, String oldName, String newName) {
		File file = new File(myDirectory.getPath()+"/"+oldName);
		File newfile = new File(myDirectory.getPath()+"/"+newName);	
		
		if(newfile.exists()) {
			newfile.delete();//удаляем если уже были эти файлы... или можно их переименовывать см.ниже
//			String s =String.valueOf(Math.random());//создаем случайное имя файла
//			newfile = new File(myDirectory.getPath()+"/"+s+".txt");	
//			newfile.renameTo(newfile);
		}
		
		if(file.exists()) {
			file.renameTo(newfile);
			System.out.println("File "+oldName+" is rename: "+newName);
		}
	}
	
	public void print(MyDirectory myDirectory) {
		
		File file = new File(myDirectory.getPath()+getFileName());

        System.out.println("File name: " + file.getName());
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Parent catalog: " + file.getParent());
        System.out.println(file.exists() ? "File/catalog exists." : "File/catalog not exists.");
        System.out.println(file.canWrite() ? "File/catalog available for editing."
                : "\"File/catalog not available for editing.");
        System.out.println(file.canRead() ? "\"File/catalog available for reading." : "\"File/catalog not available for reading");
        System.out.println((file.isDirectory() ? "Directory." : "Not directory."));
        System.out.println(file.isFile() ? "File." : "Not file.");
        System.out.println(file.isAbsolute() ? "Absolute path." : "Not absolute path.");
        System.out.println("Date of last edit: " + file.lastModified());
        System.out.println("Size of: " + file.length() + " byte.");
		
	}
}
