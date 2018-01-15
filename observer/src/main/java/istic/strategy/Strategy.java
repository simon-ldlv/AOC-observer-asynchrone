package istic.strategy;

/**
 * Interface pour le DP strategy
 *
 */
public interface Strategy {

    public void execute() ;

    boolean isDone(int current);

}
