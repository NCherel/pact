package retaurant;
import java.util.ArrayList;



public class Menu implements Achetable
{
	private ArrayList<Plat> menu;
	private final String nom;
	private float prix;

	
	public Menu(String nom, float prix)
	{
		this.menu = new ArrayList<Plat>();
		this.nom = nom;
		this.prix = prix;
	}
	
	public Menu()
	{
		this("Nom",0.f);
	}
	
	public void add(Plat plat)
	{
		for(Plat platAuMenu : menu)
		{
			if(platAuMenu != plat)
				menu.add(plat);
		}
	}
	
	// un menu est disponible que si tous les plats sont disponibles
	@Override
	public boolean disponible()
	{
		for(Plat plat : menu)
		{
			if(!plat.disponible())
				return false;
		}
		  
		return true;
	}
	
	@Override
	public void diminution() throws Exception
	{
		for(Plat plat : menu)
			plat.diminution();
	}
	
	public ArrayList<Plat> getMenu()
	{	
		return menu;
	}
	
	@Override
	public float getPrix()
	{
		return prix;
	}
	
	@Override
	public String getNom()
	{
		return nom;
		
	}
	
	public void removePlat(Plat plat) throws Exception
	{
    	if(menu.size() == 0)
    		throw new Exception("le menu est vide");
    	
        menu.remove(plat);
	}

	public ArrayList<Plat> getPlat() 
	{
		return menu;
	}
	

}
