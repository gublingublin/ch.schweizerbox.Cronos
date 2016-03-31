package view;

import java.io.File;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class CronosFileChooser{

	
// ----------------------------------------------Konstruktoren----------------------------------------------
	/** Zeigt einen FileChooser an in welchem Files oder Ordner ausgewählt werden können.
	 * @param Eingabefeld: Wo soll der Pfad hingeschrieben werden?
	 * @param FileChooserTyp: Welcher Typ des Filechosser wird gewünscht? 
	 * 						1: Datei auswählen
	 * 						2: Ordner auswhählen
	 * 						3: Datei speichern
	 *
	 */
	public CronosFileChooser(TextField Eingabefeld, int FileChooserTyp){
		switch (FileChooserTyp) {
		case 1:
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Öffne Datei");
			fileChooser.getExtensionFilters().addAll(
					 new ExtensionFilter("Alle Dateien", "*.*"),
					 new ExtensionFilter("Text Dateien", "*.txt"),
			         new ExtensionFilter("Bilddateien", "*.png", "*.jpg", "*.gif"),
			         new ExtensionFilter("Audiodateien", "*.wav", "*.mp3", "*.aac"));
			 File selectedFile = fileChooser.showOpenDialog(null);
			 if (selectedFile != null) {
			 Eingabefeld.setText(selectedFile.getAbsolutePath());
			 }
		break;
		
		case 2:
			DirectoryChooser directoryChooser = new DirectoryChooser();
			directoryChooser.setTitle("Speicherpfad auswählen");
			File selectedDirectory = directoryChooser.showDialog(null);
			if(selectedDirectory != null){
			Eingabefeld.setText(selectedDirectory.getAbsolutePath());
			}
			break;

		case 3:
			FileChooser fileChooserSave = new FileChooser();
			fileChooserSave.setTitle("Speichere Datei unter...");
			fileChooserSave.setInitialFileName("Rapportierte Arbeit");
			fileChooserSave.setInitialDirectory(new File(".\\"));
			fileChooserSave.getExtensionFilters().add(new ExtensionFilter("CSV Datei", "*.CSV"));
			fileChooserSave.getExtensionFilters().add(new ExtensionFilter("XML Datei", "*.XML"));
			fileChooserSave.getExtensionFilters().add(new ExtensionFilter("TXT Datei", "*.TXT"));
			File selectedFileSave = fileChooserSave.showSaveDialog(null);
			if (selectedFileSave != null) {
			Eingabefeld.setText(selectedFileSave.getAbsolutePath());
			}
			break;
			 
		default:
			System.out.println("Es wurde kein FileChooserTyp ausgewählt. Bitte Angaben machen!");
			break;
		}
		
		}
	
}