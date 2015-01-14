package com.kahl.animation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Animator {

	public static void main (String[] args) {

		JFrame window = new JFrame("Animator");
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new AnimationPanel());
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}

}