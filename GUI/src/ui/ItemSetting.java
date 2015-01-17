package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Item;

public class ItemSetting extends JPanel{
	
	private JTextField nom;
	private JTextField description;
	private JFormattedTextField prix;
	private JFormattedTextField quantite;
	
	public ItemSetting() {
		this(new Item());
	}
	
	public ItemSetting(Item item) {
		
		super();
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.nom = new JTextField(item.getNom()),c);
		
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.6;
		c.weighty = 0.5;
		add(this.description = new JTextField(item.getDescription()),c);
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.prix = new JFormattedTextField(NumberFormat.getNumberInstance()),c);
		this.prix.setValue(new Double(item.getPrix()));

		c.gridx=1;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(this.quantite = new JFormattedTextField(NumberFormat.getNumberInstance()),c);
		this.quantite.setValue(new Integer(item.getQuantite()));
		
		c.gridx=2;
		c.gridy=0;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(new JButton("Valider"),c);
		
		c.gridx=2;
		c.gridy=1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(new JButton("Retour"),c);
		
		setBorder(BorderFactory.createLineBorder(Color.blue));
	}

}