package window;
import java.awt.*;
import java.util.Calendar;

import javax.swing.*;

@SuppressWarnings("serial")
public class Graph extends JFrame
{
	public Graph()
	{
		init();
		//setSize(360,500);
		setBounds(500,150,360,500);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void init()
	{
		setLayout(null);
		//setSize(300,300);
		
		layeredPane=new JLayeredPane();  
        image=new ImageIcon("image\\1.jpg");         
        jp=new JPanel();  
        jp.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  

        jl=new JLabel(image);  
        jp.add(jl);  

        layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER); 
        this.setLayeredPane(layeredPane); 
        //this.setSize(image.getIconWidth(),image.getIconHeight());
        //this.setLocation(image.getIconWidth(),image.getIconHeight());
       
        head=new JLabel("TIME TRAVELER");
        head.setBounds(10,10,150,20);
        head.setForeground(Color.ORANGE);
        layeredPane.add(head,JLayeredPane.MODAL_LAYER); 
        head.setOpaque(false);
        
//		title.setText("title：");
//		getContentPane().add(title);
//		title.setBounds(10,10,100,20);
//		title.setFont(new Font("Dialog", Font.PLAIN, 14));
//		layeredPane.add(title,JLayeredPane.MODAL_LAYER);	

        name1=new JLabel("YOU NMAE:");
        name1.setBounds(30,55,130,30);
        name1.setForeground(Color.ORANGE);
        name1.setFont(new Font("Dialog", Font.BOLD, 22));
        layeredPane.add(name1,JLayeredPane.MODAL_LAYER); 
        name1.setOpaque(false);
//		name1.setText("NAME：");
//		getContentPane().add(name1);
//		name1.setBounds(51,55,80,30);
//		name1.setFont(new Font("Dialog", Font.PLAIN, 26));
//		layeredPane.add(name1,JLayeredPane.MODAL_LAYER);
		
//      name=new JTextField("");
//      name.setBounds(160,50,80,40);
//      layeredPane.add(name,JLayeredPane.MODAL_LAYER); 
//      name.setOpaque(false);
		getContentPane().add(name);
		name.setBounds(160,50,80,40);
		name.setFont(new Font("Dialog", Font.PLAIN, 26));
		name.setBackground(java.awt.Color.LIGHT_GRAY);
		layeredPane.add(name,JLayeredPane.MODAL_LAYER);
		
        birthday=new JLabel("BIRTHDAY:");
        birthday.setBounds(45,135,60,20);
        birthday.setForeground(java.awt.Color.ORANGE);
        layeredPane.add(birthday,JLayeredPane.MODAL_LAYER); 
        birthday.setOpaque(false);
//		date1.setText(" BIRTHDAY:");
//		getContentPane().add(date1);
//		date1.setBounds(35,135,80,20);
//		date1.setFont(new Font("Dialog", Font.PLAIN, 14));
//		layeredPane.add(date1,JLayeredPane.MODAL_LAYER);
		
		getContentPane().add(year_in);
		year_in.setBounds(118,130,60,30);
		year_in.setFont(new Font("Dialog", Font.PLAIN, 19));
		year_in.setBackground(java.awt.Color.LIGHT_GRAY);
		layeredPane.add(year_in,JLayeredPane.MODAL_LAYER);
		getContentPane().add(month_in);
		month_in.setBounds(183,130,60,30);
		month_in.setFont(new Font("Dialog", Font.PLAIN, 19));
		month_in.setBackground(java.awt.Color.LIGHT_GRAY);
		layeredPane.add(month_in,JLayeredPane.MODAL_LAYER);
		getContentPane().add(day_in);
		day_in.setBounds(248,130,60,30);
		day_in.setFont(new Font("Dialog", Font.PLAIN, 19));
		day_in.setBackground(java.awt.Color.LIGHT_GRAY);
		layeredPane.add(day_in,JLayeredPane.MODAL_LAYER);
		
		like.setBounds(36,180,272,50);
		getContentPane().add(like);
		like.setFont(new Font("Dialog", Font.PLAIN, 24));
		like.setBackground(java.awt.Color.LIGHT_GRAY);
		layeredPane.add(like,JLayeredPane.MODAL_LAYER);
		
		btnNew=new JButton("");
		btnNew.setIcon(login);
		btnNew.setBounds(140,250,70,39);
        layeredPane.add(btnNew,JLayeredPane.MODAL_LAYER); 
        btnNew.setOpaque(false);
//		btnNew.setLabel("sublime");
//		getContentPane().add(btnNew);
//		btnNew.setBounds(140,250,70,35);
//		btnNew.setBackground(java.awt.Color.GRAY);
//		layeredPane.add(btnNew,JLayeredPane.MODAL_LAYER);
		
		getContentPane().add(listDisp);
		listDisp.setBounds(36,300,272,106);
		listDisp.setFont(new Font("Dialog", Font.PLAIN, 24));
		listDisp.setBackground(java.awt.Color.LIGHT_GRAY);
		layeredPane.add(listDisp,JLayeredPane.MODAL_LAYER);
		
		SymAction lSymAction=new SymAction();
		btnNew.addActionListener(lSymAction);
			
	}
	
	JLayeredPane layeredPane;    
	JPanel jp;  
	JLabel jl;  
	JLabel head;
	JLabel name1;
	JLabel birthday;
	JButton btnNew;
	private Icon login = new ImageIcon("image\\2.gif");
	
	//JTextField name;
	ImageIcon image;
	
	//java.awt.Label title=new java.awt.Label();
	//java.awt.Label name1=new java.awt.Label();
	//java.awt.Label date1=new java.awt.Label();
	//java.awt.Button btnNew=new java.awt.Button();
	java.awt.TextField name=new java.awt.TextField();
	java.awt.TextField year_in=new java.awt.TextField();
	java.awt.TextField month_in=new java.awt.TextField();
	java.awt.TextField day_in=new java.awt.TextField();
	java.awt.TextField like=new java.awt.TextField("You likes");
	java.awt.List listDisp=new java.awt.List(0);
	
	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			btnNew_ActionPerformed(event);
		}
	}
	
	void btnNew_ActionPerformed(java.awt.event.ActionEvent event)
	{
		String Name=name.getText();
		String Year=year_in.getText();
		String Month=month_in.getText();
		String Day=day_in.getText();
		String Like=like.getText();

		int y=Integer.parseInt(Year);
		int m=Integer.parseInt(Month);
		int d=Integer.parseInt(Day);
		int flag=0;
		int arr_1[]= {31,59,90,120,151,181,212,243,273,304,334,365};
		int arr_2[]= {31,60,91,121,152,182,213,244,274,305,335,366};
		int temp=0,sum=0;
		if((y%100!=0 & y%4==0) || y%400==0)
		{
			flag=1;
		}
		if(flag==1)
		{
			for(int i=0;i<12;i++)
			{
				if(arr_2[i]==m-1)
					temp=arr_2[i];
			}
			temp+=d;
			sum=366-temp;
		}
		else
		{
			for(int i=0;i<12;i++)
			{
				if(arr_1[i]==m-1)
					temp=arr_1[i];
			}
			temp+=d;
			sum=365-temp;
		}
		Calendar cal=Calendar.getInstance();      
		int y_now=cal.get(Calendar.YEAR);      
		int m_now=cal.get(Calendar.MONTH);      
		int d_now=cal.get(Calendar.DATE);      
		int h_now=cal.get(Calendar.HOUR_OF_DAY);      
		int mi_now=cal.get(Calendar.MINUTE);      
		int s_now=cal.get(Calendar.SECOND);      
	
		int leapcount=0,pingcount=0;
		for(int i=y;i<y_now;i++)
		{
			if((y%100!=0 & y%4==0) || y%400==0)
			{
				leapcount++;
			}
			else
			{
				pingcount++;
			}
		}
		sum+=leapcount*366+pingcount*365;
		if((y_now%100!=0 & y_now%4==0) || y_now%400==0)
		{
			flag=1;
		}
		if(flag==1)
		{
			for(int i=0;i<12;i++)
			{
				if(arr_2[i]==m_now-1)
					temp=arr_2[i];
			}
			temp+=d_now;
			sum=366-temp;
		}
		else
		{
			for(int i=0;i<12;i++)
			{
				if(arr_1[i]==m-1)
					temp=arr_1[i];
			}
			temp+=d;
			sum+=temp;
		}
		String disp_1=" NAME: "+Name+"";
		String disp_2=" BIRTHDAY:"+y+"-"+m+"-"+d+"-";	
		String disp_3=" LIKES:"+Like+"";
		String disp_4=" LIVE TIME:"+sum+" day "+h_now+" hour "+mi_now+" min "+s_now+" s ";

		listDisp.add(disp_1);
		listDisp.add(disp_2);
		listDisp.add(disp_3);
		listDisp.add(disp_4);
	}
	
	public static void main(String[] args)
	{
		new Graph();
	}

}
