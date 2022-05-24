package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.*;

public class Store {
	private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[0];
	
	public void print() {
		System.out.println("***********************STORE***********************");
		System.out.println("Items in Store:");
		int index = 0;
		for (DigitalVideoDisc d : itemsInStore) {
			if (d != null) {
				index++;
				System.out.println(index + ". " + d);
			}
		}
		System.out.println("**************************************************");
	}
	
	public void addDVD(DigitalVideoDisc dvd) {
		DigitalVideoDisc[] newItemsInStore = new DigitalVideoDisc[itemsInStore.length + 1];
		for (int i=0; i<itemsInStore.length; i++) {
			newItemsInStore[i] = itemsInStore[i];
		}
		newItemsInStore[itemsInStore.length] = dvd;
		itemsInStore = newItemsInStore;
		System.out.println("Added to the store: " + dvd);
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		int remove_pos = -1;
		for (int i=0; i<itemsInStore.length; i++) {
			if (itemsInStore[i].equals(dvd)) {
				itemsInStore[i] = null;
				remove_pos = i;
				break;
			}
		}
		if (remove_pos != -1) {
			for (int i=remove_pos; i<itemsInStore.length - 1; i++) {
				itemsInStore[i] = itemsInStore[i+1];
				itemsInStore[i+1] = null;
			}
			DigitalVideoDisc[] newItemsInStore = new DigitalVideoDisc[itemsInStore.length - 1];
			for (int i=0; i<itemsInStore.length - 1; i++) {
				newItemsInStore[i] = itemsInStore[i];
			}
			itemsInStore = newItemsInStore;
			System.out.println("Remove from the store: " + dvd);
		} else {
			System.out.println("There is no such DVDs in the store.");
		}
		
	}
	
	public DigitalVideoDisc getDVD(String title) {
		DigitalVideoDisc targetDVD = null;
		for (DigitalVideoDisc d : itemsInStore) {
			if (d != null && d.getTitle().equals(title)) {
				targetDVD = d;
				break;
			}
		}
		return targetDVD;
	}
}
