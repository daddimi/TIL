package com.thread;

class Tt extends Thread {
	


@Override
	public void run() {
		while(true) {
			System.out.println("Thread...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class Test4 {



	public static void main(String[] args) throws InterruptedException {
		Tt tt = new Tt();
		tt.setDaemon(true);
		tt.start();
		Thread.sleep(10000);
		System.out.println("End Application....");


	}

}