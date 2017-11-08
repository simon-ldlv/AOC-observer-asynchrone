package istic.proxy;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

import istic.observer.Générateur;
import istic.observer.ObservateurGénérateur;

public class Afficheur implements ObservateurGénérateur<Générateur> {

	
	JFrame frame;
	JLabel labelValue;
	
	public void init() {
		
		this.frame = new JFrame();
		this.labelValue = new JLabel("toto");
		frame.add(labelValue);
		
	    frame.setTitle("My First Swing Application");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    frame.setPreferredSize(new Dimension(400, 300));		
		frame.pack();
	    frame.setVisible(true);		
	}

	public void update(Générateur subject) {
		
		labelValue.setText(subject.getValue()+"");
		
	}	
	

}
