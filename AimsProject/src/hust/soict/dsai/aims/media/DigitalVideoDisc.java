package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	private LocalDate dateAdded;
	
	private static int nbDigitalVideoDiscs = 0;
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	public String toString() {
		return "DVD" + " - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $"; 
	}
	
	public boolean isMatch(String title) {
		String[] tokens = title.split(" ", 0);
		for (String token : tokens) {
			if (this.title.contains(token)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(DigitalVideoDisc dvd) {
		return (dvd.getId() == this.id);
	}
}
