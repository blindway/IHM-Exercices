package s02.view;

import javafx.scene.control.Button;

public class CellButton extends Button{
	
	int x;
	int y;
	
	
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
	
	public void setflag(boolean isFlagged){
		
	}
	
	public void setflag(){
		
		//this.setBackgroundResource(.ressources.new_todo_image);
		
	}
}
