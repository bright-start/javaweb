package window;

 import javax.swing.*; 
 import java.awt.event.InputEvent; 
 import java.awt.event.KeyEvent; 
 public class java0301
 { 
	 public static void main(String args[])
	 {
		 @SuppressWarnings("unused")
		JFrame win = new JFrame("浏览器"); 
		 //创建并添加菜单栏 JMenuBar menuBar = new JMenuBar(); win.setJMenuBar(menuBar); //创建并添加各菜单，注意：菜单的快捷键是同时按下Alt键和字母键，方法setMnemonic('F')是设置快捷键为Alt +Ｆ 
		 JMenu menuFile = new JMenu("文件(F)"), menuEdit = new JMenu("编辑(E)"), menuView = new JMenu("查看(V)"); 
		 menuFile.setMnemonic('F');
		 menuEdit.setMnemonic('E'); 
		 menuView.setMnemonic('V'); 
		 JMenu itemOpen = new JMenu("打开");
		 itemOpen.setMnemonic('O'); 
		 JMenuItem itemOpen1 = new JMenuItem("打开x");
		 JMenuItem itemOpen2 = new JMenuItem("打开y");
		 itemOpen.add(itemOpen1); itemOpen.add(itemOpen2); 
		 JMenuItem itemSave = new JMenuItem("保存"); 
		 itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK)); menuFile.add(itemOpen); menuFile.add(itemSave);
	 }
 
 }