package Demo;
import java.util.*;

public class TestThreadRun {
	
	public static void main(String[] args) {
		Runner2 r = new Runner2();
		MyThread t = new MyThread(r, "kun");
	
		t.start();
		try {
			t.join();
		} catch(InterruptedException e) {
			
		}
	}

}

class MyThread extends Thread {
	MyThread(Runnable target, String name) {
		super(target, name);
	}
	
	public void run() {
		int i =0;
		while(true) {
			System.out.println("Thread.run()===" + new Date() + "===");
			if(++i == 10) {
				return;
			}
			
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				return;
			}
		}
	}
}

class Runner2 implements Runnable {
	public void run() {
		int i = 0;
		while(true) {
			System.out.println("===" + new Date() + "===");
			if(++i == 10) {
				return;
			}
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				return;
			}
		}
	}
}
