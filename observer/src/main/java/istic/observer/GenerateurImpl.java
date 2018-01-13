package istic.observer;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import istic.strategy.Strategy;


public class GenerateurImpl implements GenerateurAsync {

	final static Logger logger = Logger.getLogger(GenerateurImpl.class);
	
    private Integer value;
    private List<ObserverGenerateurAsync> observersList;

    private Strategy strategy;

    public GenerateurImpl() {
        observersList=new ArrayList<>();
    }

    public List<ObserverGenerateurAsync> getObservers() {
        return observersList;
    }

    public void setObservers(List<ObserverGenerateurAsync> observers) {
        this.observersList = observers;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public void createvalue() {

        this.value= (int)(Math.random() * 100);
        logger.info("[createvalue] => "+value);
        execute();
    }


    @Override
    public void add(ObserverGenerateurAsync o) {
        if(!observersList.contains(o)) {
            observersList.add(o);
        }
    }

    @Override
    public void delete(ObserverGenerateurAsync o) {
        observersList.remove(o);
    }

    @Override
    public void execute() {
        strategy.execute();
    }

}
