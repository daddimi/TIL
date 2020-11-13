package com.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.client.Client;

@Controller
public class MainController {
	
//	Client client;
//	
//	public MainController() {
//		client = new Client("192.168.0.15",5555,"[com]");
//		try {
//			client.connect();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {	//data와 model을 세팅하면 글로 보낸다.
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
//	@RequestMapping("/qr.mc")
//	public void iot(HttpServletResponse res) throws IOException {
//		System.out.println("Iot Send Start");
//		PrintWriter out = res.getWriter();
//		out.print("ok");
//		out.close();
//	}
//	

	
	
}
