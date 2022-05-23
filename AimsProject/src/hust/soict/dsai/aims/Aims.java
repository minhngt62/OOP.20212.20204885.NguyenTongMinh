package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		//create a new cart
		Cart anOrder = new Cart();
				
		//create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
						"Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
				
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
						"Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
				
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
						"Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
				
		//print total cost of the items in the cart
		System.out.println("The total cost is: ");
		System.out.println(anOrder.totalCost());
		
		//test the method removeDigitalVideoDisc of the Cart
		anOrder.removeDigitalVideoDisc(dvd1);
		System.out.println("The total cost is: ");
		System.out.println(anOrder.totalCost());
		
		//test method overloading
		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd1, dvd2);
		System.out.println("The total cost is: ");
		System.out.println(anOrder.totalCost());
	}

}
