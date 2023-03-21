package UMLview;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shape.GroupObject;
import shape.Port;
import shape.Shape;
import mode.Mode;

public class Canvas extends JPanel{
	private static Canvas instance = null;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<Shape> selectShapes = new ArrayList<Shape>();
	private Mode currMode = null;
	private EventListener listener = null;
	
	public Canvas() {
		setBounds(0,20,630,650);
	}
	public static Canvas getInstance() {
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}
	public void addShape(Shape s) {
		shapes.add(s);
	}
	public ArrayList<Shape> getAllShapes() {
		return shapes;
	}
	public void addSelectShapes(Shape s) {
		selectShapes.add(s);
	}
	public void resetSelectShapes() {
		selectShapes= new ArrayList<Shape>();
	}
	public ArrayList<Shape> getSelectShapes(){
		return selectShapes;
	}

	public void setCurrMode(Mode m) {
		removeMouseListener((MouseListener) listener);
		removeMouseMotionListener((MouseMotionListener) listener);
		currMode = m;
		listener = currMode;
		addMouseListener((MouseListener) listener);
		addMouseMotionListener((MouseMotionListener) listener);
	}
	public void groupShape() {
		if(selectShapes.size() < 2) {
			return;
		}
		GroupObject groupObj = new GroupObject(selectShapes);
		for(Shape shape:selectShapes) {
			shapes.remove(shape);
		}
		shapes.add(groupObj);
		
	}
	public void unGroupShape() {
		if(selectShapes.size()!=1) {return;}
		
		ArrayList<Shape> groupItems = selectShapes.get(0).getGroupItem();
		if(groupItems == null) {return;}
		
		shapes.remove(selectShapes.get(0));
		for(Shape shape:groupItems) {
			shapes.add(shape);
		}
		resetSelectShapes();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape shape:shapes) {
			if(shape == null) {break;}		
			shape.draw(g);

		}
	}
}
