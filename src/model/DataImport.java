package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataImport {
	// ----------------------------------------------Felder---------------------------------------------------
	
    
	// ----------------------------------------------Konstruktor----------------------------------------------

	// ----------------------------------------------Funktionen-----------------------------------------------
    
    public void readCSV(File importFile) throws IOException{
    	FileReader fr = new FileReader(importFile);
        BufferedReader br = new BufferedReader(fr);
        String zeile = "";
        String spalte1 = "";
        String spalte2 = "";
    	
    	while( (zeile = br.readLine()) != null )
        {
          System.out.println(zeile);
          int laengeSpalte1 = zeile.indexOf(";");
          spalte1 = zeile.substring(0, laengeSpalte1);
          System.out.println("Spalte 1: " + spalte1);
//          Data.addProjektNummern(Integer.parseInt(spalte1));
                    
          int laengeSpalte2 = zeile.indexOf(";",laengeSpalte1+1);
          spalte2 = zeile.substring(laengeSpalte1+1, laengeSpalte2);
          System.out.println("Spalte 2: " + spalte2);
          Data.addProjekte(spalte2);
          
          
        }
        br.close();
    }
    
    
	//----------------------------------------------Getter- / Setter------------------------------------------

	 	

	    

	    
	
	
	
}
