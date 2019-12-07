package 多媒体资料库;

public class CD extends Item {
	private String artist;
	private int numofTracks;
	private int playingTime;
	private boolean goIt = false;
	private String comment;
	
	public CD(String title, String artist, int numofTracks, int playingTime,
			String comment) {
		super(title,playingTime,false,comment);
		this.artist = artist;
		this.numofTracks = numofTracks;
	}
	
	public void print() {
		System.out.println("CD [artist=" + artist+", numofTracks=" + numofTracks + ", toString()=" + super.toString() + "]"); 
	}
}
