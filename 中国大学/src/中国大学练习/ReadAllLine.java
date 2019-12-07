package 中国大学练习;

import java.nio.file.*;
import java.nio.charset.*;
import java.util.List;

class ReadAllLine
{
	public static void main(String[] args) throws java.io.IOException
	{
		String filePath = "E:\\eclipse\\中国大学课堂测验\\src\\中国大学课堂测验\\ReadAllLine.java";

		List<String> lines = Files.readAllLines(
			Paths.get(filePath),  
			Charset.forName("utf8") //or Charset.defaultCharset()
		);
		for(String s : lines ) System.out.println(s);
	}
}
