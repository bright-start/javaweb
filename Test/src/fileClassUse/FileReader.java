package fileClassUse;

import java.io.File;

/**
 * ��ȡ�ļ��б�
 * @author Administrator
 *
 */
public class FileReader {

	//�ļ��ݹ��ѯ
	private static void queryFile(String path){
		File file = new File(path);
		File[] files = file.listFiles();
		for(File f : files) {
			System.out.println("�ļ���: --" + f.getName()+ "||" + f.getPath());
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
