package Demo;
//import java.util.*;

public class ProducerConsumer {
	public static void main(String[] args) {
		int i = 20;
		SyncStack ss = new SyncStack();
//		Producer p = new Producer(ss, i);
//		Consumer c = new Consumer(ss, i);
		
		Thread[] tp = new Thread[5];
		Thread[] tc = new Thread[5];
		
		for(int j=0; j<tp.length; j++) {
			tp[j] = new Thread(new Producer(ss, i, j), String.valueOf(j));
			tp[j].setPriority(Thread.MAX_PRIORITY);
			tp[j].setDaemon(true);//将所有生产者线程设置为守护线程，该函数要在线程未启动之前调用
			tp[j].start();
		}
		for(int j=0; j<tc.length; j++) {
			tc[j] = new Thread(new Consumer(ss, i, j), String.valueOf(j));
			tc[j].setPriority(Thread.MIN_PRIORITY);
			tc[j].start();
		}

	}

}

class Production {
	int id;
	int Pro_id;
	
	Production(int id, int Pro_id) {
		this.id = id;
		this.Pro_id = Pro_id;
	}
	
	public String toString() {
		return this.Pro_id + "id: " + this.id;
	}
	
}

class SyncStack {
	int index = 0;
	Production[] arrPro = new Production[6];
	
	public synchronized void push(Production p) {
//		if(index == arrPro.length) {
		while(index == arrPro.length) { //最好用while,这样不会出潜在问题（出现Interrupt）
			try {
				this.wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		arrPro[index] = p;
		index++;
		System.out.println("Producer(" + p.Pro_id + ")---(" + p + ")---position= " + (index-1));
		try {
			Thread.sleep(100);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized Production pop(int Con_id, int times) {
//		if(index == 0) {
		while(index == 0) {
			try {
				this.wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		index--;
		Production p = arrPro[index];
		System.out.println("Consumer(" + Con_id + ")---(" + p + ")---position= " 
						   + index + "--------(times: " + times + ")");
		try {
			Thread.sleep(100);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}
} 

class Producer implements Runnable {
	SyncStack ss = null;
	int i;
	int id;
	Producer(SyncStack ss, int i, int id) {
		this.ss = ss;
		this.i = i;
		this.id = id;
	}
	
	public void run() {
		Production p;
		for(int i=0; i<this.i; i++) {
			p = new Production(i, this.id);
			this.ss.push(p);
		}
	}
}

class Consumer implements Runnable {
	SyncStack ss = null;
	int i;
	int id;
	Consumer(SyncStack ss, int i, int id) {
		this.ss = ss;
		this.i = i;
		this.id = id;
	}
	
	public void run() {
		for(int i=0; i<this.i; i++) {
			this.ss.pop(this.id, i);//i代表同一位消费者消费的次数
		}	
	}
}
