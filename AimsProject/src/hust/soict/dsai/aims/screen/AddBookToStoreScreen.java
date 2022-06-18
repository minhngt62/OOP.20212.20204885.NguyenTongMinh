package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

	public AddBookToStoreScreen(Store store) {
		super(store);
		
		btnAdd.addActionListener(new btnAddListener());
		super.setTitle("Add Book");
	}
	
	private class btnAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String title=null, category=null;
			float cost=0;
			for (JTextField tf : tfs) {
				if (tf.getName().equals("Title")) {
					title = tf.getText();
				}
				if (tf.getName().equals("Category")) {
					category = tf.getText();
				}
				if (tf.getName().equals("Cost")) {
					cost = Float.parseFloat(tf.getText());
				}
			}
			
			Book b =  new Book(title, category, cost);
			store.addMedia(b);
		}
	}

}
