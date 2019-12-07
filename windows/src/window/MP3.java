package window;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.media.Player;

public class MP3{
  
	private Player player;
	private URL url;
	private File file;
	private String path = "E:\\eclipse\\windows\\songs\\韩磊-一路执着.wav";
	@SuppressWarnings("deprecation")
	MP3(){
		file = new File(path);
		try {
			url = file.toURL();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		player.start();
		
		player.stop();
	}
	
    public static void main(String args[]) {
        new MP3();
    }
}