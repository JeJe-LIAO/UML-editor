package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Port {
	private RectObject parient;
	private Point position = new Point();
	private ArrayList<LineObject> lines;
	
	public Port(int x, int y){
		position.x = x;
		position.y = y;
	}
	public void addLine(LineObject line) {
		lines.add(line);
	}
	public void setPosition(int moveX, int moveY) {
		position.x = position.x+moveX;
		position.y = position.y+moveY;
	}
	public ArrayList<LineObject> getLine(){return lines;}
	public Point getPosition() {return position;}
	public void draw(Graphics g) {
		g.fillRect(position.x, position.y, 10, 10);
	}
	
}
