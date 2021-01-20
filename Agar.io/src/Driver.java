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
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Driver extends JPanel implements KeyListener, MouseListener, ActionListener, MouseMotionListener{
	
	//create Arraylist for enemies
	ArrayList<Enemy> enemy = new ArrayList<Enemy>();
	
	//arraylist for food
	ArrayList<Food> food = new ArrayList<Food>();
	
	//instance of camera
	private Camera camera;
	
	Timer t;
	
	Rectangle world = new Rectangle(-500,-500,2000,2000);
	Cell player = new Cell(370,260,20);
	
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
		
		player.paint(g);
		
	
		//collision
		/*for(int i=0; i<enemy.size(); i++) {
			
			Enemy en = enemy.get(i);
			Rectangle enArea = new Rectangle(en.getx(), en.gety(), en.getRad()*2, en.getRad()*2);
			
			if(en.collide())
			for(int j=0; j<enemy.size(); j++) {
				Enemy en2 = enemy.get(j);
				Rectangle en2Area = new Rectangle(en2.getx(), en2.gety(), en2.getRad()*2, en2.getRad()*2);
				if(enArea.intersects(en2Area)) {
					en.get(j).setRad(0);
				}
			}
			
		}
		
		
		for(Enemy e: enemy) {
			for(int i=0; i<enemy.size(); i++) {
				if(e.collide(enemy.get(i), enemy.get(i+1))) {
					if(enemy.get(i).getRad() < enemy.get(i+1).getRad()) {
						enemy.remove(i);
					} else {
						enemy.remove(i+1);
					}
				}
			}
		}*/
		
		
		//food collision
			
		for(int i=0; i<enemy.size(); i++) {
			
			Enemy en = enemy.get(i);
			Rectangle enArea = new Rectangle(en.getx(), en.gety(), en.getRad()*2, en.getRad()*2);
			
			for(int j=0; j<food.size(); j++) {
				Food fo = food.get(j);
				Rectangle foArea = new Rectangle(fo.getX(), fo.getY(), fo.getRad()*2, fo.getRad()*2);
				if(enArea.intersects(foArea)) {
					food.get(j).setRad(0);
				}
			}
			
		}
			
	
		
		//call each enemy to paint themselves
		for(Enemy e: enemy) {
			e.paint(g);
		}
		
		//call each food to paint themselves
		for(Food f: food) {
			f.paint(g);
		}
		
		
				
		/*
		if(mouseMoved) {
		player.setX(mx);
		player.setY(my);
		player.paint(g);
		}
		*/
	}
	
	
	public Driver() {		
		
		//add enemies
		for(int i=0; i<20; i++) {
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
	
		t = new Timer(17, this);
		t.start();
		camera = new Camera(0, 0);
	
	}
	
	public static void main(String[] arg){
		Driver d = new Driver();
	}
	
	 public void checkForCollision(){
	      
	      
	      //for (int i = 0; i < enemy.size(); i++){
	         //if the distance b/w player and enemy is less than the combined radius
	         //then they are colliding - eat,  remove, and create new enemy

	}
	
	 
	 
	 
	 
	 @Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
		 	mx = e.getX();
			my = e.getY();
		 
			
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
