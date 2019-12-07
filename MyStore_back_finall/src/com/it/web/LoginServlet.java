package com.it.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.it.dao.domain.Admin;
import com.it.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginService loginService = new LoginService();
		try {
			Admin admin = loginService.login(username,password);
			System.out.println("登陆成功");
			request.getSession().setAttribute("admin", admin);
			response.setHeader("refresh", "1;url=/MyStore_back/admin/admin_index.jsp");
		} catch (Exception e) {
			if(e.getMessage().equals("用户名或密码错误")) {
				System.out.println("登录失败");
				System.out.println("用户名或密码错误");
				request.setAttribute("err", e.getMessage());
				request.getRequestDispatcher("/admin/admin_login.jsp").forward(request, response);
			}else {
				e.printStackTrace();
			}
		}
	}

}
