package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

		
	// ----------------------------------------------Konstruktor----------------------------------------------

	
	
	
	// ----------------------------------------------Funktionen-----------------------------------------------

	public void test() throws FileNotFoundException, IOException, JAXBException {
		System.out.println("test gedrückt!");
		Data cronosData = new Data();
		cronosData.setPathExportToCSV(TF_ExporttoCSV.getText());
		cronosData.setPathImportProjekte(TF_ImportProjekte.getText());
		JAXB cronosDataToXML = new JAXB();
		cronosDataToXML.erstelleXML(cronosData);
		
	}
	
	
	public void test2() throws JAXBException{
		System.out.println("Test 2 gedrückt");
		
		
	}
	
	public void initialize() throws JAXBException{
		// Importiert die zuletzt gespeicherten Pfade aus einem XML
		JAXB cronosDataToXML = new JAXB();
		File inputXML = new File(".\\CronosData.xml");
		Data cronosData = null;
		cronosData = cronosDataToXML.leseXML(inputXML);
		TF_ExporttoCSV.setText(cronosData.getPathExportToCSV());
		TF_ImportProjekte.setText(cronosData.getPathImportProjekte());
	}
		
	public void importProjects() throws IOException{
		DataImport.readCSV(new File(TF_ImportProjekte.getText()));
		ObservableList<String> data = FXCollections.observableList(DataImport.getProjekte());
		CBB_Project1.setItems(data);
		
	}
	
	public void getFileChoosertoExport(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ExporttoCSV, 3);
	}
	
	public void getFileChooserImportProjects(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ImportProjekte, 1);
	}
	//----------------------------------------------Getter- / Setter------------------------------------------
	
	
}
