package model;

import java.util.ArrayList;
import java.util.List;

public class Data {
	// ----------------------------------------------Felder---------------------------------------------------
	private static List<String> projekte = new ArrayList<String>();
	private static List<Integer> projektNummern = new ArrayList<Integer>();
	
	
	
	// ----------------------------------------------Konstruktor----------------------------------------------

	
	// ----------------------------------------------Funktionen-----------------------------------------------

	
	//----------------------------------------------Getter- / Setter------------------------------------------
	public static List<String> getProjekte() {
		return projekte;
	}

	public static void addProjekte(String projekt) {
		Data.projekte.add(projekt);
	}

	public static List<Integer> getProjektNummern() {
		return projektNummern;
	}

	public static void addProjektNummern(int projektNummer) {
		Data.projektNummern.add(projektNummer);
	}

	
}
