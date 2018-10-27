package Demo;

public class TestYield {
	
	public static void main(String[] args) {
		MyThread3 t1 = new MyThread3("a");
		MyThread3 t2 = new MyThread3("b");
		t1.start();
		t2.start();
	}

}

class MyThread3 extends Thread {
	MyThread3(String name) {
		super(name);
	}
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(this.getName() + ": " + i);
			if(i%10 == 0) {
				Thread.yield();
			}
		}
	}
}
