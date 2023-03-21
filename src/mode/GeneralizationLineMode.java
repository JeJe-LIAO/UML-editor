package mode;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import shape.GeneralizationLine;
import shape.LineObject;
import shape.Port;
import shape.Shape;

public class GeneralizationLineMode extends Mode{
	private Port startPort=null;
	private Port endPort=null;
	private ArrayList<Shape> shapes;
	private Shape pressShape = null;
	
	public void mousePressed(MouseEvent e) {
		shapes = canvas.getAllShapes();
		for(Shape shape:shapes) {
			if(shape.checkInsideShape(e.getPoint())) {
				startPort = shape.getConnectPort(e.getPoint());
				pressShape = shape;
				break;
			}
		}
	}
	public void mouseReleased(MouseEvent e) {
		if (startPort != null) {
			for(Shape shape:shapes) {
				if(shape == pressShape) {continue;}
				if(shape.checkInsideShape(e.getPoint())) {
					endPort = shape.getConnectPort(e.getPoint());
					break;
				}
			}

			if (endPort != null) {
				
				LineObject line = new GeneralizationLine(startPort, endPort);
				canvas.addShape(line);
			}
	
			canvas.repaint();
			startPort = null;
			endPort = null;
		}
	}	
}
