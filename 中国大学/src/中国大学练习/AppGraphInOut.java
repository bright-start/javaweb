package 中国大学练习;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AppGraphInOut {
	public static void main(String[] args)
	{
		new AppFrame();
	}
}
@SuppressWarnings("serial")
class AppFrame extends JFrame //继承JFrame 窗口
{
	JTextField in=new JTextField(20); 
	JButton btn =new JButton("求平方");
	JLabel out =new JLabel("用于显示结果的标签");
	//JTextField out1 =new JTextField(20);
	
	public AppFrame() //构造对象
	{
		setLayout(new FlowLayout()); //设置布局  流布局
		getContentPane().add(in);  //内容面板add
		getContentPane().add(btn);
		getContentPane().add(out);
		//getContentPane().add(out1);
		btn.addActionListener(new BtnActiveAdapter());
		setSize(400,100);  //设置大小
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置关闭按钮
		setVisible(true);  //显示
	}
	
	class BtnActiveAdapter implements ActionListener  //事件监听对象
	{
		public void actionPerformed(ActionEvent e)
		{
			String s =in.getText();  
			double d=Double.parseDouble(s);
			double sq=d*d;
			out.setText(d+"的平方："+sq);
			//out1.setText(""+sq);
		}
	}
	
}