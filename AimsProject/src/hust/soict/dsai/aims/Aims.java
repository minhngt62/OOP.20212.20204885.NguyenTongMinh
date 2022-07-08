package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.utils.*;
import javafx.collections.ObservableList;

import java.lang.Thread;

public class Aims {

	public static void main(String[] args) {
		//Thread practice
		MemoryDaemon daemon = new MemoryDaemon();
		Thread t1 = new Thread(daemon);
		t1.setDaemon(true);
		t1.start();
		
		//Setup store
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
				"George Lucas", 87, 19.95f);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",
				18.99f);
		store.addMedia(dvd3);
		
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
					Media dvd = store.getMedia(title);
					//check validity and print details
					if (dvd == null) {
						System.out.println("Invalid title!");
					} else {
						System.out.println("Details of the media: " + dvd);
					}
					//add option
					while (dvd != null) {
						System.out.println("Add that media to your cart? (Y/N): ");
						String addOption = user.next();
						if (addOption.equals("Y")) {
							try {
								cart.addMedia(dvd);
								break;
							} catch (LimitExceededException e) {
								e.printStackTrace();
								System.out.println(e.getMessage());
							}
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
					System.out.println("Enter the title of the media: ");
					user.nextLine(); //consume blank
					String title = user.nextLine();
					Media dvd = store.getMedia(title);
					//check validity and print details
					if (dvd == null) {
						System.out.println("Invalid title!");
					} else {
						try {
							cart.addMedia(dvd);
						} catch (LimitExceededException e) {
							e.printStackTrace();
							System.out.println(e.getMessage());
						}
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
							MediaUtils.sortByTitleCost((ArrayList<Media>) cart.getItemsOrdered());
							cart.print();
							//back to sort menu
							System.out.println("Insert any key to continue...");
							user.next(); //wait for the user
						} 
						
						else if (sortOption == 2) {
							MediaUtils.sortByCostTitle((ArrayList<Media>) cart.getItemsOrdered());
							cart.print();
							//back to sort menu
							System.out.println("Insert any key to continue...");
							user.next(); //wait for the user
						}
					}

					while (cartOption == 3) {
						System.out.println("Insert the title: ");
						user.nextLine(); //consume blank
						String title = user.nextLine();
						ObservableList<Media> cartDVDs = cart.getItemsOrdered();
						for (Media d : cartDVDs) {
							if (d.getTitle().equals(title)) {
								cart.removeMedia(d);
							}
						}
						System.out.println("The number of medias in the cart: " + cart.getItemsOrdered().size());
						System.out.println("Insert any key to continue...");
						user.next(); //wait for the user
						break;
					}
					
					//place order
					while (cartOption == 4) {
						System.out.println("An order is created.");
						cart.getALuckyItem();
						cart.getItemsOrdered().clear();
						//back to cart menu
						System.out.println("Insert any key to continue...");
						user.next(); //wait for the user
						break;
					}
					
					while (cartOption == 5) {
						System.out.println("Insert the title: ");
						user.nextLine(); //consume blank
						String title = user.nextLine();
						cart.playMedia(title);
						//back to cart menu
						System.out.println("Insert any key to continue...");
						user.next(); //wait for the user
						break;
					}
				}
				
				while (storeOption == 4) {
					System.out.println("Insert the title: ");
					user.nextLine(); //consume blank
					String title = user.nextLine();
					try {
						store.playMedia(title);
					} catch (PlayerException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), e.toString(), JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
					//back to cart menu
					System.out.println("Insert any key to continue...");
					user.next(); //wait for the user
					break;
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
					user.nextLine(); //consume blank
					String title = user.nextLine();
					System.out.println("Category: ");
					String category = user.nextLine();
					System.out.println("Cost: ");
					float cost = user.nextFloat();
					DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
					store.addMedia(dvd);
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
					Media dvd = store.getMedia(title);
					store.removeMedia(dvd);
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
						MediaUtils.sortByTitleCost((ArrayList<Media>) cart.getItemsOrdered());
						cart.print();
						//back to sort menu
						System.out.println("Insert any key to continue...");
						user.next(); //wait for the user
					} 
					
					else if (sortOption == 2) {
						MediaUtils.sortByCostTitle((ArrayList<Media>) cart.getItemsOrdered());
						cart.print();
						//back to sort menu
						System.out.println("Insert any key to continue...");
						user.next(); //wait for the user
					}
				}
				
				while (cartOption == 3) {
					System.out.println("Insert the title: ");
					user.nextLine(); //consume blank
					String title = user.nextLine();
					ObservableList<Media> cartDVDs = cart.getItemsOrdered();
					for (Media d : cartDVDs) {
						if (d.getTitle().equals(title)) {
							cart.removeMedia(d);
						}
					}
					System.out.println("The number of DVDs in the cart: " + cart.getItemsOrdered().size());
					System.out.println("Insert any key to continue...");
					user.next(); //wait for the user
					break;
				}
				
				//place order
				while (cartOption == 4) {
					System.out.println("An order is created.");
					cart.getALuckyItem();
					cart.getItemsOrdered().clear();
					//back to cart menu
					System.out.println("Insert any key to continue...");
					user.next(); //wait for the user
					break;
				}
				
				while (cartOption == 5) {
					System.out.println("Insert the title: ");
					user.nextLine(); //consume blank
					String title = user.nextLine();
					cart.playMedia(title);
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
		System.out.println("1. See a media details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. See current cart");
		System.out.println("4. Play a media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in the cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Place order");
		System.out.println("5. Play a media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
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
		System.out.println("1. Add a media to the store");
		System.out.println("2. Remove a media from the store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void filterCartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias by id");
		System.out.println("2. Filter medias by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void sortCartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort medias by title");
		System.out.println("2. Sort medias by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
}
