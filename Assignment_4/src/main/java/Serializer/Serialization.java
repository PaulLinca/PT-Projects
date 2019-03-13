package Serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.Bank;

public class Serialization 
{
	public void serializeBank(Bank bank)
	{
		try 
		{
			FileOutputStream fileOut = new FileOutputStream("Bank.bin");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(bank);
			
			out.close();
			fileOut.close();
			
			System.out.println("Serialization successful!");
			
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Serialization failed!");
		}
	}
	
	public Bank deserializeBank()
	{
		Bank objFromFile = null;
		try 
		{
			FileInputStream fileIn = new FileInputStream("Bank.bin");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			objFromFile = new Bank();
			objFromFile = (Bank) in.readObject();
			
			in.close();
			fileIn.close();
			
			System.out.println("Deserialization successful!");
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Serialization failed!");
		}
		return objFromFile;
	}
}
