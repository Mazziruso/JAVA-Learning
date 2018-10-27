package Demo;

public class TestJoin {

	public static void main(String[] args) {
		MyThreads t1 = new MyThreads("abcde");
		t1.start();
		
		try {
			t1.join();
		} catch(InterruptedException e) {
			
		}
		
		for(int i=0; i<=10; i++) {
			System.out.println("I am main thread");
		}
		
	}
	
}

class MyThreads extends Thread {
	
	MyThreads(String name) {
		super(name);
	}
	
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println("I am " + this.getName());
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				return;
			}
		}
	}
	
}
