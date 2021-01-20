import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	private int x, y;
	private int vx, vy;
	private int rad;
	private int mass;
	private Color color;
	private boolean isAlive;
	
	//constructor
	public Cell(int x, int y, int rad) {
		this.x = x;
		this.y = y;
		this.rad =rad;
	}
	
	public void paint(Graphics g) {
		update();
		g.setColor(color);
		g.fillOval(x, y, rad*2, rad*2);
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
}
