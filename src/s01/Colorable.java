package s01;

import javafx.scene.paint.Color;

public interface Colorable {
	// permet de d�finir la couleur de l'objet
	public void paint(Color color);

	// permet de connaitre sa couleur(null si pas definie)
	public Color whatColor();

	//inverse la couleur actuellement d�finie (sans effet si aucune couleur n'est definie
	public void inverseColor();
}
