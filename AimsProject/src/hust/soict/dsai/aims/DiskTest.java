package hust.soict.dsai.aims;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;

public class DiskTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
				"George Lucas", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",
				18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		//Test searchByTitle method
		cart.search("Aladin of Star");
		
		//Test isMatch method
		System.out.println(dvd1.isMatch("Aladin of Star"));

	}
}
