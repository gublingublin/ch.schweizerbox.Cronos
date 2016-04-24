package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;

import javax.swing.JOptionPane;

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
public void startStopTime(ToggleButton startButton, TextField beginn, TextField ende, TextField dauer){
	String text = startButton.getText();
	
	//Wenn der Button auf 'Start' steht, starte den Timer:
	if(text.compareTo("Start") == 0){
		startButton.setText("Stopp");
		
		LocalTime startzeit = LocalTime.now();
		String zeit = Formats.formatiereZuUhrzeit(startzeit);
		beginn.setText(zeit);
		this.beginn = startzeit;
	
	//Wenn der Button auf 'Stopp' steht, berechne die Zeit:	
	} else if(text.compareTo("Stopp") == 0){
		startButton.setText("Weiter");
		
		LocalTime stoppzeit = LocalTime.now();
		String zeit = Formats.formatiereZuUhrzeit(stoppzeit);
		ende.setText(zeit);
		this.ende = stoppzeit;
		
		String zeitDauer = berechneDauerinUhrzeit();
		dauer.setText(zeitDauer);
	
	//Wenn der Button auf 'Weiter' steht, leere die Zeitfelder und starte neu:
	} else if(text.compareTo("Weiter") == 0){
		ende.setText("");
		dauer.setText("");
		
		LocalTime startzeit = LocalTime.now();
		String zeit = Formats.formatiereZuUhrzeit(startzeit);
		beginn.setText(zeit);
		this.beginn = startzeit;
		startButton.setText("Stopp");
	}
		
}

public void uebertrageZeit(ToggleButton startButton, TextField beginn, TextField ende, TextField dauer, TextArea warnmeldung,
		ComboBox<String> project){
	warnmeldung.setText("");
	
	// Überprüfung ob alle benötigten Felder ausgefüllt wurden:
	if(startButton.getText().compareTo("Start") == 0 | project.getValue() == null){
		warnmeldung.setText("Projekt fehlt oder Zeit noch nicht gestartet!");
	} else if (startButton.getText().compareTo("Stopp") == 0){
		//falls die Zeit noch nicht gestoppt wurde, wird das erst gemacht.
		startStopTime(startButton, beginn, ende, dauer);
	} else {
	// senden der Daten an die Übersicht-Tabelle

	// leeren der Datenfelder
	beginn.setText("");
	ende.setText("");
	dauer.setText("");
	startButton.setText("Start");
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
	String stundenString = Formats.formatierezuUhrzeit(stunden);
	String minutenString = Formats.formatierezuUhrzeit(minuten);
	String secString = Formats.formatierezuUhrzeit(sec);
	
	String out;
	if(minuten == 0){
		out = stundenString +":"+ minutenString +":"+ secString;
		
	} else {
		out = stundenString +":"+ minutenString;
	}

	return out;
	
}
	
	//----------------------------------------------Getter- / Setter------------------------------------------

	
	
	
}
