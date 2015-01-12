package com.kahl.animation;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Animator extends JFrame implements Runnable{

	//Instance Variables
	Spritesheet sheet;

	//Constructor
	public Animator(Spritesheet spritesheet) {
		
		sheet = spritesheet;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(128,128));
		this.pack();
		this.setVisible(true);

	}

	//Methods
	public void run() {
		while (true) {
			BufferedImage[] images = sheet.getAllSubimages();
		}
	}

	public static void main (String[] args) {
		try {
			Spritesheet mySheet = new SpriteSheet("path/here/spritesheet.png",frameheight,frameWidth,framesPerRow); //Need to use args here to specify spritesheet path
			Animator animator = new Animator(mySheet);
			Thread animationThread = new Thread(animator);
			animationThread.start();	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}