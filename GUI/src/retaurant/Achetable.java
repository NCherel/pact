package retaurant;

public interface Achetable {// on cr�e une interface qui r�cup�re l'ensemble des propri�t�s d'un produit que l'on peut consommer au caf�
	public float getPrix();
	public String getNom();
	public boolean Disponible();//m�thode qui permettra de mettre �  jour la carte si on a plus un produit
	public void diminution() throws Exception;//m�thode qui diminura la quantit� d'un consommable

}
