package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;



public class App {

	public static void main(String[] args) {
		System.out.println("APP START !");
		AbstractApplicationContext factory = new GenericXmlApplicationContext("com.xml");
		System.out.println("Spring Started>>>>>>>>>>");
		
		Biz biz = (Biz)factory.getBean("ubiz");		//factory란 container가 ubiz를 만들어서 나(biz)한테 준다.
		
		//Spring container가 올라오면서 미리 consturctor 만들어줌
		biz.register();
		biz.modify();

		
		factory.close();
		System.out.println("Spring ENDED<<<<<<<<<<<<");
		System.out.println("App END !");
	}

}
