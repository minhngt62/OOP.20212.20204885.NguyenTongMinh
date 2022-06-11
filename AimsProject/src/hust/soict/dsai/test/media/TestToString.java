package hust.soict.dsai.test.media;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;

public class TestToString {
	public static void main(String[] args) {
		ArrayList<Media> medias = new ArrayList<Media>();
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		Book book = new Book("Hands-on Machine Learning", "Technology", 
				20.00f);
		CompactDisc cd = new CompactDisc("Perfect Time", "Music", 
				15.98f);
		
		medias.add(cd);
		medias.add(dvd);
		medias.add(book);
		
		for (Media m : medias) {
			System.out.println(m.toString());
		}
	}

}
