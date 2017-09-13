package assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FW {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File newFile = new File("file.txt");
		try {
			newFile.createNewFile();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(newFile);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Hello world!");
			bufferedWriter.close();
			System.out.println("file printed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
