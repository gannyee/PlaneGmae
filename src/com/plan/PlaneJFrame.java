package com.plan;

import javax.swing.JFrame;

public class PlaneJFrame extends JFrame{
	
	PlaneJFrame(){
		
		this.setBounds(0, 0, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		//声明PlaneJpanel
		PlaneJPanel pjp = new PlaneJPanel();
		pjp.startMoveBgImage();
		this.add(pjp);
		this.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlaneJFrame pjf = new PlaneJFrame();
	}

}
