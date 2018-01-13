package istic.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import istic.observer.GenerateurImpl;
import istic.proxy.Canal;
import istic.strategy.Atomique;
import istic.strategy.Sequentielle;
import istic.strategy.Strategy;


public class GuiCtrl  implements Initializable {

	final static Logger logger = Logger.getLogger(GuiCtrl.class);

	

    public void initialize(URL url, ResourceBundle rb) {

    }
}

