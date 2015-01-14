package com.kahl.animation;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements Runnable {

	//Instance Variables
	private Spritesheet sheet;
	private int currentFrame;
	private Thread animationThread;
	private BufferedImage[] frames;
	private BufferedImage image;

	public AnimationPanel() {
		super();
		setPreferredSize(new Dimension(128,128));
		setFocusable(true);
		requestFocus();
		try {
			sheet = new Spritesheet("",0,0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		animationThread = new Thread(this);
		animationThread.start();

	}

	public void run() {
		frames = sheet.getAllSprites();
		currentFrame = 0;
		Timer timer = new Timer(100,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				image = frames[currentFrame % sheet.getFrameCount()];
				repaint();
				currentFrame++;
			}
		});
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image,0,0,this);
	}

}