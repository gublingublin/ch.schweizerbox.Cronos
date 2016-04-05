package model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CronosComboBoxData", propOrder = {
		"projekte",
		"list",
		"importList",
		"importProjekte"
})

@XmlRootElement(name = "CronosComboBoxData")
public class CronosComboBox{

	// ----------------------------------------------Felder---------------------------------------------------
	private List<String> list = new ArrayList<String>();
	@XmlElement(required = true)
	private ObservableList<String> projekte;
	
	private List<String> importList = new ArrayList<String>();
	private ObservableList<String> importProjekte;
	
	// ----------------------------------------------Konstruktor----------------------------------------------
//	public CronosComboBox(){
//		list.add("abc");
//		list.add("def");
//		this.projekte = FXCollections.observableArrayList(list);
//	}

	
	
	
	
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
	
	public void saveData(ObservableList<String> projekte){
		this.projekte = projekte;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public List<String> getImportList() {
		return importList;
	}

	public void setImportList(List<String> importList) {
		this.importList = importList;
	}
	
}
