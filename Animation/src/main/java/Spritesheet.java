package com.kahl.animation;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Spritesheet {

	//Instance Variables
	private String path;
	private int frameWidth;
	private int frameHeight;
	private BufferedImage sheet = null;

	//Constructors
	public Spritesheet(String aPath,int width,int height) {

		path = aPath;
		frameWidth = width;
		frameHeight = height;

		try {
			sheet = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//Methods

	public int getHeight() {
		return frameHeight;
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

	public BufferedImage getSprite(int x, int y, int w, int h) {
		BufferedImage sprite = sheet.getSubimage(x,y,w,h);
		return sprite;
	}

	public BufferedImage[] getAllSprites() {
		int cols = getColumnCount();
		int rows = getRowCount();
		int frameCount = getFrameCount();
		BufferedImage[] sprites = new BufferedImage[frameCount];
		int index = 0;
		System.out.println("cols = " + cols);
        System.out.println("rows = " + rows);
        System.out.println("frameCount = " + frameCount);
		for (int row = 0; row < getRowCount(); row++) {
			for (int col = 0; col < getColumnCount(); col++) {
				int x = col * getWidth();
				int y = row * getHeight();
				System.out.println("x: " + x + ", y: " + y + ", width: " + getWidth() + ", height: " + getHeight());
				BufferedImage currentSprite = getSprite(col * getWidth(),row * getHeight(),getWidth(),getHeight());
				sprites[index] = currentSprite;
				index++;
			}
		}
		return sprites;
	}

}