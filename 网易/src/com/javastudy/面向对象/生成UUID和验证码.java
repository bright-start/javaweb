package com.javastudy.面向对象;

import java.util.UUID;

public class 生成UUID和验证码 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		System.out.println("-------------------------");
		String verification_code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		verification_code += verification_code.toLowerCase();
		verification_code += "0123456789";
		System.out.println("验证码：");
		for( int i = 0; i<4; i++ ) {
			int index = (int) (Math.random()*(verification_code.length()));
			System.out.print(verification_code.charAt(index));
		}
		
	}

}
