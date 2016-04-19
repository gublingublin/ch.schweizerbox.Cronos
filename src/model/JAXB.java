package model;
import java.io.File;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class JAXB {
	
	// ----------------------------------------------Felder---------------------------------------------------


	
	
	// ----------------------------------------------Konstruktor----------------------------------------------

	
	
	
	// ----------------------------------------------Funktionen-----------------------------------------------
	/** Erzeugt ein XML File mit der übergebenen Klasse und speichert es im Sourcepfad
	 * @param cronosData
	 * @throws JAXBException
	 */
	public void erstelleXML(Data cronosData) throws JAXBException{
		// Hier wird das File gespeichert:
		File output = new File(".\\CronosData.xml");
		// Hier die Klassen angeben die im XML enthalten sein sollen:
		JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(cronosData, output);
	}
	

	/** liest eine XML-Datei ein und übergibt die Daten an die vorbereitete Klasse.
	 * @param inputFile: die XML Datei, die eingelsen werden soll.
	 * @throws JAXBException
	 */
	
	public Data leseXML(File inputFile) throws JAXBException{
		//Prüfen ob das InputFile überhaupt existiert:
		Data cronosData = null;
		
		if(inputFile.exists() == true){
			// Welche Klassen sollen mit Daten aus dem XML abgefüllt werden?
			JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cronosData = (Data)jaxbUnmarshaller.unmarshal(inputFile);
			
		} else {
			JOptionPane.showMessageDialog(null, "Kein File zum einlesen gefunden!");
		}
		return cronosData;
	}
	
	
	//----------------------------------------------Getter- / Setter------------------------------------------
	
	
	
}
