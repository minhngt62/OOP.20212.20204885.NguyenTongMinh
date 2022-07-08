package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static Store store;
	private static Cart cart;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(cart, store);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
				"George Lucas", 87, 19.95f);
		store.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",
				18.99f);
		store.addMedia(dvd3);
		Book book1 = new Book("Hands-on Machine Learning", "Technology", 
				20.00f);
		store.addMedia(book1);
		CompactDisc cd1 = new CompactDisc("Perfect Time", "Music", 
				15.98f);
		store.addMedia(cd1);
		
		launch(args);
	}

}
