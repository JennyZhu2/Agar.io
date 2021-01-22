import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	private int x, y;
	private int vx, vy;
	private double rad;
	private int mass;
	private Color color;
	private boolean isAlive;
	Cell player;
	
	//constructor
	public Cell(int x, int y, double rad) {
		this.x = x;
		this.y = y;
		this.rad =rad;
		
		//generate a random color by generating random r, g, b values
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
				
		color = new Color(red, green, blue);
				
	}
	
	public void paint(Graphics g) {
		update();
		g.setColor(color);
		g.fillOval(x, y, (int)rad*2, (int)rad*2);
	}
	
	//anything that updates the variable of the object
	public void update() {
		x += vx;
		y += vy;
		
		
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
	
	public int getVx() {
		return vx;
	}
	
	public void setVx(int vx) {
		this.vx = vx;
	}
	
	public int getVy() {
		return vy;
	}
	
	public void setVy(int vy) {
		this.vy = vy;
	}
	
	public double getRad() {
		return rad;
	}
	
	public void setRad(double rad) {
		this.rad = rad;
	}
	
	public boolean getIsAlive() {
		return isAlive;
	}
	
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
