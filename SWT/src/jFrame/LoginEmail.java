package jFrame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;


@SuppressWarnings("serial")
public class LoginEmail extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEmail frame = new LoginEmail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginEmail() {
		setType(Type.UTILITY);
		setTitle("登录");
		setAlwaysOnTop(true);
		setBackground(new Color(51, 255, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(111, 100, 198, 33);
		contentPane.add(textField);
		textField.setFont(new Font("宋体", Font.PLAIN, 14));
		textField.setText("账号/手机号/邮箱");
		textField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				textField.setText("");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setBounds(111, 206, 198, 33);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(new Color(153, 255, 255));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("自动登录");
		chckbxNewCheckBox.setBounds(224, 181, 85, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("找回密码");
		chckbxNewCheckBox_1.setBounds(111, 181, 85, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 143, 198, 32);
		contentPane.add(passwordField);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}	
		});
	}
}
