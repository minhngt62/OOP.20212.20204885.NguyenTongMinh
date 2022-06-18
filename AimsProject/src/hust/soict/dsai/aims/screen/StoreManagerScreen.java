package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store; 
import hust.soict.dsai.aims.media.*;

import javax.swing.*; 
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class StoreManagerScreen extends JFrame {
	private Store store;
	private JPanel centerComponent;
	
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		this.centerComponent = createCenter();
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(this.centerComponent, BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem viewStoreMenu = new JMenuItem("View store");
		menu.add(viewStoreMenu);
		viewStoreMenu.addActionListener(new btnMenuListener());
		
		JMenu smUpdateStore = new JMenu("Update store");
		JMenuItem addBookMenu = new JMenuItem("Add Book");
		JMenuItem addCDMenu = new JMenuItem("Add CD");
		JMenuItem addDVDMenu = new JMenuItem("Add DVD");
		
		smUpdateStore.add(addBookMenu);
		smUpdateStore.add(addCDMenu);
		smUpdateStore.add(addDVDMenu);
		menu.add(smUpdateStore);
		
		addBookMenu.addActionListener(new btnMenuListener());
		addDVDMenu.addActionListener(new btnMenuListener());
		addCDMenu.addActionListener(new btnMenuListener());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i=0; i<mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	private class btnMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("Add DVD")) {
				new AddDigitalVideoDiscToStoreScreen(store, centerComponent);
			} else if (command.equals("Add Book")) {
				new AddBookToStoreScreen(store, centerComponent);
			} else if (command.equals("Add CD")) {
				new AddBookToStoreScreen(store, centerComponent);
			} else if (command.equals("View Store")) {
				new StoreScreen(store);
				dispose();
			}
		}
	}
	
	public static void main(String[] args) {
		new StoreManagerScreen(new Store());
	}
}
