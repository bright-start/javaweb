package com.it.dao.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Products {
	private String id;
	private String name;
	private Double price;
	private String category;
	private Integer pnum;
	private String imgurl;
	private String description;
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", pnum="
				+ pnum + ", imgurl=" + imgurl + ", description=" + description + "]";
	}
	
}
