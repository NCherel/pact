package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ui.notification.CommandeNotification;
import ui.notification.Notification;
import ui.notification.StockNotification;

@SuppressWarnings("serial")
public class NotificationPanel extends JPanel
{
	private ArrayList<Notification> liste;
	private JPanel content;
	
	public NotificationPanel() 
	{
		super();
		liste = new ArrayList<Notification>();
		
		setLayout(new BorderLayout());
		content = new JPanel();
		content.setLayout(new GridLayout(0,1));
		
		liste.add(new CommandeNotification(this,1));
		liste.add(new StockNotification(this,"Cola-cola",4));
		liste.add(new CommandeNotification(this,2));
		liste.add(new CommandeNotification(this,3));
		
		add(content,BorderLayout.PAGE_START);
		
		update();
	}
	
	public void removeNotification(Notification notification)
	{
		liste.remove(notification);
		update();
	}
	
	public void addNotification(Notification notification)
	{
		liste.add(notification);
		update();
	}
	
	//update the contentPanel by filling it with all the notifications of liste
	public void update()
	{
		content.removeAll();
		
		for(Notification notification : liste)
			content.add(notification);
		
		validate();
		repaint();
	}
}
