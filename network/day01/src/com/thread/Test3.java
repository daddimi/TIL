package com.thread;

import java.util.Scanner;

class Thread1 implements Runnable {
	
	boolean flag = true;
	
		
	public Thread1() {}
	
	public void setFlag(boolean flag) {
		
	}
		
	
//	public Thread1 (String name) {
//		this.name = name;
//	}

	@Override
	public void run() {
		System.out.println("Start");
		while(true) {
			if(flag == false) {
				System.out.println("Stop...");
				break;
			}
			//System.out.println("Connecting...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("End");
			
		}
		// ������ ������ ������ ���� ������ ������ �� �ؿ� ���� �������� �ʱ� ������ �������� ���.
		//System.out.println("End"); 
	}
	
	




public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		
		Thread1 r = new Thread1();
		Thread t1 = null;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.prinln("Input Cmd");
			String cmd = sc.nextLine();
			if(cmd.equals("start")) {
					t1 = new Thread1();
					t1.start();
			} else if(cmd.contentEquals("stop")) {
				r.setFlag(false);
			}else {
				break;
			}
		
		}

	}
	
}





}


}

