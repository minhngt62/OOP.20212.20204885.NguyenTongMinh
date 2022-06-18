package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;

public class Store {
	private ArrayList<Media> itemsInStore = 
			new ArrayList<Media>();
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public int addMedia(Media media) {
		itemsInStore.add(media);
		System.out.println("The media has been added");
		return 1;
	}
	
	public int removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("The media has been removed from the store");
			return 1;
		}
		System.out.println("The media is not in the store");
		return 0;
	}
	
	public void print() {
		System.out.println("***********************STORE***********************");
		System.out.println("Store Items:");
		int index = 0;
		for (Media d : itemsInStore) {
			if (d != null) {
				index++;
				System.out.println(index + ". " + d);
			}
		}
		System.out.println("***************************************************");
	}
	
	public Media getMedia(String title) {
		for (Media media : itemsInStore) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
	
	public void playMedia(String title) {
		for (Media d : itemsInStore) {
			if (d.getTitle().equals(title)) {
				if (d instanceof Playable) {
					((Playable)d).play();
					break;
				}
			}
		}
	}
}
