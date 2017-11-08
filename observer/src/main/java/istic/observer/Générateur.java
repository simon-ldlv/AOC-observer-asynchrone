package istic.observer;

import istic.observer.ObservateurGénérateur;

public interface Générateur<ObservateurGénérateur> {

	void attach(ObservateurGénérateur o);
	void detach(ObservateurGénérateur o);
	int getValue();
	void notifyObservers(); 

	
}
