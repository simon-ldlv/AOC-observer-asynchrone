package istic.observer;

import java.util.concurrent.Future;

public  interface Observer<S> {
    public Future update() ;
}
