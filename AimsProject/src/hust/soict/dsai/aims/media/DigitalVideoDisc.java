package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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
	public void setTitle(String title) {
		this.title = title;
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
	
	public StringBuffer play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
			
			StringBuffer info = new StringBuffer("");
			info.append("Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength());
			return info;
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
		
	}

}
