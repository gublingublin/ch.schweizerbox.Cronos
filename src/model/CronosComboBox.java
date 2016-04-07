package model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CronosComboBoxData", propOrder = {
		"projekte",
})

@XmlRootElement(name = "CronosComboBoxData")
public class CronosComboBox{

	
	// ----------------------------------------------Felder---------------------------------------------------
	@XmlTransient
	private List<String> list = new ArrayList<String>();
	@XmlElement(required = true)
	private ObservableList<String> projekte;

	
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


	public void saveData(ObservableList<String> projekte){
		this.projekte = projekte;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	
	
}
