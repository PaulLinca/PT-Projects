package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import DataAccess.GenericDAO;
import Model.Order;

/**
 * @author Paul
 *
 */
public class OrderView 
{
	private JScrollPane scroll;
	private JFrame frame;
	private JButton back;
	private JTextField textId;
	private JTextField productId;
	private JTextField clientId;
	private JTextField quantity;
	private JButton btnAdd;
	private JButton btnDelete;
	
	public OrderView()
	{
		init();
	}
	
	public void init()
	{
		frame = new JFrame("Order Management");
		frame.setBounds(750, 350, 450, 320);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Order Manager");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitle.setBounds(110, 0, 500, 41);
		panel.add(lblTitle);
		
		JLabel lblId = new JLabel("Id: ");
		lblId.setBounds(10, 65, 150, 15);
		panel.add(lblId);
		
		textId = new JTextField();
		textId.setBounds(30, 62, 30, 20);
		panel.add(textId);
		
		JLabel lblClient = new JLabel("Client Id: ");
		lblClient.setBounds(65, 65, 150, 15);
		panel.add(lblClient);
		
		clientId = new JTextField();
		clientId.setBounds(120, 62, 30, 20);
		panel.add(clientId);
		
		JLabel lblProduct = new JLabel("Product Id: ");
		lblProduct.setBounds(155, 65, 150, 15);
		panel.add(lblProduct);
		
		productId = new JTextField();
		productId.setBounds(220, 62, 30, 20);
		panel.add(productId);
		
		JLabel lblQuantity = new JLabel("Quantity: ");
		lblQuantity.setBounds(255, 65, 150, 15);
		panel.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setBounds(310, 62, 50, 20);
		panel.add(quantity);
		
		JLabel lblAdd = new JLabel("Place a new order: ");
		lblAdd.setBounds(10, 45, 60, 15);
		panel.add(lblAdd);
		
    	GenericDAO g = new GenericDAO();
		
		scroll = new JScrollPane(g.selectAll(Order.class));
		scroll.setBounds(10, 90, 420, 190);
		panel.add(scroll);
		
		back = new JButton("<");
		back.setBounds(10, 10, 50, 20);
		panel.add(back);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(368, 62, 60, 18);
		panel.add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(358, 10, 70, 20);
		panel.add(btnDelete);
		
		panel.setVisible(true);
		frame.setVisible(false);
		frame.setResizable(false);
	}

	public void updateTable()
	{
		GenericDAO g = new GenericDAO();
		setScroll(new JScrollPane(g.selectAll(Order.class)));
	}
	
	public JTextField[] getTexts()
	{
		JTextField[] texts = new JTextField[4];
		texts[0] = getTextId();
		texts[2] = getClientId();
		texts[1] = getProductId();
		texts[3] = getQuantity();
		
		return texts;
	}
	
	public JScrollPane getScroll()
	{
		return scroll;
	}

	public void setScroll(JScrollPane scroll)
	{
		this.scroll = scroll;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JTextField getTextId() {
		return textId;
	}

	public void setTextId(JTextField textId) {
		this.textId = textId;
	}

	public JTextField getProductId() {
		return productId;
	}

	public void setProductId(JTextField productId) {
		this.productId = productId;
	}

	public JTextField getClientId() {
		return clientId;
	}

	public void setClientId(JTextField clientId) {
		this.clientId = clientId;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JTextField getQuantity() {
		return quantity;
	}

	public void setQuantity(JTextField quantity) {
		this.quantity = quantity;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}
}
