package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store; 
import hust.soict.dsai.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
		
		JPanel director = super.createSubPanel("Director");
		JPanel length = super.createSubPanel("Length");
		JPanel artist = super.createSubPanel("Artist");
		
		super.centerPanel.add(director, BorderLayout.CENTER);
		super.centerPanel.add(length, BorderLayout.CENTER);
		super.centerPanel.add(artist, BorderLayout.CENTER);
		
		btnAdd.addActionListener(new btnAddListener());
		super.setTitle("Add Compact Disc");
	}
	
	private class btnAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String title=null, category=null, director=null, artist=null;
			float cost=0;
			int length=0;
			for (JTextField tf : tfs) {
				if (tf.getName().equals("Title")) {
					title = tf.getText();
				} else if (tf.getName().equals("Category")) {
					category = tf.getText();
				} else if (tf.getName().equals("Cost")) {
					cost = Float.parseFloat(tf.getText());
				} else if (tf.getName().equals("Length")) {
					length = Integer.parseInt(tf.getText());
				} else if (tf.getName().equals("Director")) {
					director = tf.getText();
				} else if (tf.getName().equals("Artist")) {
					artist = tf.getText();
				}
			}
			
			CompactDisc cd =  new CompactDisc(title, category, cost, length, director, artist);
			store.addMedia(cd);
			
		}
	}

}
