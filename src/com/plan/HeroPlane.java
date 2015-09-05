package com.plan;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class HeroPlane{
	//定义飞机pImage
	Image pImage,exImage,exImage1;
	// 声明飞机坐标
	private int px = 200, py = 500;
	
	//构造函数
	public HeroPlane() {
		super();
		this.pImage = new ImageIcon("images/hero.GIF").getImage();
		this.exImage = new ImageIcon("images/db1.gif").getImage();
		this.exImage1 = new ImageIcon("images/db2.gif").getImage();
		this.px = 200;
		this.py = 500;
	}
	
	//画出英雄机
	public void drawPlane(Graphics g){
		g.drawImage(pImage, this.px,this.py, null);
	}

	public void explored(Graphics g){
	/*	BufferedImage image;
		BufferedImage image1;
		BufferedImage images[] = new BufferedImage[2];
		
		try {
			image = ImageIO.read(new File("images/db1.gif"));
			images[0] = image.getSubimage(0, 0, 238, 238);
			image1 = ImageIO.read(new File("images/db2.gif"));
			images[1] = image1.getSubimage(0,0, 281, 274);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.drawImage(images[num], this.px / 2,this.py / 2, null);*/
		g.drawImage(exImage, this.px,this.py, null);
	}
	
	//获取飞机的横坐标
	public int getPx() {
		return px;
	}

	//设置飞机的横坐标
	public void setPx(int px) {
		this.px = px;
	}

	//获取飞机纵坐标
	public int getPy() {
		return py;
	}
	
	//设置飞机的纵坐标
	public void setPy(int py) {
		this.py = py;
	}
	
	//获取飞机的图片
	public Image getpImage() {
		return pImage;
	}
	
	//设置飞机的图片
	public void setpImage(Image pImage) {
		this.pImage = pImage;
	}
	
	
}
