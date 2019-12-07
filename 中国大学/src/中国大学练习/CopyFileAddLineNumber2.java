package 中国大学练习;

import java.io.*;
import java.awt.*;
import java.text.*;

public class CopyFileAddLineNumber2 {

	public static void main(String[] args) {
//		FileDialog fd=new FileDialog(new Frame(),"文件对话框",FileDialog.LOAD);
//		fd.setVisible(true);
//		String fpath=fd.getDirectory();
//		String fname=fd.getFile();
//		String si=fpath+fname;
//		File file =new File(si);
		String infname="E:\\eclipse\\中国大学课堂测验\\src\\中国大学课堂测验\\CopyFileAddLineNumber.java";
		String outfname="E:\\eclipse\\中国大学课堂测验\\src\\中国大学课堂测验\\CopyFileAddLineNumber.txt";
		if(args.length>=1)
			infname=args[0];
		if(args.length>=2)
			outfname=args[1];
		try
		{
			File fin=new File(infname);
			File fout=new File(outfname);
			LineNumberReader in=new LineNumberReader(new FileReader(fin));
			PrintWriter out= new PrintWriter(new FileWriter(fout));
			DecimalFormat fmt=new DecimalFormat("00");
			int cnt=0;
			String s =in.readLine();
			while(s!=null)
			{
				cnt=in.getLineNumber();
				s=deleteComments(s);
				out.println(fmt.format(cnt)+":\t"+s);
				s =in.readLine();
			
			}
			in.close();
			out.close();
		}
			catch(FileNotFoundException e1)
			{
				System.out.println("File not found!");
			}
			catch(IOException e2)
			{
				e2.printStackTrace();
			}

	}
	static String deleteComments(String s)
	{
		if(s==null)
			return s;
		int pos=s.indexOf("//");
		if(pos<0)
			return s;
		return s.substring(0, pos);

	}
}
