package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	public Disc(String title) {
		super(title);
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	

}
