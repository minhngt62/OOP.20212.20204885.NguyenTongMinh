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
}
