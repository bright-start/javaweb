package 中国大学练习;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class URLCrawler extends JFrame
{
	public static void main(String[] args) throws Exception 
	{
		ConcurrentLinkedQueue<String> urls=new ConcurrentLinkedQueue<>();
		urls.add("http://www.dstang.com");
		int cnt=0;
		while(!urls.isEmpty())
		{
			String url=urls.poll();
			System.out.println(url);
			new Thread( ()->{
				
				try 
				{
					String content=download(new URL(url),"gb2312");
					List<String> moreUrl=parse(content);
					urls.addAll(moreUrl);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}).start();
			if(cnt++>5)
				break;
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException ex)
			{
				
			}
		}
	}
	static List<String> parse(String text){
		String patternString="\\s*href\\s*=\\s*(\"([^\"]*\")|(\'[^\']*\')|([^\'\">\\s]+))\\s*";
		Pattern pattern=Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(text);
		List<String> list=new ArrayList<>();
		while(matcher.find()) {
			String href=matcher.group(1);
			href =href.replaceAll("\'", "");
			if(href.startsWith("http:"))
					list.add(href);
		}
		return list;
	}
	static String download(URL url,String charset) throws Exception
	{
		try(InputStream input =url.openStream();
				ByteArrayOutputStream output=new ByteArrayOutputStream()
				)
		{
			byte[] data=new byte[1024];
			int length;
			while((length=input.read(data))!=-1) {
				output.write(data,0,length);
			}
			byte[] content= output.toByteArray();
			return new String(content,Charset.forName(charset));
		}
	}
}

