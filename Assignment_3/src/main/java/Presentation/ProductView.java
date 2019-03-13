package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import DataAccess.GenericDAO;
import Model.Product;

public class ProductView 
{
	private JTextField textId;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textStock;
	private JButton btnAdd;
	private JFrame frame;
	private JButton back;
	private JScrollPane scroll;
	private JButton btnDelete;
	
	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public ProductView()
	{
		init();
	}
	
	public void init()
	{
		frame = new JFrame("Product Management");
		frame.setBounds(750, 350, 450, 320);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Product Manager");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitle.setBounds(100, 0, 500, 41);
		panel.add(lblTitle);
		
		JLabel lblAdd = new JLabel("Add new product: ");
		lblAdd.setBounds(10, 45, 150, 15);
		panel.add(lblAdd);
		
		JLabel lblId = new JLabel("Id: ");
		lblId.setBounds(10, 65, 150, 15);
		panel.add(lblId);
		
		textId = new JTextField();
		textId.setBounds(30, 62, 30, 20);
		panel.add(textId);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(65, 65, 150, 15);
		panel.add(lblName);
		
		textName = new JTextField();
		textName.setBounds(110, 62, 70, 20);
		panel.add(textName);
		
		JLabel lblPrice = new JLabel("Price: ");
		lblPrice.setBounds(185, 65, 150, 15);
		panel.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setBounds(225, 62, 40, 20);
		panel.add(textPrice);
		
		JLabel lblStock = new JLabel("Stock: ");
		lblStock.setBounds(270, 65, 150, 15);
		panel.add(lblStock);
		
		textStock = new JTextField();
		textStock.setBounds(310, 62, 40, 20);
		panel.add(textStock);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(368, 62, 60, 18);
		panel.add(btnAdd);
		
    	GenericDAO g = new GenericDAO();
		
		scroll = new JScrollPane(g.selectAll(Product.class));
		scroll.setBounds(10, 90, 420, 190);
		panel.add(scroll);
		
		back = new JButton("<");
		back.setBounds(10, 10, 50, 20);
		panel.add(back);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(358, 10, 70, 20);
		panel.add(btnDelete);
		
		panel.setVisible(true);
		frame.setVisible(false);
		frame.setResizable(false);
	}

	public JTextField[] getTexts()
	{
		JTextField[] texts = new JTextField[4];
		texts[0] = getTextId();
		texts[1] = getTextName();
		texts[2] = getTextPrice();
		texts[3] = getTextStock();
		
		return texts;
	}
	
	
	
	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JTextField getTextId() {
		return textId;
	}

	public void setTextId(JTextField textId) {
		this.textId = textId;
	}

	public JTextField getTextName() {
		return textName;
	}

	public void setTextName(JTextField textName) {
		this.textName = textName;
	}

	public JTextField getTextPrice() {
		return textPrice;
	}

	public void setTextPrice(JTextField textPrice) {
		this.textPrice = textPrice;
	}

	public JTextField getTextStock() {
		return textStock;
	}

	public void setTextStock(JTextField textStock) {
		this.textStock = textStock;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}
}
