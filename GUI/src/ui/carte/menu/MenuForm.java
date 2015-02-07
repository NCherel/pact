package ui.carte.menu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MenuController;

import retaurant.Carte;
import retaurant.Menu;
import retaurant.Plat;

@SuppressWarnings("serial")
public class MenuForm extends JPanel implements ActionListener
{
	private MenuCard parent;
	private MenuController controller;
	private Menu menu;
	private ArrayList<Plat> listePlats;
	
	private JTextField nom;
	private JTextField description;
	private JFormattedTextField prix;
	private ArrayList<JComboBox<String>> plats;
	
	private JPanel aside;
	
	private JButton validate;
	private JButton ret;
	private JButton addPlat;
	
	private Carte carte;
	
	
	public MenuForm(MenuCard parent, MenuController controller, Carte carte)
	{
		super();
		this.carte = carte;
		this.parent = parent;
		this.controller = controller;
		this.menu = controller.getMenu();
		this.listePlats = carte.getPlats();
		plats = new ArrayList<JComboBox<String>>();
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.nom = new JTextField(menu.getNom()),c);
		
		/*
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.description = new JTextField(menu.getDescription()),c);
		*/
		
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.prix = new JFormattedTextField(NumberFormat.getNumberInstance()),c);
		this.prix.setValue(new Double(menu.getPrix()));
		
		//coin pour les ingredients
		c.gridx=0;
		c.gridy=3;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(aside = new JPanel(),c);
		aside.setLayout(new GridLayout(0,1));
		
		
		//bouton pour ajouter un ingredient
		c.gridx=0;
		c.gridy=2;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(addPlat = new JButton("Ajouter un ingredient"),c);
		addPlat.addActionListener(this);
		addPlat.setActionCommand("addIn");
		
		c.gridx=2;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon edit = new ImageIcon("data/img/validate.png");
		edit = new ImageIcon(edit.getImage().getScaledInstance(18, 18,Image.SCALE_SMOOTH));
		add(validate = new JButton("Valider",edit),c);
		validate.addActionListener(this);
		validate.setActionCommand("val");
		
		c.gridx=2;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		ImageIcon retour = new ImageIcon("data/img/arrow.png");
		retour = new ImageIcon(retour.getImage().getScaledInstance(18, 18,Image.SCALE_SMOOTH));
		add(ret = new JButton("Retour",retour),c);
		ret.addActionListener(this);
		ret.setActionCommand("ret");
		
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public MenuForm(MenuCard parent)
	{
		this(parent,new MenuController(new Menu(),new ArrayList<Plat>()),new Carte());
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("addIn"))
		{
			JComboBox<String> temp = new JComboBox<String>();
			fillComboBoxWithPlats(temp);
			plats.add(temp);
			aside.add(temp);
			update();
		}
		
		else if(e.getActionCommand().equals("set"))
		{
			if(controller.setMenu(nom.getText(), description.getText(), (float) prix.getValue(), getPlats()))
			{
				parent.switchCard();
			}
			
		}
		
		else if(e.getActionCommand().equals("ret"))
		{
			parent.switchCard();
		}
		
	}
	
	public void update()
	{
		validate();
		repaint();
	}
	
	private void fillComboBoxWithPlats(JComboBox<String> box)
	{
		for(Plat plat : listePlats)
		{
			box.addItem(plat.getNom());
		}
	}
	
	public ArrayList<String> getPlats()
	{
		ArrayList<String> liste = new ArrayList<String>();
		for(JComboBox<String> box : plats)
		{
			liste.add((String) box.getSelectedItem());
		}
		
		return liste;
	}
}
