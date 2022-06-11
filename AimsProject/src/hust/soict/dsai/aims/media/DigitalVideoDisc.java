package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private String director;
	private int length;
	
	private static int nbDigitalVideoDiscs = 0;
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title) {
		super(title);
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
		nbDigitalVideoDiscs++;
	}
	
	public String toString() {
		return "DVD" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + director + " - " + length + ": " + this.getCost() + " $"; 
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

}
