package com.franconnect.baseutils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ABC extends HttpServlet{
	public static void add(String abcd) throws IOException, ServletException{
		System.out.println("Value of abce "+abcd);
	}
}
