import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.lang.*;
class Test {
	//public static CountDownLatch latch = new CountDownLatch(1);
	public static Thread t; 
	public static long start;
	
	static {
		//t = new Thread(new A(latch));
		start = System.nanoTime();
		System.out.println("In Static Block time= "+(((System.nanoTime()-start)/1e6))+ " ms");
		t = new Thread(new A(start));
		t.start();
	}
	public static void main(String ...args) {
		try {
        	//latch.await();
			//System.out.println("In main latch= "+latch);
			System.out.println("In main thread "+((System.nanoTime() - start)/1e6)+ " ms");
		}catch(Exception e) {}
		System.out.println("In main end "+((System.nanoTime() - start)/1e6)+ " ms");
	}
}	
class A implements Runnable {
   	private CountDownLatch latch=null;
	private long start;	
	A(long start) {
		this.start = start;
		System.out.println("In A Constructor time= "+((System.nanoTime() - this.start)/1e6)+" ms");
	}
	A(CountDownLatch l) {
		this.latch = l;
	}
	public void run() {
		System.out.println("In run thread "+((System.nanoTime() - start)/1e6)+ " ms");
		//latch.countDown();
		//System.out.println("In run latch= "+latch);
	}
	public void finalize() {
		System.out.println("In run end"+((System.nanoTime() - start)/1e6)+ " ms");
	}
}
