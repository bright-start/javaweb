package com.javastudy.二十三种设计模式.原型模式;

public class Mail implements Cloneable{
	private String receiver;
	private String subject;
	private String content;
	private String tail;
	public Mail(EventTemplate et) {
		this.tail = et.getEventcontent();
		this.subject = et.getEventsubject();
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}

	@Override
	public Mail clone() {
		Mail mail = null;
		try {
			mail = (Mail) super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return mail;
	}

	@Override
	public String toString() {
		return "Mail [receiver=" + receiver + ", subject=" + subject + ", content=" + content + ", tail=" + tail + "]";
	}
	
}
