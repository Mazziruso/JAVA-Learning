package Demo;
import java.util.*;

public class TestInterrupt {
	
	public static void main(String[] args) {
		Runner1 r = new Runner1();
		Thread t = new Thread(r);
		t.start();
		
		try {
			Thread.sleep(10000);
		} catch(InterruptedException e) {
			
		}
		
		t.interrupt();
	}

}

//class Runner1 extends Thread {
class Runner1 implements Runnable {

	public void run() {
		while(true) {
			System.out.println("===" + new Date() + "===");
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				return;
			}
		}
	}
}
