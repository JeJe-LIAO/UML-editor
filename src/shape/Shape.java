package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Shape {
	protected Boolean select = false;
	public void setSelect(Boolean b) {select = b;}
	public Boolean getSelect() {return select;}
	public Port getConnectPort(int p) {return null;}
	public Boolean checkInsideShape(Point p) {return false;}
	public Port getConnectPort(Point p) {return null;}
	public Port[] getAllPorts() {return null;}
	public void setPosition(int x, int y) {};
	public Boolean checkInsideBlock(Point startPort, Point endPort) {return false;}
	public Point getPosition() {return null;}
	public int getHeight() {return 0;}
	public int getWidth() {return 0;}
	public ArrayList<Shape> getGroupItem() {return null;};
	public void setName(String name) {}
	public void draw(Graphics g) {}
}
