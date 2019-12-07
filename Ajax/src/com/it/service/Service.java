package com.it.service;

import com.it.dao.Hero;
import com.it.dao.impl.dao;

public class Service {
	public Hero search(String name) throws Exception{
		System.out.println("+++++++++++"+name);
		dao dao = new dao();
		Hero hero = new Hero();
		hero = dao.search(name);
		return hero;
	}
}
