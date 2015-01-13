package com.kahl.animation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Animator extends JFrame implements Runnable{

	//Instance Variables
	private Spritesheet sheet;
	private int currentFrame;
	private JPanel animationPane;
	private BufferedImage image;

	//Constructor
	public Animator(Spritesheet spritesheet) {

		animationPanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image,0,0,null);
			}
		};		
		sheet = spritesheet;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(128,128));
		setResizable(false);
		add(animationPane);
		pack();
		setVisible(true);

	}

	//Methods
	public void run() {
		while (true) {
			BufferedImage[] images = sheet.getAllSubimages();
			for (int i = 0; i < images.length; i++) {
				image = images[i];
				animationPane.paintComponent();
			}
		}
	}

	public static void main (String[] args) {
		try {
			Spritesheet mySheet = new SpriteSheet(args[0],(int) args[1],(int) args[2],(int) args[3],(int) args[4]);
			Animator animator = new Animator(mySheet);
			Thread animationThread = new Thread(animator);
			animationThread.start();	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}