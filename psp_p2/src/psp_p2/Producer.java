package psp_p2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Producer  extends Thread
{
	public TaskManager taskManager;
	private int id;
	
	//constructor
    public Producer ( int id, TaskManager taskManager) {
    	this.id = id;
    	this.taskManager = taskManager;
    }

    @Override
    public void run(){
    	Integer n = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    	try {
    		taskManager.write(n);
    		System.out.println("Producer [" + this.id + "] >>> produces: " + n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Producer error ==> " + e.getMessage());
		}
    	
    }
}
