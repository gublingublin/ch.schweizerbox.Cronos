package model;

import java.time.Duration;
import java.time.LocalTime;
import javafx.scene.control.*;
import javafx.scene.text.Text;


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
public static void startStopTime(ToggleButton startButton, TextField beginn){
	System.out.println(startButton.getText());
	boolean test = startButton.getText().toString() == "Start";
	System.out.println(test);
	if(startButton.getText() == "Start"){
		startButton.setText("Stopp");
		beginn.setText(LocalTime.now().toString());
	} else {
		startButton.setText("Start");
	}
		
}
	
	
	
	//----------------------------------------------Getter- / Setter------------------------------------------

	
	
	
}
