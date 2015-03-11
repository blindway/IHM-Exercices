package s01;

import javafx.geometry.Point2D;

public class Rectangle {
	private double x0, y0, x1, y1;
	private Point2D downLeft, upRight;
	
	Rectangle (double x0, double y0, double x1, double y1){
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}
	
	Rectangle(Point2D downLeft, Point2D upRight){
		this.downLeft = downLeft;
		this.upRight = upRight;
	}
	
	public double getWidth(){
		return 0.0;
	}
	
	public double getHeight(){
		return 0.0;
	}
	
	public boolean isIn(){
		return false;
	}
	
	public void move(double x, double y){
		
	}
	
	public Rectangle union(Rectangle rec){
		
	}
	
	public Rectangle intersection(Rectangle rec){
		
	}
	@Override
	public String toString(){
		return "";
	}
	@Override
	public boolean equals(Rectangle rec){
		
	}
	
}
