package model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
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
	
	public static String formatierezuUhrzeit(long zeit){
		DecimalFormat uhrzeitFormat = new DecimalFormat("#,#00.##");
		String out = uhrzeitFormat.format(zeit);
		return out;
	}
	
	//----------------------------------------------Getter- / Setter------------------------------------------

}
