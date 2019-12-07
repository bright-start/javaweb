package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Test {
	public static void main(String[] args) throws IOException {
		String path="E:\\javaEE\\eclipseWorkspace\\JavaWeb\\Test\\src\\util\\User.java";
		FileReader reader = new FileReader(new File(path));
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		ZJutil zJutil = new ZJutil();
		while((line = bufferedReader.readLine()) != null) {
			zJutil.find(line);
		}
	}
}
