package one;

public class Test1 {
    private int i = f(); 
    private static int j = 10;
    private int f() {
        return j;
    }
    Test1(){
    	System.out.println(i);
    }
    public static void main(String args[]) { 
        System.out.println((new Test1()).i); 
    }
}