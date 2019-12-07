package 中国大学练习;

import java.io.*;

import javax.swing.JFrame;

import java.awt.*;

public class FileDisplay{
	public static void main(String args[]){
		JFrame f = new JFrame("test for filedialog");
		TextArea text = new TextArea(140,40);
		f.add( text );
		f.setSize(600,500);
		f.setVisible(true);
		
		FileDialog fd=new FileDialog(f,"文件对话框",FileDialog.LOAD);
		fd.setVisible(true);
		String fpath=fd.getDirectory();
		String fname=fd.getFile();
		String si=fpath+fname;
		
		File file = new File(si);  
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s;
			s = in.readLine();
			while ( s != null ) {
				text.append( s + "\n" );
				s = in.readLine();
			}
			in.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}	
	}
}