package com.it.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.domain.User;
import com.it.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String PASSWORD = request.getParameter("password");
		String[] values = request.getParameterValues("checkbox");
		System.out.println(Arrays.toString(values));
		System.out.println(username +"-"+PASSWORD);
		UserService userService = new UserService();
		User user = null;
		try {
			user = userService.getUserService(username, PASSWORD);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("---------------------");
		System.out.println(user);
		
		if(user != null) {
			if(values != null && values.length > 0 ) {
				if(values[0].equals("checkbox01")) {
					Cookie cookie = new Cookie("username", username);
					cookie.setMaxAge(60*60*24*15);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
				}else if(values[1].equals("checkbox02")) {
					Cookie cookie = new Cookie("autologin","autologin");
					cookie.setMaxAge(60*60*24*15);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);	
					Cookie cookie_username = new Cookie("username", username);
					cookie.setMaxAge(60*60*24*15);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie_username);
					Cookie cookie_psssword = new Cookie("password",PASSWORD);
					cookie.setMaxAge(60*60*24*15);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie_psssword);
					
				}
			}
			request.getSession().setAttribute("user", user);
			response.getWriter().write("login success!!!");
			response.sendRedirect(request.getContextPath()+"/ProductsServlet");
		}else {

			request.getRequestDispatcher("client/login.jsp").forward(request, response);
		}
	}

}
