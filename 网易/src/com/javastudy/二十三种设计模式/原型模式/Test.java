package com.javastudy.二十三种设计模式.原型模式;

public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int i = 0;
		int MAX_COUNT = 10;
		EventTemplate et = new EventTemplate("邀请函（不变）","婚嫁生日。。。（不变部分）");
		Mail mail = new Mail(et);
		while(i < MAX_COUNT) {
			Mail cloneMail = mail.clone();
			mail.setReceiver("xxx" + i + "先生");
			mail.setTail("xxxx-xx-xx");
			cloneMail.setContent("XXX先生（变化部分）"+mail.getTail());
			cloneMail.setReceiver("每个人的邮箱地址（变化部分）");
			sendMail(cloneMail);
			i++;
		}
	}

	private static void sendMail(Mail cloneMail) {
		System.out.println(cloneMail);
	}
}
