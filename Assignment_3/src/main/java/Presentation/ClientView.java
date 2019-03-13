package Presentation;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import DataAccess.GenericDAO;
import Model.Client;
import Model.Product;

public class ClientView
{
	private JTextField textId;
	private JTextField textName;
	private JTextField textAddress;
	private JButton btnAdd;
	private JScrollPane scroll;
	private JButton back;
	private JFrame frame;
	private JButton btnDelete;

	public ClientView()
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
		
		JLabel lblTitle = new JLabel("Client Manager");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitle.setBounds(110, 0, 500, 41);
		panel.add(lblTitle);
		
		JLabel lblAdd = new JLabel("Add new customer: ");
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
		textName.setBounds(110, 62, 90, 20);
		panel.add(textName);
		
		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setBounds(205, 65, 150, 15);
		panel.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setBounds(260, 62, 100, 20);
		panel.add(textAddress);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(368, 62, 60, 18);
		panel.add(btnAdd);
		
    	GenericDAO g = new GenericDAO();
    	
		scroll = new JScrollPane(g.selectAll(Client.class));
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
		JTextField[] texts = new JTextField[3];
		texts[0] = getTextId();
		texts[1] = getTextName();
		texts[2] = getTextAddress();
		
		return texts;
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

	public JTextField getTextAddress() {
		return textAddress;
	}

	public void setTextAddress(JTextField textAddress) {
		this.textAddress = textAddress;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
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
