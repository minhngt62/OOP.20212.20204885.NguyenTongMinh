package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new
			ArrayList<Media>();
	
	public float totalCost() {
		float totalCost = 0;
		for (Media d : itemsOrdered) {
			if (d != null) {
				totalCost += d.getCost();
			}
		}
		return totalCost;
	}
	
	public int addMedia(Media media) {
		if (itemsOrdered.size() <  MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("The media has been added to the cart");
			return 1;
		}
		System.out.println("The cart is almost full");
		return 0;
	}
	public int addMedia(Media media1, Media media2) {
		int countAdded = 0;
		countAdded += addMedia(media1);
		countAdded += addMedia(media2);
		return countAdded;
	}
	public int addMedia(ArrayList<Media> medias) {
		int countAdded = 0;
		for (int i=0; i<medias.size(); i++) {
			int isAdded = addMedia(medias.get(i));
			if (isAdded == 0) {
				return countAdded;
			} else {
				countAdded += isAdded;
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
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		int index = 0;
		itemsOrdered = DVDUtils.sortByTitleCostLength(itemsOrdered);
		for (DigitalVideoDisc d : itemsOrdered) {
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
		for (DigitalVideoDisc d : itemsOrdered) {
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
		for (DigitalVideoDisc d : itemsOrdered) {
			if (d != null && d.isMatch(title)) {
				count++;
				System.out.println("Found a DVD of the title: " + d);
			}
		}
		if (count == 0) {
			System.out.println("Cannot find any DVD of the title!");
		}
	}
	
	public void sortByCost() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		int index = 0;
		itemsOrdered = DVDUtils.sortByCost(itemsOrdered);
		for (DigitalVideoDisc d : itemsOrdered) {
			if (d != null) {
				index++;
				System.out.println(index + ". " + d);
			}
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("**************************************************");
	}
	public void sortByTitle() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		int index = 0;
		itemsOrdered = DVDUtils.sortByTitle(itemsOrdered);
		for (DigitalVideoDisc d : itemsOrdered) {
			if (d != null) {
				index++;
				System.out.println(index + ". " + d);
			}
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("**************************************************");
	}
	public void sortByCostTitle() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		int index = 0;
		itemsOrdered = DVDUtils.sortByCostTitle(itemsOrdered);
		for (DigitalVideoDisc d : itemsOrdered) {
			if (d != null) {
				index++;
				System.out.println(index + ". " + d);
			}
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("**************************************************");
	}
	public void sortByTitleCost() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		int index = 0;
		itemsOrdered = DVDUtils.sortByTitleCost(itemsOrdered);
		for (DigitalVideoDisc d : itemsOrdered) {
			if (d != null) {
				index++;
				System.out.println(index + ". " + d);
			}
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("**************************************************");
	}
}
