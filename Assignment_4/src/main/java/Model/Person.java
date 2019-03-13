package Model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class Person implements Serializable, Observer
{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String SSN;
	
	public Person(String name, String email, String SSN)
	{
		this.name = name;
		this.email = email;
		this.SSN = SSN;
	}
	
	@Override
	public int hashCode()
	{
		int result = 17;
		
		result = 31 * result + name.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + SSN.hashCode();
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		
		if(obj == null)
		{
			return false;
		}
		
		Person p = (Person) obj;
		
		return p.name.equals(name) && p.email.equals(email) && p.SSN.equals(SSN);
	}
	
	public String toString()
	{
		String returnString = "";
		
		returnString += "P(";
		returnString += this.getName();
		returnString += ", ";
		returnString += this.getEmail();
		returnString += ", ";
		returnString += this.getSSN();
		returnString += ")";
		
		return returnString;
	}

	public void update(Observable o, Object arg)
	{
		System.out.println(toString() + ", your data has been modified.");
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getSSN()
	{
		return SSN;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
	
}
