package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import retaurant.Consommable;
import retaurant.Ingredient;
import retaurant.Stock;

public class StockController implements ActionListener
{
	//Model
	private Stock stock;

	public StockController(Stock stock) 
	{
		this.stock = stock;
	}
	
	public Stock getStock()
	{
		return stock;
	}
	
	public void removeIngredient(Ingredient ingredient)
	{
		stock.removeIngredient(ingredient);
	}
	
	public void addIngredient(Ingredient ingredient)
	{
		stock.addIngredient(ingredient);
	}
	
	public void removeConsommable(Consommable consommable)
	{
		stock.removeConsommable(consommable);
	}
	
	public void addConsommable(Consommable consommable)
	{
		stock.addConsommable(consommable);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	
}
