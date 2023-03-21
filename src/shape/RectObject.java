package shape;

import java.awt.Point;

public class RectObject extends Shape{
	protected Point position = new Point();
	protected Port[] port = new Port[4];
	protected String name = "JEJE";
	private int height;
	private int width;
	
	public RectObject(Point p, int w, int h) {
		position.setLocation(p);
		height = h;
		width = w;
	}
	public Port getConnectPort(Point p) {return null;}
	public Point getPosition() {return position;}
	public int getHeight() {return height;}
	public int getWidth() {return height;}
	public void setName(String _name) {name = _name;}
	public void setPosition(int moveX, int moveY) {
		position.x = position.x+moveX;
		position.y = position.y+moveY;
		for(int i=0; i<4; i++) {
			port[i].setPosition(moveX, moveY);
		}
	}
	public Port[] getAllPorts() {return port;}
	public Boolean checkInsideShape(Point p) {
		if(p.x>=position.x && p.x<=position.x+width && p.y>=position.y && p.y<=position.y+height) {
			return true;
		}
		return false;
	}
	public Boolean checkInsideBlock(Point startPort, Point endPort) {
		int x1 = Math.min(startPort.x, endPort.x);
		int y1 = Math.min(startPort.y, endPort.y);
		int x2 = Math.max(startPort.x, endPort.x);
		int y2 = Math.max(startPort.y, endPort.y);
		if(x1<position.x && y1<position.y && x2>position.x+width && y2>position.y+height)
			return true;
		return false;
	}
	public void draw() {};
	
}
