package 中国大学练习;

import java.applet.AudioClip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;// 声音播放程序

public class TestAudioClip extends JFrame implements ActionListener, ItemListener {

	String[] choics = { "1.wav", "派对动物.wav" }; // 音乐文件名数组
	URL file1 = getClass().getResource(choics[0]); // 音乐文件1
	URL file2 = getClass().getResource(choics[1]); // 文件2
	// URL file3 = getClass().getResource(choics[2]); //音乐文件3
	// URL file4 = getClass().getResource(choics[3]); //文件4
	// URL file5 = getClass().getResource(choics[4]); //音乐文件5

	AudioClip sound1 = java.applet.Applet.newAudioClip(file1); // 声音剪辑对象1
	AudioClip sound2 = java.applet.Applet.newAudioClip(file2); // 声音剪辑对象2
	// AudioClip sound3 = java.applet.Applet.newAudioClip(file3); //声音剪辑对象3
	// AudioClip sound4 = java.applet.Applet.newAudioClip(file4); //声音剪辑对象4
	// AudioClip sound5 = java.applet.Applet.newAudioClip(file5); //声音剪辑对象5

	AudioClip chosenClip = sound1; // 选择的声音剪辑对象
	JComboBox jcbFiles = new JComboBox(choics); // 文件选择组合框
	JButton playButton = new JButton("播放"); // 播放按钮
	JButton ExitBt = new JButton("退出");
	JButton stopButton = new JButton("停止"); // 停止播放按钮
	JLabel status = new JLabel("选择文件"); // 状态栏标签
	JPanel Panel = new JPanel(); // 控制面板用于包容按钮
	JPanel jp = new JPanel();
	JLabel jlImg = new JLabel(); // 放背景图片的标签
	JLabel jlImg1 = new JLabel();
	Container container = getContentPane(); // 获得窗口内容窗格

	public TestAudioClip() { // 构造函数
		super("音乐播放器"); // 调用父类构造器设置窗口标题栏
		jcbFiles.setSelectedIndex(0); // 设置选中的选项
		jcbFiles.addItemListener(this); // 为播放按钮添加项目监听器
		playButton.addActionListener(this);
		ExitBt.addActionListener(this);
		stopButton.addActionListener(this);
		stopButton.setEnabled(false); // 设置停止播放按钮不可用

		Panel.add(playButton);
		Panel.add(stopButton);
		Panel.add(ExitBt);
		container.setLayout(null);
		container.setBackground(new Color(210, 255, 210));

		jcbFiles.setBounds(0, 0, 295, 30);
		Panel.setBounds(0, 30, 300, 200);
		status.setBounds(0, 230, 300, 30);

		container.add(jcbFiles);
		container.add(Panel);
		container.add(status);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// Image imgtop = toolkit.getImage("bin/top.jpg");
		// super.setIconImage(imgtop); //标签图片
		Icon img = new ImageIcon("bin/img.jpg"); // 背景图片
		jlImg = new JLabel(img);
		jlImg.setBounds(0, 0, 300, 220);
		Panel.add(jlImg);

		Icon img1 = new ImageIcon("bin/img2.jpg"); // 背景图片
		jlImg1 = new JLabel(img1);
		jlImg1.setBounds(50, 0, 300, 38);
		status.add(jlImg1);

		setResizable(false); // 设置窗口不可改变大小
		setSize(300, 285); // 设置窗口大小
		setVisible(true); // 设置窗口可视
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时退出程序
	}

	public void itemStateChanged(ItemEvent e) {
		// for(int i=0;i<5;i++)
		if (jcbFiles.getSelectedIndex() == 0) {
			chosenClip = sound1;
		} else if (jcbFiles.getSelectedIndex() == 1) {
			chosenClip = sound2;
		}

	}

	public void actionPerformed(ActionEvent event) {

		Object source = event.getSource(); // 获取用户洗涤激活的按钮
		if (source == playButton) // 播放按钮事件处理
		{
			stopButton.setEnabled(true); // 设置停止播放按钮可用
			chosenClip.play(); // 播放选择的声音剪辑对象一次
			status.setText("正在播放..."); // 设置状态栏信息
		}

		if (source == ExitBt) {
			System.exit(0);
		}
		if (source == stopButton) {
			chosenClip.stop(); // 停止播放选择的声音剪辑对象
			stopButton.setEnabled(true);
			status.setText("停止播放"); // 设置状态栏信息
		}
	}

	public static void main(String s[]) {
		new TestAudioClip(); // 创建Audio对象
	}
}
