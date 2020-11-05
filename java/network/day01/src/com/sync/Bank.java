package com.sync;

public class Bank {

	public static void main(String[] args) {
		Account acc = new Account(3000);
		
		Dth dt1 = new Dth(acc);
		Wth wt1 = new Wth(acc);
		
		Dth dt2 = new Dth(acc);
		Wth wt2 = new Wth(acc);
		
		Dth dt3 = new Dth(acc);
		Wth wt3 = new Wth(acc);
		
		wt1.start();
		dt1.start();
		
		wt2.start();
		dt2.start();
		
		wt3.start();
		dt3.start();
		

	}

}
