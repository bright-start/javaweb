package com.it.dao.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class PageBean {
	//当前页
	private Integer currentPage;
	//总记录数
	private Integer totalCount;
	//总页数
	private Integer totalPage;	
	//获取当前页商品信息
	private List<Goods> goodsList = new ArrayList<>();
}
