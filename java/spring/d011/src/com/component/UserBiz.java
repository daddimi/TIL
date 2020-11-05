package com.component;

import com.biz.Biz;

public class UserBiz implements Biz {

	public UserBiz() {
		System.out.println("User Biz Constructor ....");
	}
	@Override
	public void register() {
		System.out.println("User Register");

	}

	@Override
	public void remove() {
		System.out.println("User Remove");

	}

	@Override
	public void modify() {
		System.out.println("User Modify");

	}

}
