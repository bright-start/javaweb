package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.it.dao.domain.Goods;
import com.it.utils.JDBCUtil;

public class GoodsDao {
	private QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
	//增加商品
	public int addGoods(Goods goods) throws SQLException {
		String sql = "insert into goods(name,price,image,g_desc,is_hot,cid) values(?,?,?,?,?,?)";
		int value = qr.update(sql,goods.getName(),goods.getPrice(),goods.getImage(),goods.getG_desc(),goods.getIs_hot(),goods.getCid());
		return value;
	}
	//删除商品
	public int delGoods(int id) throws SQLException {
		String sql = "delete from goods where id=?";
		int value = qr.update(sql,new Integer(id));
		return value;
	}
	//修改商品属性
	public int setGoods(Goods goods) throws SQLException {
		String sql = "update goods set name=?,price=?,image=?,g_desc=?,is_hot=?,cid=? where id=?";
		int value = qr.update(sql,goods.getName(),goods.getPrice(),goods.getImage(),goods.getG_desc(),goods.getIs_hot(),goods.getCid(),goods.getId());
		return value;
	}
	//查询一个商品
	public Goods getGoods(Integer id) throws SQLException{
		String sql = "select *from goods where id=?";
		Goods goods = null;
		goods = qr.query(sql,new BeanHandler<Goods>(Goods.class),id);
		return goods;
	}
	//查询所有商品
	public List<Goods> getAllGoods() throws SQLException{
		String sql = "select *from goods";
		List<Goods> allGoods = null;
		allGoods = qr.query(sql,new BeanListHandler<Goods>(Goods.class));
		System.out.println(allGoods);
		return allGoods;
	}
	//查询商品记录数目
	public Long getCount() throws SQLException {
		String sql = "select count(*) from goods";
		Long count = (Long)qr.query(sql,new ScalarHandler());
		return count;
	}
	public List<Goods> getPageData(Integer index, Integer pageCount) throws SQLException {
		String sql = "select *from goods limit ?,?";
		List<Goods> list = qr.query(sql, new BeanListHandler<Goods>(Goods.class),index,pageCount);
		System.out.println(list);
		return list;
	}

}
