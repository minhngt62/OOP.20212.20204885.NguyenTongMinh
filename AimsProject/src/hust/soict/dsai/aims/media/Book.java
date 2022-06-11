package hust.soict.dsai.aims.media;
import java.util.*;

public class Book extends Media {
	private ArrayList<String> authors = new ArrayList<String>();
	private int length;
	
	private String content;
	private ArrayList<String> contentTokens;
	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
	
	public Book(String title, int length) {
		super(title);
		this.length = length;
	}
	public Book(String title, String category, float cost, int length) {
		super(title, category, cost);
		this.length = length;
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	public Book(String title, String category, float cost, ArrayList<String> authors, int length, String content) {
		super(title, category, cost);
		this.authors = authors;
		this.length = length;
		
		this.content = content;
		processContent();
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}
	public int getLength() {
		return this.length;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
		processContent();
	}
	public Map<String, Integer> getWordFrequency() {
		return this.wordFrequency;
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
	
	public String toString() {
		return this.getTitle() + "-" + this.getCategory() + "-" + this.authors
				+ "-" + this.length + ": " + this.getCost() + " $" + "\n" + content;
	}
	
	public void processContent() {
		this.contentTokens = new ArrayList<String>(Arrays.asList(this.content.split(" ")));
		Collections.sort(contentTokens);

		for (String token : this.contentTokens) {
			if (wordFrequency.get(token) == null) {
				wordFrequency.put(token, 1);
			} else {
				wordFrequency.put(token, (wordFrequency.get(token) + 1));
			}
		}
		
	}

}
