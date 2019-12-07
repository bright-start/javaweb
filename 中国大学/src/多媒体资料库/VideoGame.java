package 多媒体资料库;

public class VideoGame extends Item {
	private int numberofPlayers;
	
	public VideoGame(String title, int playingTime, boolean gotIt, String comment, int number) {
		super(title,playingTime, gotIt, comment);
		numberofPlayers = number;
	}
	
	public void print() {
		System.out.println("VideoGame:");
		super.print();
		System.out.println(numberofPlayers);
	}
}
