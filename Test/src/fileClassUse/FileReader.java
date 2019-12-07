package fileClassUse;

import java.io.File;

/**
 * 读取文件列表
 * @author Administrator
 *
 */
public class FileReader {

	//文件递归查询
	private static void queryFile(String path){
		File file = new File(path);
		File[] files = file.listFiles();
		for(File f : files) {
			System.out.println("文件名: --" + f.getName()+ "||" + f.getPath());
			if(f.isDirectory()) {
				System.out.println("------------");
				queryFile(f.getAbsolutePath());
			}
		}
	}
	
	public static void main(String[] args) {
		String path = "E:\\C-C++";
		FileReader fileReader = new FileReader();
		fileReader.queryFile(path);
	}
}
