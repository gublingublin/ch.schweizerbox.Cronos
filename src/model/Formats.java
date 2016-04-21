package model;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Formats {
	// ----------------------------------------------Felder---------------------------------------------------

	
	
	// ----------------------------------------------Konstruktor----------------------------------------------

	
	
	// ----------------------------------------------Funktionen-----------------------------------------------

	public static String formatiereZuUhrzeit(LocalTime zeit){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String out = zeit.format(formatter);
		zeit.parse(out, formatter);
		
		return out;
	}
	
	
	
	//----------------------------------------------Getter- / Setter------------------------------------------

}
