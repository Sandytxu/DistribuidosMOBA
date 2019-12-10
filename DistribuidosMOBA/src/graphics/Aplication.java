package graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Aplication extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 800;
	private static final int HEIGTH = 800;
	
	public static volatile boolean working = false;
	
	private static final String NAME = "M.O.B.A. UR-Distribuidos";
	
	private static JFrame window;
	private static Thread thread;
	
	
	public Aplication() {
		setPreferredSize(new Dimension(WIDTH,HEIGTH));
		
		window = new JFrame(NAME);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLayout(new BorderLayout());
		window.add(this,BorderLayout.CENTER);
		window.pack();
		window.setLocationRelativeTo(null); //Centrado en el escritorio.
		window.setVisible(true);
	}

	@Override
	public void run() {
		while(working) {
			
		}
	}
	
	public synchronized void ini_thread() {
		working = true;
		thread = new Thread(this,"Graphics");
		thread.start();
	}
	
	public synchronized void stop_thread() {
		working = false;
	}
}
