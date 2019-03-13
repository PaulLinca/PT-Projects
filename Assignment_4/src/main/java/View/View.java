package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class View 
{
	private JFrame frame;
	
	private JLabel lblType;
	private JLabel lblAccs;
	
	private JTextField textDelSSN;
	private JButton btnDelPers;
	
	private JTextField textDelID;
	private JButton btnDelAcc;
	
	private JScrollPane scroll;
	private JScrollPane scroll1;

	private JTable table;
	private JTable table1;

	private JTextField textName;
	private JTextField textEmail;
	private JTextField textSSN;
	
	private JTextField textName1;
	private JTextField textEmail1;
	private JTextField textSSN1;
	private JTextField textPeriod;
	
	private JButton btnAddPerson;
	private JButton btnAddSpending;
	private JButton btnAddSaving;
	
	private JTextField textID;
	private JTextField textAmount;
	private JButton btnDeposit;
	
	private JTextField textID1;
	private JTextField textAmount1;
	private JButton btnWdraw;
	
	private JButton btnEdit1;
	private JButton btnEdit;
	
	DefaultTableModel model1;
	DefaultTableModel model;
	
	public View()
	{
		init();
	}
	
	public void init()
	{
		frame = new JFrame("Bank");
		frame.setBounds(750, 350, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane jtp = new JTabbedPane();
        frame.getContentPane().add(jtp);
        jtp.setBounds(0, 0, 444, 320);
		
		////////////////////////////////////////////////////////////////////
        
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 300);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Persons");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitle.setBounds(160, 0, 500, 35);
		panel.add(lblTitle);
		
		JLabel lblDelPers = new JLabel("SSN: ");
		lblDelPers.setBounds(10, 45, 100, 20);
		panel.add(lblDelPers);
		
		textDelSSN = new JTextField();
		textDelSSN.setBounds(10, 65, 100, 20);
		panel.add(textDelSSN);
		
		btnDelPers = new JButton("Delete");
		btnDelPers.setBounds(120, 65, 70, 19);;
		panel.add(btnDelPers);
		
		lblAccs = new JLabel("Nr. of accounts");
		lblAccs.setBounds(300, 65, 500, 20);
		panel.add(lblAccs);
		
		Object[] columns = {"Name", "Email","SSN"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table = new JTable();
		table.setModel(model);
		table.setRowHeight(20);
		
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 90, 420, 190);
		panel.add(scroll);
		
		panel.setVisible(true);
		
		////////////////////////////////////////////////////////////////////
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 435, 300);
		panel1.setLayout(null);
		
		JLabel lblTitle1 = new JLabel("Accounts");
		lblTitle1.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitle1.setBounds(160, 0, 500, 35);
		panel1.add(lblTitle1);
		
		JLabel lblDelAcc = new JLabel("ID: ");
		lblDelAcc.setBounds(10, 45, 100, 20);
		panel1.add(lblDelAcc);
		
		textDelID = new JTextField();
		textDelID.setBounds(10, 65, 100, 20);
		panel1.add(textDelID);
		
		btnDelAcc = new JButton("Delete");
		btnDelAcc.setBounds(120, 65, 70, 19);;
		panel1.add(btnDelAcc);
		
		lblType = new JLabel("Type of the account");
		lblType.setBounds(300, 65, 500, 20);
		panel1.add(lblType);
		
		Object[] columns1 = {"Account ID", "Balance"};
		model1 = new DefaultTableModel();
		model1.setColumnIdentifiers(columns1);
		table1 = new JTable();
		table1.setModel(model1);
		table1.setRowHeight(20);
		
		scroll1 = new JScrollPane(table1);
		scroll1.setBounds(10, 90, 420, 190);
		panel1.add(scroll1);
		
		panel1.setVisible(true);

		///////////////////////////////////////////////////////////////////
		
		JPanel panelAddPerson = new JPanel();
		panelAddPerson.setBounds(0, 0, 435, 300);
		panelAddPerson.setLayout(null);
		
		JLabel lblTitle2 = new JLabel("Add Person");
		lblTitle2.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitle2.setBounds(140, 0, 500, 35);
		panelAddPerson.add(lblTitle2);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(175, 40, 100, 20);
		panelAddPerson.add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(175, 90, 100, 20);
		panelAddPerson.add(lblEmail);
		
		JLabel lblSSN = new JLabel("SSN:");
		lblSSN.setBounds(175, 140, 100, 20);
		panelAddPerson.add(lblSSN);
		
		textName = new JTextField();
		textName.setBounds(175, 60, 100, 20);
		panelAddPerson.add(textName);
		
		textEmail = new JTextField();
		textEmail.setBounds(175, 110, 100, 20);
		panelAddPerson.add(textEmail);
		
		textSSN = new JTextField();
		textSSN.setBounds(175, 160, 100, 20);
		panelAddPerson.add(textSSN);
		
		btnAddPerson = new JButton("Add");
		btnAddPerson.setBounds(175, 210, 100, 20);
		panelAddPerson.add(btnAddPerson);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(175, 260, 100, 20);
		panelAddPerson.add(btnEdit);
		
		///////////////////////////////////////////////////////////////////
		
		JPanel panelAddAcc = new JPanel();
		panelAddAcc.setBounds(0, 0, 435, 300);
		panelAddAcc.setLayout(null);
		
		JLabel lblTitle3 = new JLabel("Add Account");
		lblTitle3.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitle3.setBounds(140, 0, 500, 35);
		panelAddAcc.add(lblTitle3);
		
		JLabel lblHolder = new JLabel("Holder Name:");
		lblHolder.setBounds(175, 40, 100, 20);
		panelAddAcc.add(lblHolder);
		
		JLabel lblEm = new JLabel("Holder Email:");
		lblEm.setBounds(175, 90, 100, 20);
		panelAddAcc.add(lblEm);
		
		JLabel lblHSSN = new JLabel("Holder SSN:");
		lblHSSN.setBounds(175, 140, 100, 20);
		panelAddAcc.add(lblHSSN);
		
		JLabel lblPeriod = new JLabel("Period: ");
		lblPeriod.setBounds(260, 240, 100, 20);
		panelAddAcc.add(lblPeriod);
		
		JLabel lblMonths = new JLabel("months");
		lblMonths.setBounds(360, 260, 100, 20);
		panelAddAcc.add(lblMonths);
		
		textName1 = new JTextField();
		textName1.setBounds(175, 60, 100, 20);
		panelAddAcc.add(textName1);
		
		textEmail1 = new JTextField();
		textEmail1.setBounds(175, 110, 100, 20);
		panelAddAcc.add(textEmail1);
		
		textSSN1 = new JTextField();
		textSSN1.setBounds(175, 160, 100, 20);
		panelAddAcc.add(textSSN1);
		
		textPeriod = new JTextField();
		textPeriod.setBounds(260, 260, 100, 20);
		panelAddAcc.add(textPeriod);
		
		JLabel lblAcc = new JLabel("Please choose what kind of account you want: ");
		lblAcc.setBounds(92, 190, 300, 20);
		panelAddAcc.add(lblAcc);
		
		btnAddSpending = new JButton("Spending");
		btnAddSpending.setBounds(85, 220, 100, 20);
		panelAddAcc.add(btnAddSpending);
		
		btnAddSaving = new JButton("Saving");
		btnAddSaving.setBounds(260, 220, 100, 20);
		panelAddAcc.add(btnAddSaving);
		
		btnEdit1 = new JButton("Edit");
		btnEdit1.setBounds(85, 260, 100, 20);
		panelAddAcc.add(btnEdit1);
		
		///////////////////////////////////////////////////////////////////

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 0, 435, 300);
		panel2.setLayout(null);
		
		JLabel lblTitle4 = new JLabel("Deposit");
		lblTitle4.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitle4.setBounds(170, 0, 500, 35);
		panel2.add(lblTitle4);
		
		JLabel lblID = new JLabel("Account ID:");
		lblID.setBounds(175, 40, 100, 20);
		panel2.add(lblID);
		
		JLabel lblAm = new JLabel("Amount:");
		lblAm.setBounds(175, 90, 100, 20);
		panel2.add(lblAm);
		
		textID = new JTextField();
		textID.setBounds(175, 60, 100, 20);
		panel2.add(textID);
		
		textAmount = new JTextField();
		textAmount.setBounds(175, 110, 100, 20);
		panel2.add(textAmount);
		
		btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(175, 160, 100, 20);;
		panel2.add(btnDeposit);
		
		///////////////////////////////////////////////////////////////////
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 0, 435, 300);
		panel3.setLayout(null);
		
		JLabel lblTitle5 = new JLabel("Withdraw");
		lblTitle5.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitle5.setBounds(157, 0, 500, 35);
		panel3.add(lblTitle5);
		
		JLabel lblID1 = new JLabel("Account ID:");
		lblID1.setBounds(175, 40, 100, 20);
		panel3.add(lblID1);
		
		JLabel lblAm1 = new JLabel("Amount:");
		lblAm1.setBounds(175, 90, 100, 20);
		panel3.add(lblAm1);
		
		textID1 = new JTextField();
		textID1.setBounds(175, 60, 100, 20);
		panel3.add(textID1);
		
		textAmount1 = new JTextField();
		textAmount1.setBounds(175, 110, 100, 20);
		panel3.add(textAmount1);
		
		btnWdraw = new JButton("Withdraw");
		btnWdraw.setBounds(175, 160, 100, 20);;
		panel3.add(btnWdraw);
		
		///////////////////////////////////////////////////////////////////

		jtp.addTab("Persons", panel);
		jtp.addTab("Accounts", panel1);
		jtp.addTab("+ Person", panelAddPerson);
		jtp.addTab("+ Account", panelAddAcc);
		jtp.addTab("Deposit", panel2);
		jtp.addTab("Withdraw", panel3);
		
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JScrollPane getScroll1() {
		return scroll1;
	}

	public void setScroll1(JScrollPane scroll1) {
		this.scroll1 = scroll1;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTable getTable1() {
		return table1;
	}

	public void setTable1(JTable table1) {
		this.table1 = table1;
	}

	public JTextField getTextName() {
		return textName;
	}

	public void setTextName(JTextField textName) {
		this.textName = textName;
	}

	public JTextField getTextEmail() {
		return textEmail;
	}

	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}

	public JTextField getTextSSN() {
		return textSSN;
	}

	public void setTextSSN(JTextField textSSN) {
		this.textSSN = textSSN;
	}

	public JTextField getTextName1() {
		return textName1;
	}

	public void setTextName1(JTextField textName1) {
		this.textName1 = textName1;
	}

	public JTextField getTextEmail1() {
		return textEmail1;
	}

	public void setTextEmail1(JTextField textEmail1) {
		this.textEmail1 = textEmail1;
	}

	public JTextField getTextSSN1() {
		return textSSN1;
	}

	public void setTextSSN1(JTextField textSSN1) {
		this.textSSN1 = textSSN1;
	}

	public JButton getBtnAddPerson() {
		return btnAddPerson;
	}

	public void setBtnAddPerson(JButton btnAddPerson) {
		this.btnAddPerson = btnAddPerson;
	}

	public JButton getBtnAddSpending() {
		return btnAddSpending;
	}

	public void setBtnAddSpending(JButton btnAddSpending) {
		this.btnAddSpending = btnAddSpending;
	}

	public JButton getBtnAddSaving() {
		return btnAddSaving;
	}

	public void setBtnAddSaving(JButton btnAddSaving) {
		this.btnAddSaving = btnAddSaving;
	}

	public DefaultTableModel getModel1() {
		return model1;
	}

	public void setModel1(DefaultTableModel model1) {
		this.model1 = model1;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JTextField getTextPeriod() {
		return textPeriod;
	}

	public void setTextPeriod(JTextField textPeriod) {
		this.textPeriod = textPeriod;
	}

	public JTextField getTextID() {
		return textID;
	}

	public void setTextID(JTextField textID) {
		this.textID = textID;
	}

	public JTextField getTextAmount() {
		return textAmount;
	}

	public void setTextAmount(JTextField textAmount) {
		this.textAmount = textAmount;
	}

	public JButton getBtnDeposit() {
		return btnDeposit;
	}

	public void setBtnDeposit(JButton btnDeposit) {
		this.btnDeposit = btnDeposit;
	}

	public JTextField getTextID1() {
		return textID1;
	}

	public void setTextID1(JTextField textID1) {
		this.textID1 = textID1;
	}

	public JTextField getTextAmount1() {
		return textAmount1;
	}

	public void setTextAmount1(JTextField textAmount1) {
		this.textAmount1 = textAmount1;
	}

	public JButton getBtnWdraw() {
		return btnWdraw;
	}

	public void setBtnWdraw(JButton btnWdraw) {
		this.btnWdraw = btnWdraw;
	}

	public JTextField getTextDelSSN() {
		return textDelSSN;
	}

	public void setTextDelSSN(JTextField textDelSSN) {
		this.textDelSSN = textDelSSN;
	}

	public JButton getBtnDelPers() {
		return btnDelPers;
	}

	public void setBtnDelPers(JButton btnDelPers) {
		this.btnDelPers = btnDelPers;
	}

	public JTextField getTextDelID() {
		return textDelID;
	}

	public void setTextDelID(JTextField textDelID) {
		this.textDelID = textDelID;
	}

	public JButton getBtnDelAcc() {
		return btnDelAcc;
	}

	public void setBtnDelAcc(JButton btnDelAcc) {
		this.btnDelAcc = btnDelAcc;
	}

	public JLabel getLblType() {
		return lblType;
	}

	public void setLblType(JLabel lblType) {
		this.lblType = lblType;
	}

	public JLabel getLblAccs() {
		return lblAccs;
	}

	public void setLblAccs(JLabel lblAccs) {
		this.lblAccs = lblAccs;
	}

	public JButton getBtnEdit1() {
		return btnEdit1;
	}

	public void setBtnEdit1(JButton btnEdit1) {
		this.btnEdit1 = btnEdit1;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}
	

}
