package multiThreadedHS.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileProcessor {
	
	File file;
	
	public FileProcessor(String inputString) {	
		file = new File(inputString);
		
		if(!file.exists()) {
			System.out.println("Input file does not exist. Exiting program.");
			System.exit(0);
		}
	}
	
	//Returns the given line from the given file.
	public String readline(int line) {
		int count = 1;
		String temp = "a";
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				if(count == line) {
					temp = scanner.nextLine();
					scanner.close();
					return temp;
				} else {
					scanner.nextLine();
					count++;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return temp;
	}
	
	//Returns the number of lines in the current file.
	public int numLines() {
		int num = 0;
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				num++;
				scanner.nextLine();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return num;
	}
}
