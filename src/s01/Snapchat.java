package s01;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Snapchat extends Message{

	Image image;
	
	public Snapchat(String sender, ArrayList<String> recipients,Image image, Color couleur) {
		super(sender, recipients, couleur);
		this.image = image;
	}


	@Override
	public void paint(Color color) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void display() {
		System.out.println(this);	
	}

	@Override
	public String getType() {
		return "SnapChat";
	}
	
	@Override
	public String toString() {
		return image.toString() + " [Couleur:" + super.getColor() + "]";
	}

	
}
