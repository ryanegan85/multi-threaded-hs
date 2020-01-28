package multiThreadedHS.threads;

import java.util.ArrayList;
import multiThreadedHS.util.*;


public class ThreadWorker extends Thread {
	private String name;
	private ArrayList<Integer> data;
	FileProcessor fp;
	Results res;
	MergeSort ms;
	private boolean runSuccess;
	
	public ThreadWorker(String name, String input, Results res) {
		this.name = name;
		fp = new FileProcessor(input);
		data = new ArrayList<Integer>();
		this.res = res;
		ms = new MergeSort();
		runSuccess = true;
	}
	
	public void run() {
		int numLines = fp.numLines();
		String temp;
		
		for(int i=1; i<=numLines; i++) {
			temp = fp.readline(i);
			data.add(Integer.parseInt(temp));
		}
		
		data = ms.mergeSort(data);
		
		res.addResults(data);
		
		runSuccess = true;
	}
	
	public ArrayList<Integer> getData() {
		return data;
	}
	
	public boolean getRunSuccess() {
		return runSuccess;
	}

}
