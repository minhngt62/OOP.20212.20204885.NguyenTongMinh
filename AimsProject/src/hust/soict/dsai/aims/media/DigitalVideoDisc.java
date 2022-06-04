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
		super(title);
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
	}
	
	public String toString() {
		return "DVD" + " - " + super.getTitle() + " - " + super.getCategory() + " - " + director + " - " + length + ": " + super.getCost() + " $"; 
	}
	
	public boolean isMatch(String title) {
		String[] tokens = title.split(" ", 0);
		for (String token : tokens) {
			if (super.getTitle().contains(token)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(DigitalVideoDisc dvd) {
		return (dvd.getId() == super.getId());
	}
}
