package hust.soict.dsai.aims.media;
import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
	private int id;
	String title; //for testing parameter
	private String category;
	private float cost;
	private LocalDate dateAdded;
	
	private static int nbMedia = 0;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
			new MediaComparatorByCostTitle();
	
	
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
	
	public boolean equals(Object o) {
		try {
			return ((Media)o).getId() == this.id;
		} catch (NullPointerException e) {
			return false;
		} catch (ClassCastException e1) {
			return false;
		}
		
	}
	
	public String toString() {
		return "Media" + " - " + this.title + " - " + this.category + ": " + this.cost + " $"; 
	}

	
	public boolean isMatch(String title) {
		String[] tokens = title.split(" ", 0);
		for (String token : tokens) {
			if (this.getTitle().contains(token)) {
				return true;
			}
		}
		return false;
	}
	
	public int compareTo(Media d) {
		try {
			int titleDiff = this.getTitle().compareTo(d.getTitle());
			if (titleDiff != 0) {
				return titleDiff;
			} else {
				return this.getCategory().compareTo(d.getCategory());
			}
		} catch (NullPointerException e) {
			return -1; // null is before all others
		}
	}
	
	public boolean filterProperty(String filter, String type) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else {
    		if (type == "title") {
    			if (this.getTitle().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    				return true;
    			}
    		} else if (type == "id") {
    			if(Integer.toString(this.getId()).toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    				return true;
    			}
    		}
        }
        return false;
	}
}
