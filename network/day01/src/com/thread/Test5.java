package com.thread;

class Th1 extends Thread {

	int sum;
	@Override
	public void run() {
		for(int i=1; i<=20; i++) {
			System.out.println("thread 1 Start");
			sum +=i ;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	


	public int getSum() {
		return sum;
	}
}

class Th2 extends Thread {
	int sum;
	@Override
	public void run() {
		for(int i=1; i<=40; i++) {
			System.out.println("thread 2 Start");
			sum +=i ;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	


	public int getSum() {
		return sum;
	}
}

public class Test5 {

	public static void main(String[] args) throws InterruptedException {
		Th1 th1 = new Th1();
		Th2 th2 = new Th2();
		System.out.println("Start");
		
		th1.start();
		System.out.println("Th1 Start");
		
		th2.start();
		System.out.println("Th2 Start");
		
		th1.join();
		th2.join();
		System.out.println(th1.getSum()+" "+th2.getSum());
		System.out.println(th1.getSum()+th2.getSum());

	}

}