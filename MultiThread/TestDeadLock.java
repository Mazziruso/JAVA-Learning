package Demo;

public class TestDeadLock implements Runnable {
	public int flag = 1;
	static Object o1 = new Object();
	static Object o2 = new Object();
	
	public void run() {
		System.out.println("flag= " + flag);
		if(this.flag == 1) {
			synchronized(TestDeadLock.o1) {
				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(TestDeadLock.o2) {
					System.out.println("1");
				}
			}
		}
		if(this.flag == 0) {
			synchronized(TestDeadLock.o2) {
				try {
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(TestDeadLock.o1) {
					System.out.println("0");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TestDeadLock tdl1 = new TestDeadLock();
		TestDeadLock tdl2 = new TestDeadLock();
		Thread t1 = new Thread(tdl1);
		Thread t2 = new Thread(tdl2);
		tdl1.flag = 1;
		tdl2.flag = 0;
		
		t1.start();
		t2.start();
	}

}
