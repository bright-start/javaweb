package com.it.dao.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class User {
	private Integer id;
	private String username;
	private String PASSWORD;
	private String gender;
	private String email;
	private String telephone;
	private String introduce;
	private String activeCode;
	private Integer state;
	private String role;
	private Timestamp registTime;
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", PASSWORD=" + PASSWORD + ", gender=" + gender
				+ ", email=" + email + ", telephone=" + telephone + ", introduce=" + introduce + ", activeCode="
				+ activeCode + ", state=" + state + ", role=" + role + ", registTime=" + registTime + "]";
	}
	
	
}
