package controls;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	
	private final static int numKeys = 120;
	
	private final boolean[] keys = new boolean[numKeys];
	
	public boolean up;
	public boolean down;
	public boolean rigth;
	public boolean left;
	
	public void update() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		rigth = keys[KeyEvent.VK_D];
		left = keys[KeyEvent.VK_A];
	}
	
	public void keyPressed(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = false;
	}
	
	public void keyTyped (KeyEvent arg0) {
		
	}
}
