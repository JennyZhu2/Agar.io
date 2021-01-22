import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Food {

	private int rad;
	private int x, y;
	private int vx, vy;
	private Color color;
	public static ArrayList<Food> food;
	
	
	public Food() {
		//spawn the food randomly anywhere on the 800x600 screen
			x = (int)(Math.random()*2000)-500;
			y = (int)(Math.random()*2000)-500;
				
		//generate a random color by generating random r, g, b values
			int red = (int)(Math.random()*256);
			int green = (int)(Math.random()*256);
			int blue = (int)(Math.random()*256);
				
			color = new Color(red, green, blue);
		//randomize radius
			rad = (int)(Math.random()*2+1)+5;
	}
	
	public void update() {
	
		/*if(Driver.mouseMoved) {
			x = Driver.mx -x;
			y = Driver.my - y;
		}*/
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getRad() {
		return rad;
	}
	
	public void setRad(int rad) {
		this.rad = rad;
	}
	

	public static void spawn() {
		
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		update();
		g.setColor(color);
		g.fillOval(x, y, rad*2, rad*2);
		
	}
}

