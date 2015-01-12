package com.kahl.animation;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Animator extends JFrame implements Runnable{

	//Instance Variables
	Spritesheet ssheet;
	Thread animationThread;

	//Constructor
	public Animator(Spritesheet spritesheet) {
		
		ssheet = spritesheet;
		animationThread = new Thread();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(128,128));
		this.pack();
		this.setVisible(true);

	}

	//Methods
	public void run() {
		
	}

	public static void main (String[] args) {
		Spritesheet sheet = new SpriteSheet();
		Animator animator = new Animator(sheet);
		animator.run();

	}

}