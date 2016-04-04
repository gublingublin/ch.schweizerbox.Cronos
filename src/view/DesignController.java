package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.CronosComboBox;
import model.Data;
import model.DataImport;
import model.JAXB;

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
	
	CronosComboBox importProjekte = new CronosComboBox();
		
	// ----------------------------------------------Konstruktor----------------------------------------------

	
	
	
	// ----------------------------------------------Funktionen-----------------------------------------------

	public void test() throws FileNotFoundException, IOException, JAXBException {
		JAXB jaxb = new JAXB();
		jaxb.erstelleXML(importProjekte);
		System.out.println("test gedr�ckt!");
	}
	
	public void initialize(){
		CronosComboBox projekte = new CronosComboBox();
		CBB_Project1.setItems(projekte.getProjekte());
		
	}
		
	public void importProcets() throws IOException{
		DataImport.readCSV(new File(TF_ImportProjekte.getText()));
		importProjekte.setImportProjekte(FXCollections.observableArrayList(DataImport.getProjekte()));
		CBB_Project1.setItems(importProjekte.getImportProjekte());
	}
	
	public void getFileChoosertoExport(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ExporttoCSV, 3);
	}
	
	public void getFileChooserImportProjects(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ImportProjekte, 1);
	}
	//----------------------------------------------Getter- / Setter------------------------------------------
	
	
}
