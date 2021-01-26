package psp_p2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	static final int NUM_CONSUMERS = 20;
	static final int NUM_PRODUCERS = 90;
	
	public static void main (String []args){
		
		final TaskManager taskManager = new TaskManager (75);
		List<Consumer> consumers = new ArrayList<>();
		List<Producer> producers = new ArrayList<>();
		
		for (int i = 0; i <NUM_CONSUMERS; i ++) {
			consumers.add(new Consumer(i, taskManager));
		}

		for (int i = 0; i <NUM_PRODUCERS; i ++) {
			producers.add(new Producer(i, taskManager));
		}

		for(Consumer c : consumers) {
			c.start();
		}

		for(Producer p : producers) {
			p.start();
		}
		
		for (Consumer c : consumers) {
			try { c.join(); }
			catch(Exception e) {}
		}

		for (Producer p : producers) {
			try { p.join(); }
			catch(Exception e) {}
		}

		System.out.println("Elementos en la cola: " + taskManager.list.size());
		System.out.println("THE END");
	}


}
