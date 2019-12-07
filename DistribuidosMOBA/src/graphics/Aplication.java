package graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Aplication extends Canvas{

	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 800;
	private static final int HEIGTH = 800;
	
	private static final String NAME = "M.O.B.A. UR-Distribuidos";
	
	private static JFrame window;

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
}
