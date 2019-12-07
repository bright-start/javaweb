package com.it.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.it.dao.domain.Goods;
import com.it.service.GoodsService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String searchName = request.getParameter("searchName");
		GoodsService goodsService = new GoodsService();
		Goods goods = null;
		try {
			goods = goodsService.getGoods(searchName);
		} catch (Exception e) {
			if(e.getMessage().equals("")) {
				System.out.println(e.getMessage());
			}else {
				e.printStackTrace();
			}
		}
		response.getWriter().write(new Gson().toJson(goods));
	}

}
