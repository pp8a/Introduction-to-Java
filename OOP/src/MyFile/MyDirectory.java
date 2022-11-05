package MyFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class MyDirectory {
	private String catalogName;
	private String directory;
	private MyFile[] myFiles;
	public String path;
	
	public MyDirectory(String catalogName, String directory, MyFile[] myFiles) {
		super();
		this.catalogName = catalogName;
		this.directory = directory;
		this.myFiles = myFiles;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public MyFile[] getMyFiles() {
		return myFiles;
	}

	public void setMyFiles(MyFile[] myFiles) {
		this.myFiles = myFiles;
	}	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "MyDirectory [catalogName=" + catalogName + ", directory=" + directory + ", myFiles=" + Arrays.toString(myFiles)
				+ "]";
	}	
	
	public void createDirectory() {
		File theDir = new File(getDirectory()+getCatalogName());		
		if (!theDir.exists()){				
		    theDir.mkdirs();
		    System.out.println("The directory \""+getDirectory()+getCatalogName()+"\" has been created!");
		    setPath(getDirectory()+getCatalogName());
		}else {
			System.out.println("The directory \""+getDirectory()+getCatalogName()+"\" is exists!");
		}
		if(getPath()==null) {
			setPath(getDirectory()+getCatalogName());
		}
	}
	
	public void createDirectory(String directory) throws IOException{
		Path path = Paths.get("src/path/"+directory);
		
		if(Files.isDirectory(path)) {
			System.out.println("The directory: \""+path+"\" is exists!");
		}else {
			Files.createDirectories(path);
			System.out.println("The directory: \""+path+"\" created.");
		}
	}
	
	public String[] printGetFile() {		
		String catalogName = getPath();
        File catalog = new File(catalogName);
        String[] list = null;
        if (catalog.isDirectory()) {
            System.out.println("Folder " + "\""+catalogName+"\":");
            list = catalog.list();//содержимое каталога         
            
            if (list != null) {            	
                for (String fileName : list) {
                    File file = new File(catalogName + "/" + fileName);
                    if (file.isDirectory()) {
                        System.out.printf("\t%s folder%n", fileName);
                    }else {
                        System.out.printf("\t%s file%n", fileName);                        
                    }
                }
            }
            
        } else {
            System.out.println(catalogName + " don't catalog");
        }		
        return list;
	}
	
	public void initMyFiles(String[] list) {
//		MyFile newFile = new MyFile();
		
		myFiles = new MyFile[list.length];
		for (int i = 0; i < list.length; i++) {
//			newFile.setFileName(list[i]);
//			myFiles[i] = new MyFile(newFile.getFileName());
			myFiles[i] = new MyFile(list[i]);
		}
	}
}
