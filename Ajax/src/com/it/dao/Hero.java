package com.it.dao;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Hero {
	private Integer id;
	private String name;
	private Integer price;
	private String position;
	private String h_desc;
	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", price=" + price + ", position=" + position + ", h_desc="
				+ h_desc + "]";
	}
	
}
