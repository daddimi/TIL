package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.UserVO;

@Controller
public class MainController {
	//ID PWD �������� �뵵
	@Resource(name="ubiz")
	Biz<String, UserVO> biz;
	
	
	//dispatcher�� �˾Ƽ� index.html�� ���� �ִ� main.mc�� �ش� �ϴ� �κ��� �Ϸ� ������ �ڵ����� �� �Լ��� �����Ŵ
	@RequestMapping("/main.mc")
	public ModelAndView main() {	//data�� model�� �����ϸ� �۷� ������.
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/login.mc")
	public ModelAndView login() {	//data�� model�� �����ϸ� �۷� ������.
		ModelAndView mv = new ModelAndView();
		mv.addObject("centerpage", "login");	//centerpage�� login�� ��
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/loginimpl.mc")
	public ModelAndView loginimpl(HttpServletRequest request) {	//data�� model�� �����ϸ� �۷� ������.
		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		UserVO dbuser = null;
		try {
			dbuser = biz.get(id);
			if(dbuser.getPwd().equals(pwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("loginuser", dbuser);
				mv.addObject("centerpage", "loginok");
			}else {
				mv.addObject("centerpage", "loginfail");
			}
		} catch (Exception e) {
			mv.addObject("centerpage", "loginfail");
			e.printStackTrace();
		}
		
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/logout.mc")
	public ModelAndView logout(HttpServletRequest request) {	//data�� model�� �����ϸ� �۷� ������.
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if(session!= null) {
			session.invalidate();
		}
		mv.setViewName("main");
		return mv;
	}
}
