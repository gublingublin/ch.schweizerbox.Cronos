package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DataImport {
	// ----------------------------------------------Felder---------------------------------------------------
	private static List<String> projekte = new ArrayList<String>();
	private static List<Integer> projektnummern = new ArrayList<Integer>();
	
	// ----------------------------------------------Konstruktor----------------------------------------------

	// ----------------------------------------------Funktionen-----------------------------------------------
    
    public static void readCSV(File importFile) throws IOException{
    	FileReader fr = new FileReader(importFile);
        BufferedReader br = new BufferedReader(fr);
        String zeile = "";
        String spalte1 = "";
        String spalte2 = "";
    	
    	while( (zeile = br.readLine()) != null )
        {
//          System.out.println(zeile);
          int laengeSpalte1 = zeile.indexOf(";");
          spalte1 = zeile.substring(0, laengeSpalte1);
//          System.out.println("Spalte 1: " + spalte1);
          try {
        	  projektnummern.add(Integer.parseInt(spalte1));
        	  int laengeSpalte2 = zeile.indexOf(";",laengeSpalte1+1);
              spalte2 = zeile.substring(laengeSpalte1+1, laengeSpalte2);
//              System.out.println("Spalte 2: " + spalte2);
              projekte.add(spalte2);
		} catch (Exception e) {
			System.out.printf("Die Zeile mit dem Inhalt \"%s\" enthält Daten die nicht verarbeitet werden können"
					+ " und wird daher übersprungen!\n", zeile);
		}
        }
    	JOptionPane.showMessageDialog(null, "Es wurden "+ projekte.size() +" Projekte übetragen.");
    	br.close();
    }

	
    
    
	//----------------------------------------------Getter- / Setter------------------------------------------
    public static List<String> getProjekte() {
		return projekte;
	}

	public static void setProjekte(List<String> projekte) {
		DataImport.projekte = projekte;
	}

	public static List<Integer> getProjektnummern() {
		return projektnummern;
	}

	public static void setProjektnummern(List<Integer> projektnummern) {
		DataImport.projektnummern = projektnummern;
	}
	 	

	    

	    
	
	
	
}
