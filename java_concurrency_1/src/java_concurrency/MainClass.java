package java_concurrency;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		int choice;
		List <Thread> threadPool = new ArrayList<Thread>();
		System.out.println("Enter choice\n 1. Spawn 1 thread \n 2. Spawn 2 threads \n");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		choice = in.nextInt();
		switch(choice){
			case 1:
				Thread displayMessage = new Thread(new ParallelProcessing(1));
				displayMessage.start();
				try {
					displayMessage.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				break;
			case 2:
				for(int loop = 0; loop < 5; loop++){
					threadPool.add(new Thread(new ParallelProcessing(1)));
					threadPool.get(loop).start();
				}
				for (Thread thread: threadPool){
					try {
						thread.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			default: System.out.println("Invalid Choice");	
		}
		ParallelProcessing concurrentObject = new ParallelProcessing(); 
		System.out.println("Hello World from ");
		concurrentObject.printThreadName();
		concurrentObject.printThreadID();

	}

}
