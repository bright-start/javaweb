package window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class MusicPlayer extends JFrame {

	private JPanel contentPane;
	private Thread thread;

	JTextArea textArea = new JTextArea();
	JScrollPane scroll = new JScrollPane(textArea);
	JProgressBar progressBar = new JProgressBar();
	JLabel lblNewLabel = new JLabel("歌曲");
    private String[] music=new String[] {
    		"周笔畅-最美的期待-(电视剧《茧镇奇缘》片头曲)","陈志朋-歌颂者",
    		"范玮琪-最初的梦想","韩磊-一路执着",
    		"胡夏-念","汪峰-飞的更高"
    };
	JComboBox<String> comboBox = new JComboBox<String>(music);
	JButton button_1 = new JButton("读取歌词");
	JButton btnNewButton = new JButton("播放");
	JButton button = new JButton("暂停");

	JRadioButton rdbtnNewRadioButton = new JRadioButton("循环播放");
	JRadioButton radioButton = new JRadioButton("随机播放");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicPlayer frame = new MusicPlayer();
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
	public MusicPlayer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		initWindow();
	}
	public void initWindow() {
		textArea.setBounds(10, 10, 252, 183);
//		scroll.setViewportView(textArea);
		scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setEditable(false);
		contentPane.add(textArea);
		

		progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setBounds(10, 218, 252, 14);
		contentPane.add(progressBar);
		

		rdbtnNewRadioButton.setBounds(290, 232, 73, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		

		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(290, 44, 147, 26);
		contentPane.add(comboBox);
		

		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(290, 192, 147, 34);
		contentPane.add(button_1);
		

		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(290, 148, 67, 34);
		contentPane.add(btnNewButton);
		

		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(367, 148, 70, 34);
		contentPane.add(button);
		

		lblNewLabel.setBounds(290, 19, 54, 15);
		contentPane.add(lblNewLabel);
		

		radioButton.setBounds(364, 232, 73, 23);
		contentPane.add(radioButton);
		
		initListener();
	}
	public void initListener() {
		btnNewButton.addActionListener(new playActionListener());
//		button.addActionListener(new pauseActionListener());
		button_1.addActionListener(new button_1ActionListener());
		progressBar.addChangeListener(new progressBarActionListener());
		radioButton.addActionListener(new rdbtnNewRadioButtonActionListener());
		radioButton.addActionListener(new radioButtonActionListener());
	}
	class playActionListener implements ActionListener{
		Player player; 
		String path=null;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			
			textArea.setText("\n\n\t\t无歌词");
			
			if(comboBox.getSelectedItem().equals("周笔畅-最美的期待-(电视剧《茧镇奇缘》片头曲)")){
				path="E:\\eclipse\\windows\\songs\\周笔畅-最美的期待-(电视剧《茧镇奇缘》片头曲).mp3";
			}
			else if(comboBox.getSelectedItem().equals("陈志朋-歌颂者")){
				path="E:\\eclipse\\windows\\songs\\陈志朋-歌颂者.mp3";
			}
			else if(comboBox.getSelectedItem().equals("范玮琪-最初的梦想")){
				path="E:\\eclipse\\windows\\songs\\范玮琪-最初的梦想.mp3";
			}
			else if(comboBox.getSelectedItem().equals("韩磊-一路执着")){
				path="E:\\eclipse\\windows\\songs\\韩磊-一路执着.mp3";
			}
			else if(comboBox.getSelectedItem().equals("胡夏-念")){
				path="E:\\eclipse\\windows\\songs\\胡夏-念.mp3";
			}
			else if(comboBox.getSelectedItem().equals("汪峰-飞的更高")){
				path="E:\\eclipse\\windows\\songs\\汪峰-飞的更高.mp3";
			}
			String str = (String) e.getActionCommand();
			MyThread thread = new MyThread();
			//System.out.println(str);
			if(  str.equals( "播放") ) {
				System.out.println("播放");
				thread.start();
				btnNewButton.setText("停止");
			}
			else if(str.equals( "停止")){
				System.out.println(!thread.isInterrupted());
				if(!thread.isInterrupted()){
						//thread.join();
					thread.interrupted();
						//thread.stop();
					btnNewButton.setText("播放");
				}
			}
	
		}
		class MyThread extends Thread {
			@Override
			public void run() {
				while(true) {
					try{  
						
			            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(path));  
			              
			            player = new Player(buf);  
			            
			            player.play();  
			            if(player==null) {
			            	player.close();
			            	break;
			            }
						
			        }catch(IOException | JavaLayerException ex){  
			            ex.printStackTrace();  
			        }
				}
			}
		}
		
	}

//	class pauseActionListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO 自动生成的方法存根
//		}
//		
//	}
	class button_1ActionListener implements ActionListener{
		String file=null;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(comboBox.getSelectedItem().equals("周笔畅-最美的期待-(电视剧《茧镇奇缘》片头曲)")){
				file=("E:\\eclipse\\windows\\songs\\words\\最美的期待.txt");
			}
			else if(comboBox.getSelectedItem().equals("陈志朋-歌颂者")){
				file=("E:\\eclipse\\windows\\songs\\words\\陈志朋-歌颂者.txt");
			}
			else if(comboBox.getSelectedItem().equals("范玮琪-最初的梦想")){
				file=("E:\\eclipse\\windows\\songs\\words\\范玮琪-最初的梦想.txt");
			}
			else if(comboBox.getSelectedItem().equals("韩磊-一路执着")){
				file=("E:\\eclipse\\windows\\songs\\words\\韩磊-一路执着.txt");
			}
			else if(comboBox.getSelectedItem().equals("胡夏-念")){
				file=("E:\\eclipse\\windows\\songs\\words\\胡夏-念.txt");
			}
			else if(comboBox.getSelectedItem().equals("汪峰-飞的更高")){
				file=("E:\\eclipse\\windows\\songs\\words\\汪峰-飞的更高.txt");
			}
			BufferedReader read;
			try {
				textArea.setText(null);
				read = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("gb2312")));
				String s=read.readLine();
				while(s!=null) {
					textArea.append(s+"\n");
					s=read.readLine();
				}
				read.close();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}

		}
		
	}
	class progressBarActionListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO 自动生成的方法存根
			progressBar.setMinimum(00);
			progressBar.setMaximum(100);
			progressBar.setValue(12);
		}
		
	}
	class rdbtnNewRadioButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根

		}
		
	}
	class radioButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根

		}
		
	}
}
