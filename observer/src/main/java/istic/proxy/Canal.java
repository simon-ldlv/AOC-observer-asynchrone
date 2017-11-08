package istic.proxy;

import istic.observer.Générateur;
import istic.observer.ObservateurGénérateur;
import istic.observer.Observer;

public class Canal implements Générateur<ObservateurGénérateur>, ObservateurGénérateur<Générateur> {

	public void attach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	public void detach(Observer o) {
		// TODO Auto-generated method stub
		
	}

	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void update(Générateur subject) {
		// TODO Auto-generated method stub
		
	}

	public void attach(ObservateurGénérateur o) {
		// TODO Auto-generated method stub
		
	}

	public void detach(ObservateurGénérateur o) {
		// TODO Auto-generated method stub
		
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

}
