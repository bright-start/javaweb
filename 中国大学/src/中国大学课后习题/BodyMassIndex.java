package 中国大学课后习题;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BodyMassIndex extends JFrame
{
	JFrame jf=new JFrame("身体质量指数评估");
	JLabel namelabel=new JLabel("姓名");
	JLabel higlabel=new JLabel("身高");
	JLabel widlabel=new JLabel("体重");
	JLabel height=new JLabel("m");
	JLabel weight=new JLabel("kg");
	JTextField nametextfield=new JTextField();
	JTextField higtextfield=new JTextField();
	JTextField widtextfield=new JTextField();
	JTextArea restextarea=new JTextArea();
	
	JButton resbutton=new JButton("评估");
	
	JPanel pnlfore=new JPanel();
	JPanel pnlback=new JPanel();
	
	BodyMassIndex()
	{
		jf.setSize(300,500);
		init();
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setVisible(true);
	}
	
	public void init()
	{
		jf.setLayout(null);
		jf.add(pnlfore);
		jf.add(pnlback);
		pnlfore.setBounds(20, 20, 260, 200);
		pnlfore.add(namelabel);
		pnlfore.add(nametextfield);
		pnlfore.add(higlabel);	
		pnlfore.add(higtextfield);	
		pnlfore.add(height);
		pnlfore.add(widlabel);	
		pnlfore.add(widtextfield);	
		pnlfore.add(weight);
		pnlfore.add(resbutton);

		pnlfore.setLayout(null);
		namelabel.setBounds(70,20,30,30);
		nametextfield.setBounds(110,20,60,30);
		higlabel.setBounds(70,60,30,30);
		higtextfield.setBounds(110,60,60,30);
		height.setBounds(175,60,30,30);
		widlabel.setBounds(70,100,30,30);	
		widtextfield.setBounds(110,100,60,30);
		weight.setBounds(175,100,30,30);
		resbutton.setBounds(110,155,60,30);	
		
		pnlback.setBounds(15, 230, 260, 230);
		pnlback.setLayout(new GridLayout());
		JScrollPane scroll=new JScrollPane(restextarea);
		restextarea.setEditable(false);
		pnlback.add(scroll);

		resbutton.addActionListener(new buttonActionListener());
	}
	
	class buttonActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(nametextfield.getText().equals(null)== higtextfield.getText().equals(null))
				if(nametextfield.getText().equals(null)== widtextfield.getText().equals(null))
					if(higtextfield.getText().equals(null)== widtextfield.getText().equals(null))
						return ;
			System.out.println(nametextfield.getText());
			restextarea.append("身体指数评估清单："+"\n");
			restextarea.append("\t"+"姓名:"+nametextfield.getText()+"\n");
			restextarea.append("\t"+"身高:"+higtextfield.getText()+"\n");
			restextarea.append("\t"+"体重:"+widtextfield.getText()+"\n");
			String s=higtextfield.getText();
			double height=Double.parseDouble(s);
			s=higtextfield.getText();
			double weight=Double.parseDouble(s);
			double BMI=weight/Math.pow(height,2);
			if(BMI>32)
				restextarea.append("\t"+"身体质量：  非常肥胖"+"\n");
			else if(BMI>28)
				restextarea.append("\t"+"身体质量：  肥胖"+"\n");
			else if(BMI>24)
				restextarea.append("\t"+"身体质量：  过重"+"\n");
			else if(BMI>18.5)
				restextarea.append("\t"+"身体质量：  正常"+"\n");
			else
				restextarea.append("\t"+"身体质量：  过轻"+"\n");
			
			restextarea.append("---------------------------------------------"+"\n");	
			restextarea.append("并不是每个人都适用BMI的，如："+"\n");	
			restextarea.append("1. 未满18岁；"+"\n");	
			restextarea.append("2. 是运动员；"+"\n");	
			restextarea.append("3. 正在做重量训练；"+"\n");	
			restextarea.append("4. 怀孕或哺乳中；"+"\n");	
			restextarea.append("5. 身体虚弱或久坐不动的老人。"+"\n");	
			restextarea.append("如果认为BMI算出来的结果不能正确反映体重问题，请带着结果与医师讨论，并要求做体脂肪测试。"+"\n");	
			restextarea.append("tip: 由于存在误差，所以BMI只能作为评估个人体重和健康状况的多项标准之一"+"\n");			
		}
		
	}

	public static void main(String[] args) 
	{
		// TODO 自动生成的方法存根
		new BodyMassIndex();
	}

}
