package mode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import shape.Port;
import shape.Shape;

public class SelectMode extends Mode{
	private ArrayList<Shape> shapes;
	private Point startPoint=null;
	private Point prePoint=null;
	private ArrayList<Shape> selectShapes;
	
	public void mousePressed(MouseEvent e) {
		startPoint = e.getPoint();
		// clean all selectObjs
		shapes = canvas.getAllShapes();
		for(Shape shape:shapes) {
			shape.setSelect(false);
		}
		
		selectShapes = canvas.getSelectShapes();
		canvas.resetSelectShapes();
		shapes = canvas.getAllShapes();
		
		for(Shape shape:shapes) {
			if(shape.checkInsideShape(e.getPoint())) {
				shape.setSelect(true);
				shapes.remove(shape);
				shapes.add(shape);
				canvas.addSelectShapes(shape);
				break;
			}
		}
		canvas.repaint();
	}
	public void mouseDragged(MouseEvent e) {
		if(prePoint==null) {
			prePoint = e.getPoint();
		}
		int moveX = e.getX() - prePoint.x;
		int moveY = e.getY() - prePoint.y;
		
		for(Shape shape:shapes) {
			if(shape.getSelect() == true) {
				shape.setPosition(moveX, moveY);
			}
		}
		
		prePoint.x = e.getX();
		prePoint.y = e.getY();
		canvas.repaint();
	}
	public void mouseReleased(MouseEvent e) {
		prePoint=null;

		for(Shape shape:shapes) {
			if(shape.checkInsideBlock(startPoint, e.getPoint())) {
				shape.setSelect(true);
				canvas.addSelectShapes(shape);
			}
		}
		canvas.repaint();
	}
	
}
