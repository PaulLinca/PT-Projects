package model;
public class Monomial 
{
	private Number coeff;
	private int power;
	
	//constructor that sets the attributes based on the parameters
	public Monomial(Number c, int p)
	{
		setCoeff(c);
		setPower(p);
	}
	
	//getters and setters
	public Number getCoeff()
	{
		return coeff;
	}
	public void setCoeff(Number coeff)
	{
		this.coeff = coeff;
	}
	public int getPower()
	{
		return power;
	}
	public void setPower(int power) 
	{
		this.power = power;
	}
	
}
