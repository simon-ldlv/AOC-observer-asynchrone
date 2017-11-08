package istic.observer;

public interface Subject {
	
	void detach(Observer o);
	void attach(Observer o);

}
