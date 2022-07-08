package hust.soict.dsai.test.cart;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.MediaUtils;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		try {
			cart.addMedia(dvd1);
		} catch (LimitExceededException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), e1.toString(), JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
				"George Lucas", 87, 19.95f);
		try {
			cart.addMedia(dvd2);
		} catch (LimitExceededException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.toString(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",
				18.99f);
		try {
			cart.addMedia(dvd3);
		} catch (LimitExceededException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.toString(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		//Test the print method
		cart.print();
		
		//Test the sort by cost method
		MediaUtils.sortByCost((ArrayList<Media>) cart.getItemsOrdered());
		
		//Test the sort by title method
		MediaUtils.sortByTitleCost((ArrayList<Media>) cart.getItemsOrdered());
		
		//Test the search by id
		cart.search(3);
	}

}
