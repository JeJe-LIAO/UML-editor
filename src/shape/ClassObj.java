package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class ClassObj extends RectObject{
	
	public ClassObj(Point p) {
		super(p, 80, 100);
		//0：left, 1：up, 2：right, 3：down
		int x = position.x;
		int y = position.y;
		//x,y+50, x+80,y+50, x+40,y, x+40,y+100
		port[0] = new Port(x,y+50);
		port[1] = new Port(x+80,y+50);
		port[2] = new Port(x+40,y);
		port[3] = new Port(x+40,y+100);
	}

	public void draw(Graphics g) {
		if(getSelect() == true) {
			for(int i=0; i<4; i++) {
				port[i].draw(g);
			}
		}
		g.drawRect(position.x, position.y, 80, 100);
		g.drawLine(position.x, position.y+100/3,position.x+80, position.y+100/3); 
		g.drawLine(position.x, position.y+100/3*2, position.x+80, position.y+100/3*2); 
		g.drawString(name, position.x, position.y+20);
	}
	public Port getConnectPort(Point p) {
		//x,y   x+80,y+100 -> line1   |  x+80,y   x,y+100 -> line2
		// C=(-(X2-X1)*-Y1)+((Y2-Y1)*-X1);
		// 座標修正
		
		int posX = p.x-position.x;
		int posY = -1*(p.y-position.y);
		
		float x1=0;
		float y1=0;
		float x2=80;
		float y2=-100;
		float C1=(-(x2-x1)*-y1)+((y2-y1)*-x1);
		float X1=y2-y1;
        float Y1=-(x2-x1);
        x1=80;
		y1=0;
		x2=0;
		y2=-100;
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
