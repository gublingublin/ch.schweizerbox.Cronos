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
	
	public static long formatierezuUhrzeit(long zeit){
		NumberFormat uhrzeit = new DecimalFormat("#,##0.##");
		
		uhrzeit.format(zeit);
		System.out.println(zeit);
		return zeit;
	}
	
	//----------------------------------------------Getter- / Setter------------------------------------------

}
