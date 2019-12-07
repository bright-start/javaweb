package com.javastudy.面向对象;

public class 多态 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Animal animal = new Animal();
		Animal dog = new Dog();
		Animal cat = new Cat();
		Person per = new Person();
		per.feedAnimal(animal);
		per.feedAnimal(dog);
		per.feedAnimal(cat);
	}

}
class Person{
	void feedAnimal(Animal animal) {
		System.out.println(animal.getClass());
		animal.eat();
		if(animal instanceof Dog) {
			Dog dog = (Dog)animal;
			dog.doWork();
		}else if(animal instanceof Cat) {
			Cat cat = (Cat)animal;
			cat.doWork();
		}
	}
}
class Animal{
	void eat() {
		System.out.println("动物要吃食物！");
	}
}
class Dog extends Animal{
	void eat() {
		System.out.println("狗吃骨头!");
	}
	void doWork() {
		System.out.println("狗汪汪汪！");
	}
}
class Cat extends Animal{
	void eat() {
		System.out.println("猫吃鱼！");
	}
	void doWork() {
		System.out.println("猫抓老鼠！");
	}
}