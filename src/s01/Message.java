package s01;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public abstract class Message implements Colorable {

	private String sender;
	private ArrayList<String> recipients;
	private Color couleur;

	public Message(String sender, ArrayList<String> recipients, Color couleur) {
		this.sender = sender;
		this.recipients = recipients;
		this.couleur = couleur;
	}

	public abstract void display();

	public String getSender() {
		return sender;
	}

	public ArrayList<String> getRecipients() {
		return recipients;
	}

	public abstract String getType();

	public Color getColor() {
		return couleur;
	}

	public void setColor(Color color) {
		this.couleur = color;
	}
}
