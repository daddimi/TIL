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
		// 문법상 문제는 없지만 무한 루프를 돌리면 이 밑에 까지 내려오지 않기 때문에 빨간줄이 뜬다.
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

