package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import com.demo.beans.*;
import com.demo.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/validateuser")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		LoginService lservice = new LoginServiceImpl();
		MyUser user = lservice.validateuser(uname,pass);
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			RequestDispatcher rd = request.getRequestDispatcher("category");
			rd.forward(request, response);
		}
		else {
			out.println("Invalid Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
	}

}
