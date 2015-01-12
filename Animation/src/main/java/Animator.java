package com.kahl.animation;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Animator extends JFrame implements Runnable{

	//Instance Variables
	Spritesheet ssheet;

	//Constructor
	public Animator(Spritesheet spritesheet) {
		
		ssheet = spritesheet;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(128,128));
		this.pack();
		this.setVisible(true);

	}

	//Methods
	public void run() {
		while (true) {
			// loop the images and display to screen
		}
	}

	public static void main (String[] args) {
		try {
			Spritesheet sheet = new SpriteSheet(); //Need to use args here to specify spritesheet path
			Animator animator = new Animator(sheet);
			Thread animationThread = new Thread(animator);
			animattionThread.start();	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}