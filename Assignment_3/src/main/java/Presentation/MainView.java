package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView 
{
	
	private JButton btnClients;
	private JButton btnOrders;
	private JButton btnProducts;
	
	public MainView()
	{
		init();
	}
	
	public void init()
	{
		JFrame frame = new JFrame("Order Management");
		frame.setBounds(750, 350, 450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Order Management System");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitle.setBounds(25, 0, 500, 41);
		panel.add(lblTitle);
		
		btnClients = new JButton("Clients");
		btnClients.setBounds(175, 75, 90, 20);
		panel.add(btnClients);

		btnProducts = new JButton("Products");
		btnProducts.setBounds(175, 125, 90, 20);
		panel.add(btnProducts);
		
		btnOrders = new JButton("Orders");
		btnOrders.setBounds(175, 175, 90, 20);
		panel.add(btnOrders);
		
		panel.setVisible(true);
		frame.setVisible(true);
		frame.setResizable(false);

	}	
	public JButton getBtnClients() {
		return btnClients;
	}

	public void setBtnClients(JButton btnClients) {
		this.btnClients = btnClients;
	}

	public JButton getBtnOrders() {
		return btnOrders;
	}

	public void setBtnOrders(JButton btnOrders) {
		this.btnOrders = btnOrders;
	}

	public JButton getBtnProducts() {
		return btnProducts;
	}

	public void setBtnProducts(JButton btnProducts) {
		this.btnProducts = btnProducts;
	}
	
	
}
