package istic.observer;

import java.util.concurrent.Future;

public interface ObserverGenerateurAsync extends Observer<GenerateurAsync> {

    Future update() ;
}
