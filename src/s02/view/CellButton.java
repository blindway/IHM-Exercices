package s02.view;

import com.sun.prism.paint.Color;

import javafx.scene.control.Button;

public class CellButton extends Button{
	
	int x;
	int y;
	
	this.setStyle("-fx-background-color: grey;");
	
	
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
