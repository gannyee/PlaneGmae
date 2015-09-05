package com.plan;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

//构造函数
public class Elan {
	//敌机图片变量
	Image eImage;
	//敌机坐标
	int ex, ey;
	//敌机速度
	int speed;

	// 含参构造函数
	public Elan(Image eImage, int ex, int ey, int speed) {
		super();
		this.eImage = eImage;
		this.ex = ex;
		this.ey = ey;
		this.speed = speed;
	}

	// 画出敌机
	public void drawElan(Graphics g) {
		g.drawImage(this.eImage, this.ex, this.ey, null);
	}

	// 敌机移动
	public int moveElan() {
		ey += speed - 1;
		setEy(ey);
		int i = 0;
		if (ey >= 600) {
			i = 1;
		}
		return i;
	}

	public Image geteImage() {
		return eImage;
	}

	public void seteImage(Image eImage) {
		this.eImage = eImage;
	}

	public int getEx() {
		return ex;
	}

	public void setEx(int ex) {
		this.ex = ex;
	}

	public int getEy() {
		return ey;
	}

	public void setEy(int ey) {
		this.ey = ey;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	

}
