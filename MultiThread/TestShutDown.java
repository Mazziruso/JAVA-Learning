package Demo;

public class TestShutDown {
	
	public static void main(String[] args) {
		Runner4 r = new Runner4();
		Thread t = new Thread(r);
		t.start();
		
		for(int i=0; i<100000; i++) {
			if((i%10000 == 0) && (i>0)) {
				System.out.println("In thread main i=" + i);
			}
		}
		System.out.println("Thread main is over");
		r.shutDown();
		//t.stop();
	}

}

class Runner4 implements Runnable {
	private boolean flag;
	
	Runner4() {
		this.flag = true;
	}
	
	public void run() {
		
		int i = 0;
		while(this.flag == true) {
			System.out.println(" " + i++);
		}
	}
	
	public void shutDown() {
		this.flag = false;
	}
}
