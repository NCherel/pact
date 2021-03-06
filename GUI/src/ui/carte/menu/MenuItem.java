package ui.carte.menu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import retaurant.Menu;
import retaurant.Plat;

public class MenuItem extends JPanel
{
	private Menu menu;
	
	private JLabel nom;
	private JLabel description;
	private JLabel prix;
	
	private JButton setButton;
	private JButton delButton;
	
	public MenuItem(Menu menu)
	{
		super();
		this.menu = menu;
		
		this.nom = new JLabel();
		this.prix = new JLabel();
		this.description = new JLabel();
		update();
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.2;
		add(nom,c);

		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.2;
		add(prix,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.8;
		c.weighty = 0.8;
		add(description,c);
		
		c.gridx=2;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon edit = new ImageIcon("data/img/circle.png");
		edit = new ImageIcon(edit.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT));
		add(setButton = new JButton("Modifier",edit),c);
		
		c.gridx=2;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon cross = new ImageIcon("data/img/close.png");
		cross = new ImageIcon(cross.getImage().getScaledInstance(18, 18,Image.SCALE_DEFAULT));
		add(delButton = new JButton("Supprimer",cross),c);
	}
	
	public void update()
	{
		nom.setText("Nom : " + menu.getNom());
		prix.setText("Prix : " + menu.getPrix() +"€");
		
		String descr = "Plats : ";
		for(Plat plat : menu.getMenu())
		{
			descr += plat.getNom()+",";
		}
		
		description.setText(descr);
	}
}
