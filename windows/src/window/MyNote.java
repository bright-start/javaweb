package window;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class MyNote extends JFrame
{  
	JFrame jf=new JFrame();
	JMenuBar jm=new JMenuBar();
	//导航栏
	JMenu menu[]=new JMenu[] {
			new JMenu("文件"),
			new JMenu("编辑"),
			new JMenu("格式"),
			new JMenu("查看"),
			new JMenu("帮助")
	};

	//导航栏下拉框
	JMenuItem menuitem[][] =new JMenuItem[][] {
		{		//文列表件
			new JMenuItem("新建"),
			new JMenuItem("打开"),
			new JMenuItem("保存"),
			new JMenuItem("另存为"),
			new JMenuItem("页面设置"),
			new JMenuItem("打印"),
			new JMenuItem("退出")
		},
		{
			//编辑列表
			new JMenuItem("撤销"),
			new JMenuItem("剪切"),
			new JMenuItem("复制"),
			new JMenuItem("粘贴"),
			new JMenuItem("删除"),
			new JMenuItem("查找"),
			new JMenuItem("查找下一个"),
			new JMenuItem("替换"),
			new JMenuItem("转到"),
			new JMenuItem("全选"),
		},
		{
			//格式列表
			new JMenuItem("自动换行"),
			new JMenuItem("字体"),
			new JMenuItem("字体颜色"),
			new JMenuItem("背景颜色")
		},
		{
			new JMenuItem("绘图模式")
		},
		{
			//查看列表
			new JMenuItem("状态")
		},
		{
			//帮助
			new JMenuItem("查看帮助"),
			new JMenuItem("关于记事本")
		}

	};
	//文本框
	JTextArea textarea=new JTextArea();
	JScrollPane scroll=new JScrollPane(textarea);
	//状态栏
	JLabel label=new JLabel("状态");
	//面板
	JPanel pnlFoot=new JPanel();
	
	static String font=null;
	
	public MyNote()
	{
    	init();
    	jf.setTitle("记事本");
    	jf.setSize(400, 400);
    	jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	jf.setVisible(true);
	}
	
	public void init()
	{	//初始化
		for(int i=0;i<menu.length;i++)
		{
			jm.add(menu[i]);
//			if(i==menu.length-1)
//				break;
			for(int j=0;j<menuitem[i].length;j++)
			{
				menu[i].add(menuitem[i][j]);
				menuitem[i][j].addActionListener(new actionListener());
				if(i==0 && (j==3 || j==5))
				{
					menu[i].addSeparator();
				}
				if(i==1 && (j==0 || j==4 || j==8))
				{
					menu[i].addSeparator();
				}
			}
		}
		jf.setJMenuBar(jm);
		jf.add(scroll);
		jf.add(pnlFoot,BorderLayout.SOUTH);
		pnlFoot.add(label);
		label_show();
	}
	
	void label_show()
	{
		Timer timer = new Timer();
		TimerTask task=new TimerTask() {
		    @Override
		    public void run() {
		        label.setText("状态    "+"    字数/单词: "+getMSWordsCount(textarea.getText())+"    Time: "+new Date());
		    }
		};
		timer.scheduleAtFixedRate(task,0,1000);
	}

	//字符统计
	public int getMSWordsCount(String context)
	{
		int words_count = 0;
		//中文单词
		String cn_words = context.replaceAll("[^(\\u4e00-\\u9fa5，。《》？；’‘：“”【】、）（……￥！·)]", "");
		int cn_words_count = cn_words.length();
		//非中文单词
		String non_cn_words = context.replaceAll("[^(a-zA-Z0-9`\\-=\';.,/~!@#$%^&*()_+|}{\":><?\\[\\])]", " ");
		int non_cn_words_count = 0;
		String[] ss = non_cn_words.split(" ");
		for(String s:ss)
		{
			if(s.trim().length()!=0) 
				non_cn_words_count++;
		}
		//中文和非中文单词合计
		words_count = cn_words_count + non_cn_words_count;
		return words_count;
	}

	class actionListener implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO 自动生成的方法存根
			menu_show(e);
		}		
	}
	
	public void menu_show(ActionEvent e)
	{
		JMenuItem id=(JMenuItem)e.getSource(); 
		String content=id.getText();
		System.out.println(content);
		if(content.equals("新建"))
		{
			textarea.setText("");
		}
		else if(content.equals("打开"))
		{
			FileDialog dialog=new FileDialog(jf, "选择", FileDialog.LOAD);
			dialog.setVisible(true);
			String position=dialog.getDirectory();
			String filename=dialog.getFile();
			String path=position+filename;
			try 
			{
				List<String> line=Files.readAllLines(Paths.get(path),Charset.forName("utf8"));
				for(String s:line)
				{
					textarea.append(s+"\n");
				}
			} 
			catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			
		}
		else if(content.equals("保存"))
		{
			try 
			{
				String index="";
				int n=0;
				String defaultpath="C:\\Users\\Administrator\\Desktop\\新建文本文档"+index+".txt";
				File path=new File("C:\\Users\\Administrator\\Desktop\\新建文本文档"+index+".txt");
				System.out.println(path);
				System.out.println(path.exists());
				while(path.exists())
				{
					int judge=JOptionPane.showConfirmDialog(null, "文件名已经存在，是否覆盖原有文件  ?","保存文件到桌面",JOptionPane.YES_NO_OPTION);
					
					if(judge==0)//覆盖
					{
						break;
					}
					n++;
					index="("+n+")";
					defaultpath="C:\\Users\\Administrator\\Desktop\\新建文本文档"+index+".txt";
					path=new File("C:\\Users\\Administrator\\Desktop\\新建文本文档"+index+".txt");
				}

				BufferedWriter output=new BufferedWriter(new FileWriter(defaultpath));
				output.write(textarea.getText());
				output.flush();
				output.close();
				textarea.setText("");
			
			} 
			catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		else if(content.equals("另存为"))
		{
			FileDialog dialog=new FileDialog(jf,"另保存",FileDialog.SAVE);
			dialog.setVisible(true);
			String savepath=dialog.getDirectory()+dialog.getFile();

			try 
			{
				BufferedWriter output=new BufferedWriter(new FileWriter(savepath));
				output.write(textarea.getText());
				output.flush();
				output.close();
				textarea.setText("");
			} 
			catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		else if(content.equals("页面设置"))
		{
			
		}
		else if(content.equals("打印"))
		{
			//
		}
		else if(content.equals("退出"))
		{
			System.exit(0);
		}
		else if(content.equals("撤销"))
		{
			//
		}
		else if(content.equals("剪切"))
		{
			//获取系统剪切板
			java.awt.datatransfer.Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();  
			//复制文本到剪切板
			Transferable tText = new StringSelection(textarea.getText());  
	        clip.setContents(tText, null); 
	        textarea.setText("");
		}
		else if(content.equals("复制"))
		{
			java.awt.datatransfer.Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();  
	        Transferable tText = new StringSelection(textarea.getText());  
	        clip.setContents(tText, null); 
		}
		else if(content.equals("粘贴"))
		{
			//获取系统剪切板
			java.awt.datatransfer.Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard(); 
			Transferable clipTf = sysClip.getContents(null); 
			if(clipTf!=null)
			{
				if(clipTf.isDataFlavorSupported(DataFlavor.stringFlavor))  //判断剪切板内容是否是文本类型
				{
					try 
					{
						textarea.setText((String)clipTf.getTransferData(DataFlavor.stringFlavor));
					} 
					catch (UnsupportedFlavorException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} 
					catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			}
		}
		else if(content.equals("删除"))
		{
			textarea.setText("");
		}
		else if(content.equals("查找"))
		{
			
		}			
		else if(content.equals("查找下一个"))
		{
			
		}
		else if(content.equals("替换"))
		{
			
		}
		else if(content.equals("转到"))
		{
			
		}
		else if(content.equals("全选"))
		{
			
		}
		else if(content.equals("时间/日期"))
		{
			
		}
		else if(content.equals("自动换行"))
		{
			
		}
		else if(content.equals("字体"))
		{
			font_window window=new font_window();
			window.init();
			
		}
		else if(content.equals("字体颜色"))
		{
			//颜色选择对话框
			JColorChooser colorchooser = new JColorChooser();
			colorchooser.setVisible(true);
			Color color = JColorChooser.showDialog(jf,"字体颜色",null);
			textarea.setForeground(color);
		}
		else if(content.equals("背景颜色"))
		{
			//颜色选择对话框
			JColorChooser colorchooser = new JColorChooser();
			colorchooser.setVisible(true);
			Color color = JColorChooser.showDialog(jf,"背景颜色",null);
			textarea.setBackground(color);
		}
		else if(content.equals("绘图模式"))
		{
			
		}
		else if(content.equals("状态"))
		{
			
		}
		else if(content.equals("查看帮助"))
		{
			JFrame frame =new JFrame("查看帮助");
			frame.setSize(300,100);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setVisible(true);
			JTextArea area=new JTextArea();
			frame.add(area);
			area.setEditable(false);
		}
		else if(content.equals("关于记事本"))
		{
			JFrame frame =new JFrame("关于记事本");
			frame.setSize(300,100);
			frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			JTextArea area=new JTextArea();
			frame.add(area);
			area.setEditable(false);
			area.append("版本信息: 1.0 version"+"\n");
			area.append("作者：user_white"+"\n");
		}
		
	}
	class font_window
	{	
		JFrame fontchooser=new JFrame("字体设置");
		
		JLabel fontlabel=new JLabel("字体");
		JLabel glyphlabel=new JLabel("字形");
		JLabel sizelabel=new JLabel("大小");
		JTextField fonttextfield=new JTextField();
		JTextField glyphtextfield=new JTextField();
		JTextField sizetextfield=new JTextField();
		JLabel scriptlabel=new JLabel("脚本");
		JLabel examplelabel=new JLabel("AaBbYyZz");
		JLabel more=new JLabel("显示更多字体");
		JPanel fontpanel=new JPanel();
		JPanel glyphpanel=new JPanel();
		JPanel sizepanel=new JPanel();
		
		ListSelectionModel listmodel_font;
		ListSelectionModel listmodel_glyph;
		ListSelectionModel listmodel_size;
		
		private String current_fontName = "宋体";//当前的字体名称,默认宋体.
	    private int current_fontStyle = Font.PLAIN;//当前的字样,默认常规.
	    private int current_fontSize = 9;//当前字体大小,默认9号.
		
		JButton button[]=new JButton[] {
				new JButton("保存"),
				new JButton("取消")
		};
		//字体
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		String test_1[]=ge.getAvailableFontFamilyNames();
		String test_1[]=new String[] {
				"隶书","华文宋体","华文细黑","楷体","微软雅黑","新宋体","幼圆",
				"华文仿宋","华文行楷","华文隶书","方正兰亭超细黑简体","SketchFlow Print","Oswald","Prestige Elite Std                                   "
		};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList fontlist=new JList(test_1);
		JScrollPane fontscroll=new JScrollPane(fontlist);
		
		//字形
		String test_2[]=new String[] {"常规", "粗体", "斜体", "粗偏斜体           "};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList glyphlist=new JList(test_2);
		JScrollPane glyphscroll=new JScrollPane(glyphlist);

		//大小
		String test_3[]=new String[] {"8", "9", "10", "11", "12", "14", "16", "18", 
				"20", "22", "24", "26", "28", "36", "48", "初号", "小初", "一号", "小一", 
				"二号", "小二", "三号", "小三", "四号", "小四", "五号", "小五", "六号", "小六", "七号",
				"八号    "};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList sizelist=new JList(test_3);
		JScrollPane sizescroll=new JScrollPane(sizelist);
		
		String test[]=new String[] {"日语","中文","西欧语言","西里尔文" };
		JComboBox<String> scriptchoose=new JComboBox<String>(test);
		
		public void init()
		{
			fontchooser.setSize(440,440);
			fontchooser.setResizable(false);
			fontchooser.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			fontchooser.setVisible(true);
			initpanel(fontchooser);
		}
		
		//添加组件到面板
		public void initpanel(JFrame fontchoose)
		{	
			fontchoose.setLayout(null);
			fontchoose.add(fontlabel);
			fontchoose.add(fonttextfield);
			fontchoose.add(fontpanel);
			
			fontchoose.add(glyphlabel);
			fontchoose.add(glyphtextfield);
			fontchoose.add(glyphpanel);
			
			fontchoose.add(sizelabel);
			fontchoose.add(sizetextfield);
			fontchoose.add(sizepanel);
			
			fontchoose.add(examplelabel);
			
			fontchoose.add(scriptlabel);
			fontchoose.add(scriptchoose);
			
			fontchoose.add(more);
			for(int i=0;i<2;i++)
			{
				fontchoose.add(button[i]);
			}
			
			initlayout();
			
		}
		
		//面板布局
		public void initlayout()
		{
			fontlabel.setBounds(20, 10, 200, 20);
			fonttextfield.setBounds(20, 30, 220, 20);
			fontpanel.setBounds(20, 50, 220, 80);
			
			glyphlabel.setBounds(250, 10, 90, 20);	
			glyphtextfield.setBounds(250, 30, 90, 20);	
			glyphpanel.setBounds(250, 50, 90, 80);
			
			sizelabel.setBounds(350, 10, 60, 20);	
			sizetextfield.setBounds(350, 30, 60, 20);
			sizepanel.setBounds(350, 50, 60, 80);	
			
			examplelabel.setBounds(250, 150, 170, 60);
			examplelabel.setBorder(BorderFactory.createTitledBorder("示例"));
			examplelabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			
			scriptlabel.setBounds(250, 220, 150, 20);
			scriptchoose.setBounds(250, 250, 150, 20);	
			scriptchoose.setSelectedItem("中文");
			
			more.setBounds(20, 340, 140, 20);
			button[0].setBounds(270, 360, 60, 30);
			button[1].setBounds(340, 360, 60, 30);
			
			fontlist.setVisibleRowCount(5);
			fontlist.setVisibleRowCount(5);
			sizelist.setVisibleRowCount(5);
			fontpanel.add(fontscroll,BorderLayout.CENTER);
			glyphpanel.add(glyphscroll,BorderLayout.CENTER);
			sizepanel.add(sizescroll,BorderLayout.CENTER);
			initActionlistener();
		}
		
		//监听事件
		public void initActionlistener()
		{
			listmodel_font=fontlist.getSelectionModel();
			listmodel_font.addListSelectionListener(new font_listSelectionListener());	
			listmodel_glyph=glyphlist.getSelectionModel();
			listmodel_glyph.addListSelectionListener(new glyph_listSelectionListener());	
			listmodel_size=sizelist.getSelectionModel();
			listmodel_size.addListSelectionListener(new size_listSelectionListener());	
				
			for(int i=0;i<2;i++)
			{
				button[i].addActionListener(new buttonActionListener());
			}
			
		}
		class font_listSelectionListener implements ListSelectionListener
		{
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO 自动生成的方法存根
				ListSelectionModel lsm=(ListSelectionModel)e.getSource();
				//得到选择的值
				fonttextfield.setText((String) fontlist.getSelectedValue());
				current_fontName=fonttextfield.getText();
				examplelabel.setFont(new Font(current_fontName, current_fontStyle, current_fontSize));
				
				System.out.println(lsm.getLeadSelectionIndex());
			}
		}
		class glyph_listSelectionListener implements ListSelectionListener
		{
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO 自动生成的方法存根
				ListSelectionModel lsm=(ListSelectionModel)e.getSource();
				//得到选择的值
				glyphtextfield.setText((String) glyphlist.getSelectedValue());
				if(glyphtextfield.getText().equals("常规"))
				{
					current_fontStyle=Font.PLAIN;
				}
				else if(glyphtextfield.getText().equals("粗体"))
				{
					current_fontStyle=Font.BOLD;
				}
				else if(glyphtextfield.getText().equals("斜体"))
				{
					current_fontStyle=Font.ITALIC;
				}
				else if(glyphtextfield.getText().equals("粗偏斜体"))
				{
					current_fontStyle=Font.BOLD+ Font.ITALIC;
				}
				examplelabel.setFont(new Font(current_fontName, current_fontStyle, current_fontSize));
				
				System.out.println(lsm.getLeadSelectionIndex());
			}
		}
		
		class size_listSelectionListener implements ListSelectionListener
		{
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO 自动生成的方法存根
				ListSelectionModel lsm=(ListSelectionModel)e.getSource();
				//得到选择的值
				sizetextfield.setText((String) sizelist.getSelectedValue());
				current_fontSize=Integer.parseInt(sizetextfield.getText());
				examplelabel.setFont(new Font(current_fontName, current_fontStyle, current_fontSize));
				
				System.out.println(lsm.getLeadSelectionIndex());
			}
		}
		
		class buttonActionListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JButton button=(JButton)e.getSource();
				if(button.getText().equals("保存"))
				{
					save_show();
				}
				fontchooser.dispose();
			}
			public void save_show()
			{		
//				String font;
//				int glyph=Font.PLAIN;
//				int size;
//				font=fonttextfield.getText();
//				if(glyphtextfield.getText().equals("常规"))
//				{
//					glyph=Font.PLAIN;
//				}
//				else if(glyphtextfield.getText().equals("粗体"))
//				{
//					glyph=Font.BOLD;
//				}
//				else if(glyphtextfield.getText().equals("斜体"))
//				{
//					glyph=Font.ITALIC;
//				}
//				else if(glyphtextfield.getText().equals("粗偏斜体"))
//				{
//					glyph=Font.BOLD& Font.ITALIC;
//				}
//				size=Integer.parseInt(sizetextfield.getText());
				Font f=new Font(current_fontName, current_fontStyle, current_fontSize);
				textarea.setFont(f);
			}
		}
	}
	

		

	
    public static void main(String[] args)
    {
    	new MyNote();
	}
}

