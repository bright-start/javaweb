package com.it.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.domain.Products;
import com.it.service.ProductsService;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet("/ProductsServlet")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductsService productsService = new ProductsService();
		try {
			List<Products> allProduct = productsService.getAllProduct();
			request.setAttribute("bean.ps", allProduct);
			System.out.println("-----------------------------");
			request.getRequestDispatcher("client/product_list.jsp").forward(request, response);
		} catch (Exception e) {
			if(e.getMessage().equals("无商品信息")) {
				request.setAttribute("productInfo", e.getMessage());
			}else {
				e.printStackTrace();
			}
		}
	}

}
