package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class UsecaseObj extends RectObject{

	public UsecaseObj(Point p) {
		super(p, 80, 50);
		int x = position.x;
		int y = position.y;
		//x,y+25, x+80,y+25, x+40,y, x+40,y+50
		port[0] = new Port(x,y+25);
		port[1] = new Port(x+80,y+25);
		port[2] = new Port(x+40,y);
		port[3] = new Port(x+40,y+50);
	}
	public void draw(Graphics g) {
		if(getSelect() == true) {
			for(int i=0; i<4; i++) {
				port[i].draw(g);
			}
		}
		g.drawOval(position.x, position.y, 80, 50);
		g.drawString(name, position.x+20, position.y+25);
	}
	public Port getConnectPort(Point p) {
		// C=(-(X2-X1)*-Y1)+((Y2-Y1)*-X1);
		// 座標修正
		int posX = p.x-position.x;
		int posY = -1*(p.y-position.y);
		
		float x1=0;
		float y1=0;
		float x2=80;
		float y2=-50;
		float C1=(-(x2-x1)*-y1)+((y2-y1)*-x1);
		float X1=y2-y1;
        float Y1=-(x2-x1);
        x1=80;
		y1=0;
		x2=0;
		y2=-50;
		float C2=(-(x2-x1)*-y1)+((y2-y1)*-x1);
		float X2=y2-y1;
        float Y2=-(x2-x1);
        
        // 在line1上方
        if(posX*X1+posY*Y1+C1 <= 0) {	
        	// 在line2上方
        	if(posX*X2+posY*Y2+C2 >= 0) {
        		//lp[2]
        		return port[2];
        	}
        	else {
        		//lp[1]
        		return port[1];
        	}
        }
        else {
        	if(posX*X2+posY*Y2+C2 >= 0) {
        		//lp[0]
        		return port[0];
        	}
        	else {
        		//lp[3]}
        		return port[3];
        	}
        		
        }
	}
	
}
