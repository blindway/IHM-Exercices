package s01;

import javafx.geometry.Point2D;

public class Rectangle {
	private double x0, y0, x1, y1;
	private Point2D downLeft, upRight;

	Rectangle(double x0, double y0, double x1, double y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}

	Rectangle(Point2D downLeft, Point2D upRight) {
		this.downLeft = downLeft;
		this.upRight = upRight;
		x0 = downLeft.getX();
		y0 = downLeft.getY();
		x1 = upRight.getX();
		y1 = upRight.getY();
	}

	public double getWidth() {
		return x1 - x0;
	}

	public double getHeight() {
		return y1 - y0;
	}

	public boolean isIn(Point2D point) {
		double x = point.getX();
		double y = point.getY();
		boolean xOkay = x0 < x && x < x1;
		boolean yOkay = y0 < y && y < y1;
		return xOkay && yOkay;
	}

	public void move(double x, double y) {
		x0 += x;
		x1 += x;
		y0 += y;
		y1 += y;
	}

	public Rectangle union(Rectangle rec) {
		Rectangle resultat = new Rectangle(rec.x0, rec.x1, rec.y0, rec.y1);
		if (x0 < rec.x0) {
			resultat.x0 = x0;
		}
		if (x1 > rec.x1) {
			resultat.x1 = x1;
		}
		if (y0 < rec.y0) {
			resultat.y0 = y0;
		}
		if (y1 > rec.y1) {
			resultat.y1 = y1;
		}
		return resultat;
	}

	public Rectangle intersection(Rectangle rec) {
		Rectangle resultat = new Rectangle(rec.x0, rec.x1, rec.y0, rec.y1);
		if (x0 > rec.x0) {
			resultat.x0 = x0;
		}
		if (x1 < rec.x1) {
			resultat.x1 = x1;
		}
		if (y0 > rec.y0) {
			resultat.y0 = y0;
		}
		if (y1 < rec.y1) {
			resultat.y1 = y1;
		}
		return resultat;
	}

	@Override
	public String toString() {
		return "Rectangle [" + x0 + ", " + y0 + "], [" + x1 + ", " + y1 + "]";
	}

	@Override
	public boolean equals(Object ob) {
		Rectangle rec = (Rectangle) ob;
		if (rec.x0 == x0 && rec.y1 == y1) {
			return true;
		} else {
			return false;
		}
	}
}
