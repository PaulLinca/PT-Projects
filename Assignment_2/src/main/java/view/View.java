package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class View
{
	private JTextField textArrival1;
	private JTextField textArrival2;
	private JTextField textService1;
	private JTextField textService2;
	private JTextField textSimulation1;
	private JTextField textQueues;
	private JTextField textCustomers;
	private JButton btnStart;
	private JLabel lblTimer;
	private JTextArea textArea;
	private JLabel lblStatus;
	
	public View()
	{
		init();
	}
	
	public void init() 
	{
		JFrame frame = new JFrame("Queue Simulator");
		frame.setBounds(100, 100, 450, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Queue Simulation");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTitle.setBounds(10, 0, 322, 41);
		panel.add(lblTitle);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(280, 11, 70, 20);
		panel.add(btnStart);
		
		JLabel lblArrival = new JLabel("Arrival time: ");
		lblArrival.setBounds(10, 45, 90, 15);
		panel.add(lblArrival);
		
		textArrival1 = new JTextField("2");
		textArrival1.setBounds(10, 60, 30, 20);
		panel.add(textArrival1);
		
		JLabel lblTo1 = new JLabel("to");
		lblTo1.setBounds(50, 65, 20, 15);
		panel.add(lblTo1);
		
		textArrival2 = new JTextField("20");
		textArrival2.setBounds(70, 60, 30, 20);
		panel.add(textArrival2);
		
		textArea = new JTextArea();
		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(120, 50, 310, 190);
		panel.add(scroll);

		textService1 = new JTextField("2");
		textService1.setBounds(10, 105, 30, 20);
		panel.add(textService1);
		
		JLabel lblTo2 = new JLabel("to");
		lblTo2.setBounds(50, 110, 20, 15);
		panel.add(lblTo2);
		
		textService2 = new JTextField("5");
		textService2.setBounds(70, 105, 30, 20);
		panel.add(textService2);
		
		JLabel lblService = new JLabel("Service time: ");
		lblService.setBounds(10, 90, 90, 15);
		panel.add(lblService);
		
		JLabel lblSimulation = new JLabel("Simulation time: ");
		lblSimulation.setBounds(10, 135, 100, 15);
		panel.add(lblSimulation);
		
		textSimulation1 = new JTextField("30");
		textSimulation1.setBounds(10, 150, 30, 20);
		panel.add(textSimulation1);
		
		JLabel lblQueues = new JLabel("Nr. of queues:");
		lblQueues.setBounds(10, 180, 90, 15);
		panel.add(lblQueues);
		
		textQueues = new JTextField("4");
		textQueues.setBounds(10, 195, 30, 20);
		panel.add(textQueues);
		
		JLabel lblCustomers = new JLabel("Max. customers:");
		lblCustomers.setBounds(10, 225, 100, 17);
		panel.add(lblCustomers);
		
		textCustomers = new JTextField("25");
		textCustomers.setBounds(10, 240, 30, 20);
		panel.add(textCustomers);
		
		lblTimer = new JLabel("0");
		lblTimer.setBounds(375, 17, 30, 14);
		panel.add(lblTimer);
		
		JLabel lblSeconds = new JLabel("sec");
		lblSeconds.setBounds(395, 17, 30, 14);
		panel.add(lblSeconds);
		
		lblStatus = new JLabel("Fill in the simulation data and press start;");
		lblStatus.setBounds(140, 245, 300, 15);
		panel.add(lblStatus);
		
		panel.setVisible(true);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public JTextField getTextArrival1() 
	{
		return textArrival1;
	}

	public void setTextArrival1(JTextField textArrival1)
	{
		this.textArrival1 = textArrival1;
	}

	public JTextField getTextArrival2()
	{
		return textArrival2;
	}

	public void setTextArrival2(JTextField textArrival2)
	{
		this.textArrival2 = textArrival2;
	}

	public JTextField getTextService1()
	{
		return textService1;
	}

	public void setTextService1(JTextField textService1)
	{
		this.textService1 = textService1;
	}

	public JTextField getTextService2()
	{
		return textService2;
	}

	public void setTextService2(JTextField textService2)
	{
		this.textService2 = textService2;
	}

	public JTextField getTextSimulation1()
	{
		return textSimulation1;
	}

	public void setTextSimulation1(JTextField textSimulation1)
	{
		this.textSimulation1 = textSimulation1;
	}

	public JTextField getTextQueues()
	{
		return textQueues;
	}

	public void setTextQueues(JTextField textQueues)
	{
		this.textQueues = textQueues;
	}

	public JButton getBtnStart()
	{
		return btnStart;
	}

	public void setBtnStart(JButton btnStart)
	{
		this.btnStart = btnStart;
	}

	public JLabel getLblTimer()
	{
		return lblTimer;
	}

	public void setLblTimer(JLabel lblTimer)
	{
		this.lblTimer = lblTimer;
	}

	public JTextArea getTextArea()
	{
		return textArea;
	}

	public void setTextArea(JTextArea textArea)
	{
		this.textArea = textArea;
	}

	public JTextField getTextCustomers()
	{
		return textCustomers;
	}

	public void setTextCustomers(JTextField textCustomers)
	{
		this.textCustomers = textCustomers;
	}

	public JLabel getLblStatus()
	{
		return lblStatus;
	}

	public void setLblStatus(JLabel lblStatus) 
	{
		this.lblStatus = lblStatus;
	}
	
	

}


