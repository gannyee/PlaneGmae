package com.plan;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

public class Elan {
	Image eImage;
	int ex,ey;
	int speed;
	
	//含参构造函数
	public Elan(Image eImage, int ex, int ey, int speed) {
		super();
		this.eImage = eImage;
		this.ex = ex;
		this.ey = ey;
		this.speed = speed;
	}
	
	//画出敌机
	public void drawElan(Graphics g){
		g.drawImage(this.eImage, this.ex, this.ey, null);
	}
	
	//敌机移动
	public int moveElan(){
		ey += speed - 1;
		int i = 0;
		if(ey >= 600){
			i = 1;
		}
		return i;
	}
	
}
