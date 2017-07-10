package com.mau.introductionSwing.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MonListerner1 implements ActionListener {
	
	private String name;
	
	
	


	public MonListerner1(String name) {
		super();
		this.name = name;
	}
	



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JOptionPane.showMessageDialog(null, "action declenchée chez" + getName());
		
	}


}
