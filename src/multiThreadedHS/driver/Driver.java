package multiThreadedHS.driver;

import java.util.ArrayList;
import java.util.Collections;
import multiThreadedHS.threads.ThreadWorker;
import multiThreadedHS.util.*;


public class Driver {
	
	public static void main(String[] args) {
		int n = 0;
		String input1 = "";
		String input2 = "";
		String input3 = "";
		String output = "";
		int debugValue = 0;
		ArrayList<Integer> data = new ArrayList<Integer>();
		Results res;
		MyLogger logger = new MyLogger();
		
		//Possible valid args length: 4, 5, 6
		if(args.length < 4 || args.length > 6) {
			System.out.println("Proper arg format is: <N> <N input files> <output file> <debugValue>");
			System.exit(0);
		}
		

		if(args.length == 4) {
			try {
				n = Integer.parseInt(args[0]);
				input1 = args[1];
				output = args[2];
				debugValue = Integer.parseInt(args[3]);
			} catch(NumberFormatException e) {
				System.out.println("ERROR: N and debugValues must be integers.");
				System.exit(0);
			}
		}
		
		if(args.length == 5) {
			try {
				n = Integer.parseInt(args[0]);
				input1 = args[1];
				input2 = args[2];
				output = args[3];
				debugValue = Integer.parseInt(args[4]);
			} catch(NumberFormatException e) {
				System.out.println("ERROR: N and debugValues must be integers.");
				System.exit(0);
			}
		}
		
		if(args.length == 6) {
			try {
				n = Integer.parseInt(args[0]);
				input1 = args[1];
				input2 = args[2];
				input3 = args[3];
				output = args[4];
				debugValue = Integer.parseInt(args[5]);
			} catch(NumberFormatException e) {
				System.out.println("ERROR: N and debugValues must be integers.");
				System.exit(0);
			}
		}
		
		res = new Results(output);
		
		if(n < 1 || n > 3) {
			System.out.println("ERROR: N must be between 1 and 3.");
			System.exit(0);
		}
		
		if(debugValue != 0 && debugValue != 1) {
			System.out.println("Debug value must be 0 or 1.");
			System.exit(0);
		}
		
		if(n == 1) {
			ThreadWorker t1 = new ThreadWorker("Thread 1", input1, res);
			
			t1.start();
			
			try {
				t1.join();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(0);
			}
			
			if(debugValue == 1) {
				if(logger.checkSuccess(t1)) {
					System.out.println("All threads successfully ran.");
				} else {
					System.out.println("Not all threads successfully ran.");
				}
			}
		}
		
		if(n == 2) {
			ThreadWorker t1 = new ThreadWorker("Thread 1", input1, res);
			ThreadWorker t2 = new ThreadWorker("Thread 2", input2, res);
			
			t1.start();
			t2.start();

			try {
				t1.join();
				t2.join();

			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(0);
			}
			
			if(debugValue == 1) {
				if(logger.checkSuccess(t1) && logger.checkSuccess(t2)) {
					System.out.println("All threads successfully ran.");
				} else {
					System.out.println("Not all threads successfully ran.");
				}
			}
		}
		
		if(n == 3) {
			ThreadWorker t1 = new ThreadWorker("Thread 1", input1, res);
			ThreadWorker t2 = new ThreadWorker("Thread 2", input2, res);
			ThreadWorker t3 = new ThreadWorker("Thread 3", input3, res);
			
			t1.start();
			t2.start();
			t3.start();
			
			try {
				t1.join();
				t2.join();
				t3.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(0);
			}
			
			if(debugValue == 1) {
				if(logger.checkSuccess(t1) && logger.checkSuccess(t2) && logger.checkSuccess(t3)) {
					System.out.println("All threads successfully ran.");
				} else {
					System.out.println("Not all threads successfully ran.");
				}
			}
		}
		
		MergeSort ms = new MergeSort();
		data = ms.mergeSort(res.getData());
		res.setData(data);
		
		res.writeToFile();
		//res.printResults();

	}
}
