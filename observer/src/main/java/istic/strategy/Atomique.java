package istic.strategy;

import org.apache.log4j.Logger;

import istic.observer.GenerateurImpl;
import istic.observer.Observer;

/**
 * Algo de diffusion atomique : l'ordre d'arrivé des valeurs n'est pas pris en compte
 *
 *
 */
public class Atomique implements Strategy {

	
	final static Logger logger = Logger.getLogger(Atomique.class);

    private GenerateurImpl generator;

    public Atomique(GenerateurImpl generator) {
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
            observer.update();
        }
    }

    public boolean isDone(int current) {

        return false;
    }
}
