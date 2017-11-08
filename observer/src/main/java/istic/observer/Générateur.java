package istic.observer;

public interface Générateur {

	void attach(Observer o);
	void detach(Observer o);
	int getValue();
	
}
