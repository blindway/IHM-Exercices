package s02.view;

import com.sun.prism.paint.Color;

import javafx.scene.control.Button;

public class CellButton extends Button{
	
<<<<<<< Updated upstream
	private int x, y;
	
	this.setStyle("-fx-background-color: grey;");
	
=======
	int x;
	int y;	
>>>>>>> Stashed changes
	
	public CellButton(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getx() {
		return this.x;
	}

	public int gety() {
		return this.y;
	}
	
}
