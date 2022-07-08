package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;
import java.util.Collections;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	@FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private RadioButton radiaBtnFilterId;

    @FXML
    private TextField tfFilter;
	
	@FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    private Cart cart;
    private Store store;
    public CartController(Cart cart, Store store) {
    	this.cart = cart;
    	this.store = store;
    }
    
    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(
    			new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	Collections.sort(
    			cart.getItemsOrdered(), new MediaComparatorByTitleCost());
    	if (cart.getItemsOrdered()!= null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			updateButtonBar(newValue);
    		}
    	});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			showFilteredMedia(newValue);
    		}
    	});
    	costLabel.setText(cart.totalCost() + " $");
    }
    
    void updateButtonBar(Media media) {
    	if (media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	}
    	else {
    		btnRemove.setVisible(true);
    		if (media instanceof Playable) {
    			btnPlay.setVisible(true);
    		}
    		else {
    			btnPlay.setVisible(false);
    		}
    	}
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
    	try {
    		Media media = tblMedia.getSelectionModel().getSelectedItem();
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, ((Playable) media).play().toString());
            alert.showAndWait();
    	} catch (PlayerException e) {
    		e.printStackTrace();
    		Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
    	}
    	
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	costLabel.setText(cart.totalCost() + " $");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
			final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			fxmlLoader.setController(new ViewStoreController(cart, store));
			Parent root = fxmlLoader.load();
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setTitle("Store");
			stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void placeOrderClicked(ActionEvent event) {
    	Media luckyItem = cart.getALuckyItem();
    	if (luckyItem != null) {
    		costLabel.setText(cart.totalCost() + " $");
    		Alert alert = new Alert(Alert.AlertType.INFORMATION, "You got " + luckyItem.toString() + " as a lucky item.\n" + "The total cost is " + cart.totalCost() + " $");
            alert.showAndWait();
    	}
    	cart = new Cart();
    	costLabel.setText(cart.totalCost() + " $");
    	tblMedia.setItems(null);
    	
    }
    
    void showFilteredMedia(String filter) {
    	String filterType;
    	if (radioBtnFilterTitle.isSelected()) {
    		filterType = "title";
    	} else {
    		filterType = "id";
    	}
    	
    	FilteredList<Media> list = new FilteredList<>(cart.getItemsOrdered(), null);
		list.setPredicate(media -> media.filterProperty(filter, filterType));
		
		if (cart.getItemsOrdered()!= null) {
			tblMedia.setItems(list);
		}
    }
    
    

}

