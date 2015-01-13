package com.kahl.animation;

import java.awt.BufferedImage;

public class Spritesheet {

	//Instance Variables
	private String path;
	private int frameWidth;
	private int frameHeight;
	private int framesPerRow;
	private int frames;
	private BufferedImage sheet = null;

	//Constructors
	public Spritesheet() {
		//have default sheet here to make sure I never have a null object
	}

	public Spritesheet(String aPath,int width,int height,int fpr, int numOfFrames) {

		path = aPath;
		frameWidth = width;
		frameHeight = height;
		framesPerRow = fpr;
		frames = numOfFrames;

		try {
			sheet = ImageIO.read(new File(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getHeight() {
		return frameWidth;
	}

	public int getWidth() {
		return frameWidth;
	}

	public int getFramesPerRow() {
		return framesPerRow;
	}

	private BufferedImage getSprite(int x, int y, int h, int w) {
		BufferedImage sprite = sheet.getSubimage(x,y,h,w);
	}

	public BufferedImage[] getAllSubimages(int h,int w,int f) {
		BufferedImage[] images = new BufferedImage[frames];
		currentImage = sheet.getSprite(x,y,h,w);
		images.add(currentImage);
		return images;
		
	}



}