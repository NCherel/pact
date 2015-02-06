package ui.parasol;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import retaurant.Table;


@SuppressWarnings("serial")
public class ParasolLabel extends JLabel
{
	
	private static final Color GREEN = new Color(0,200,0);
	private static final Color RED = new Color(200,0,0);
	private static final Color ORANGE = new Color(200,120,120);
	
	private Table table;
	
	public ParasolLabel(Table table)
	{
		super();
		this.table = table;
		setOpaque(true);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int min = Math.min(this.getWidth(), this.getHeight());
		
		g.setColor(getColor());
		g.fillOval(this.getWidth()/4,this.getHeight()/4,min/2,min/2);
		g.setColor(getColor().darker());
		g.drawOval(this.getWidth()/4, this.getHeight()/4, min/2, min/2);
		
		
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman",Font.PLAIN,min/8));
		int width = g.getFontMetrics().charWidth('0' + table.getNo());
		g.drawString(table.getNo()+"",this.getWidth()/2-width/2,this.getHeight()/2);
	}
	
	private Color getColor()
	{
		if(table.getPropre() && table.isLibre())
		{
			return GREEN;
		}
		
		else if(!table.getPropre() && table.isLibre())
		{
			return ORANGE;
		}
		
		else
			return RED;
	}
	
	

}
