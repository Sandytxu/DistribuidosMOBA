package graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import controls.Keyboard;
import map.Screen;

public class Aplication extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 800;
	private static final int HEIGTH = 800;
	
	public static volatile boolean working = false;
	
	private static int ups = 0;
	private static int fps = 0;
	
	private static final String NAME = "M.O.B.A. UR-Distribuidos";
	
	private static JFrame window;
	private static Thread thread;
	
	private static Keyboard keyboard;
	
	private static int x = 0;
	private static int y = 0;
	
	private static Screen screen;
	
	
	private static BufferedImage image = new BufferedImage(WIDTH,HEIGTH,BufferedImage.TYPE_INT_RGB);
	private static int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Aplication() {
		setPreferredSize(new Dimension(WIDTH,HEIGTH));
		
		screen = new Screen(WIDTH,HEIGTH);
		
		keyboard = new Keyboard();
		addKeyListener(keyboard);
		
		window = new JFrame(NAME);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLayout(new BorderLayout());
		window.add(this,BorderLayout.CENTER);
		window.pack();
		window.setLocationRelativeTo(null); //Center to the desktop.
		window.setVisible(true);
	}

	@Override
	public void run() {
		final int NS_FOR_SEC = 1000000000; //Conversion Nano to Sec
		final byte UPS_OBJECTIVE = 60; //FPS
		final double NS_IN_UPDATE = NS_FOR_SEC/UPS_OBJECTIVE;
		
		long updateReference = System.nanoTime();
		long counterReference = System.nanoTime();
		
		double timePassed;
		double delta = 0;
		
		requestFocus();//Focus the window to use the keyboard;
		
		while(working) {
			final long startLoop = System.nanoTime();
			
			timePassed = startLoop - updateReference;
			updateReference = startLoop;
			
			delta += timePassed / NS_IN_UPDATE;
			
			while(delta>=1) {
				update();
				delta--;
			}
			
			draw();
			
			if(System.nanoTime()-counterReference > NS_FOR_SEC) {
				window.setTitle(NAME + " || UPS: " + ups + " || FPS: " + fps );
				ups = 0;
				fps = 0;
				counterReference = System.nanoTime();
			}
		}
	}
	
	public synchronized void ini_thread() {
		working = true;
		thread = new Thread(this,"Graphics");
		thread.start();
	}
	
	public synchronized void stop_thread() {
		working = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void update() {//Update the Players stats
		keyboard.update();
		if(keyboard.up) {
			System.out.println("UP");
		}
		if(keyboard.down) {
			System.out.println("DOWN");
		}
		if(keyboard.left) {
			System.out.println("LEFT");
		}
		if(keyboard.rigth) {
			System.out.println("RIGTH");
		}
		
		ups++;
	}
	
	private void draw() {//Draw the map
		BufferStrategy strategy = getBufferStrategy();
		
		if(strategy==null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clean();
		screen.draw(0, 0);
		
		System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
		
		Graphics g = strategy.getDrawGraphics();
		g.drawImage(image,0,0,getWidth(),getHeight(),null);
		g.dispose();
		
		strategy.show();
		
		fps++;
	}
}
