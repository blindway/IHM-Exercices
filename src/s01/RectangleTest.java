package s01;

import javafx.geometry.Point2D;

public class RectangleTest {
	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle(4, 6, 8, 8);
		Rectangle rec2 = new Rectangle(7, 7, 10, 9);
		Rectangle rec3 = new Rectangle(4, 6, 8, 8);
		Point2D point = new Point2D(5, 7);
		Rectangle intersec = rec1.intersection(rec2);
		Rectangle uni = rec1.union(rec2);
		Box box1 = new Box(0, 0, 2, 2, 1.0, LineType.DASHED);
		Box box2 = new Box(0, 0, 2, 2, 1.0, LineType.DASHED);
		Box box3 = new Box(1, 1, 3, 3, 2.0, LineType.PLAIN);

		boolean resultat = true;
		if (!rec1.equals(rec3))
			resultat = false;
		if (rec2.getHeight() != 2)
			resultat = false;
		if (rec2.getWidth() != 3)
			resultat = false;
		if (!rec1.isIn(point))
			resultat = false;
		rec2.move(1, 1);
		if (rec2.getX0() != 8 || rec2.getY0() != 8)
			resultat = false;
		// rec2 (8, 8, 11, 10)
		rec2.move(-1, -1);
		if (uni.getX0() != 4 || uni.getY1() != 9)
			resultat = false;
		if (intersec.getX0() != 7 || intersec.getY1() != 8)
			resultat = false;
		System.out.println(intersec.toString());

		if (!box1.equals(box2))
			resultat = false;
		if (box1.equals(box3))
			resultat = false;
		System.out.println(box1.toString());

		if (resultat == true) {
			System.out.println("Test passed successfully");
		} else {
			System.out.println("Something is wrong...");
		}
	}
}
