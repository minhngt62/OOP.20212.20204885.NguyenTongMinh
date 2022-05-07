package features;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean isAdded = false;
		for (int i=0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] == null) {
				itemsOrdered[i] = disc;
				System.out.println("The disc has been added");
				isAdded = true;
				break;
			}
		}
		if (isAdded == false) {
			System.out.println("The cart is almost full");
		}
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
}
