package com.kahl.animation;

import java.awt.BufferedImage;

public class Spritesheet {

	//Instance Variables
	String path;
	int frameWidth;
	int frameHeight;
	int framesPerRow;

	//Constructors
	public Spritesheet() {
		//have default sheet here to make sure I never have a null object
	}

	public Spritesheet(String aPath,int width,int height,int fpr) {

		path = aPath;
		frameWidth = width;
		frameHeight = height;
		framesPerRow = fpr;

	}

	public BufferedImage[] getAllSubimages() {
		// use frameWidth,frameHeight,framesPerRow to calculate and
		BufferedImage[] images = new BufferedImage[](); 
	}



}