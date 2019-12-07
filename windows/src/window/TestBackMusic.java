package window;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class TestBackMusic {

	private String path = "E:\\eclipse\\windows\\songs\\韩磊-一路执着.wav";
	private File file;
	private URL url;
	private AudioClip au;
	@SuppressWarnings("deprecation")
	TestBackMusic() throws MalformedURLException{
		file = new File(path);
		url = file.toURL();
		au = Applet.newAudioClip(url);
		new Thread(()-> {
			au.play();
		}).start();
		
		Scanner in = new Scanner(System.in);
		in.nextLine();
		au.stop();
		in.nextLine();
		au.play();
		//au.loop();
		System.out.println("play");
	}
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO 自动生成的方法存根
		TestBackMusic bm = new TestBackMusic();
		//bm.play();
	}

}
