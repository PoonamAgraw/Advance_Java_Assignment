package com.demo.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String name = request.getParameter("name");
	out.println("<form action='servlet2' method='get'> ");
	out.println("Location :<input type='text' name='loc' id='loc'><br>");
	out.println("<input type='hidden' name='name' id='name' value='"+name+"'><br>");
	out.println("<button type=\"submit\" name=\"btn\" id=\"btn\"> Submit</button>");
	out.println("</form>");
	}

	

}
