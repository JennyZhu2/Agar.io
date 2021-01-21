import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Driver extends JPanel implements KeyListener, MouseListener, ActionListener, MouseMotionListener{
	
	//create Arraylist for enemies
	ArrayList<Enemy> enemy = new ArrayList<Enemy>();
	
	//create player
	Cell player = new Cell(370,260,25);
	
	//arraylist for food
	ArrayList<Food> food = new ArrayList<Food>();
	
	//instance of camera
	private Camera camera;
	
	Timer t;
	
	Rectangle world = new Rectangle(-500,-500,2000,2000);
	
	
	
	//game over
	boolean lose = false;
	
	
	//mouse location
	int mx;
	int my;
	boolean mouseMoved;
	
	
	
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		//Graphics2D g2d = (Graphics2D) g;
		
	//	g2d.translate(-camera.getX(), -camera.getY());
		
		
	//	g2d.translate(camera.getX(), camera.getY());
		
		g.fillRect(30, 30, 50, 50);
		
		//paint objects
		
		player.paint(g);

		for(Enemy e: enemy) {
			e.paint(g);
		}
		
		for(Food f: food) {
			f.paint(g);
		}
		
		
			
		
	//PLAYER GAME MECHANICS	
		//player movement
		if(mouseMoved) {
			player.setX(mx);
			player.setY(my);
				
		}
		repaint();
				
				
		//player collision
		
		for(int i=0; i<enemy.size(); i++) {
			int rad1 = (int)player.getRad();
			int x1 = player.getX() + rad1;
			int y1 = player.getY() + rad1;
			int rad2 = (int)enemy.get(i).getRad();
			int x2 = enemy.get(i).getx() + rad2;
			int y2 = enemy.get(i).gety() + rad2;
			
			double dist = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
			
			if(dist <= rad1+rad2/3 && rad1>rad2){
				enemy.get(i).setRad(0);
				
				//player increase mass
				player.setRad(rad1 + rad2/4);
			}
			if(dist <= rad1+rad2/3 && rad2>rad1){
				player.setRad(0);
				
				//enemy increase mass
				enemy.get(i).setRad(rad2 + rad1/4);
				
				lose = true;
			}
			
			if(lose) {
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setFont(new Font("VERDANA", Font.BOLD, 100));
				g2.drawString("GAME OVER", 450, 360);
			}
			
		}
			
				
	//ENEMY GAME MECHANICS	
		//velocity as enemy grows
		for(int i=0; i<enemy.size(); i++) {
			double velX = enemy.get(i).getvx() - (1/10)*enemy.get(i).getRad();
			enemy.get(i).setVx(velX);
			double velY = enemy.get(i).getvy() - (1/20)*enemy.get(i).getRad();
			enemy.get(i).setVy(velY);
		}
				
				
		//enemy collision
		for(int i=0; i<enemy.size(); i++) {
			
			Enemy en = enemy.get(i);
			int d1 = (int)en.getRad()*2;
			Rectangle enArea = new Rectangle((int)en.getx(), (int)en.gety(), d1, d1);
			
			for(int j=0; j<enemy.size(); j++) {
				Enemy en2 = enemy.get(j);
				int d2 = (int)en2.getRad()*2;
				Rectangle en2Area = new Rectangle((int)en2.getx(), (int)en2.gety(), d2 , d2);
				
				//delete smaller enemy and increase mass
				if(enArea.intersects(en2Area) && d1>d2) {
					enemy.get(j).setRad(0);
					int inc = d1/2 + d2*4/d1;
					enemy.get(i).setRad(inc);
				}
				if(enArea.intersects(en2Area) && d2>d1) {
					enemy.get(i).setRad(0);
					int inc = d2/2 + d1*4/d2;
					enemy.get(j).setRad(inc);
				}
			}
			
		}
		

		
		
		//food collision
			
		for(int i=0; i<enemy.size(); i++) {
			
			Enemy en = enemy.get(i);
			Rectangle enArea = new Rectangle((int)en.getx(), (int)en.gety(), (int)en.getRad()*2, (int)en.getRad()*2);
			
			for(int j=0; j<food.size(); j++) {
				Food fo = food.get(j);
				Rectangle foArea = new Rectangle(fo.getX(), fo.getY(), fo.getRad()*2, fo.getRad()*2);
				if(enArea.intersects(foArea)) {
					//delete food
					food.get(j).setRad(0);
					//spawn in food
					int random = (int)(Math.random()*10);
					if(random<6) {
						food.add(new Food());
					}
					//increase mass
					double rad = enemy.get(i).getRad();
					double increase = 15/rad;
					enemy.get(i).setRad(increase+rad);
					
				}
			}
			
		}
			
		
		
	}
	
	
	public Driver() {		
		
		//add enemies
		for(int i=0; i<30; i++) {
			enemy.add(new Enemy());
		}
		
		//add food
		for(int i=0; i<700; i++) {
			food.add(new Food());
		}
		
		Timer t = new Timer(16, this);//choose swing library
		t.start();
		
		JFrame frame = new JFrame("Agar.io");
		frame.setSize(800,600);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.addKeyListener(this);
		frame.addMouseListener(this);
		frame.addMouseMotionListener(this);
	
		t = new Timer(17, this);
		t.start();
		camera = new Camera(0, 0);
	
	}
	
	public static void main(String[] arg){
		Driver d = new Driver();
	}
	
	
	 
	 
	 
	 
	 @Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
		 	
		 
		 	mx = e.getX()-35;
			my = e.getY()-35;
		 
			
			mouseMoved =true;
		 	e.consume();
		}

	 
	 
	 @Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
