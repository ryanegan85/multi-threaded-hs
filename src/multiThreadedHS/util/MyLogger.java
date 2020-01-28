package multiThreadedHS.util;

import multiThreadedHS.threads.ThreadWorker;

public class MyLogger {
	
	public MyLogger() {}
	
	public boolean checkSuccess(ThreadWorker t) {
		return t.getRunSuccess();
	}
}