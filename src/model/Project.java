package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
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
	private long totalDauer;
	
	
	
	
	
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
		
		System.out.println(berechneDauerinUhrzeit());
	}
		
}
	
public String berechneDauerinUhrzeit(){
	Duration dauer = Duration.between(beginn, ende);
	totalDauer = totalDauer + dauer.toMillis();
	long stunden = dauer.toHours();
	long minuten = 0;
	long sec = 0;
	
	//Berechnung der Dauer in Stunden, Minuten, Sekunden
	if(stunden > 0){
		minuten = dauer.toMinutes() % (dauer.toHours()*60);
	} else {
		minuten = dauer.toMinutes();
	}
	
	if(minuten > 0){
		sec = dauer.toMillis()/1000 % (dauer.toMinutes()*60);
	} else {
		sec = dauer.toMillis()/1000;
	}
//	System.out.printf("Die Dauer beträgt  %d Stunden %d Minuten %d Sekunden \n" ,stunden, minuten, sec);
	
	//Fomatierung für den Output
	Formats.formatierezuUhrzeit(stunden);
	Formats.formatierezuUhrzeit(minuten);
	Formats.formatierezuUhrzeit(sec);
	Formats.formatierezuUhrzeit(2926384);
	
	String out;
	if(minuten == 0){
		out = stunden+":"+minuten+":"+sec;
		
	} else {
		out = stunden+":"+minuten;
	}

	return out;
	
}
	
	//----------------------------------------------Getter- / Setter------------------------------------------

	
	
	
}
