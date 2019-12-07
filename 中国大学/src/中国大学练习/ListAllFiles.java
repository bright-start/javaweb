package 中国大学练习;

import java.io.*;
class  ListAllFiles 
{
	public static void main(String[] args){ 
		ListFiles( new File( "E:\\C-C++\\中国大学\\java图形编程范例"));
	}

	public static void ListFiles( File dir ){
		if( !dir.exists() || ! dir.isDirectory() ) return;
		
		String [] files = dir.list();
		for( int i=0; i<files.length; i++){
			File file = new File( dir, files[i] );
			if( file.isFile() ){
				System.out.println( 
					dir + "\\" + file.getName() + "\t" + file.length() );
			}else{
				System.out.println( 
					dir + "\\" + file.getName() + "\t<dir>" );
				
				ListFiles( file );  //对于子目录,进行递归调用
			}
		}
	}
}
