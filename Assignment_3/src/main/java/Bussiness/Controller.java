package Bussiness;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import com.mysql.fabric.xmlrpc.Client;

import DataAccess.GenericDAO;
import Model.Order;
import Model.Product;
import Presentation.ClientView;
import Presentation.MainView;
import Presentation.OrderView;
import Presentation.ProductView;

public class Controller
{
	private MainView mview;
	private ClientView cview = new ClientView();
	private ProductView pview = new ProductView();
	private OrderView oview = new OrderView();
	
	public Controller()
	{
		mview = new MainView();
		mainButtons();
		backButtons();
		add();
		delete();
	}
	
	//implements action listeners to the buttons on main view
	public void mainButtons()
	{
		mview.getBtnClients().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						cview.getFrame().setVisible(true);
					}
				});
		
		mview.getBtnProducts().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						pview.getFrame().setVisible(true);
					}
				});
		
		mview.getBtnOrders().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						oview.getFrame().setVisible(true);
					}
				});
	}
	
	//implements action listeners to the back buttons
	public void backButtons()
	{
		cview.getBack().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						cview.getFrame().setVisible(false);
					}
				});

		pview.getBack().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						pview.getFrame().setVisible(false);
					}
				});
		
		oview.getBack().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						oview.getFrame().setVisible(false);
					}
				});
	}
	
	//implements action listeners to the add buttons
	public void add()
	{
		cview.getBtnAdd().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						GenericDAO g = new GenericDAO();
						g.insert(Client.class, cview.getTexts());
						cview.setScroll(new JScrollPane(g.selectAll(Client.class)));
						cview.getScroll().revalidate();
					}
				});
		
		pview.getBtnAdd().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						GenericDAO g = new GenericDAO();
						g.insert(Product.class, pview.getTexts());
						pview.setScroll(new JScrollPane(g.selectAll(Product.class)));
						pview.getScroll().setSize(3, 3);
					}
				});
		
		oview.getBtnAdd().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						GenericDAO g = new GenericDAO();
						g.insertOrder(oview.getTexts());
						oview.setScroll(new JScrollPane(g.selectAll(Order.class)));
					}
				});
	}
	
	//implements action listeners to the delete buttons
	public void delete()
	{
		cview.getBtnDelete().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						GenericDAO g = new GenericDAO();
						g.delete(Client.class, Integer.parseInt(cview.getTextId().getText()));
					}
				});
		
		pview.getBtnDelete().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						GenericDAO g = new GenericDAO();
						g.delete(Product.class, Integer.parseInt(pview.getTextId().getText()));
					}
				});
		
		oview.getBtnDelete().addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						GenericDAO g = new GenericDAO();
						g.delete(Order.class, Integer.parseInt(oview.getTextId().getText()));
					}
				});
	}
}
