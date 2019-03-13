package DataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import Bussiness.BillGenerator;

public class GenericDAO
{
	//this method is used to connect to the database and returns the connection
	private static Connection connectToDB()
	{
		ConnectionFactory cF = new ConnectionFactory();
		cF.createConnection();
		
		return (Connection) cF.getConnection();
	}
	
	//this method builds a table model from a given result set
	public DefaultTableModel buildTableModel(ResultSet rs) throws SQLException
	{
		ResultSetMetaData metaData = rs.getMetaData();
		
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		
		for(int i = 1; i <= columnCount; i++)
		{
			columnNames.add(metaData.getColumnName(i));
		}
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while(rs.next())
		{
			Vector<Object> vector = new Vector<Object>();
			for(int i = 1; i <= columnCount; i++)
			{
				vector.add(rs.getObject(i));
			}
			data.add(vector);
		}
		return new DefaultTableModel(data, columnNames);
	}
	
	//this method returns a string array of the names of a table corresponding to a given class
	public String[] getColumns(Class c)
	{
		String selectAllStatement = "SELECT * FROM assignment3." + c.getSimpleName();
		Connection connect = connectToDB();

		PreparedStatement selAll = null;
		ResultSet rSet = null;
		
		String[] cols = null;
		try 
		{
			selAll = connect.prepareStatement(selectAllStatement);
			rSet = selAll.executeQuery();
			ResultSetMetaData metaData = rSet.getMetaData();

			cols = new String[metaData.getColumnCount()];
			for(int i = 1; i <= metaData.getColumnCount(); i++)
			{
				cols[i - 1]  = metaData.getColumnLabel(i);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cols;
	}
	
	//checks if a string is numeric 
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public void insertOrder(JTextField[] texts)
	{
		Connection connect = connectToDB();
		String insertStatement = "INSERT INTO assignment3.Order (Id, ProductId, ClientId, Quantity) VALUES(";
		PreparedStatement ins = null;
		String selectStatement = "SELECT * FROM assignment3.Product WHERE id = " + texts[1].getText();
		PreparedStatement sel = null;
		ResultSet rSet = null;
		
		for(int i = 0; i < texts.length; i++)
		{
			insertStatement += texts[i].getText();
			if(i != texts.length - 1)
			{
				insertStatement += ", ";
			}
		}
		insertStatement += ")";
		try 
		{
			sel = connect.prepareStatement(selectStatement);
			rSet = sel.executeQuery();
			rSet.next();
			int newQuantity = rSet.getInt(4) - Integer.parseInt(texts[3].getText());
			if(newQuantity <= 0) 
			{
				System.out.println("Not enough products on stock");
			}
			else
			{
				ins = connect.prepareStatement(insertStatement);
				updateStock(Integer.parseInt(texts[1].getText()), newQuantity);
				ins.execute();
				BillGenerator bill = new BillGenerator(Integer.parseInt(texts[0].getText()), Integer.parseInt(texts[2].getText()), rSet.getString(2), Integer.parseInt(texts[3].getText()), rSet.getInt(3));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void updateStock(int productId, int newQuantity)
	{
		Connection connect = connectToDB();
		String updateStatement = "UPDATE assignment3.Product SET Stock = " + newQuantity + " WHERE id = " + productId;
		PreparedStatement upd = null;
		
		try 
		{
			System.out.println(updateStatement);
			upd = connect.prepareStatement(updateStatement);
			upd.execute();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	//inserts data into a table based on the data in the text fields
	public void insert(Class c, JTextField[] texts)
	{

		Connection connect = connectToDB();
		String insertStatement = "INSERT INTO assignment3." + c.getSimpleName() + " (";
		PreparedStatement ins = null;
		
		String[] columns = getColumns(c);
		for(int i = 0; i < columns.length; i++)
		{
			insertStatement += columns[i];
			if(i != columns.length - 1)
			{
				insertStatement += ", ";
			}
		}
		insertStatement += ") VALUES(";
		
		for(int i = 0; i < texts.length; i++)
		{
			if(!isNumeric(texts[i].getText()))
			{
				insertStatement += "'" + texts[i].getText() + "'";
			}
			else insertStatement += texts[i].getText();

			if(i != texts.length - 1)
			{
				insertStatement += ", ";
			}
		}
		insertStatement += ");";
		try
		{		
			System.out.println(insertStatement);
			ins = connect.prepareStatement(insertStatement);
			ins.execute();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//deletes a row based on the given id
	public void delete(Class c, int id)
	{
		String deleteStatement = "DELETE FROM assignment3." + c.getSimpleName() + " WHERE id = " + id;
		Connection connect = connectToDB();
		PreparedStatement del = null;
		
		try
		{
			del = connect.prepareStatement(deleteStatement);
			del.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void updateStock(int id)
	{
		String updateStatement = "UPDATE assignment3.product SET stock = ";
		String selectStock = "SELECT stock from assignment3.product WHERE id =" + id;
		
		Connection connect = connectToDB();
		PreparedStatement upd = null;
		
		ResultSet rSet = null;

		
		try 
		{
			upd = connect.prepareStatement(selectStock);
			rSet = upd.executeQuery();
			rSet.next();
			int newStock = Integer.parseInt(rSet.getString(1)) - 1;
			updateStatement += newStock + "WHERE id = " + id;
			
			upd = connect.prepareStatement(updateStatement);
			upd.execute();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//selects all the data from a table and returns a corresponding JTable
	public JTable selectAll(Class c)
	{
		String selectAllStatement = "SELECT * FROM assignment3." + c.getSimpleName();
		Connection connect = connectToDB();

		PreparedStatement selAll = null;
		ResultSet rSet = null;
		
		try
		{
			
			selAll = connect.prepareStatement(selectAllStatement);
			rSet = selAll.executeQuery();
			JTable result = new JTable(buildTableModel(rSet));
			return result;

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
