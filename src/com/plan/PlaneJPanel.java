package com.plan;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PlaneJPanel extends JPanel implements MouseMotionListener,
		MouseListener {
	// 定义背景图片bgImagae, 定义飞机pImage,定义子弹bImage,定义敌机eImage
	Image bgImage, bImage;
	// 声明飞机坐标
	//int px = 200, py = 500;
	// 声明背景图片的坐标
	int bgx = 0, bgy = -5400;
	HeroPlane heroPlane = new HeroPlane();
	List<Bullets> bulletList = new ArrayList<Bullets>();
	List<Elan> enermyPlaneList = new ArrayList<Elan>();
	List<HeroPlane> planeList = new ArrayList<HeroPlane>();
	// 构造函数
	public PlaneJPanel() {
		// 获取背景，飞机,子弹图片
		bgImage = new ImageIcon("images/bk.jpg").getImage();
		//pImage = new ImageIcon("images/hero.GIF").getImage();
		bImage = new ImageIcon("images/bullet.png").getImage();
		planeList.add(heroPlane);
		addMouseMotionListener(this);

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		// 画出背景，飞机
		g.drawImage(bgImage, bgx, bgy, null);
		
		if(!planeList.isEmpty())
			planeList.get(0).drawPlane(g);
		else if(planeList.isEmpty()){
			heroPlane.explored(g);
			//Thread.currentThread().stop();
			//System.exit(0);
		}
		//g.drawImage(pImage, px, py, null);
		// 声明子弹对象
		for (Bullets bu : bulletList) {
			bu.drawBullet(g);
		}

		for (Elan elan : enermyPlaneList) {
			elan.drawElan(g);
		}
	}
	int count = 0;// 控制子弹，敌机的数量
	int num;// 存放随机数的容器

	// 背景图片移动
	public void startMoveBgImage() {
		new Thread() {
			public void run() {
				while (true) {
					// 改变背景图片的高度
					bgy++;
					// 如果背景图片的高度等于0，说明背景图片到底
					if (bgy == 0)
						bgy = -5400;

					count++;

					// 控制子弹移动
					if (count % 10 == 0) {
						// 添加子弹
						/*Bullets bullets = new Bullets(bImage, px
								+ pImage.getWidth(null) / 2 + 4, py);*/
						Bullets bullets = new Bullets(bImage, heroPlane.getPx()
								+ heroPlane.getpImage().getWidth(null) / 2 + 4, heroPlane.getPy());
						bulletList.add(bullets);
					}
					for (int i = 0; i < bulletList.size(); i++) {
						bulletList.get(i).moveBullet();
						if (bulletList.get(i).moveBullet() == 1) {
							bulletList.remove(i);
							break;
						}
					}

					// 控制敌机移动
					if (count % 15 == 0) {
						// 添加敌机
						num = (int) (Math.random() * 5 + 2);
						Elan eImage = new Elan(new ImageIcon("images/e" + num
								+ ".png").getImage(),
								(int) (Math.random() * 360), 0, num);
						enermyPlaneList.add(eImage);
					}

					for (int i = 0; i < enermyPlaneList.size(); i++) {
						enermyPlaneList.get(i).moveElan();
						if (enermyPlaneList.get(i).moveElan() == 1) {
							enermyPlaneList.remove(i);
							break;
						}
					}
					
					//碰撞检测通过Rectangle类构造两个矩形，判断两个矩形的的Intersection是否为true
					if(bulletList.size() > 0 && enermyPlaneList.size() > 0){
					for (int j = 0; j < bulletList.size(); j++) {
						Rectangle bulletsRectangle = new Rectangle(
								bulletList.get(j).bx, 
								bulletList.get(j).by,
								bulletList.get(j).bImage.getWidth(null), 
								bulletList.get(j).bImage.getHeight(null));
						for (int k = 0; k < enermyPlaneList.size(); k++) {
							Rectangle enermyRectangle = new Rectangle(
									enermyPlaneList.get(k).ex,
									enermyPlaneList.get(k).ey,
									enermyPlaneList.get(k).eImage.getWidth(null),
									enermyPlaneList.get(k).eImage.getHeight(null));
							
							/*Rectangle planeRectangle = new Rectangle(px,py,pImage.getWidth(null),
									pImage.getHeight(null));*/
							Rectangle planeRectangle = new Rectangle(planeList.get(0).getPx(),planeList.get(0).getPy(),planeList.get(0).getpImage().getWidth(null),
									planeList.get(0).getpImage().getHeight(null) + 5);
							if (bulletsRectangle.intersects(enermyRectangle)) {
								System.out.println("碰撞发生");
								bulletList.remove(j);
								enermyPlaneList.remove(k);
								break;
							}
							
							if(enermyRectangle.intersects(planeRectangle)){
								System.out.println("英雄机碰撞发生");
								planeList.remove(0);
								enermyPlaneList.remove(k);
								//System.exit(0);
								//break;
							}
						}
					}

					}
					// 重绘面板
					repaint();
					// 睡眠
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}.start();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		/*px = e.getX() - pImage.getWidth(null) / 2;
		py = e.getY() - pImage.getHeight(null) / 2;*/
		heroPlane.setPx(e.getX() - heroPlane.getpImage().getWidth(null) / 2);
		heroPlane.setPy(e.getY() - heroPlane.getpImage().getHeight(null) / 2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
