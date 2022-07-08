package hust.soict.dsai.aims.screen.customer.controller;

 
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;
    
    private Media media;
    private Cart cart;
    public ItemController(Cart cart) {
    	this.cart = cart;
    }
    
    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	int numAdded;
		try {
			numAdded = cart.addMedia(media);
		} catch (LimitExceededException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
			e.printStackTrace();
		}
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
    	try {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION, ((Playable) media).play().toString());
            alert.showAndWait();
    	} catch (PlayerException e) {
    		Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
    	}
    	
    }
    

    public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost() + " $");
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
    	}
    }
}

