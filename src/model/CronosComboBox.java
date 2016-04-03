package model;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CronosComboBox{
	// ----------------------------------------------Felder---------------------------------------------------
	private List<String> list = new ArrayList<String>();
	private ObservableList<String> projekte;
	
	private List<String> importList = new ArrayList<String>();
	private ObservableList<String> importProjekte;
	
	// ----------------------------------------------Konstruktor----------------------------------------------
	public CronosComboBox(){
		list.add("abc");
		list.add("def");
		this.projekte = FXCollections.observableArrayList(list);
	}

	
	
	
	
	// ----------------------------------------------Funktionen-----------------------------------------------
	
	
	
	//----------------------------------------------Getter- / Setter------------------------------------------
	public ObservableList<String> getProjekte() {
		return projekte;
	}


	public void setProjekte(ObservableList<String> projekte) {
		this.projekte = projekte;
	}





	public ObservableList<String> getImportProjekte() {
		return importProjekte;
	}





	public void setImportProjekte(ObservableList<String> importProjekte) {
		this.importProjekte = importProjekte;
	}
}
