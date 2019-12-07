package 中国大学练习;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.util.List;
import java.util.ArrayList;

public class Recite extends JFrame
{
	JLabel word=new JLabel("word");
	JLabel meaning=new JLabel("meaning");
	JTextField time=new JTextField("1000");
	JLabel ok=new JLabel("ms");
	JButton backword=new JButton("背单词");
	JButton marker=new JButton("标记");
	JButton reRecite=new JButton("读标记单词");
	public void init()
	{
		setSize(400,150);
		setLayout(null);
		getContentPane().add(word);
		word.setBounds(40, 10, 90, 20);
		getContentPane().add(meaning);
		meaning.setBounds(140, 10, 250, 20);
		getContentPane().add(time);
		time.setBounds(5, 60, 60, 20);
		getContentPane().add(marker);
		ok.setBounds(65, 60, 20, 20);
		getContentPane().add(backword);
		backword.setBounds(90, 60, 80, 20);
		backword.addActionListener(new backwordActionListener());
		getContentPane().add(ok);
		marker.setBounds(175, 60, 80, 20);
		marker.addActionListener(new markActionListener());
		getContentPane().add(reRecite);
		reRecite.setBounds(260, 60, 120, 20);
		reRecite.addActionListener(new reReciteActionListener());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
	}
	
	List<String> words=new ArrayList<>();
	List<String> meanings=new ArrayList<>();
	int current=0;
	public void start()
	{
		String s=time.getText();
		int timer=Integer.parseInt(s);
		new Thread(()->{//异步进程
			try {
				readAll();
			}
			catch(IOException ex)
			{
				System.out.println(ex);
			}
			new javax.swing.Timer(timer,(e)->{//计时器
				word.setText(words.get(current));
				meaning.setText(meanings.get(current));
				current++;
			}).start();
		}).start();
	}
	
	public void readAll() throws IOException{
		String fileName="word_file\\College_Grade4.txt";
		String charset="utf-8";
		BufferedReader reader=new BufferedReader(
				new InputStreamReader(
						new FileInputStream(fileName),charset));
		String line;
		while((line=reader.readLine())!=null) {
			line=line.trim();
			if(line.length()==0)
				continue;
			int idx =line.indexOf("\t");
			words.add(line.substring(0, idx));
			line=line.substring(idx+1);
			int index=line.indexOf("\t");
			meanings.add(line.substring(0,index));
		}
		reader.close();
	}
	//背单词按钮监听
	class backwordActionListener implements ActionListener
	{
		JTextField wordz=new JTextField();
		JLabel means=new JLabel("meaing");
		JLabel real=new JLabel("Yes:0");
		JLabel error=new JLabel("No:0");
		JButton btn=new JButton("提交");
		JTextArea textarea=new JTextArea();
		JScrollPane scroll=new JScrollPane(textarea);
		JPanel pnlHead=new JPanel();
		JPanel panel=new JPanel();
		int temp=0;
		int y=0;
		int n=0;
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			JFrame jf=new JFrame("单词默写");
			jf.setResizable(false);
			jf.setSize(400, 400);
			jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			jf.setVisible(true);

			jf.setLayout(null);
			jf.add(pnlHead);
			pnlHead.setBounds(0,0,360,100);
			pnlHead.setLayout(null);
			pnlHead.add(wordz);
			wordz.setBounds(25,30,80,30);
			pnlHead.add(means);
			means.setBounds(110, 30, 280, 30);
			pnlHead.add(btn);
			btn.addActionListener(new btnActionListener());
			btn.setBounds(300,30,60,30);
			
			pnlHead.add(real);
			real.setBounds(155, 70, 40, 20);
			pnlHead.add(error);
			error.setBounds(225, 70, 40, 20);
			
			jf.add(panel);
			panel.setBounds(25,100,340,250);
			panel.setLayout(new GridLayout());
			panel.add(scroll);
			textarea.setEditable(false);
	
			temp=(int) (Math.random()*current);
			means.setText(meanings.get(temp));
		}
		//背单词提交按钮监听
		class btnActionListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e) {
				if(rootPaneCheckingEnabled==false)
					marker.setEnabled(true);
				if(wordz.getText().equals(words.get(temp)))
				{
					textarea.append("Yes"+"\n");
					y++;
				}
				else
				{
					textarea.append(" No "+meanings.get(temp)+ " 正确单词应该是："+words.get(temp)+"\n");
					n++;
				}
				real.setText("Yes:"+y);
				error.setText("No:"+n);
				wordz.setText("");
				wordz.requestFocus();
				temp=(int) (Math.random()*current);
				means.setText(meanings.get(temp));
			}	
		}
	}
	//标记
	class markActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(rootPaneCheckingEnabled==false)
				marker.setEnabled(true);
			try 
			{
				File output=new File("word_file\\mark.txt");
				BufferedWriter out=new BufferedWriter(new FileWriter(output,true));
				out.write(words.get(current));
				out.write("\t");
				out.write(meanings.get(current));
				out.newLine();
				out.close();
			}
			catch (IOException e1) 
			{
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}

	}
	//读标记单词
	class reReciteActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
			JFrame reRecite=new JFrame();
			reRecite.setSize(400,400);
			reRecite.setTitle("reRecite");
			reRecite.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			reRecite.setVisible(true);
			TextArea reword=new TextArea(400,200);
			reRecite.add(reword);
			String filePath = "word_file\\mark.txt";

			List<String> lines = null;
			try {
				lines = Files.readAllLines(
					Paths.get(filePath),  
					Charset.forName("utf8") //or Charset.defaultCharset()
				);
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			for(String s : lines ) reword.append(s+"\n");
		}

	}
	
	public static void main(String[] args) 
	{
		Recite f=new Recite();
		f.init();
		f.start();

	}

}

