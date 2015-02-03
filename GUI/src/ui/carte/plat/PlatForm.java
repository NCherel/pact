package ui.carte.plat;

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

import controller.PlatController;

import retaurant.Ingredient;
import retaurant.Plat;

@SuppressWarnings("serial")
public class PlatForm extends JPanel implements ActionListener
{
	private PlatCard parent;
	private PlatController controller;
	private Plat plat;
	private ArrayList<Ingredient> listeIngredients;
	
	private JTextField nom;
	private JTextField description;
	private JFormattedTextField prix;
	private ArrayList<JComboBox> ingredients;
	
	private JPanel aside;
	
	private JButton validate;
	private JButton ret;
	private JButton addIngredient;
	
	
	public PlatForm(PlatCard parent, PlatController controller, ArrayList<Ingredient> listeIngredients)
	{
		super();
		this.parent = parent;
		this.controller = controller;
		this.plat = controller.getPlat();
		this.listeIngredients = listeIngredients;
		ingredients = new ArrayList<JComboBox>();
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.nom = new JTextField(plat.getNom()),c);
		
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.description = new JTextField(plat.getDescription()),c);
		
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.prix = new JFormattedTextField(NumberFormat.getNumberInstance()),c);
		this.prix.setValue(new Double(plat.getPrix()));
		
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
		add(addIngredient = new JButton("Ajouter un ingredient"),c);
		addIngredient.addActionListener(this);
		addIngredient.setActionCommand("addIn");
		
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
	
	public PlatForm(PlatCard parent)
	{
		this(parent,new PlatController(new Plat(),new ArrayList<Ingredient>()),new ArrayList<Ingredient>());
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("addIn"))
		{
			JComboBox temp = new JComboBox<String>();
			fillComboBoxWithIngredients(temp);
			ingredients.add(temp);
			aside.add(temp);
			update();
		}
		
		else if(e.getActionCommand().equals("set"))
		{
			if(controller.setPlat(nom.getText(), description.getText(), (float) prix.getValue(), getIngredients()))
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
	
	private void fillComboBoxWithIngredients(JComboBox<String> box)
	{
		for(Ingredient ingredient : listeIngredients)
		{
			box.addItem(ingredient.getNom());
		}
	}
	
	public ArrayList<String> getIngredients()
	{
		ArrayList<String> liste = new ArrayList<String>();
		for(JComboBox<String> box : ingredients)
		{
			liste.add((String) box.getSelectedItem());
		}
		
		return liste;
	}
}
