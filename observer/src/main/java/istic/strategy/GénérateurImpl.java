package istic.strategy;

import java.util.HashSet;
import java.util.Set;

import istic.observer.Générateur;
import istic.observer.ObservateurGénérateur;
import istic.observer.Observer;

public class GénérateurImpl implements Générateur<ObservateurGénérateur> {

	private int value;
	
	private Set<ObservateurGénérateur> observateurs;
	
	public GénérateurImpl() {
		this.observateurs = new HashSet<ObservateurGénérateur>();
	}
	
	public void attach(ObservateurGénérateur o) {

		observateurs.add(o);
	}

	public void detach(ObservateurGénérateur o) {
		observateurs.remove(o);
		
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int myVal) {
		this.value = myVal;
		this.notifyObservers();
	}
	
	public void notifyObservers() {

		for(ObservateurGénérateur myObservateurs : observateurs) {
			myObservateurs.update(this);
		}
	}

}
