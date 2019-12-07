package com.it.service;

import java.util.List;

import com.it.dao.domain.Products;
import com.it.dao.impl.ProductsDao;

public class ProductsService {
	ProductsDao productsDao = new ProductsDao();
	public List<Products> getAllProduct() throws Exception {
		List<Products> allProduct = productsDao.getAllProduct();
		if(allProduct == null) {
			throw new Exception("无商品信息");
		}
		return allProduct;
	}
}
