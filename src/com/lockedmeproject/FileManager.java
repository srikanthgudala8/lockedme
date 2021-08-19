package com.lockedmeproject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager 
{
	/**
	 * This method will return the file names from the folder
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> getAllFiles(String folderpath)
	{
		
		//Creating File Object
		File filel= new File(folderpath);
		
		// Getting all the files into file array
		File[] listOfFiles = filel.listFiles();
		
		//Declare a list to store a file names
		List<String> fileNames = new ArrayList<String>();
		
		for(File fl:listOfFiles)
			fileNames.add(fl.getName());
		
		//return the list
		return fileNames;
		 
	}
	
	/**
	 * This method will create or append into file specified
	 * @param folderpath
	 * @param Foldername
	 * @return boolean
	 */
	
	public static boolean createNewFile(String folderpath,String fileName,List<String> content) {
	
		try {
			File file1=new File(folderpath,fileName);
			FileWriter fw=new FileWriter(file1);
			
			for(String s:content)
			{
				fw.write(s+"\n");
			}
			fw.close();
			return true;
			
		}
		catch(Exception Ex) {
			return false;
		}
		
	}
	/**
	 * This method will delete the file if it exists 
	 * @param folderpath
	 * @param fileName
	 * @return
	 */
	
	public static boolean deleteFile(String folderpath,String fileName) 
	{
		File file = new File(folderpath+"\\"+fileName);
		
		try {
			if(file.delete())
				return true;
			else
				return false;
		}
		catch(Exception Ex) {
			return false;
		}
		
	}
	
	
	/**
	 * This method will search the file from the folder
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	
	public static boolean searchFile(String folderpath,String fileName) 
	{
		File file = new File(folderpath+"\\"+fileName);
		
		if(file.exists()) {
			return true;
		}
		else
			return false;
		
	}
 }
