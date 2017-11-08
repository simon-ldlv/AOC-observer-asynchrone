package istic.observer;

public interface Subject <T>  {
	
	void detach(T o);
	void attach(T o);
	void notifyObservers();

}
