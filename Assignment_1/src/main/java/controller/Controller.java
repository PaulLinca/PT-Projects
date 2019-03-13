package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.IntMonomial;
import model.Polynomial;
import view.View;

public class Controller 
{
	private View view = new View();
	private Polynomial firstPol = new Polynomial();
	private Polynomial secondPol = new Polynomial();
	
	public Controller()
	{
		getView().init();
		addition();
		subtraction();
		multiplication();
		division();
		differentiation();
		integration();
	}
	//this method turns the strings in the polynomial text fields into monomial lists that are the attributes of the two polynomials
	public void read()
	{
		try 
		{
			firstPol = new Polynomial();
			secondPol = new Polynomial();
		    String pol1 = view.getFirstPol().getText();
		    String pol2 = view.getSecondPol().getText();
			String[] poly1Data = pol1.split(",\\ ");
			String[] poly2Data = pol2.split(",\\ ");
			
			initPols(poly1Data, poly2Data);
			
			for(int i = 0; i < poly1Data.length; i++)
			{
				String[] data = poly1Data[i].split(" ");
				addMonom(getFirstPol(), data);
			}
			
			for(int i = 0; i < poly2Data.length; i++)
			{
				String[] data = poly2Data[i].split(" ");
				addMonom(getSecondPol(), data);
			}
		}catch(Exception e)
		{
			System.out.println("Wrong polynmial format \n Program will exit");
			System.exit(1);
		}
	}
	
	//this method initializes the two polynomial lists by adjusting their length making each monomial's coefficient 0. 
	//the two parameters are two string arrays, each element being a coefficient and a power separated by a space
	public void initPols(String[] s1, String[] s2)
	{
		int max1 = -1, max2 = -1;
			for(int i = 0; i < s1.length; i++)
			{
				String[] data = s1[i].split(" ");
				if(Integer.parseInt(data[1]) > max1)
				{
					max1 = Integer.parseInt(data[1]);
				}
			}
			
			for(int i = max1; i >= 0; i--){
				getFirstPol().getPolynomial().add(new IntMonomial(0, i));
			}
			
			for(int i = 0; i < s2.length; i++)
			{
				String[] data = s2[i].split(" ");
				if(Integer.parseInt(data[1]) > max2)
				{
					max2 = Integer.parseInt(data[1]);
				}
			}
			
			for(int i = max2; i >= 0; i--){
				getSecondPol().getPolynomial().add(new IntMonomial(0, i));
			}
	}
	//this method updates a monomial's data with its correct value. The 
	public void addMonom(Polynomial pol, String[] d)
	{
			int coeff = Integer.parseInt(d[0]);
			int power = Integer.parseInt(d[1]);
			
			for(int i = 0; i < pol.getPolynomial().size(); i++)
			{
				if(power == pol.getPolynomial().get(i).getPower())
				{
					pol.getPolynomial().get(i).setCoeff(coeff);
				}
			}
	}
	
	//reads and adds the polynomials and displays the result
	public void addition()
	{
		view.getBtnAddition().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						read();
						Polynomial result = firstPol.addition(secondPol);
						display(result.toString(result));
					}
				});
	}	
	
	//reads and subtracts the polynomials and displays the result
	public void subtraction()
	{
		view.getBtnSubtraction().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						read();
						Polynomial result = firstPol.subtraction(secondPol);
						display(result.toString(result));
					}
				});
	}	
	
	//reads and multiplies the polynomials and displays the result
	public void multiplication()
	{
		view.getBtnMultiplication().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						read();
						Polynomial result = firstPol.multiplication(secondPol);
						display(result.toString(result));

					}
				});
	}	
	
	//reads and divides the polynomials and displays the result
	public void division()
	{
		view.getBtnDivision().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						read();
						Polynomial result = firstPol.division(secondPol);
						display(result.toString());
					}
				});
	}	
	
	//reads and derivates the first polynomial and displays the result
	public void differentiation()
	{
		view.getBtndifferentiation().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						read();
						Polynomial result = firstPol.differentiation();
						display(result.toString(result));

					}
				});
	}	
	
	//reads and integrates the first polynomial and displays the result
	public void integration()
	{
		view.getBtnIntegration().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						read();
						Polynomial result = firstPol.integration();
						display(result.toString(result));

					}
				});
	}	
	
	//changes the solution labe to display the result of the operation
	public void display(String pol)
	{
		view.getLblFinal().setText(pol);
	}
	
	//getters and setters
	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Polynomial getFirstPol() {
		return firstPol;
	}

	public void setFirstPol(Polynomial firstPol) {
		this.firstPol = firstPol;
	}

	public Polynomial getSecondPol() {
		return secondPol;
	}

	public void setSecondPol(Polynomial secondPol) {
		this.secondPol = secondPol;
	}
}
