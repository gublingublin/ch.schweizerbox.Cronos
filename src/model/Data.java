
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CronosData", propOrder = {
		"PathExportToCSV",
		"PathImportProjekte"
})
@XmlRootElement(name = "CronosData")


public class Data{
	// ----------------------------------------------Felder---------------------------------------------------
	@XmlElement (required = true)
	protected String PathExportToCSV;
	
	@XmlElement (required = true)
	protected String PathImportProjekte;

	
	
	// ----------------------------------------------Konstruktor----------------------------------------------

	
	// ----------------------------------------------Funktionen-----------------------------------------------

	
	//----------------------------------------------Getter- / Setter------------------------------------------
	public String getPathExportToCSV() {
		return PathExportToCSV;
	}

	public void setPathExportToCSV(String pathExportToCSV) {
		PathExportToCSV = pathExportToCSV;
	}

	public String getPathImportProjekte() {
		return PathImportProjekte;
	}

	public void setPathImportProjekte(String pathImportProjekte) {
		PathImportProjekte = pathImportProjekte;
	}


}
