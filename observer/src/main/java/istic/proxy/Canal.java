package istic.proxy;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import org.apache.log4j.Logger;

import istic.main.Afficheur;
import istic.observer.GenerateurImpl;
import istic.observer.GenerateurAsync;
import istic.observer.ObserverGenerateurAsync;

/**
 * classe Canal : classe faisant l'intermediaire entre le générateur et les observateurs / clients.
 * Un canal est associé a un seul Afficheur.
 * 
 * @author Simon LEDOUX-LEVIN / Alan MARZIN
 * 
 */
public class Canal implements GenerateurAsync,ObserverGenerateurAsync {
	
	final static Logger logger = Logger.getLogger(Canal.class);
   
    private ScheduledExecutorService executorService;
    private GenerateurImpl generator;
    private Afficheur display;

    public Canal(ScheduledExecutorService executorService, GenerateurImpl generator) {
        this.executorService = executorService;
        this.generator = generator;
        this.display=new Afficheur(this);
    }
    
    @Override
    public Integer getValue() {

        logger.info("getValue()");

        int random= (int)(Math.random()*1000);

        Callable<Integer> callable = this.generator::getValue;

        Future<Integer> future= executorService.schedule(callable,random,TimeUnit.MILLISECONDS);
        Integer integer= null;

        try {
            integer = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.debug("InterruptedException :"+e.getMessage());
        } catch (ExecutionException e) {
        	logger.debug("ExecutionException:"+e.getMessage());
            e.printStackTrace();
        }

        logger.info("integer => "+integer);

        return integer ;
    }

    @Override
    /**
     * Met a jor les Afficheurs observers.
     * 
     */
    public Future update() {
        int random= (int)(Math.random()*1000);
        Runnable runnable= this.display::update;

        logger.info("[update] RANDOM := "+random);

        Future<Integer> future;
        future = (Future<Integer>) executorService.schedule(runnable,random, TimeUnit.MILLISECONDS);

        return future;    
    }

    public Afficheur getDisplay() {
        return display;
    }

    public void setDisplay(Afficheur display) {
        this.display = display;
    }
    
    @Override
    public void execute() {

    }

    @Override
    public void add(ObserverGenerateurAsync o) {

    }

    @Override
    public void delete(ObserverGenerateurAsync o) {

    }


}
