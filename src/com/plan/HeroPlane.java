package com.plan;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;

public class HeroPlane{
	//定义飞机pImage
	Image pImage,exImage,exImage1;
	// 声明飞机坐标
	private int px = 200, py = 500;
	public HeroPlane() {
		super();
		this.pImage = new ImageIcon("images/hero.GIF").getImage();
		this.exImage = new ImageIcon("images/db1.gif").getImage();
		this.exImage1 = new ImageIcon("images/db2.gif").getImage();
		this.px = 200;
		this.py = 500;
	}
	
	public void drawPlane(Graphics g){
		g.drawImage(pImage, this.px,this.py, null);
	}

	public void explored(Graphics g){
		g.drawImage(exImage, this.px,this.py, null);
		
		//g.drawImage(exImage1, this.px,this.py, null);
	}
	public int getPx() {
		return px;
	}

	public void setPx(int px) {
		this.px = px;
	}

	public int getPy() {
		return py;
	}

	public void setPy(int py) {
		this.py = py;
	}

	public Image getpImage() {
		return pImage;
	}

	public void setpImage(Image pImage) {
		this.pImage = pImage;
	}
	
	
}
