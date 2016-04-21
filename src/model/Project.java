package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;

import com.sun.xml.internal.ws.policy.privateutil.LocalizationMessages;

import javafx.scene.control.*;
import javafx.scene.text.Text;
import sun.util.locale.provider.LocaleProviderAdapter;


public class Project {
	// ----------------------------------------------Felder---------------------------------------------------
	private int projectnr;
	private String projectname;
	private LocalTime beginn;
	private LocalTime ende;
	private Duration dauer;
	private Duration totalDauer;
	
	
	
	
	
	// ----------------------------------------------Konstruktor----------------------------------------------

	
	
	
	// ----------------------------------------------Funktionen-----------------------------------------------
public void startStopTime(ToggleButton startButton, TextField beginn, TextField ende){
	String text = startButton.getText();
	
	//Wenn der Button auf 'Start' steht, starte den Timer:
	if(text.compareTo("Start") == 0){
		startButton.setText("Stopp");
		
		LocalTime startzeit = LocalTime.now();
		String zeit = Formats.formatiereZuUhrzeit(startzeit);
		beginn.setText(zeit);
		this.beginn = startzeit;
		
	} else if(text.compareTo("Stopp") == 0){
		startButton.setText("Start");
		
		LocalTime stoppzeit = LocalTime.now();
		String zeit = Formats.formatiereZuUhrzeit(stoppzeit);
		ende.setText(zeit);
		this.ende = stoppzeit;
		
		berechneDauer();
	}
		
}
	
public void berechneDauer(){
	Duration dauer = Duration.between(beginn, ende);
	dauer = dauer.plusHours(47);
	long stunden = dauer.toHours();
	long minuten = dauer.toMinutes();
	long sec = dauer.toMillis()/1000;
	System.out.printf("%d : %d : %d" ,stunden, minuten, sec);
	
	
	
	
}
	
	//----------------------------------------------Getter- / Setter------------------------------------------

	
	
	
}
