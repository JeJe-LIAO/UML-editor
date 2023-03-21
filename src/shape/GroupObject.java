package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class GroupObject extends Shape{
	private ArrayList<Shape> children;
	private int height;
	private int width;
	private Point position = new Point();
	
	public GroupObject(ArrayList<Shape> selectShapes) {
		children = selectShapes;
		int maxX=Integer.MIN_VALUE;
		int maxY=Integer.MIN_VALUE;
		int minX=Integer.MAX_VALUE;
		int minY=Integer.MAX_VALUE;
		for(Shape shape : children) {
			if(shape.getPosition()!=null) {
				if(shape.getPosition().x < minX) {minX = shape.getPosition().x;}
				if(shape.getPosition().y < minY) {minY = shape.getPosition().y;}
				if(shape.getPosition().x+shape.getWidth() > maxX) {maxX = shape.getPosition().x+shape.getWidth();}
				if(shape.getPosition().y+shape.getHeight() > maxY) {maxY = shape.getPosition().y+shape.getHeight();}
			}
			
		}
		width = maxX-minX;
		height = maxY-minY;
		position.setLocation(minX, minY);
	}
	
	public Point getPosition() {return position;}
	public int getHeight() {return height;}
	public int getWidth() {return width;}
	public ArrayList<Shape> getGroupItem(){
		System.out.println("rtn children");
		return children;
	}
	
	public void setSelect(Boolean b) {
		for(Shape shape:children) {
			shape.setSelect(b);
		}
		select=b;
	}
	public void setPosition(int moveX, int moveY) {
		position.x = position.x+moveX;
		position.y = position.y+moveY;
		for(Shape shape:children) {
			shape.setPosition(moveX, moveY);
		}
	}
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
	
	public void draw(Graphics g) {
		for(Shape shape:children) {
			shape.draw(g);
		}
		//g.drawRect(position.x, position.y, width, height);
	}
}
