package bingfa;

import java.util.Random;

public class saleTicket {
    public static void main(String[] args) {
        Sellticket sell=new Sellticket();
        Thread t1=new Thread (sell,"����");
        Thread t2=new Thread (sell,"����");
        Thread t3=new Thread (sell,"����");
        Thread t4=new Thread (sell,"����");
        Thread t5=new Thread (sell,"����");
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
            synchronized (this){  //ͬ������飬��δ����ͬʱֻ����һ���̷߳���
                if(ticket>0){   //����ʣ��Ʊ����С��0
                    try {
                        Thread.sleep(rd.nextInt(100)+500); //ÿ����һ�Σ�����һ����
                        System.out.println(Thread.currentThread().getName()  + "��������  "+ ticket-- +"Ʊ.." );
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