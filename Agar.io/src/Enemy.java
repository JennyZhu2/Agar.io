import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
	private int x, y;
	private int vx, vy;
	private double rad;
	private int mass;
	private Color color;
	Rectangle world = new Rectangle(-500,-500,2000,2000);
	
	public Enemy() {
		//have enemy move randomly by setting vx, vy to some random 
		//NON-zero value between -3 and 3
		
		while(vx==0) {
			vx = (int)(Math.random()*(3+3)-3);
		}
		while(vy==0) {
			vy = (int)(Math.random()*(3+3)-3);
		}
	
		//spawn the enemy randomly anywhere on the 800x600 screen
		x = (int)(Math.random()*2000)-500;
		y = (int)(Math.random()*2000)-500;
		
		//generate a random color by generating random r, g, b values
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		
		color = new Color(red, green, blue);
		//randomize radius
		rad = (int)(Math.random()*15)+10;
	}
	
	public void paint(Graphics g) {
		
		g.setColor(color);
		g.fillOval(x, y, (int)rad*2, (int)rad*2);
		update();
		
		//have the enemy object bounce off of the rectangle borders using the helper methods (getters) for 
		//minx and max x etc
	
		if(x >= world.getMaxX() || x<=world.getMinX()) {
			vx*=-1;
		}
		if(y >= world.getMaxY() || y<=world.getMinY()) {
			vy*=-1;
		}
	}
	
	//anything that updates the variables of this object
	public void update() {
		x+=vx;
		y+=vy;
	}
	
	//collision code
	public boolean collide(Enemy en1, Enemy en2) {
		
		int dist = (int)en2.rad + (int)en1.rad/3;
		if(Math.abs(en1.x - en2.x) <=dist || Math.abs(en1.y - en2.y) <=dist) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	public int getx() {
		return x;
	}
	
	public void setx(int x) {
		this.x = x;
	}
	
	public int gety() {
		return y;
	}
	
	public void sety(int y) {
		this.y = y;
	}
	
	
	public int getvx() {
		return vx;
	}
	
	public void setVx(int vx) {
		this.vx = vx;
	}
	
	public int getvy() {
		return vy;
	}
	
	public void setVy(int vy) {
		this.vy = vy;
	}
	
	public double getRad() {
		return rad;
	}
	
	public void setRad(double increase) {
		this.rad = increase;
	}

	

	
	
	
	
}
