package com.plan;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Bullets {
	//定义子弹变量
	Image bImage;
	//定义子弹图片
	int bx ,by;
	
	//构造函数
	public Bullets(Image bImage,int bx,int by){
		this.bImage = bImage;
		this.bx = bx;
		this.by = by;
	}
	//画出子弹
	public void drawBullet(Graphics g){
		g.drawImage(this.bImage, this.bx, this.by, null);
	}
	//子弹的移动
	public int moveBullet(){
		this.by --;
		int i = 0;
		if(this.by <= -bImage.getHeight(null)){
			i = 1;
		}
		return i;
	}
	
}
