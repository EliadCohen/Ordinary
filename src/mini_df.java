import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class mini_df {

	public static void main(String[] args) {
		if(args.length == 0) {
			String currentDir = System.getProperty("user.dir");//Get the current directory
			printDirectoryInfo(currentDir);
		}
		else {
			for(String str : args) {
				printDirectoryInfo(str);
			}
		}	
	}
	
	public static void printDirectoryInfo(String pathStr) {
		
		File file = new File(pathStr);
		
		if(file.isDirectory() && file.exists()) {
			//Path path = Paths.get(pathStr);
			File[] fileList = file.listFiles();		
			long size = 0;
			//long usedSize = 0;
			for (File fileItem : fileList) {
				size += directorySize(fileItem.getAbsolutePath());
				//usedSize += directoryUsedSize(fileItem.getAbsolutePath());
			}
			
			
			System.out.println(file.getName() + " size is " + size + " Bytes");
			System.out.println();
			//System.out.println(file.getName() + " Total space is " + usedSize + " Bytes");
		}
		else {
			System.out.println(file.getName() + " is Illegal");
		}
		
		printDiskSpace(pathStr);
	}
	
	public static void printDiskSpace(String pathStr) {
		File f = new File(pathStr);
		System.out.println("Total space is: "+ f.getTotalSpace() +" Bytes");
		System.out.println("Free space is: "+ f.getFreeSpace() +" Bytes");
	}
	
	public static long directorySize(String directoryName) {

		long size = 0;
		File directory = new File(directoryName);			// .............list file
		
		File[] fList = directory.listFiles();				// get all the files from a directory

		if(fList != null){
			for (File file : fList) {
				if (file.isFile()) {
					size += file.length();
				} else if (file.isDirectory()) {
					size += directorySize(file.getAbsolutePath());
				}
			}
		}
		else if(directory.isFile()) {
			
			size += directory.length();
		}

		return size;
	} 
	
	public static long directoryUsedSize(String directoryName) {

		long size = 0;
		File directory = new File(directoryName);			// .............list file
		
		File[] fList = directory.listFiles();				// get all the files from a directory

		if(fList != null){
			for (File file : fList) {
				if (file.isFile()) {
					size += file.getFreeSpace();
				} else if (file.isDirectory()) {
					size += directorySize(file.getAbsolutePath());
				}
			}
		}
		else if(directory.isFile()) {
			
			size += directory.getFreeSpace();
		}

		return size;
	}
}
