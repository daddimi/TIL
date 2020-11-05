package com.tcpip;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chat.Client;

@Controller
public class MainController {
	
	Client client;
	
	public MainController() {
		client = new Client("192.168.0.15",5555,"[com]");
		try {
			client.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {	//data와 model을 세팅하면 글로 보낸다.
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/iot.mc")
	public void iot(HttpServletResponse res) throws IOException {
		System.out.println("Iot Send Start");
		client.sendTarget("/192.168.0.15","101");
		PrintWriter out = res.getWriter();
		out.print("ok");
		out.close();
	}
	
	@RequestMapping("/phone.mc")
	public void phone(HttpServletResponse res) throws IOException  {
		System.out.println("Phone Send Start");
		client.sendTarget("/192.168.0.15","102");
		PrintWriter out = res.getWriter();
		out.print("ok");
		out.close();
	}
	
	@RequestMapping("/can.mc")
	public void can(HttpServletResponse res) throws IOException	 {
		System.out.println("Can Send Start");
		client.sendTarget("/192.168.0.15", "103");
		PrintWriter out = res.getWriter();
		out.print("ok");
		out.close();
	}
	
}
