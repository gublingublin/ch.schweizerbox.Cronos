package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Data;
import model.DataImport;
import model.JAXB;
import model.Project;


public class DesignController {

	// ----------------------------------------------Felder---------------------------------------------------
	 
	@FXML ComboBox<String> CBB_Project1;
	@FXML TextField TF_Beginn1;
	@FXML TextField TF_Ende1;
	@FXML TextField TF_Dauer1;
	@FXML TextField TF_ExporttoCSV;
	@FXML TextField TF_ImportProjekte;
	@FXML TextArea TA_Text1;
	@FXML ToggleButton TBTN_Start1;
	@FXML SplitMenuButton SMBTN_Ende1;
	@FXML RadioButton RBTN_tsl1;
	@FXML RadioButton RBTN_ot1;
	@FXML Tab TAB_Einstellungen;
	@FXML Tab TAB_Projekt;
	@FXML AnchorPane AP_Projekt;
	
		
	// ----------------------------------------------Konstruktor----------------------------------------------

	
	
	
	// ----------------------------------------------Funktionen-----------------------------------------------
	public void starProcess(){
		Project.startStopTime(TBTN_Start1, TF_Beginn1);
		
		System.out.println(TBTN_Start1.getText());
		String start = "Start";
		String test = "Start" ;//TBTN_Start1.getText();
		if(test == start){
			System.out.println("JA");
		} else {
			System.out.println("nein");
		}
	}
	
	
	
	public void test() throws FileNotFoundException, IOException, JAXBException {
		System.out.println("test gedrückt!");
		Data cronosData = new Data();
		cronosData.setPathExportToCSV(TF_ExporttoCSV.getText());
		cronosData.setPathImportProjekte(TF_ImportProjekte.getText());
		JAXB cronosDataToXML = new JAXB();
		cronosDataToXML.erstelleXML(cronosData);
		
		JAXB jaxb = new JAXB();
	}
	
	
	public void test2() throws JAXBException{
		System.out.println("Test 2 gedrückt");
	
	}
	
	
	public void initialize() throws JAXBException{
		// Importiert die zuletzt gespeicherten Pfade und Projekte aus einem XML
		JAXB cronosDataToXML = new JAXB();
		File inputXML = new File(".\\CronosData.xml");
		if(inputXML.exists() == true){
			Data cronosData = null;
			cronosData = cronosDataToXML.leseXML(inputXML);
			TF_ExporttoCSV.setText(cronosData.getPathExportToCSV());
			TF_ImportProjekte.setText(cronosData.getPathImportProjekte());
			ObservableList<String> projekte = FXCollections.observableList(cronosData.getProjects());
			CBB_Project1.setItems(projekte);
			
		} else {
			JOptionPane.showMessageDialog(null, "Es wurden unter Einstellungen noch keine Speicherpfade angegeben. Bitte geben Sie diese an!");
		}
		
	}
		

	public void importProjects() throws IOException{
		// List die Daten aus einem CSV und übergibt sie an die Combobox.
		DataImport.readCSV(new File(TF_ImportProjekte.getText()));
		ObservableList<String> data = FXCollections.observableList(DataImport.getProjekte());
		CBB_Project1.setItems(data);
		
		//Speichert die unter Einstellungen verwendeten Pfade in ein XML:
		JAXB cronosDataToXML = new JAXB();
		File outputXML = new File(".\\CronosData.xml");
		Data cronosData = new Data();
		cronosData.setPathExportToCSV(TF_ExporttoCSV.getText());
		cronosData.setPathImportProjekte(TF_ImportProjekte.getText());
		//Speichert ebenfalls die Projectdaten in dieses XML:
		List<String> projects = DataImport.getProjekte();
		cronosData.setProjects(projects);
		
		try {
			cronosDataToXML.erstelleXML(cronosData);
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "Aktion konnte nicht ausgeführt werden! Siehe LOG-Datei.");
			e.printStackTrace();
		}
		
		
	}
	
	
	public void getFileChoosertoExport(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ExporttoCSV, 3);
	}
	
	
	public void getFileChooserImportProjects(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ImportProjekte, 1);
	}

	
	
	
	
	//----------------------------------------------Getter- / Setter------------------------------------------
	
	
}
