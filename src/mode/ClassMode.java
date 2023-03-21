package mode;

import java.awt.event.MouseEvent;

import shape.ClassObj;
import shape.RectObject;

public class ClassMode extends Mode{
	public void mousePressed(MouseEvent e) {
		RectObject rectObj = new ClassObj(e.getPoint());
		canvas.addShape(rectObj);
		canvas.repaint();
	}
}
