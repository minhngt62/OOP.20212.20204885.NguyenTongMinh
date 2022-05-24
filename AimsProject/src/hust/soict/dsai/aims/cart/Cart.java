package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public DigitalVideoDisc[] getItemsOrdered() {
		int count = 0;
		for (DigitalVideoDisc d : itemsOrdered) {
			if (d != null) {
				count++;
			}
		}
		DigitalVideoDisc[] cleanedItemsOrdered = new DigitalVideoDisc[count];
		for (int i=0; i<itemsOrdered.length; i++) {
			if (itemsOrdered[i] != null) {
				cleanedItemsOrdered[i] = itemsOrdered[i];
			}
		}
		return cleanedItemsOrdered;
	}
	public void setItemsOrdered(DigitalVideoDisc[] dvdList) {
		this.itemsOrdered = dvdList;
	}
	
	public int addDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i=0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] == null) {
				itemsOrdered[i] = disc;
				System.out.println("The disc has been added");
				return 1;
			}
		}
		System.out.println("The cart is almost full");
		return 0;
	}
	public int addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		int count = 0;
		int i = 0;
		while (i < dvdList.length) {
			int numDisc = addDigitalVideoDisc(dvdList[i]);
			if (numDisc == 0) {
				break;
			}
			count += numDisc;
			i++;
		}
		return count;
	}
	public int addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		DigitalVideoDisc[] dvdList = {dvd1, dvd2};
		int count = addDigitalVideoDisc(dvdList);
		return count;
	}
	
	public float totalCost() {
		float totalCost = 0;
		for (DigitalVideoDisc d : itemsOrdered) {
			if (d != null) {
				totalCost += d.getCost();
			}
		}
		return totalCost;
	}
	
	public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int isRemoved = 0;
		for (int i=0; i < MAX_NUMBERS_ORDERED; i++) {
			if (disc.getTitle() == itemsOrdered[i].getTitle()) {
				for (int j=i+1; j < MAX_NUMBERS_ORDERED; j++) {
					itemsOrdered[j-1] = itemsOrdered[j]; // shift discs to fill the empty slot
				}
				System.out.println("The disc has been removed");
				isRemoved = 1;
				break;
			}
		}
		if (isRemoved == 0) {
			System.out.println("The cart does not have this disc");
			itemsOrdered[MAX_NUMBERS_ORDERED - 1] = null;
		}
		return isRemoved;
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
