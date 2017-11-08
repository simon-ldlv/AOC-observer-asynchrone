package istic.main;

import istic.proxy.Afficheur;
import istic.strategy.GénérateurImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	// création d'un géénrateur
    	// création d'un canal
    	// création d'un diplay
    	
    	// gen.attach (canal)
    	// canal.attach (display)
    	
    	Afficheur aff = new Afficheur();
    	GénérateurImpl gen =  new GénérateurImpl();
    	aff.init();
    	
    	gen.attach(aff);
    	gen.setValue(10);
    	
    	

    }
}
