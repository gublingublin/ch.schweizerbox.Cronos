package view;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.CronosComboBox;
import model.Data;
import model.DataImport;

public class DesignController {

	// ----------------------------------------------Felder---------------------------------------------------
	 
	@FXML ComboBox<String> CBB_Project1 = new ComboBox<>();
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

	public void test() {
		String out = Data.getProjekte().get(4);
		System.out.println("Projektnummer 4 ist: " + out);
	}
	
	public void initialize(){
		CBB_Project1.setItems(CronosComboBox.aktionen);
	}
		
	public void importProcets() throws IOException{
		DataImport csvImport = new DataImport();
		csvImport.readCSV(new File(TF_ImportProjekte.getText()));
	}
	
	public void getFileChoosertoExport(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ExporttoCSV, 3);
	}
	
	public void getFileChooserImportProjects(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ImportProjekte, 1);
	}
	//----------------------------------------------Getter- / Setter------------------------------------------
	
	
}
