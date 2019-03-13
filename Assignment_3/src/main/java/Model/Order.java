package Model;

public class Order 
{
	private int id;
	private int productId;
	private int customerId;
	private int quantity;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public int getProductId()
	{
		return productId;
	}
	
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	
	public int getCustomerId() 
	{
		return customerId;
	}
	
	public void setCustomerId(int customerId) 
	{
		this.customerId = customerId;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
}
