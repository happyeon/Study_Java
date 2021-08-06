package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class MTest01 {
	
	public static void main(String[] args) throws URISyntaxException {
		
		URI uri = new URI("http://localhost:8787/Java_19_URI_Web/res.jsp?name=%EC%9D%B4%EC%88%98%EC%97%B0&addr=%EC%84%9C%EC%9A%B8");
		
		System.out.println(uri.getScheme());
		System.out.println(uri.getHost());
		System.out.println(uri.getPort());
		System.out.println(uri.getPath());
		System.out.println(uri.getQuery());
	}

}
