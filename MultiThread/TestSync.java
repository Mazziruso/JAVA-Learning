package Demo;

public class TestSync implements Runnable{
	
	Timer timer = new Timer();
	
	public static void main(String[] args) {
		TestSync r = new TestSync();
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		t1.start();
		t2.start();
	}
	
	public void run() {
		this.timer.add(Thread.currentThread().getName());
	}
	
	

}

//class Timer{
//	private static int num = 0;
//	public void add(String name) {
//		synchronized(this) {
//			num++;
//			try {
//				Thread.sleep(2000);
//			} catch(InterruptedException e) {
//				
//			}
//			System.out.println(name + ", you're the No." + num + " thread excuting timer!");
//		}
//	}
//}

class Timer{
	private static int num = 0;
	synchronized public void add(String name) {
		num++;
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			
		}
		System.out.println(name + ", you're the No." + num + " thread excuting timer!");
	}
}
