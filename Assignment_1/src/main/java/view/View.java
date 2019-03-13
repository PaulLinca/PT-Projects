package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View
{
	private JTextField firstPol;
	private JTextField secondPol;
	private JFrame frame;
	private JButton btnAddition;
	private JButton btnSubtraction;
	private JButton btnMultiplication;
	private JButton btnDivision;
	private JButton btndifferentiation;
	private JButton btnIntegration;
	private JLabel lblFinal;

	public void init()
	{
		frame = new JFrame("Polynomial Processing System");
		frame.setBounds(100, 100, 340, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 340, 420);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Polynomial Processing System");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(10,5,350,30);
		panel.add(lblTitle);
		
		JLabel lblInstr = new JLabel("The format of the polynomial must look like this:");
		lblInstr.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblInstr.setBounds(10,25,350,30);
		panel.add(lblInstr);
		
		JLabel lblFormat = new JLabel("C1 P1, C2 P2, C3 P3... (Spaces are mandatory!)");
		lblFormat.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblFormat.setBounds(10,40,350,30);
		panel.add(lblFormat);
		
		firstPol = new JTextField();
		firstPol.setBounds(10, 90, 300, 20);
		panel.add(firstPol);
		
		secondPol = new JTextField();
		secondPol.setBounds(10, 150, 300, 20);
		panel.add(secondPol);

		JLabel lblFirst = new JLabel("First Polynomial:");
		lblFirst.setBounds(10, 70, 100, 15);
		panel.add(lblFirst);
		
		JLabel lblSecond = new JLabel("Second Polynomial:");
		lblSecond.setBounds(10, 130, 120, 15);
		panel.add(lblSecond);
		
		JLabel lblData = new JLabel("There must be correct data in both text fields for the program to work!");
		lblData.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblData.setBounds(10,168,350,30);
		panel.add(lblData);
		
		btnAddition = new JButton("Addition (+)");
		btnAddition.setBounds(10, 200, 130, 20);
		panel.add(btnAddition);
		
		btnSubtraction = new JButton("Substraction (-)");
		btnSubtraction.setBounds(180, 200, 130, 20);
		panel.add(btnSubtraction);
		
		btnMultiplication = new JButton("Multiplication (*)");
		btnMultiplication.setBounds(10, 240, 130, 20);
		panel.add(btnMultiplication);
		
		btnDivision = new JButton("Division (/)");
		btnDivision.setBounds(180, 240, 130, 20);
		panel.add(btnDivision);

		btndifferentiation = new JButton("Derivative ( ' )");
		btndifferentiation.setBounds(10, 280, 130, 20);
		panel.add(btndifferentiation);
		
		btnIntegration = new JButton("Integration (S)");
		btnIntegration.setBounds(180, 280, 130, 20);
		panel.add(btnIntegration);
		
		JLabel lblSolution = new JLabel("Solution:");
		lblSolution.setBounds(10, 315, 100, 15);
		panel.add(lblSolution);
		
		lblFinal = new JLabel("-");
		lblFinal.setBounds(10, 340, 340, 15);
		panel.add(lblFinal);
		
		panel.setVisible(true);
		frame.setVisible(true);

	}
	
	//getters and setters
	public JTextField getFirstPol() {
		return firstPol;
	}

	public void setFirstPol(JTextField firstPol) {
		this.firstPol = firstPol;
	}

	public JTextField getSecondPol() {
		return secondPol;
	}

	public void setSecondPol(JTextField secondPol) {
		this.secondPol = secondPol;
	}

	public JButton getBtnAddition() 
	{
		return btnAddition;
	}

	public void setBtnAddition(JButton btnAddition)
{
		this.btnAddition = btnAddition;
	}

	public JButton getBtnSubtraction() 
	{
		return btnSubtraction;
	}

	public void setBtnSubtraction(JButton btnSubstraction) 
	{
		this.btnSubtraction = btnSubstraction;
	}

	public JButton getBtnMultiplication() 
	{
		return btnMultiplication;
	}

	public void setBtnMultiplication(JButton btnMultiplication) 
	{
		this.btnMultiplication = btnMultiplication;
	}

	public JButton getBtnDivision()
	{
		return btnDivision;
	}

	public void setBtnDivision(JButton btnDivision)
	{
		this.btnDivision = btnDivision;
	}

	public JButton getBtndifferentiation() 
	{
		return btndifferentiation;
	}

	public void setBtndifferentiation(JButton btndifferentiation) 
	{
		this.btndifferentiation = btndifferentiation;
	}

	public JButton getBtnIntegration() 
	{
		return btnIntegration;
	}

	public void setBtnIntegration(JButton btnIntegration) 
	{
		this.btnIntegration = btnIntegration;
	}

	public JLabel getLblFinal() 
	{
		return lblFinal;
	}

	public void setLblFinal(JLabel lblFinal)
	{
		this.lblFinal = lblFinal;
	}
}
