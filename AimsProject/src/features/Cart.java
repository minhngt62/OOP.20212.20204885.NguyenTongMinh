package features;
import utils.DVDUtils;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
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
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean isRemoved = false;
		for (int i=0; i < MAX_NUMBERS_ORDERED; i++) {
			if (disc.getTitle() == itemsOrdered[i].getTitle()) {
				for (int j=i+1; j < MAX_NUMBERS_ORDERED; j++) {
					itemsOrdered[j-1] = itemsOrdered[j]; // shift discs to fill the empty slot
				}
				System.out.println("The disc has been removed");
				isRemoved = true;
				break;
			}
		}
		if (isRemoved == false) {
			System.out.println("The cart does not have this disc");
			itemsOrdered[MAX_NUMBERS_ORDERED - 1] = null;
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
	public void searchById(int id) {
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
}
