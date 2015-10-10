package java_concurrency_2;


public class SharedInteger implements Runnable{
	// shared Integers of the same object
	private int sharedInt=0,syncSharedInt=0;
	
	// note not a synchronised function
	public void incrementSharedInt(){
		sharedInt++;
	}
	
	// Synchronised function
	public synchronized void incrementInt(){
		syncSharedInt++;
	}
	@Override
	public void run() {
		for (int loopVar = 1; loopVar<=1000000;loopVar++){
		incrementSharedInt();
		incrementInt();
		}
	}
	public int getSharedInt() {
		return sharedInt;
	}
	
	public int getSyncSharedInt() {
		return syncSharedInt;
	}
	public static void main (String args[]){
		
		//Note spawn the two threads on the same objects else they independently work
//		on their respective shared space
		SharedInteger shared = new SharedInteger();
		Thread t1 = new Thread(shared);
		Thread t2 = new Thread(shared);
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Without synchronization :"+shared.getSharedInt());
		System.out.println("With synchronization : "+shared.getSyncSharedInt());
	}
}
