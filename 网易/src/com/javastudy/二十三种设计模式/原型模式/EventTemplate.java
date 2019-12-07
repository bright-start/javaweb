package com.javastudy.二十三种设计模式.原型模式;

public class EventTemplate {
	private String eventcontent;
	private String eventsubject;
	public EventTemplate(String eventcontent, String eventsubject) {
		super();
		this.eventcontent = eventcontent;
		this.eventsubject = eventsubject;
	}
	public String getEventcontent() {
		return eventcontent;
	}
	public String getEventsubject() {
		return eventsubject;
	}
}
