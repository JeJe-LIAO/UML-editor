package mode;

import java.awt.event.MouseEvent;

import shape.RectObject;
import shape.UsecaseObj;

public class UsecaseMode extends Mode{
	public void mousePressed(MouseEvent e) {
		RectObject rectObj = new UsecaseObj(e.getPoint());
		canvas.addShape(rectObj);
		canvas.repaint();
	}
}
