package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {

	public static void main(String[] args) {
		//Setup store
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		store.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
				"George Lucas", 87, 19.95f);
		store.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",
				18.99f);
		store.addDVD(dvd3);
		
		//Setup cart
		Cart cart = new Cart();
		
		//Setup scanner 
		Scanner user = new Scanner(System.in);
		
		//Drive code
		program:
		while (true) {
			showMenu();
			int menuOption = user.nextInt();
			
			//exit
			while (menuOption == 0) {
				break program;
			}
			
			//view store
			store:
			while (menuOption == 1) {
				store.print();
				//store menu
				storeMenu();
				int storeOption = user.nextInt();
				
				while (storeOption == 0) {
					//back to main menu
					break store;
				}
				
				while (storeOption == 1) {
					System.out.println("Insert the title: ");
					user.nextLine(); //consume blank
					String title = user.nextLine();
					DigitalVideoDisc dvd = store.getDVD(title);
					//check validity and print details
					if (dvd == null) {
						System.out.println("Invalid title!");
					} else {
						System.out.println("Details of the DVD: " + dvd);
					}
					//add option
					while (dvd != null) {
						System.out.println("Add that DVD to your cart? (Y/N): ");
						String addOption = user.next();
						if (addOption.equals("Y")) {
							cart.addDigitalVideoDisc(dvd);
							break;
						} else if (addOption.equals("N")) {
							break;
						} else {
							System.out.println("Invalid input!");
						}
					}
					//back to store menu
					System.out.println("Insert any key to continue...");
					user.next(); //wait for the user
					break;
				}
				
				while (storeOption == 2) {
					System.out.println("Enter the title of the DVD: ");
					user.nextLine(); //consume blank
					String title = user.nextLine();
					DigitalVideoDisc dvd = store.getDVD(title);
					//check validity and add DVD to cart
					if (dvd == null) {
						System.out.println("Invalid title!");
					} else {
						cart.addDigitalVideoDisc(dvd);
						System.out.println("The number of DVDs in the cart: " + cart.getItemsOrdered().length);
					}
					//back to store menu
					System.out.println("Insert any key to continue...");
					user.next(); //wait for the user
					break;
				}
				
				cart:
				while (storeOption == 3) {
					cart.print();
					cartMenu();
					int cartOption = user.nextInt();
					
					while (cartOption == 0) {
						//back to main menu
						break cart;
					}
					
					filter:
					while (cartOption == 1) {
						filterCartMenu();
						int filterOption = user.nextInt();
						
						if (filterOption == 0) {
							//back to cart menu
							break filter; 
						}
						
						else if (filterOption == 1) {
							System.out.println("Insert an ID: ");
							int id = user.nextInt();
							cart.search(id);
							//back to filter menu
							System.out.println("Insert any key to continue...");
							user.next(); //wait for the user
						}
						
						else if (filterOption == 2) {
							System.out.println("Insert a title: ");
							user.nextLine(); //consume blank
							String title = user.nextLine();
							cart.search(title);
							//back to filter menu
							System.out.println("Insert any key to continue...");
							user.next(); //wait for the user
						}
					}
					
					sort:
					while (cartOption == 2) {
						sortCartMenu();
						int sortOption = user.nextInt();
						
						if (sortOption == 0) {
							//back to cart menu
							break sort;
						} 
						
						else if (sortOption == 1) {
							cart.sortByTitleCost();
							//back to sort menu
							System.out.println("Insert any key to continue...");
							user.next(); //wait for the user
						} 
						
						else if (sortOption == 2) {
							cart.sortByCostTitle();
							//back to sort menu
							System.out.println("Insert any key to continue...");
							user.next(); //wait for the user
						}
					}

					while (cartOption == 3) {
						System.out.println("Insert the title: ");
						user.nextLine(); //consume blank
						String title = user.nextLine();
						DigitalVideoDisc[] cartDVDs = cart.getItemsOrdered();
						for (DigitalVideoDisc d : cartDVDs) {
							if (d.getTitle().equals(title)) {
								cart.removeDigitalVideoDisc(d);
							}
						}
						System.out.println("The number of DVDs in the cart: " + cart.getItemsOrdered().length);
						System.out.println("Insert any key to continue...");
						user.next(); //wait for the user
						break;
					}
					
					//place order
					while (cartOption == 4) {
						System.out.println("An order is created.");
						cart.setItemsOrdered(new DigitalVideoDisc[Cart.MAX_NUMBERS_ORDERED]);
						//back to cart menu
						System.out.println("Insert any key to continue...");
						user.next(); //wait for the user
						break;
					}
				}
			}
			
			update:
			while (menuOption == 2) {
				updateStoreMenu();
				int updateOption = user.nextInt();
				
				while (updateOption == 0) {
					//back to main menu
					break update;
				}
				
				while (updateOption == 1) {
					//add DVD
					System.out.println("Please insert the details of the DVD: ");
					System.out.println("--------------------------------");
					System.out.println("Title: ");
					String title = user.next();
					System.out.println("Category: ");
					String category = user.next();
					System.out.println("Director: ");
					String director = user.next();
					System.out.println("Length: ");
					int length = user.nextInt();
					System.out.println("Cost: ");
					float cost = user.nextFloat();
					DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
					store.addDVD(dvd);
					//back to update menu
					System.out.println("Insert any key to continue...");
					user.next(); //wait for the user
					break;
				}
				
				while (updateOption == 2) {
					//remove DVD
					System.out.println("Insert the title: ");
					user.nextLine(); //consume blank
					String title = user.nextLine();
					DigitalVideoDisc dvd = store.getDVD(title);
					store.removeDVD(dvd);
					//back to update menu
					System.out.println("Insert any key to continue...");
					user.next(); //wait for the user
					break;
				}
				
			}
			
			cart:
			while (menuOption == 3) {
				cart.print();
				cartMenu();
				int cartOption = user.nextInt();
				
				while (cartOption == 0) {
					//back to main menu
					break cart;
				}
				
				filter:
				while (cartOption == 1) {
					filterCartMenu();
					int filterOption = user.nextInt();
					
					if (filterOption == 0) {
						//back to cart menu
						break filter; 
					}
					
					else if (filterOption == 1) {
						System.out.println("Insert an ID: ");
						int id = user.nextInt();
						cart.search(id);
						//back to filter menu
						System.out.println("Insert any key to continue...");
						user.next(); //wait for the user
					}
					
					else if (filterOption == 2) {
						System.out.println("Insert a title: ");
						user.nextLine(); //consume blank
						String title = user.nextLine();
						cart.search(title);
						//back to filter menu
						System.out.println("Insert any key to continue...");
						user.next(); //wait for the user
					}
				}
				
				sort:
				while (cartOption == 2) {
					sortCartMenu();
					int sortOption = user.nextInt();
					
					if (sortOption == 0) {
						//back to cart menu
						break sort;
					} 
					
					else if (sortOption == 1) {
						cart.sortByTitleCost();
						//back to sort menu
						System.out.println("Insert any key to continue...");
						user.next(); //wait for the user
					} 
					
					else if (sortOption == 2) {
						cart.sortByCostTitle();
						//back to sort menu
						System.out.println("Insert any key to continue...");
						user.next(); //wait for the user
					}
				}
				
				while (cartOption == 3) {
					System.out.println("Insert the title: ");
					user.nextLine(); //consume blank
					String title = user.nextLine();
					DigitalVideoDisc[] cartDVDs = cart.getItemsOrdered();
					for (DigitalVideoDisc d : cartDVDs) {
						if (d.getTitle().equals(title)) {
							cart.removeDigitalVideoDisc(d);
						}
					}
					System.out.println("The number of DVDs in the cart: " + cart.getItemsOrdered().length);
					System.out.println("Insert any key to continue...");
					user.next(); //wait for the user
					break;
				}
				
				//place order
				while (cartOption == 4) {
					System.out.println("An order is created.");
					cart.setItemsOrdered(new DigitalVideoDisc[Cart.MAX_NUMBERS_ORDERED]);
					//back to cart menu
					System.out.println("Insert any key to continue...");
					user.next(); //wait for the user
					break;
				}
			}
		}
		user.close();
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs in the cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void updateStoreMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a DVD to the store");
		System.out.println("2. Remove a DVD from the store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void filterCartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs by id");
		System.out.println("2. Filter DVDs by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void sortCartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort DVDs by title");
		System.out.println("2. Sort DVDs by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
}
