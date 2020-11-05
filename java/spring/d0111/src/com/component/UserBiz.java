package com.component;

import org.springframework.stereotype.Component;

import com.biz.Biz;
@Component("ubiz")

/*��Ŭ������ �̸��� ubiz�� �ȴ�*/
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
