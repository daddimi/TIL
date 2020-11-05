package com.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Search;
import com.frame.Service;
import com.vo.Item;
import com.vo.User;


public class App {
	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Service service = 
				(Service)factory.getBean("userservice");
	
		User user = new User("id66", "pwd66", "±Ë«≥πÆ");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("INSERT NUM: ");
		switch(sc.nextInt()) {
		case 1:
			try {
				service.register(user);
				System.out.println("OK");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				service.remove("id66");
				System.out.println("Delete OK");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				service.modify(user);
				System.out.println("UPDATE OK");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 4:
			try {
				System.out.println(service.get("id01"));
				System.out.println("SELECT OK");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 5:
			try {
				System.out.println(service.get());
				System.out.println("SELECT ALL OK");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;				
		}
		Service service2 = 
				(Service)factory.getBean("itemservice");
		Date date = new Date();
		Item item = new Item("id02", "pants02", 100000, date);
		System.out.println("Insert New Num: ");
		switch(sc.nextInt()) {
		case 1:
			try {
				service2.register(item);
			} catch (Exception e) {
				System.out.println("FAIL");
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				service2.remove("id88");
				System.out.println("Delete OK");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case 3:
			try {
				service2.modify(item);
				System.out.println("UPDATE OK");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;			
		case 4:
			try {
				System.out.println(service2.get("id88"));
				System.out.println("SELECT OK");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 5:
			try {
				System.out.println(service2.get());
				System.out.println("SELECT ALL OK");
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		
		sc.close();
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}
}
