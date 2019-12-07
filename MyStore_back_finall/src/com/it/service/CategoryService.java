package com.it.service;

import java.util.List;

import com.it.dao.CategoryDao;
import com.it.dao.domain.Category;

public class CategoryService {
	
	public List<Category> findCategory() throws Exception {
		CategoryDao categoryDao = new CategoryDao();
		List<Category> allCategory = null;
		allCategory = categoryDao.getAllCategory();
		if(allCategory == null) {
			throw new Exception("无信息");
		}
		return allCategory;
	}
}
