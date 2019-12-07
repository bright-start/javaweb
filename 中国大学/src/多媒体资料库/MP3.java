package 多媒体资料库;

public class MP3 extends Item {
	private String artist;

	public MP3(String title, String artist, int playingTime, boolean gotIt, String comment) {
		super();
		setTitle(title);
		this.artist = artist;
	}
	public void print() {
		System.out.println("MP3:");
		super.print();
		System.out.println(artist);
	}
}
