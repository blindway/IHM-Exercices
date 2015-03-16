package s01;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Sms extends Message {

	char[] messageChar;

	public Sms(String sender, ArrayList<String> recipients, String message,
			Color couleur) {
		super(sender, recipients, couleur);
		messageChar = new char[160];
		messageToTab(message);
	}

	private void messageToTab(String message) {
		for (int i = 0; i < message.length(); i++) {
			messageChar[i] = message.charAt(i);
		}
	}

	@Override
	public void display() {
		System.out.println(this);

	}

	@Override
	public String toString() {
		String message = new String(messageChar);
		String color = " [Couleur:" + super.getColor() + "]";
		return message+color;
	}

	@Override
	public String getType() {
		return "SMS";
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
