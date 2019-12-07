package com.it.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.it.dao.domain.User;
import com.it.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, parameterMap);
			System.out.println(user);	
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String PASSWORD = request.getParameter("password");
		user.setPASSWORD(PASSWORD);
		user.setActiveCode(UUID.randomUUID().toString());
		user.setState(0);
		user.setRole("普通用户");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ss hh:mm:ss");
		Date date = new Date();
		String registTime = df.format(date);
		user.setRegistTime(Timestamp.valueOf(registTime));
		System.out.println(user+"--");
		UserService userService = new UserService();
		try {
			int value = userService.addUserService(user);
			if(value == 1) {
				response.getWriter().write("注册成功");
				response.setHeader("refresh", "3;url=client/login.jsp");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
