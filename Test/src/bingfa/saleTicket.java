package bingfa;

import java.util.Random;

public class saleTicket {
    public static void main(String[] args) {
        Sellticket sell=new Sellticket();
        Thread t1=new Thread (sell,"张三");
        Thread t2=new Thread (sell,"李四");
        Thread t3=new Thread (sell,"王五");
        Thread t4=new Thread (sell,"赵六");
        Thread t5=new Thread (sell,"田七");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        System.out.println(Thread.activeCount());    
    }
}
class Sellticket implements Runnable{
    private int ticket=50;
    Random rd=new Random();
    public void run(){
        while(ticket>0){
            synchronized (this){  //同步代码块，这段代码块同时只允许一个线程方法
                if(ticket>0){   //控制剩余票数不小于0
                    try {
                        Thread.sleep(rd.nextInt(100)+500); //每运行一次，休眠一秒钟
                        System.out.println(Thread.currentThread().getName()  + "正在卖第  "+ ticket-- +"票.." );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } 
                }else{
                    return;
                }
            }
        }
    }
}