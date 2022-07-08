package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.exception.LimitExceededException;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = 
			FXCollections.observableArrayList();
	
	public float totalCost() {
		float totalCost = 0;
		for (Media d : itemsOrdered) {
			if (d != null) {
				totalCost += d.getCost();
			}
		}
		return totalCost;
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public int addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() <  MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("The media has been added to the cart");
			return 1;
		} else {
			throw new LimitExceededException("ERROR: The cart is almost full"); 
		}
	}
	public int addMedia(Media media1, Media media2) throws LimitExceededException {
		int countAdded = 0;
		try {
			countAdded += addMedia(media1);
			countAdded += addMedia(media2);
		} catch (LimitExceededException e) {
			throw e;
		}
		
		return countAdded;		
	}
	public int addMedia(ArrayList<Media> medias) throws LimitExceededException {
		int countAdded = 0;
		for (int i=0; i<medias.size(); i++) {
			try {
				countAdded += addMedia(medias.get(i));
			} catch (LimitExceededException e) {
				throw e;
			}
		}
		return countAdded;
	}
	
	public int removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("The media has been removed from the cart");
			return 1;
		}
		System.out.println("The media is not in the cart");
		return 0;
	}
	
	public Media getALuckyItem() {
		if (itemsOrdered.size() >= 5) {
			int index = (int)(Math.random() * itemsOrdered.size());
			Media luckyItem = itemsOrdered.get(index);
			System.out.println("The lucky item: " + luckyItem);
			
			removeMedia(luckyItem);
			System.out.println("The bill of this order is now " + totalCost());
			
			return luckyItem;
		}
		return null;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		int index = 0;
		for (Media d : itemsOrdered) {
			if (d != null) {
				index++;
				System.out.println(index + ". " + d);
			}
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("**************************************************");
	}
	
	public void search(int id) {
		int count = 0;
		for (Media d : itemsOrdered) {
			if (d != null && d.getId() == id) {
				count++;
				System.out.println("Found a DVD of the ID: " + d);
			}
		}
		if (count == 0) {
			System.out.println("Cannot find any DVD of the ID!");
		}
	}
	public void search(String title) {
		int count = 0;
		for (Media d : itemsOrdered) {
			if (d != null && d.isMatch(title)) {
				count++;
				System.out.println("Found a DVD of the title: " + d);
			}
		}
		if (count == 0) {
			System.out.println("Cannot find any DVD of the title!");
		}
	}
	
	public void playMedia(String title) {
		for (Media d : itemsOrdered) {
			if (d.getTitle().equals(title)) {
				try {
					((Playable)d).play();
				} catch (PlayerException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
