package psp_p2;

public class Consumer extends Thread
{
    public TaskManager taskManager;
    private int id;

    //constructor
	public Consumer (int id, TaskManager taskManager) {
		this.id = id;
    	this.taskManager = taskManager;
    }

    @Override
	public void run(){
		try{
			int n = taskManager.extract();
			System.out.println("Consumer [" + this.id + "] >>> consumes: " + n);
		} catch (InterruptedException e) {
			 System.out.println("Consumer error ==> " + e.getMessage());
		}
	}
}
