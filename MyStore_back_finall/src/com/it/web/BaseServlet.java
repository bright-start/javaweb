package com.it.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			Class clazz = this.getClass();
			Method m = clazz.getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			System.out.println(m);
			if(m != null) {
				String desPath = (String) m.invoke(this, request,response);
				if(desPath != null) {
					request.getRequestDispatcher(desPath).forward(request, response);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
