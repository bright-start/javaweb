package com.javastudy.二十三种设计模式.工厂模式;

import org.junit.Test;

public class TestFactory {
	@Test
	public void test() {
		ICarFactory factory = null;
		//bike
		factory = new BikeFactory();
		Car bike = factory.getCar();
		bike.gotowork();
		//bus
		factory = new BusFactory();
		Car bus = factory.getCar();
		bus.gotowork();
	}
}
