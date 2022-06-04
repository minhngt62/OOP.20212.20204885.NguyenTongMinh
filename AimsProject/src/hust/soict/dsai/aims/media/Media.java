package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	
	private static int nbMedia = 0;
	
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public int getId() {
		return id;
	}
	
	
	public Media(String title) {
		this.title = title;
		this.dateAdded = LocalDate.now();
		nbMedia++;
		this.id = nbMedia;
	}
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbMedia++;
		this.id = nbMedia;
	}

}
