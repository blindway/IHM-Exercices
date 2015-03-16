package s01;

import javafx.scene.paint.Color;

public class ColorTools {
	public static void paintALL(Colorable[] tabColor, Color couleur) {
		for (Colorable colorable : tabColor) {
			colorable.paint(couleur);
		}
	}
}
