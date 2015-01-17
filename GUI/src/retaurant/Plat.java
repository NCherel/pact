package retaurant;
import java.util.ArrayList;



public class Plat implements Achetable
	{
	private final String nom; 
	private String description;
	private float prix;
	private ArrayList<Ingredient> listeingredient;
	
	public Plat(String nom, String description, float prix)
		{

		this.nom = nom;
		this.description = description;
		this.prix = prix;
		listeingredient = new ArrayList<Ingredient>();
		}
	
	public boolean Disponible()//toujours un plat est disponible si tous les ingr�dients sont pr�sents
		{int i =0;
		for (Ingredient ingredient : listeingredient){
			if (ingredient.getNoInStock()!=0)
		i++;
			}
		return(i==listeingredient.size());
		}
	public void diminution () throws Exception{// on diminue la quantit� de tous les ingr�dients
		for (Ingredient ingredient : listeingredient)
			ingredient.removeProduct(1);
	}
	
	public String getNom()
		{	
		return nom;
		}
	
	public void setDescription(String description)// si erreur d'ortographe
		{	
		this.description = description;
		}
	
	public float getPrix()
		{	
		return prix;
		}
	
	public void setPrix(float prix)
		{	
		this.prix = prix;
		}
	
	}
