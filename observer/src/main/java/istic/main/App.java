package istic.main;

import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

	final static Logger logger = Logger.getLogger(Afficheur.class);

	
    public static void main(String[] args) {
        launch();
    }
	
    public void start(Stage stage) throws Exception {
    	
        Parent root = FXMLLoader.load(getClass().getResource("ihm.fxml"));
        Scene scene = new Scene(root);
        
        stage.setTitle("AOC ILA 2017");
        stage.setScene(scene);
        
        logger.info("Start Application !");
        
        stage.show();

    }

    public void stop(){
        System.exit(0);
    }
}

