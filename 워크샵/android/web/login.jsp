<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	//Thread.sleep(3000);
	System.out.println(id+" "+pwd);
	if(id.equals("id01") && pwd.equals("pwd01")) {
		out.print("1");
	} else {
		out.print("2");
	}

%>