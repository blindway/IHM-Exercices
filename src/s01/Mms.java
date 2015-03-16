package s01;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Mms extends Message {

	String message;
	Image image;

	public Mms(String sender, ArrayList<String> recipients, String message,
			Image image, Color couleur) {
		super(sender, recipients, couleur);
		this.message = message;
		this.image = image;
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
		return "MMS";
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
			super.setColor(super.getColor().invert());
		}
	}
}
