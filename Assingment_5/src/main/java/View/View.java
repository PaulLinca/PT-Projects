package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View 
{
	private JTextArea textArea;
	private JFrame frame;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	

	public View()
	{
		init();
	}
	
	public void init()
	{
		frame = new JFrame("Bank");
		frame.setBounds(750, 350, 450, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		textArea = new JTextArea();

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(10, 50, 425, 222);
		panel.add(scroll);

		btn1 = new JButton("1");
		btn1.setBounds(10, 15, 70, 20);
		panel.add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBounds(95, 15, 70, 20);
		panel.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBounds(190, 15, 70, 20);
		panel.add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBounds(280, 15, 70, 20);
		panel.add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBounds(364, 15, 70, 20);
		panel.add(btn5);
		
		frame.setVisible(true);
		frame.setResizable(false);
		panel.setVisible(true);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtn1() {
		return btn1;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	public JButton getBtn4() {
		return btn4;
	}

	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	public JButton getBtn5() {
		return btn5;
	}

	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}
	
	
}
