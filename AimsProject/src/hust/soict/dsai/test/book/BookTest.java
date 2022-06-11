package hust.soict.dsai.test.book;
import hust.soict.dsai.aims.media.*;
import java.util.*;

public class BookTest {
	public static void main(String[] args) {
		ArrayList<String> authors = new ArrayList<String>();
		authors.add("Geron");
		String content = "Assume that this is the content of the book";
		
		Book book = new Book("Hands-on Machine Learning", "Technology", 
				20.00f, authors, 500, content);
		
		System.out.println(book);
		
		//print wordFeq
		System.out.println();
		for (String key : book.getWordFrequency().keySet()) {
			System.out.println(key + ": " + book.getWordFrequency().get(key));
		}
	}
	
}
