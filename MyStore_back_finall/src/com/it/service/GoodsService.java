package com.it.service;

import java.sql.SQLException;
import java.util.List;

import com.it.dao.GoodsDao;
import com.it.dao.domain.Goods;
import com.it.dao.domain.PageBean;

public class GoodsService {
	public int addGoods(Goods goods) throws Exception{
		GoodsDao goodsDao = new GoodsDao();
		int value = goodsDao.addGoods(goods);
		if(value == 1) {
			return value;
		}else {
			throw new Exception("添加商品信息失败");
		}
	}
	public int delGoods(String id) throws Exception{
		GoodsDao goodsDao = new GoodsDao();
		int value = goodsDao.delGoods(Integer.parseInt(id));
		if(value == 1) {
			return value;
		}else {
			throw new Exception("删除商品信息失败");
		}
	}
	public int setGoods(Goods goods) throws Exception{
		GoodsDao goodsDao = new GoodsDao();
		int value = goodsDao.setGoods(goods);
		if(value == 1) {
			return value;
		}else {
			throw new Exception("更新商品信息失败");
		}
	}
	public Goods getGoods(String id) throws Exception{
		GoodsDao goodsDao = new GoodsDao();
		Goods goods = goodsDao.getGoods(Integer.parseInt(id));
		if(goods != null) {
			return goods;
		}else {
			throw new Exception("查询不到该商品,请检查商品名字是否有误！");
		}
	}
	public List<Goods> getAllGoods() throws Exception{
		GoodsDao goodsDao = new GoodsDao();
		List<Goods> allGoods = goodsDao.getAllGoods();
		if(allGoods != null) {
			return allGoods;
		}else {
			throw new Exception("无商品信息");
		}
	}
	public PageBean getPageData(Integer currentPage) throws SQLException{
		GoodsDao goodsDao = new GoodsDao();
		PageBean pageBean = new PageBean();
		//设置当前页
		pageBean.setCurrentPage(currentPage);
		//获取数据库中记录总数
		Long count =  goodsDao.getCount();
		pageBean.setTotalCount(count.intValue());
		//一页展示的数据条数
		Integer pageCount = 5;
		//总页数
		pageBean.setTotalPage((int)Math.ceil(1.0*pageBean.getTotalCount()/pageCount));
		//当前页的角标
		Integer index = (pageBean.getCurrentPage() - 1) * pageCount;
		List<Goods> list = goodsDao.getPageData(index,pageCount);
		pageBean.setGoodsList(list);
		return pageBean;
	}
}
