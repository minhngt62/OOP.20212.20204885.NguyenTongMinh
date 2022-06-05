package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public class DigitalVideoDisc extends Disc implements Playable {
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
		return "DVD" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + director + " - " + length + ": " + this.getCost() + " $"; 
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
