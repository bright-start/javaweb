package window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;

import javax.swing.*;

@SuppressWarnings("serial")
class GetURLContent extends JFrame{
//	ImageIcon icon=new ImageIcon(images\\);
//	JFrame frame=new JFrame();
	JPanel pnlHead=new JPanel();
	JPanel pnlBody=new JPanel();
	JTextField textfield=new JTextField(15);
	JButton button=new JButton("解析网址");
	JTextArea textarea=new JTextArea();
	JScrollPane scroll=new JScrollPane();

	GetURLContent(){
		init();
		setTitle("网页爬虫");
//		setIconImage(icon。getIconImage());
		setSize(400, 400);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	void init() {

		getContentPane().setLayout(new BorderLayout());
		
		getContentPane().add(pnlHead,BorderLayout.NORTH);
		getContentPane().add(pnlBody,BorderLayout.CENTER);

		pnlHead.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlBody.setLayout(new GridLayout());
		
		pnlHead.add(textfield);
		pnlHead.add(button);

		textarea.setEditable(false);
		scroll.setViewportView(textarea);
		pnlBody.add(scroll);
		initActionListener();
	}
	void initActionListener() {
		button.addActionListener(new ButtonActionListener());
	}
	class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			try {
				if(textfield.getText().equals(""))
				{
					textarea.setText("请输入网址！！！");
				}
				else {
					URL url_address=new URL(textfield.getText());
					textarea.setText("");
					textarea.append("正在解析： \n");
					//方法一
					InputStream urls=url_address.openStream();
					String content=readAll(urls,"utf-8");
					textarea.setText(content);
					textarea.setCaretPosition(textarea.getText().length());
				}
				
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		String readAll(InputStream input,String charset) throws IOException {
			LineNumberReader read=new LineNumberReader(new InputStreamReader(input,charset));
			StringBuilder s=new  StringBuilder();
			String line=null;
			while((line=read.readLine())!=null) {
				s.append(line+"\n");
			}
			return s.toString();
			
		}
		
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new GetURLContent();
	}
}
