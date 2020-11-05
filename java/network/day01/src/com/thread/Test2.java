package com.thread;


class T1 extends Thread {

	
	String name;
	this.name = name;
	

@Override
public void run() {
	String name;
	this.name = name;
	for(int i=0; i<=100; i++) {
		data2 += i;
		System.out.println(data2);
		Thread.sleep(300);
		try {
			Thread.sleep(1000);
		} catch (Interrupt e){
			e.printStackTrace();
		}
}

}

public class Test2 {

public static void main(String[] args) {
	Thread t1 = new Thread(new Th("T1"));
	t1.start();
	t1.setPriority(10);
	Thread t2 = new Thread(new Th("T2"));
	t2.start();
	t2.setPriority(2);


}

}
