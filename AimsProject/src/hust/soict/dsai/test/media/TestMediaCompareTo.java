package hust.soict.dsai.test.media;
import hust.soict.dsai.aims.media.*;
import java.util.*;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		ArrayList<Media> collection = new ArrayList<Media>();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
				"George Lucas", 87, 19.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",
				18.99f);
		Book book1 = new Book("Hands-on Machine Learning", "Technology", 
				20.00f);
		CompactDisc cd1 = new CompactDisc("Perfect Time", "Music", 
				15.98f);
		
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		collection.add(book1);
		collection.add(cd1);
		
		Iterator<Media> iterator = collection.iterator();
		
		System.out.println("-----------------------------------");
		System.out.println("The medias currently in the order are: ");
		
		while (iterator.hasNext()) {
			System.out.println(((Media)iterator.next()).getTitle());
		}
		
		Collections.sort((List<Media>)collection);
		
		iterator = collection.iterator();
		
		System.out.println("-----------------------------------");
		System.out.println("The medias in sorted order are: ");
		
		while (iterator.hasNext()) {
			System.out.println(((Media)iterator.next()).getTitle());
		}
		
		System.out.println("-----------------------------------");
		
		Collections.sort((List<Media>)collection, Media.COMPARE_BY_COST_TITLE);
		
		iterator = collection.iterator();
		
		System.out.println("-----------------------------------");
		System.out.println("The medias in sorted order (cost-title) are: ");
		
		while (iterator.hasNext()) {
			System.out.println(((Media)iterator.next()).getTitle());
		}
		
		System.out.println("-----------------------------------");
	}

}
