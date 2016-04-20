
package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CronosData", propOrder = {
		"pathExportToCSV",
		"pathImportProjekte",
		"projects"
})
@XmlRootElement(name = "CronosData")


public class Data{
	// ----------------------------------------------Felder---------------------------------------------------
	
	@XmlElement (required = true)
	protected String pathExportToCSV;
	
	@XmlElement (required = true)
	protected String pathImportProjekte;

	@XmlElement (required = false)
	@XmlElementWrapper (name = "projects")
	protected List<String> projects;
	
	// ----------------------------------------------Konstruktor----------------------------------------------

	
	// ----------------------------------------------Funktionen-----------------------------------------------

	
	//----------------------------------------------Getter- / Setter------------------------------------------
	public String getPathExportToCSV() {
		return pathExportToCSV;
	}

	public void setPathExportToCSV(String pathExportToCSV) {
		this.pathExportToCSV = pathExportToCSV;
	}

	public String getPathImportProjekte() {
		return pathImportProjekte;
	}

	public void setPathImportProjekte(String pathImportProjekte) {
		this.pathImportProjekte = pathImportProjekte;
	}

	public List<String> getProjects() {
		return projects;
	}

	public void setProjects(List<String> projects) {
		this.projects = projects;
	}


}
