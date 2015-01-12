package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel{

	private final ParasolPanel parasol;
	private final JLabel parasolHeader;
	private final ContentPanel content;
	private final JLabel contentHeader;
	
	MainPanel()
	{
		super();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx=0;
		c.gridy=0;
		c.weightx = 0.33;
		c.weighty = 0.2;
		add(parasolHeader = new JLabel("Terrasse"), c);
		parasolHeader.setHorizontalAlignment(JLabel.CENTER);
		parasolHeader.setForeground(Color.white);
		parasolHeader.setBackground(new Color(0,94,197));
		parasolHeader.setOpaque(true);
		
		c.gridx=0;
		c.gridy=1;
		c.weightx = 0.33;
		c.weighty = 0.8;
		add(parasol = new ParasolPanel(),c);
		
		
		c.gridx=1;
		c.gridy=0;
		c.weightx = 0.66;
		c.weighty = 0.2;
		add(contentHeader = new JLabel("Administration"), c);
		contentHeader.setHorizontalAlignment(JLabel.CENTER);
		contentHeader.setForeground(Color.white);
		contentHeader.setBackground(new Color(200,55,55));
		contentHeader.setOpaque(true);
		
		c.gridx=1;
		c.gridy=1;
		c.weightx = 0.66;
		c.weighty = 0.8;
		add(content = new ContentPanel(),c);

	}
	
}
