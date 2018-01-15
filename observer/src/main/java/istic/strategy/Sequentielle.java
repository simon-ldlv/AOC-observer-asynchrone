package istic.strategy;

import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;

import istic.observer.GenerateurImpl;
import istic.observer.Observer;

/**
 * Algo de diffusion sequentielle : l'ordre d'arrivé des valeurs est pris en compte
 *
 */
public class Sequentielle implements Strategy {
	
	final static Logger logger = Logger.getLogger(Sequentielle.class);

    private GenerateurImpl generator;

    public Sequentielle(GenerateurImpl generator) {
        this.generator = generator;
        generator.setStrategy(this);
    }

    public GenerateurImpl getGenerator() {
        return generator;
    }

    public void setGenerator(GenerateurImpl generator) {
        this.generator = generator;
    }

    public void execute() {
    	
    	logger.info("[execute]");
    	
        for(Observer observer : generator.getObservers()){
        	try {
                observer.update().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

	public boolean isDone(int current) {
		return false;
	}
}
