package 中国大学课后习题;

public class Fly {

	public static void main(String[] args) {
		FlyWorld fly=new Bird(); 
		fly.action();
		Bird bird=new Bird();
		bird.CountNum();
		bird.setName("燕子");
		bird.setSpeed(2);
		System.out.println("我的属性:"+"\n name:"+(bird.getName())+"\n speed:"+(bird.getSpeed())+"m/s");
		bird.speck();
		Bee bee=new Bee();
		bee.CountNum();
		bee.getAge();
		bee.eat();
		bee.weight();
		
		System.out.println("现在飞行世界有"+(fly.getNum())+"类动物！");
	}

}
interface Eat{//定义接口
	abstract void eat();		
}
interface Weight{//定义接口
	public void weight();
}
abstract class FlyWorld{//定义一个抽象类
	static int num=0;//定义一个静态字段
	final String animal_kind="飞行世界的飞行者";//定义一个终态字段
	final void action()//定义一个终态方法
	{
		System.out.println(animal_kind);
	}
	void speck() {
		System.out.println("we are animal");
	}

	void CountNum() {
		num++;
	}
	int getNum()//getter
	{
		return num;
	}
}
class Bird extends FlyWorld{//继承FlyWorld类
	String name;
	private int speed;
	void speck() {//重载基类speck()方法     @Override
		System.out.println("I am a bird");
	}
	void setName(String s) {//setter
		name=s;
	}
	String getName() {//getter
		return name;
	}
	public void setSpeed(int speed) {//setter
		this.speed=speed;
	}
	public int getSpeed() {//getter
		return speed;
	}
	
}
class Bee extends FlyWorld implements Eat,Weight{//继承FlyWorld类，实现定义的两个接口
	public final int age=12;//定义一个final字段
	public int getAge() {//getter
		return age;
	}
	public void eat() {
		System.out.println("Bees love to eat nectar!");
	}
	public void weight() {
		System.out.println("The bees are very light weight!");
	}
}
