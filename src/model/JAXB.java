package model;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXB {
	
	// ----------------------------------------------Felder---------------------------------------------------


	
	
	// ----------------------------------------------Konstruktor----------------------------------------------

	
	
	
	// ----------------------------------------------Funktionen-----------------------------------------------
	/** Erzeugt ein XML File mit der übergebenen Klasse und speichert es im Sourcepfad
	 * @param cronosComboBoxData
	 * @throws JAXBException
	 */
	public void erstelleXML(CronosComboBox cronosComboBoxData) throws JAXBException{
		// Hier wird das File gespeichert:
		File output = new File(".\\CronosComboboxData.xml");
		// Hier die Klassen angeben die im XML enthalten sein sollen:
		JAXBContext jaxbContext = JAXBContext.newInstance(CronosComboBox.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(cronosComboBoxData, output);
	}
	
	
	public CronosComboBox leseXML(File inputFile) throws JAXBException{
		// Welche Klassen sollen mit Daten aus dem XML abgefüllt werden?
		JAXBContext jaxbContext = JAXBContext.newInstance(CronosComboBox.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		CronosComboBox cronosComboBox = (CronosComboBox)jaxbUnmarshaller.unmarshal(inputFile);
		return cronosComboBox;
	}
	
	
		
	//----------------------------------------------Getter- / Setter------------------------------------------
	
	
	
}
