package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.*;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		//Test addDVD method
		store.addDVD(dvd1);
		store.print();
		
		//Test removeDVD method
		store.removeDVD(dvd1);
		store.print();
	}
}
