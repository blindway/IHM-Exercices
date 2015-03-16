package s01;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Box extends Rectangle implements Colorable {
	private double epaisseur;
	private LineType typeLigne;
	private Color couleur;

	public Box(double x0, double y0, double x1, double y1, double epaisseur,
			LineType typeLigne, Color couleur) {
		super(x0, y0, x1, y1);
		this.epaisseur = epaisseur;
		this.typeLigne = typeLigne;
		this.couleur = couleur;
	}

	public Box(Point2D downLeft, Point2D upRight, double epaisseur,
			LineType typeLigne, Color couleur) {
		super(downLeft, upRight);
		this.epaisseur = epaisseur;
		this.typeLigne = typeLigne;
		this.couleur = couleur;
	}

	public double getEpaisseur() {
		return epaisseur;
	}

	public void setEpaisseur(double epaisseur) {
		this.epaisseur = epaisseur;
	}

	public LineType getTypeLigne() {
		return typeLigne;
	}

	public void setTypeLigne(LineType typeLigne) {
		this.typeLigne = typeLigne;
	}

	public double getX0() {
		return super.getX0();
	}

	public double getX1() {
		return super.getX1();
	}

	public double getY0() {
		return super.getY0();
	}

	public double getY1() {
		return super.getY1();
	}

	@Override
	public String toString() {
		return "Box [" + getX0() + ", " + getY0() + "], [" + getX1() + ", "
				+ getY1() + "]" + " [Epaisseur:" + epaisseur + "] " + "[type:"
				+ typeLigne.toString() + "]" + " [Couleur:" + couleur + "]";
	}

	@Override
	public boolean equals(Object ob) {
		Box box = (Box) ob;
		if (getX0() == box.getX0() && getY1() == box.getY1()
				&& epaisseur == box.getEpaisseur()
				&& typeLigne == box.getTypeLigne()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void paint(Color color) {
		this.couleur = color;
	}

	@Override
	public Color whatColor() {
		return couleur;
	}

	@Override
	public void inverseColor() {
		if (couleur != null) {
			couleur.invert();
		}
	}
}
