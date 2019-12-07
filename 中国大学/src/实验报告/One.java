package 实验报告;

public class One {

	static void speck(Student s) {
		System.out.println(s.getName()+"/"+s.getAge());
	}
	public static void main(String[] args) {
		Student s=new Student();
		s.setName("张三");
		s.setAge(20);
		speck(s);
		int arr[]=new int[5];
		for(int k=0;k<5;k++)
		{
			arr[k]=(int)( Math.random()*20);
			//arr[k]=k;
			System.out.print(arr[k]+" ");
		}
// 		数组需要是单调性
//		for(int i:arr)
//		{
//			System.out.println(arr[i]);
//		}
	}

}
class Student{
		private String name;
		private int age;
		public void setName(String s) {
			name=s;
		}
		public String getName() {
			return name;
		}
		public void setAge(int age) {
			this.age=age;
		}
		public int getAge() {
			return age;
		}
		public void speck() {
			System.out.println(getName()+" "+getAge());
		}
	}