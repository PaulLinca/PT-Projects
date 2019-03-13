package model;

import java.util.ArrayList;
import java.util.List;

public class Polynomial 
{	
	private List<Monomial> polynomial = new ArrayList<Monomial>();
	
	//adds the polynomial with the parameter polynomial and returns the resulting polynomial
	public Polynomial addition(Polynomial pol)
	{
		Polynomial result;
		if(this.getPolynomial().size() > pol.getPolynomial().size())
		{	result = this;
			for(Monomial mon1: pol.getPolynomial())
			{
				for(Monomial mon2: this.getPolynomial())
					if(mon1.getPower() == mon2.getPower())
					{
						Number sum = mon1.getCoeff().intValue() + mon2.getCoeff().intValue();
						mon2.setCoeff(sum);
					}
			}
		}
		else
		{	result = pol;
			for(Monomial mon1: this.getPolynomial())
			{
				for(Monomial mon2: pol.getPolynomial())
					if(mon1.getPower() == mon2.getPower())
					{
						Number sum = mon1.getCoeff().intValue() + mon2.getCoeff().intValue();
						mon2.setCoeff(sum);
					}
			}
		}
		return result;
	}
	
	//subtracts the polynomial with the parameter polynomial and returns the resulting polynomial
	public Polynomial subtraction(Polynomial pol)
	{
		if(this.getPolynomial().size() >= pol.getPolynomial().size())
		{
			for(Monomial mon1: this.getPolynomial())
			{
				for(Monomial mon2: pol.getPolynomial())
					if(mon1.getPower() == mon2.getPower())
					{
						Number diff = mon1.getCoeff().intValue() - mon2.getCoeff().intValue();
						mon1.setCoeff(diff);
					}
			}
			return this;
		}
		else
		{
			for(Monomial mon1: pol.getPolynomial())
			{
				for(Monomial mon2: this.getPolynomial())
					if(mon1.getPower() == mon2.getPower())
					{
						Number diff = mon1.getCoeff().intValue() - mon2.getCoeff().intValue();
						mon1.setCoeff(diff);
					}
				mon1.setCoeff(-mon1.getCoeff().intValue());
			}
			return pol;
		}
	}
	
	//multiplies the polynomial with the parameter polynomial and returns the resulting polynomial
	public Polynomial multiplication(Polynomial pol)
	{
		int totalLength = this.getPolynomial().size() + pol.getPolynomial().size();
		Polynomial result = new Polynomial();
		for(int i = totalLength - 2; i >= 0; i--)
		{
			result.getPolynomial().add(new IntMonomial(0, i));
		}
		for(int i = 0; i < this.getPolynomial().size(); i++)
		{
			for(int j = 0; j < pol.getPolynomial().size(); j++)
			{
				result.getPolynomial().get(i + j).setCoeff(result.getPolynomial().get(i + j).getCoeff().intValue() + (this.getPolynomial().get(i).getCoeff().intValue() * pol.getPolynomial().get(j).getCoeff().intValue()));
			}
		}
		return result;
	}
	
	//divides the polynomial with the parameter polynomial and returns the resulting polynomial
	public Polynomial division(Polynomial pol)
	{
		Polynomial result = null;
		
		return result;
	}
	
	//differentiaties the polynomial and returns the resulting polynomial
	public Polynomial differentiation()
	{
		Polynomial result = new Polynomial();
		for(int i = this.getPolynomial().size() - 2; i >= 0; i--)
		{
			result.getPolynomial().add(new IntMonomial(0, i));
		}
		int i = 0;
		for(Monomial mon: result.getPolynomial())
		{
			mon.setCoeff(this.getPolynomial().get(i).getCoeff().intValue() * (this.getPolynomial().size() - 1 - i));
			i++;
		}
		return result;
	}
	
	//integrates the polynomial and returns the resulting polynomial
	public Polynomial integration()
	{
		Polynomial result = new Polynomial();
		for(int i = this.getPolynomial().size(); i >= 0; i--)
		{
			result.getPolynomial().add(new RealMonomial(0., i));
		}
		int i = 0;
		for(Monomial mon: result.getPolynomial())
		{	if(this.getPolynomial().get(i).getCoeff().intValue() != 0)
				{
					double newCoeff = this.getPolynomial().get(i).getCoeff().doubleValue() / (this.getPolynomial().get(i).getPower() + 1);
					mon.setCoeff(Math.round(newCoeff * 100.0) / 100.0);
					i++;
				}
		}
		return result;
	}
	//transforms the monomial list into a string to be displayed and returns it
	public String toString(Polynomial pol)
	{
		String finalPol = "";
		StringBuilder sb1 = new StringBuilder();
		for(Monomial mon: pol.getPolynomial())
		{
			if(mon.getCoeff().doubleValue() != 0)
			{
				sb1.append(String.valueOf(mon.getCoeff()));
				if(mon.getPower() != 0)
				{
					sb1.append("x^");
					sb1.append(String.valueOf(mon.getPower()));
				}
				sb1.append("+");
			}
		}
		if(sb1.length() != 0)
		{
			sb1.deleteCharAt(sb1.length() - 1);
		}
		else sb1.append("0");
		finalPol = sb1.toString();
		finalPol = finalPol.replace("+-", "-");

		return finalPol;
	}
	
	//getters and setters
	public List<Monomial> getPolynomial() 
	{
		return polynomial;
	}
	
	public void setPolynomial(List<Monomial> polynomial) 
	{
		this.polynomial = polynomial;
	}
}
