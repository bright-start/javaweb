package com.it.dao.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Goods {
	private Integer id;
	private String name;
	private Double price;
	private String  image;
	private String g_desc;
	private Integer is_hot;
	private Integer cid;
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", g_desc=" + g_desc
				+ ", is_hot=" + is_hot + ", cid=" + cid + "]";
	}
}
