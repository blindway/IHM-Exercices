package s01;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Email extends Message {

	String message;

	public Email(String sender, ArrayList<String> recipients, String message,
			Color couleur) {
		super(sender, recipients, couleur);
		this.message = message;
	}

	@Override
	public void display() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return message + " [Couleur:" + super.getColor() + "]";
	}

	@Override
	public String getType() {
		return "Email";
	}

	@Override
	public void paint(Color color) {
		super.setColor(color);
	}

	@Override
	public Color whatColor() {
		return super.getColor();
	}

	@Override
	public void inverseColor() {
		if (super.getColor() != null) {
			super.setColor(getColor().invert());
		}
	}
}
