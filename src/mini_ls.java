import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class mini_ls {

	public static void main(String[] args) {

		
		
		if(args.length==1 && args[0].equals("-r")) {     //drill down to dir after -r

			
			listf(System.getProperty("user.dir"));		//Detection of -r - print all folders and files.

		}
		
		else if(args.length > 1 && args[0].equals("-r")) {		//drill down on current

			
			listf(args[1]);			//Detection of -r - print all folders and files.

		}
		
		else if(args.length>=1) {		//arg that is not -r

			for(int i = 0; i<args.length; i++) {

				
				printFileInfo(args[i]);
			}
		}
		
		else {			//zero arguments

			currentDirectory();
		}

	}
	public static void printFileInfo(String p) {

		Path path = Paths.get(p);
		File file = new File(p);


		if (file.isFile()==true) {
		fileName(path);
		owner(path);
		permission(file);
		modified(file);
		}
		
		else if (file.isDirectory()) {
			System.out.println(file.getName() + " is a folder");
		}
		
		else if (file.isFile()==false) {
			System.out.println("File Name: "+file.getName()+" File does not exist");
		}
		
		
		
		
	}

	public static void fileName(Path path1) {
		
		Path fileName = path1.getFileName();     // call getFileName() and get FileName path object
		
		System.out.println("File Name: "+ fileName.toString());
		System.out.println("======================");
	}

	public static void owner(Path path1) {

		
		FileOwnerAttributeView file = Files.getFileAttributeView(path1, FileOwnerAttributeView.class);    // Create object having the file attribute

		
		try {
			
			UserPrincipal user = file.getOwner(); 				// Taking owner name from the file
			System.out.println("Owner: " + user.getName());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void permission(File file1) {

		try {

			System.out.println("Permissions are: Executable: " + file1.canExecute() 
			+ " Readable: " + file1.canRead()
			+" Writable: "+ file1.canWrite());

		} catch (Exception e) {
			System.out.println(e);
		}
	}	

	public static void modified(File file1) {


		try {
			
			long time1 = file1.lastModified();									//modification
			DateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
			System.out.println("Modified date is : " + sdf.format(time1));
			System.out.println("                                                  ");

		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public static File[] listf(String directoryName) {

		
		File directory = new File(directoryName);			// .............list file

		
		File[] fList = directory.listFiles();				// get all the files from a directory

		for (File file : fList) {
			if (file.isFile()) {
				printFileInfo(file.getAbsolutePath());
			} else if (file.isDirectory()) {
				listf(file.getAbsolutePath());
			}
		}

		return fList;
	}  
	
	public static void currentDirectory() {

		System.out.println("Working Directory = " + System.getProperty("user.dir"));

		File directory = new File(System.getProperty("user.dir"));

		
		File[] fList1 = directory.listFiles();					// get all the files from a directory

		for (File file : fList1) {
			if (file.isFile()) {
				printFileInfo(file.getAbsolutePath());
			}
		}
	}
}