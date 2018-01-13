package istic.strategy;

/**
 * 
 * Patron de conception stratégie
 * interface definissant les classes d'algo
 *
 */
public interface Strategy {

    public void execute() ;

    boolean isDone(int current);

}
