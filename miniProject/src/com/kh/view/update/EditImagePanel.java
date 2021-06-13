package com.kh.view.update;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EditImagePanel extends JPanel {

	String imagePath;
	Dimension dimension;
	
	public EditImagePanel(String imagePath , Dimension dimension ) {
		this.imagePath = imagePath;
		this.dimension = dimension;
		
		setSize(dimension);
		setLayout(null);

	
}
	
	public void paintComponent(Graphics g) {
		//이미지를 패널을 열었을때 자동으로 들어가게 만듬
		ImageIcon image = new ImageIcon(imagePath);
		g.drawImage(image.getImage(), 0 ,0 , dimension.width , dimension.height, null);
		
		
	}
	
}
