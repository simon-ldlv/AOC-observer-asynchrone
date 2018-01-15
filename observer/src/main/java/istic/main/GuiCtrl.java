package istic.main;

import org.apache.log4j.Logger;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import istic.observer.GenerateurImpl;
import istic.proxy.Canal;
import istic.strategy.Atomique;
import istic.strategy.Sequentielle;
import istic.strategy.Strategy;

/**
 * Controleur de l'interface graphique: receptionne les evenements de l'utilisateur.
 * Les éléments graphiques sont définis dans le fichier "ihm.fxml"
 * Cette classe impélmente une méthode qui controle le bouton Start/Stop et une méthode d'init de l'IHM
 * 
 * @author Simon LEDOUX-LEVIN / Alan MARZIN
 *
 */
public class GuiCtrl  implements Initializable {

	final static Logger logger = Logger.getLogger(GuiCtrl.class);

    @FXML
    private Button startStopBtn;
    @FXML
    private Label value1,value2,value3,value4;
     
    @FXML
    private Label labelDesc;
    
    @FXML
    private RadioButton radioSeq;
    
    @FXML
    private RadioButton radioAtom;
    
    final ToggleGroup toggleRadio = new ToggleGroup();


    public static ScheduledExecutorService executorService;
    
    private Strategy myStrat;
    
    private Canal canal1,canal2,canal3,canal4;

    private GenerateurImpl generator;

    private boolean process=false;
    

    public void initialize(URL url, ResourceBundle rb) {
    	
    	logger.info("[init IHM]");

    	
    	labelDesc.setText("Welcome to AOC 2017 !\n\nSimon LEDOUX-LEVIN\nAlan MARZIN");
    	
        radioAtom.setToggleGroup(toggleRadio);
        radioSeq.setToggleGroup(toggleRadio);

        radioAtom.setSelected(true);
    }

    @FXML
    private void startStop(ActionEvent event) {
    	
        if(process){
        	executorService.shutdown();
        	process=false;
        	logger.info("[STOP]");

        } else {
        	
        	logger.info("[START]");
        	process=true;
        	executorService = new ScheduledThreadPoolExecutor(7);
            generator = new GenerateurImpl();
            
            canal1 = new Canal(executorService, generator);
            canal2 = new Canal(executorService, generator);
            canal3 = new Canal(executorService, generator);
            canal4 = new Canal(executorService, generator);
            
            if (radioAtom.isSelected()) {
                myStrat = new Atomique(generator);
            } else {
              	myStrat = new Sequentielle(generator);
            }
          	
            generator.add(canal1);
            generator.add(canal2);
            generator.add(canal3);
            generator.add(canal4);

            canal1.getDisplay().setValue(value1);
            canal2.getDisplay().setValue(value2);
            canal3.getDisplay().setValue(value3);
            canal4.getDisplay().setValue(value4);

            executorService.scheduleAtFixedRate(generator::createvalue, 0, 3000, TimeUnit.MILLISECONDS);
            
            process=true;
        }
    }

}

