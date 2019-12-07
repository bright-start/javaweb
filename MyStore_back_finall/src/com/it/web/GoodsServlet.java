package com.it.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.it.dao.domain.Category;
import com.it.dao.domain.Goods;
import com.it.dao.domain.PageBean;
import com.it.service.CategoryService;
import com.it.service.GoodsService;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	public String goodsList(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		/**
		 * 显示全部商品
		 */
		
		try {
			GoodsService goodsService = new GoodsService();
			List<Goods> allGoods = goodsService.getAllGoods();
			//集合反转
			Collections.reverse(allGoods);
			request.setAttribute("allGoods", allGoods);
			return "admin/main.jsp";
		} catch (Exception e) {
			if(e.getMessage().equals("无商品信息")) {
				request.setAttribute("goodsInfo", e.getMessage());
			}else {
				e.printStackTrace();
			}
		}
		return null;
	}
	public String goodsDel(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		/**
		 * 删除商品
		 */
		String id = request.getParameter("id");
		System.out.println(id);
		try {
			GoodsService goodsService = new GoodsService();
			goodsService.delGoods(id);
			request.setAttribute("delGoodsInfo", "商品已成功删除");
			return "GoodsServlet?action=getPageData&currentPage=1";
		} catch (Exception e) {
			if(e.getMessage().equals("删除商品信息失败")) {
				request.setAttribute("delGoodsInfo", e.getMessage());
			}else {
				e.printStackTrace();
			}
		}
		return null;
	}
	public String goodsEditUI(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * 预处理商品信息
		 */
		GoodsService goodsService = new GoodsService();
		String id = request.getParameter("id");
		try {
			
			Goods goods = goodsService.getGoods(id);
			goods.setId(Integer.parseInt(id));
			request.getSession().setAttribute("goods", goods);
		} catch (Exception e) {
			if(e.getMessage().equals("查询不到该商品,请检查商品名字是否有误！")) {
				request.setAttribute("getGoodsInfo", e.getMessage());
			}else {
				e.printStackTrace();
			}
		}
		CategoryService categoryService = new CategoryService();
		try {
			List<Category> allCategory = categoryService.findCategory();
			request.setAttribute("allCategory", allCategory);
		} catch (Exception e) {
			if(e.getMessage().equals("无信息")) {
				System.out.println(e.getMessage());
			}else {
				e.printStackTrace();
			}
		}
		return "admin/edit.jsp";
	}
	public String goodsEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/**
		 * 修改商品信息
		 */
		Map<String, String[]> parameterMap = request.getParameterMap();
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods , parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		System.out.println("-------------------");
		System.out.println(goods);
		GoodsService goodsService = new GoodsService();
		try {
			goodsService.setGoods(goods);
			request.setAttribute("addGoodsInfo", "商品信息已成功修改");
			return "GoodsServlet?action=getPageData&currentPage=1";
		}catch(Exception e) {
			if(e.getMessage().equals("更新商品信息失败")) {
				request.setAttribute("addGoodsInfo", e.getMessage());
			}else {
				e.printStackTrace();
			}
		}
		return null;
	}
	public String goodsAddUI(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		/**
		 * 预处理商品信息
		 */
		CategoryService categoryService = new CategoryService();
		try {
			List<Category> allCategory = categoryService.findCategory();
			request.getSession().setAttribute("allCategory", allCategory);
			return "admin/add.jsp";
		} catch (Exception e) {
			if(e.getMessage().equals("无信息")) {
				System.out.println(e.getMessage());
			}else {
				e.printStackTrace();
			}
		}
		return null;
	}
	public String goodsAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 增加商品
		 */
		Map<String, String[]> parameterMap = request.getParameterMap();
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods , parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		System.out.println("-------------------");
		System.out.println(goods);
		
		GoodsService goodsService = new GoodsService();
		try {
			goodsService.addGoods(goods);
			request.setAttribute("addGoodsInfo", "商品已成功添加");
			return "GoodsServlet?action=getPageData&currentPage=1";
		}catch(Exception e) {
			if(e.getMessage().equals("添加商品信息失败")) {
				request.setAttribute("addGoodsInfo", e.getMessage());
			}else {
				e.printStackTrace();
			}
		}
		return null;
	}
	public String getPageData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//获取当前页
			String currentPage = request.getParameter("currentPage");
			//根据当前页码返回一个pageBean
			GoodsService goodsService = new GoodsService();
			PageBean pageBean = goodsService.getPageData(Integer.parseInt(currentPage));
			request.setAttribute("pageBean", pageBean);
			return "admin/main.jsp";
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
