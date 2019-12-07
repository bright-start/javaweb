package 中国大学练习;

import java.io.*;

public class CopyFileAddLineNumber {

	public static void main(String[] args) {
		//文件流的输入与输出
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
		
			BufferedReader in=new BufferedReader(new FileReader(fin));
			PrintWriter out=new PrintWriter(new FileWriter(fout));
			int cnt =0;
			String s=in.readLine();
			while(s!=null)
			{
				cnt++;
				s=deleteComments(s);
				out.println(cnt+"\t"+s);
				s=in.readLine();
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
		int pos=s.indexOf ("//");
		if(pos<0)
			return s;
		return s.substring(0, pos);
	}

}
