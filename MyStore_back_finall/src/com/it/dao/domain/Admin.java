package com.it.dao.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Admin {
	private String uid;
	private String username;
	private String password;
	private String image;
	@Override
	public String toString() {
		return "Admin [uid=" + uid + ", username=" + username + ", password=" + password + ", image=" + image + "]";
	}

	
}
