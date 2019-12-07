package 绘画;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Picture extends JFrame {
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	
	private ArrayList<AbstractShape> listShape = new ArrayList<AbstractShape>();
	
	private class ShapesPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for ( AbstractShape s : listShape )
			{
				s.draw(g);
			}			
		}
		
	}
	
	public void add(AbstractShape s)
	{
		listShape.add(s);
	}

	public Picture(int width, int height)
	{
		add(new ShapesPanel());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.width = width;
		this.height = height;
	}
	
	public void draw()
	{
		setLocationRelativeTo(null);
		setSize(width, height);
		setVisible(true);
	}
}
