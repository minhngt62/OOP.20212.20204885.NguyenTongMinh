package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class Book extends Media {
	private ArrayList<String> authors = new ArrayList<String>();
	
	public Book(String title) {
		super(title);
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}
	
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("This author has already been in the list");
		} else {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		} else {
			System.out.println("This author is not in the list");
		}
	}

}
