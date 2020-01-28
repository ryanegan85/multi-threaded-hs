package multiThreadedHS.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	ArrayList<Integer> data;
	File outputFile;
	
	public Results(String filename) {
		data = new ArrayList<Integer>();
		
		outputFile = new File(filename);
		
		try {
			if(outputFile.createNewFile()) {
				System.out.println("Output file not found, creating one.");
			} else {
				System.out.println("Output file found.");
			}
		} catch (IOException e) {
			System.out.println("Error with files.");
			System.exit(0);
		}
	}
	
	public void addResults(ArrayList<Integer> values) {
		data.addAll(values);
	}
	
	public void printResults() {
		for(int i=0; i<data.size(); i++) {
			writeToStdout(Integer.toString(data.get(i)));
		}
	}
	
	public void sortData() {
		Collections.sort(data);
	}
	
	public void writeToFile() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
			for(int i=0; i<data.size(); i++) {
				bw.write(Integer.toString(data.get(i)));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			writeToStdout("Error writing to file.");
		}
		
	}

	public void writeToStdout(String s) {
		System.out.println(s);	
	}
	
	public ArrayList<Integer> getData() {
		return data;
	}
	
	public void setData(ArrayList<Integer> newData) {
		data = newData;
	}
}
