package com.thread;

class T1 extends Thread {

	
		String name;
		this.name = name;
		
	
	@Override
	public void run() {
		String name;
		this.name = name;
		for(int i=0; i<=100; i++) {
			
			
		}
	}
	
}

public class Test {

	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.start();
		T1 t1 = new T2();
		t2.start();


	}

}
