package com.example.demo.vo;


import lombok.Data;

@Data
public class UserVo {
	private String username;
	private int age;
	public UserVo(String username, int age) {
		this.username = username;
		this.age = age;
	}
}