
public class Camera {

	private int x, y;
	
	public Camera(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick(Cell object) {
		
		x += ((object.getX() - x) -1000/2)*0.05f;
		y += ((object.getY() - y) -1000/2)*0.05f;
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
	
}
