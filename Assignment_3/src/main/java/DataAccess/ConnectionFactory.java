package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.mysql.jdbc.Statement;

public class ConnectionFactory 
{
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/Assignment3";
	private static final String USER = "root";
	private static final String PASS = "password";
	
	private Connection connection;
	
	private static ConnectionFactory singleInstance = new ConnectionFactory();
	
	public ConnectionFactory()
	{
		try
		{
			Class.forName(DRIVER);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	//creates a connection to the database
	public void createConnection()
	{		
		try 
		{
			connection = (Connection) DriverManager.getConnection(DBURL + "?autoReconnect=true&useSSL=false", USER, PASS);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(connection == null)
		{
			System.out.println("Couldn't connect to the database;");
		}
		else
		{
			System.out.println("Connected to the database;");
		}
		
	}
	
	public static void close(Connection connection)
	{
		try 
		{
			connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	//closes the statements, connections and result sets
	public static void close(Statement statement)
	{
		try 
		{
			statement.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public Connection getConnection()
	{
		return connection;
	}

	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}

	public static void close(ResultSet resultSet)
	{
		try 
		{
			resultSet.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
}

