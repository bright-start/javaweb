package jvm;

public class Person {
	private String name = "haha";
	static int age = 0;
	Person(String n, int age){
		if(age < 0) {
			System.out.println("���Ի����Ϸ�");
			return ;
		}
		name = n;
		System.out.println(age);
		System.out.println(Person.age);
		age = ++age;
		System.out.println(name+":"+Person.age);
		return ;
	}
}
class PersonTest{
	public static void main(String[] args) {
		Person p = new Person("Сǿ",Person.age--);
		System.out.println(Person.age);
	}
}
