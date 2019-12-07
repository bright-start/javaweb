package window;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Tabel
{
	public static void main(String[] args) 
	{
		new AppFrame();
	}

}

@SuppressWarnings("serial")
class AppFrame  extends JFrame
{  

	
	JLayeredPane layeredPane=new JLayeredPane();    
	ImageIcon backimage=new ImageIcon("image\\4.jpg");
	ImageIcon login=new ImageIcon("image\\5.jpg");
	ImageIcon icon=new ImageIcon("image\\6.jpg");
	ImageIcon image=new ImageIcon("image\\7.jpg");
	
	JPanel jp=new JPanel();  
	JLabel jl=new JLabel(backimage); 
	JTextField textfield_1=new JTextField("QQ账号");
	JPasswordField passwordfield_1=new JPasswordField();
	JButton button_1=new JButton(login);
	JCheckBox checkbox_1=new JCheckBox();
	JCheckBox checkbox_2=new JCheckBox();
	JLabel label_1=new JLabel("自动登录");
	JLabel label_2=new JLabel("记住密码");
	JLabel label_3=new JLabel("找回密码");
	JLabel label_4=new JLabel("注册账号");
	JLabel label_5=new JLabel("密码输入错误！");
	JLabel label_6=new JLabel("账号或密码输入错误！");
	
	public AppFrame()
	{
		init();	
		setTitle("QQ");
		setIconImage(icon.getImage());
		setBounds(500,220,400,350);
		setBackground(Color.lightGray);
		setForeground(Color.blue);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void wait_on() 
	{
		try
		{
            Thread.sleep(3000);
        }
		catch(InterruptedException e1)
		{
        	e1.printStackTrace();
        }
		dispose();
	}
	
	public void init()
	{
		setLayout(null);
		setSize(300,300);
		
		jp.add(jl);
		jp.setBounds(0,0,backimage.getIconWidth(),backimage.getIconHeight());
        layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER); 
        this.setLayeredPane(layeredPane);  
		
		getContentPane().add(textfield_1);
		textfield_1.setBounds(75,135,250,30);
		textfield_1.addMouseListener(new textfieldMouseAdapter());
		layeredPane.add(textfield_1,JLayeredPane.MODAL_LAYER); 
		textfield_1.setOpaque(false);
		
		getContentPane().add(passwordfield_1);
		passwordfield_1.setBounds(75,170,250,30);
		passwordfield_1.addMouseListener(new passwordfieldMouseAdapter());
		layeredPane.add(passwordfield_1,JLayeredPane.MODAL_LAYER); 
		passwordfield_1.setOpaque(false);
		
		getContentPane().add(checkbox_1);
		checkbox_1.setBounds(75,205,20,20);
		layeredPane.add(checkbox_1,JLayeredPane.MODAL_LAYER); 
		checkbox_1.setOpaque(false);
		
		getContentPane().add(label_1);
		label_1.setBounds(100,205,60,20);
		layeredPane.add(label_1,JLayeredPane.MODAL_LAYER); 
		label_1.setOpaque(false);
		
		getContentPane().add(checkbox_2);
		checkbox_2.setBounds(170,205,20,20);
		layeredPane.add(checkbox_2,JLayeredPane.MODAL_LAYER); 
		checkbox_2.setOpaque(false);
		
		getContentPane().add(label_2);
		label_2.setBounds(195,205,60,20);
		layeredPane.add(label_2,JLayeredPane.MODAL_LAYER); 
		label_2.setOpaque(false);
		
		getContentPane().add(label_3);
		label_3.setBounds(270,205,60,20);
		label_3.addMouseListener(new LabelMouseAdapter());
		layeredPane.add(label_3,JLayeredPane.MODAL_LAYER); 
		label_3.setOpaque(false);
		
		getContentPane().add(label_4);
		label_4.setBounds(20,290,60,20);
		label_4.addMouseListener(new LabelMouseAdapter());
		layeredPane.add(label_4,JLayeredPane.MODAL_LAYER); 
		label_4.setOpaque(false);
		
		getContentPane().add(label_5);
		label_5.setBounds(80,180,140,20);
		label_5.setForeground(Color.red);
		
		getContentPane().add(label_6);
		label_6.setBounds(80,145,140,20);
		label_6.setForeground(Color.red);
	
		getContentPane().add(button_1);
		button_1.setBounds(75,240,250,38);
		button_1.addActionListener(new BtnActiveAdapter());
		layeredPane.add(button_1,JLayeredPane.MODAL_LAYER); 
		button_1.setOpaque(false);
		
	}
    class textfieldMouseAdapter implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			textfield_1.setText(" ");
			layeredPane.add(label_6,JLayeredPane.DEFAULT_LAYER); 
			label_6.setOpaque(false);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
	}
		
    class passwordfieldMouseAdapter implements MouseListener
    {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			layeredPane.add(label_5,JLayeredPane.DEFAULT_LAYER); 
			label_5.setOpaque(false);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
    }
    
    class LabelMouseAdapter implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			JFrame tabel = new JFrame();
			
			tabel.setBounds(500,220,400,350);
			tabel.setResizable(false);
			//tabel.setDefaultCloseOperation(EXIT_ON_CLOSE);
			tabel.setAlwaysOnTop(true);
			tabel.setVisible(true);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
	}
	
	class BtnActiveAdapter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String name=textfield_1.getText();
			String namelib=" 2421366898";
			String password=passwordfield_1.getName();
			String password_name=" admin123456";
			System.out.println(password+" "+name.equals(namelib));
			if(name.compareTo(namelib)==0)
			{
				if(passwordfield_1.equals(password_name))
				{
					try
					{
						button_1.setIcon(image);
			            Thread.sleep(3000);
			        }
					catch(InterruptedException e1)
					{
			        	e1.printStackTrace();
			        }
					dispose();
				}
				else
				{
					try
					{
						passwordfield_1.setText("");
						layeredPane.add(label_5,JLayeredPane.POPUP_LAYER); 
						label_5.setOpaque(false);
					}
					catch(Exception err1)
					{
						System.out.println(err1);
					}
				}
			}
			else
			{
				try
				{
					textfield_1.setText("");
					passwordfield_1.setText("");
					layeredPane.add(label_6,JLayeredPane.POPUP_LAYER); 
					label_6.setOpaque(false);
				}
				catch(Exception err2)
				{
					System.out.println(err2);
				}
			}
				

		}
	}
}

