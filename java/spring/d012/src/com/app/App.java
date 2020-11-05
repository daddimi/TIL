package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;



public class App {

	public static void main(String[] args) {
		System.out.println("APP START !");
		AbstractApplicationContext factory = new GenericXmlApplicationContext("com.xml");
		System.out.println("Spring Started>>>>>>>>>>");
		
		Biz biz = (Biz)factory.getBean("ubiz");		//factory�� container�� ubiz�� ���� ��(biz)���� �ش�.
		
		//Spring container�� �ö���鼭 �̸� consturctor �������
		biz.register();
		biz.modify();

		
		factory.close();
		System.out.println("Spring ENDED<<<<<<<<<<<<");
		System.out.println("App END !");
	}

}
