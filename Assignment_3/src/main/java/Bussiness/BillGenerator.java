package Bussiness;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

public class BillGenerator 
{
	//generates a text file that represents a bill based on the data on the parameters
	public BillGenerator(int orderId, int clientId, String product, int quantity, int price)
	{
		Date date = new Date();
		int total = price * quantity;
		String textFile = "Order no. " + orderId + "\n";
		textFile += "Date: " + date.toString() + "\n";
		textFile += "Customer: " + clientId + "\n";
		textFile += "Product: " + product + "......" + total + " lei\n\nHave a nice day!";
		
		byte [] buff = textFile.getBytes();
		
		try
		{
			RandomAccessFile raf = new RandomAccessFile("Bill "+ orderId, "rw");
			raf.write(buff);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
