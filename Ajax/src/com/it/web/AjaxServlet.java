package com.it.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.it.dao.Hero;
import com.it.service.Service;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求编码方式
		request.setCharacterEncoding("utf-8");
		//设置响应编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String name = request.getParameter("name");
		name =  java.net.URLDecoder.decode(name,"utf-8");
		//处理请求信息
		Service service = new Service();
		Hero hero = new Hero();
		try {
			hero = service.search(name);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//响应处理结果
//		response.getWriter().write("今天天气不错");
		if(hero != null)
		{
			response.getWriter().write(new Gson().toJson(hero));
		}
	}

}
