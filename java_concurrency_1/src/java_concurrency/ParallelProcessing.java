package java_concurrency;

public class ParallelProcessing implements Runnable{
	
	// local variables used to control the run() method
	int choice;

	//default constructor
	public ParallelProcessing(){
	}
	
	
	// Parameterised constructor
	public ParallelProcessing(int choice) {
		this.choice = choice;
	}
	
	public void printThreadName() {
	      Thread t = Thread.currentThread();
	      String name = t.getName();
	      System.out.println("Thread name = " + name);
	   } 
	
	public void printThreadID() {
	      Thread t = Thread.currentThread();
	      Long name = t.getId();
	      System.out.println("Thread ID = " + name +"\n");
	   } 
	@Override
	public void run() {
		
		switch (this.choice){
			case 1:
				System.out.println("Hello World from ");
				printThreadName();
				printThreadID();
				break;
			default: System.out.println("Invalid Choice\n");
		}
		
	}

}
