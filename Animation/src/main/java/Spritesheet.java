package com.kahl.animation;

import java.awt.image.BufferedImage;
import java.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Spritesheet {

	//Instance Variables
	private String path;
	private int frameWidth;
	private int frameHeight;
	private BufferedImage sheet = null;
	private BufferedImage[] frames;

	//Constructors
	public Spritesheet(String aPath,int width,int height) {

		path = aPath;
		frameWidth = width;
		frameHeight = height;

		try {
			sheet = ImageIO.read(getClass().getResourceAsStream(path));
			frames = sheet.getAllSprites();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//Methods
	public BufferedImage getSprite(int frame) {
		return frames[frame];
	}

	public int getHeight() {
		return frameHeigth;
	}

	public int getWidth() {
		return frameWidth;
	}

	public int getColumnCount() {
		return sheet.getWidth() / getWidth();
	}

	public int getRowCount() {
		return sheet.getHeight() / getHeight();
	}

	public int getFrameCount() {
		int cols = getColumnCount();
		int rows = getRowCount();
		return cols * rows;
	}

	private BufferedImage getSprite(int x, int y, int h, int w) {
		BufferedImage sprite = sheet.getSubimage(x,y,h,w);
		return sprite;
	}

	public BufferedImage[] getAllSprites() {
		int frameCount = getFrameCount();
		BufferedImage[] sprites = new BufferedImage[frames];
		int index = 0;
		for (int row = 0; row < getRowCount(); row++) {
			for (int col = 0; col < getColumnCount(); col++) {
				currentSprite = sheet.getSprite(col * getWidth(),row * getHeight(),getHeight(),getWidth());
				sprites[index] = currentSprite;
				index++;
			}
		}
		return sprites;
	}

}