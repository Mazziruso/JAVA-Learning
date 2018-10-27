package Demo;

public class TestPriority {
	
	public static void main(String[] args) {
		T1 r1 = new T1();
		T2 r2 = new T2();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
	}

}

class T1 implements Runnable {
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("T1: " + i);
		}
	}
}

class T2 implements Runnable {
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("-----T2: " + i);
		}
	}
}
