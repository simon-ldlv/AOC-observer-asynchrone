package istic.main;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import istic.observer.ObserverGenerateurAsync;
import istic.proxy.Canal;


/**
 * 
 * Afficheur de la valeur reçu de façon asynchrone par le canal
 * 
 * @author Simon LEDOUX-LEVIN / Alan MARZIN
 *
 */
public class Afficheur implements ObserverGenerateurAsync {

	
	final static Logger logger = Logger.getLogger(Afficheur.class);

    private Canal canal;
    private Integer integer;
    private Label value;

    public Afficheur(Canal canal, Label value) {
        this.canal = canal;
        this.value = value;
    }

    public Afficheur(Canal canal) {
        this.canal = canal;
    }
    

    /**
     * Met a jour dans l'IHM la valeur recu
     * 
     */
    public Future update() {
        integer=canal.getValue();
        logger.info("Afficheur [update] =>" + integer);
        Platform.runLater(() -> value.setText(String.valueOf(integer % 100)));
        return null;
    }

    public Label getValue() {
        return value;
    }

    public void setValue(Label value) {
        this.value = value;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

}
