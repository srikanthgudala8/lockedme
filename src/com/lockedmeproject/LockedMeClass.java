package com.lockedmeproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeClass {
	
	static final String folderpath="G:\\Lockedme project\\Files";
	public static void main(String[] args) {
		
		int proceed=1;
			
		
		do {
				//Variable declaration
				int ch;
				
				//Display Menu
				ch=displayMenu();
				
				
				switch(ch) {
				case 1: getAllFiles();
						break;
				case 2: createNewFile();
						break;
				case 3:deleteFile();
						break;
				case 4:searchFile();
						break;
				case 5:System.exit(0);
						break;
				default:System.out.println("invalid Selection");
						break;
				}
				
		}
			while(proceed>0);
	}
	
	/**
	 * This method displays Main Menu to the user.
	 */
	
	public static int displayMenu() {
		Scanner obj= new Scanner(System.in);
		int ch;
		System.out.println();
		System.out.println(" ******************************************************************");
		System.out.println("\t\t\t Lockedme.com");
		System.out.println(" ******************************************************************");
		System.out.println(" 1. Display all files");
		System.out.println(" 2. Create a new file");
		System.out.println(" 3. Delete the existing file");
		System.out.println(" 4. Search the file");
		System.out.println(" 5. Exit");
		System.out.println(" ******************************************************************");
		System.out.println(" Please enter your choice:");
		ch=Integer.parseInt(obj.nextLine());
		
		return ch;
	}
	
	/**
	 * This method will display all the files in the folder.
	 */
	
	public static void getAllFiles() {
		
	List<String>fileNames =FileManager.getAllFiles(folderpath);
	
		if(fileNames.size()==0) {
			System.out.println("No files in the directory");
		}
		else {
			System.out.println("File list is below \n");
			for(String f:fileNames)
				System.out.println(f);
		}
		
	}
	
	/**
	 * This method will create new files.
	 */
	
	public static void createNewFile()
	{
		//Declaring the variable
		Scanner obj= new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();
		
		//Read file name from the user
		System.out.println("Enter file Name:");
		fileName=obj.nextLine();
		
		//Read number of lines from the user
		System.out.println("Enter how many lines in the file:");
		linesCount=Integer.parseInt(obj.nextLine());
		
		//Read data from the user
		for(int i=1;i<=linesCount;i++)
		{
			System.out.println("Enter line"+i+":");
			content.add(obj.nextLine());
		}
		
		//Save the content into the file
		boolean isSaved=FileManager.createNewFile(folderpath, fileName, content);
		
		if(isSaved)
			System.out.println("File and Data are saved successfully");
		else
			System.out.println("Some error occured");		
	}
	
	/**
	 * This method will delete the existing  files from the folder.
	 */
	public static void deleteFile() {
		
		String fileName;
		Scanner obj =new Scanner(System.in);
		System.out.println("Enter the file which you have to delete:");
		fileName= obj.nextLine();
		
		boolean isDelete=FileManager.deleteFile(folderpath, fileName);
		
		if(isDelete) {
			System.out.println("File deleted successfully");
		}
		else {
			System.out.println("Either file not there or some access issue");
		}

	}
	
	
	/**
	 * This method will search the files to the user.
	 */
	public static void searchFile() {
		

				String fileName;
				Scanner obj =new Scanner(System.in);
				System.out.println("Enter the file name to be searched:");
				fileName= obj.nextLine();
				
				boolean isFound=FileManager.searchFile(folderpath, fileName);
				
				if(isFound) {
					System.out.println("File is available in the folder");
				}
				else {
					System.out.println("File not available in the folder");
				}
				

	}
}



