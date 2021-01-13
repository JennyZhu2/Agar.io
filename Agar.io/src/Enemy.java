import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
	private int x, y;
	private int vx, vy;
	private int rad;
	private int mass;
	private Color color;
	Rectangle world = new Rectangle(-500,-500,2000,2000);
	
	public Enemy() {
		//have enemy move randomly by setting vx, vy to some random 
		//NON-zero value between -3 and 3
		vx = (int)(Math.random()*(3+6)-3);
		vy = (int)(Math.random()*(3+6)-3);
		while(vx==0) {
			vx = (int)(Math.random()*(3+6)-3);
		}
		while(vy==0) {
			vy = (int)(Math.random()*(3+6)-3);
		}
		
		//spawn the enemy randomly anywhere on the 800x600 screen
		x = (int)(Math.random()*800);
		y = (int)(Math.random()*600);
		
		//generate a random color by generating random r, g, b values
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		
		color = new Color(red, green, blue);
		//randomize radius
		rad = (int)(Math.random()*50)-10;
	}
	
	public void paint(Graphics g) {
		update();
		g.setColor(color);
		g.fillOval(x, y, rad, rad);
		
		//have the enemy object bounce off of the rectangle borders using the helper methods (getters) for 
		//minx and max x etc
		x+=vx;
		y+=vy;
		if(x >= world.getMaxX() || x<=world.getMinX()) {
			vx*=-1;
		}
		if(x >= world.getMaxY() || x<=world.getMinY()) {
			vx*=-1;
		}
	}
	
	//anything that updates the variables of this object
	public void update() {
		x+=vx;
		y+=vy;
	}
	
	//collision code
	public boolean collide(Enemy en1, Enemy en2) {
		int dist = en2.rad + en1.rad/3;
		
	}
}
