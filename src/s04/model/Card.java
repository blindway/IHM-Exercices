package s04.model;

public class Card {

	// -------------------------------------
	// Variables
	// -------------------------------------

	private int value; // valeur de la carte
	private String imagePath; // chemin vers l'image de la carte
	private boolean dealt; // la carte a-t-elle été tirée?

	// -------------------------------------
	// Constructor
	// -------------------------------------

	public Card(int value, String imagePath) {
		this.value = value;
		this.imagePath = imagePath;
	}

	// -------------------------------------
	// Getters
	// -------------------------------------

	public int getValue() {
		return value;
	}

	public String getImagePath() {
		return imagePath;
	}

	public boolean isDealt() {
		return dealt;
	}

	// -------------------------------------
	// Setters
	// -------------------------------------

	public void setValue(int value) {
		this.value = value;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setDealt(boolean dealt) {
		this.dealt = dealt;
	}

}
