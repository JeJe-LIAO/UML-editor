package shape;

import java.awt.Graphics;
import java.awt.Point;

public class LineObject extends Shape{
	protected Port startPort;
	protected Port endPort;
	
	public LineObject(Port s, Port e) {
		startPort = s;
		endPort = e;
	}
	public Boolean checkInsideBlock(Point _startPort, Point _endPort) {
		int startX = _startPort.x;
		int startY = _startPort.y;
		int endX = _endPort.y;
		int endY = _endPort.y;
		
		if(startX<startPort.getPosition().x && startY<startPort.getPosition().y && endX>endPort.getPosition().x && endY>endPort.getPosition().y && 
		   startX<endPort.getPosition().x && startY<endPort.getPosition().y && endX>startPort.getPosition().x && endY>startPort.getPosition().y)
			return true;
		
		return false;
	}
	public void draw(Graphics g) {}
}
