package com.tcphttp;

import java.net.HttpURLConnection;
import java.net.URL;

import com.chat.Client;

public class TcpHttp {

	public static void main(String[] args) {
		Client client = new Client("192.168.0.15", 5555, "[th]"); //이전 Client 그대로 사용
		try {
			client.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		send();
	}

	public static void send() {
		HttpSender sender = null;
		while (true) {
			String urlstr = "http://192.168.0.15/tcpip/temp.jsp";
			URL url = null;
			try {
				double temp = Math.random() * 20;
				url = new URL(urlstr + "?temp=" + temp);
				sender = new HttpSender(temp, url);
				new Thread(sender).start();
			} catch (Exception e) {
//				break;
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class HttpSender implements Runnable {

		URL url = null;
		double temp;

		public HttpSender() {
		}

		public HttpSender(double temp, URL url) {
			this.temp = temp;
			this.url = url;
		}

		@Override
		public void run() {
			HttpURLConnection con = null;
			try {
				con = (HttpURLConnection) url.openConnection();
				con.setReadTimeout(5000);
				con.setRequestMethod("POST");
				con.getInputStream();
				System.out.println("temp:" + temp);
			} catch (Exception e) {

			} finally {
				con.disconnect();
			}
		}

	}

}