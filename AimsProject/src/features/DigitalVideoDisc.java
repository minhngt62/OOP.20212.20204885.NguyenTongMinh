package features;
import java.time.LocalDate;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private int id;
	private LocalDate dateAdded;
	
	private static int nbDigitalVideoDiscs = 0;
	
	public int getId() {
		return id;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
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
}
