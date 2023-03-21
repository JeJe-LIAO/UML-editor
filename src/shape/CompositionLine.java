package shape;

import java.awt.Graphics;

public class CompositionLine extends LineObject{

	public CompositionLine(Port s, Port e) {
		super(s, e);
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g) {
		float x1=startPort.getPosition().x;
		float y1=startPort.getPosition().y;
		float x2=endPort.getPosition().x;
		float y2=endPort.getPosition().y;
		float C1=(-(x2-x1)*-y1)+((y2-y1)*-x1);
		float X1=y2-y1;
        float Y1=-(x2-x1);
        float C2;
        float crossX = 0;
    	float crossY = 0;
    	float midX = 0;
    	float midY = 0;
    	
    	float trix1=0;
    	float triy1=0;
    	float trix2=0;
    	float triy2=0;
    	   	
    	if(Math.max((x1-x2)*(x1-x2), (y1-y2)*(y1-y2)) == (x1-x2)*(x1-x2) ) {
    		// X變量大
    		if(x2>=x1) {
    			midX=x2-10;
    			crossX=x2-20;
    		}
    		else {
    			midX=x2+10;
    			crossX=x2+20;
    		}
    		crossY=(-1*X1*crossX-C1)/Y1;

    		midY=(-1*X1*midX-C1)/Y1;
    		C2=(Y1*midX+(-1*X1)*midY)*-1;
    		
    		triy1 = midY+10;
    		triy2 = midY-10;
    		trix1=(-1*(-X1)*triy1-C2)/Y1;
    		trix2=(-1*(-X1)*triy2-C2)/Y1;
    	}
    	else{
    		// Y變量大
    		if(y2>=y1) {
    			midY=y2-10;
    			crossY=y2-20;
    		}
    		else {
    			midY=y2+10;
    			crossY=y2+20;
    		}
    		crossX=(-1*Y1*crossY-C1)/X1;
    		
    		midX=(-1*Y1*midY-C1)/X1;
    		C2=(Y1*midX+(-1*X1)*midY)*-1;
    		
    		trix1=midX+10;
    		trix2=midX-10;
    		triy1=(-1*Y1*trix1-C2)/(-1*X1);
    		triy2=(-1*Y1*trix2-C2)/(-1*X1);	
    	}
    	//垂直線：Y1*x + (-X1)*y + C2 = 0
    	
    	g.drawLine((int)x1, (int)y1, (int)crossX, (int)crossY); 
    	//draw diamond
		g.drawLine((int)trix1, (int)triy1, (int)x2, (int)y2); 
    	g.drawLine((int)trix2, (int)triy2, (int)x2, (int)y2); 
    	g.drawLine((int)trix1, (int)triy1, (int)crossX, (int)crossY); 
    	g.drawLine((int)trix2, (int)triy2, (int)crossX, (int)crossY);
	}
}
