package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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
	
	
	CronosComboBox projekte2 = new CronosComboBox();
		
	// ----------------------------------------------Konstruktor----------------------------------------------

	
	
	
	// ----------------------------------------------Funktionen-----------------------------------------------

	public void test() throws FileNotFoundException, IOException, JAXBException {
		System.out.println("test gedrückt!");
		File inputFile = new File(".\\CronosComboboxData.xml");
		if( inputFile.exists() == true)
			JOptionPane.showMessageDialog(null, "File existiert!");
		
		
		JAXBContext jaxbContext = JAXBContext.newInstance(CronosComboBox.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		CronosComboBox cronosComboBoxXML = (CronosComboBox)jaxbUnmarshaller.unmarshal(inputFile);
		List<String> out = cronosComboBoxXML.getList();
		
		System.out.println(out.get(4));		
//		JAXB jaxb = new JAXB();
//		jaxb.leseXML();
		
	}
	
	
	public void test2() throws JAXBException{
		CronosComboBox projekte = new CronosComboBox();
		System.out.println("Test 2 gedrückt");
		JAXB jaxb = new JAXB();
		
		String out = projekte.getProjekte().get(3);
		System.out.println(out);
		
		jaxb.erstelleXML(projekte);
	}
	
	public void initialize(){
//		CBB_Project1.setItems(projekte.getProjekte());
	}
		
	public void importProcets() throws IOException{
		CronosComboBox projekte = new CronosComboBox();
		DataImport.readCSV(new File(TF_ImportProjekte.getText()));
		projekte.setImportProjekte(FXCollections.observableArrayList(DataImport.getProjekte()));
		CBB_Project1.setItems(projekte.getImportProjekte());
		
	}
	
	public void getFileChoosertoExport(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ExporttoCSV, 3);
	}
	
	public void getFileChooserImportProjects(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ImportProjekte, 1);
	}
	//----------------------------------------------Getter- / Setter------------------------------------------
	
	
}
