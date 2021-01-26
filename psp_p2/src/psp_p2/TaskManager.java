package psp_p2;

import java.util.ArrayList;
import java.util.List;

public class TaskManager
{
	
	List<Integer> list;

	int maxSize;

	public TaskManager(int size) {
		this. list = new ArrayList<Integer>();
		this.maxSize = size;
	}
	
	public synchronized Integer extract() throws InterruptedException {
		while (list.size() <= 0) { wait(); } 
		
		int n = list.remove(0); 
		notifyAll();
		
		return n;
		
	}
	
	public synchronized void write(Integer llong) throws InterruptedException {
		while (list.size() > this.maxSize) { wait(); }
		
		list.add(llong);
		
		notifyAll();
	}

}
