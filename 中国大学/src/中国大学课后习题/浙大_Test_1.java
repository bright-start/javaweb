package 中国大学课后习题;

import java.util.Scanner;

public class 浙大_Test_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(), in.nextInt());
		Fraction b = new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
	}

}
class Fraction {
	int molecule ;
	int denominator; 
	Fraction(int molecule,int denominator){
		this.molecule=molecule;
		this.denominator=denominator;
	}
	Fraction plus(Fraction another) {
		Fraction z=new Fraction(0,0);
		z.molecule=this.molecule*another.denominator+another.molecule*this.denominator;
		z.denominator=this.denominator*another.denominator;
		return z;
	}
	Fraction multiply(Fraction other) {
		Fraction z=new Fraction(0,0);
		z.molecule=this.molecule*other.molecule;
		z.denominator=this.denominator*other.denominator;
		return z;
	}
	int appointment(int a,int b) {
		int mod;
		while(b!=0) {
			mod=a%b;
			a=b;
			b=mod;
		}
		return a;
		
	}
	void print() {
		int mod=appointment(molecule,denominator);
		if(molecule>=denominator && molecule%denominator==0)
			System.out.println(molecule/denominator);
		else
			System.out.println(molecule/mod+"/"+denominator/mod);
	}
}