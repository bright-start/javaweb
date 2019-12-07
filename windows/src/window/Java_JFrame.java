package window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

//我们用JLayeredPane，JLayeredPane 为 JFC/Swing 容器添加了深度，允许组件在需要时互相重叠。
//Integer 对象指定容器中每个组件的深度，其中编号较高的组件位于其他组件之上
//层次依次是:Default,Palette,Modal,PopUp,Drag
@SuppressWarnings("serial")
public class Java_JFrame extends JFrame 
{  
  //创建一个JLayeredPane用于分层的。  
  JLayeredPane layeredPane;  
  //创建一个Panel和一个Label用于存放图片，作为背景。  
  JPanel jp;  
  JLabel jl;  
  ImageIcon image;  

  //创建一个按钮用于测试的。  
  JButton jb;  
  public static void main(String[] args)  
  {  
      new Java_JFrame();  
  }  

  public Java_JFrame()  
  {  
      layeredPane=new JLayeredPane();  
      image=new ImageIcon("C:\\\\Users\\\\Administrator\\\\Desktop\\\\1.jpg");//随便找一张图就可以看到效果。        
      //创建背景的那些东西  
      jp=new JPanel();  
      jp.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  

      jl=new JLabel(image);  
//    jl.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
      jp.add(jl);  

      //创建一个测试按钮  
      jb=new JButton("测试按钮");  
      jb.setBounds(100,100,100,100);  

      //将jp放到最底层。                                    /*层次关系可见方法2下面的注释*/
      layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);  
      //将jb放到高一层的地方  
      layeredPane.add(jb,JLayeredPane.MODAL_LAYER);  

      this.setLayeredPane(layeredPane);  
      this.setSize(image.getIconWidth(),image.getIconHeight());  
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      this.setLocation(image.getIconWidth(),image.getIconHeight());  
      this.setVisible(true);    
  }  
}