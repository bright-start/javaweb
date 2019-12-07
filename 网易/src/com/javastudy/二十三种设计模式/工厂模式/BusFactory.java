package com.javastudy.二十三种设计模式.工厂模式;

public class BusFactory implements ICarFactory{

	@Override
	public Car getCar() {
		// TODO 自动生成的方法存根
		return new Bus();
	}

}
