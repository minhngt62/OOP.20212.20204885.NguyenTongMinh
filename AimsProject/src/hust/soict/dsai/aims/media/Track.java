package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}


	public Track(String title) {
		this.title = title;
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Track) {
			return this.title.equals(((Track)o).getTitle()) && 
					this.length == ((Track)o).getLength();
		}
		return false;
	}
	
	public StringBuffer play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
		
		StringBuffer info = new StringBuffer("");
		info.append("Playing track: " + this.getTitle() + "\n" + "Track length: " + this.getLength());
		return info;
	}
}
