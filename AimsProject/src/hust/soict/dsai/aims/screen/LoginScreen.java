package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame {
	private Store store;
	
	public LoginScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		
		JRadioButton customerBtn = new JRadioButton("Customer");
		JRadioButton managerBtn = new JRadioButton("Store Manager");
		customerBtn.setBounds(140, 40, 120, 30);
		managerBtn.setBounds(140, 90, 120, 30);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(customerBtn);
		bg.add(managerBtn);
		customerBtn.setSelected(true);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(140, 140, 120, 30);
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (managerBtn.isSelected()) {
					new StoreManagerScreen(store);
					dispose();
				}
			}
		});
		
		cp.add(customerBtn);
		cp.add(loginBtn);
		cp.add(managerBtn);
		
		setTitle("Login");
		setSize(400, 250);
		
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
