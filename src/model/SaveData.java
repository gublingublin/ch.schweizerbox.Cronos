package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class SaveData {

	// ----------------------------------------------Felder---------------------------------------------------
		CronosComboBox saveData = new CronosComboBox();
		String TestFeld1;		
		
		
		
	// ----------------------------------------------Konstruktor----------------------------------------------
		public SaveData(String TestFeld1){
			this.TestFeld1 = TestFeld1;
		}
		
		
		
	// ----------------------------------------------Funktionen-----------------------------------------------
	/**speichert die Daten in das File Data.data. Beim Konstruktor soll angegeben werden, welche
	 * Daten benötigt werden.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void speichereDaten() throws FileNotFoundException, IOException{
		saveData.setFeld1(TestFeld1);
		try(
				OutputStream dateiSchreiber = new FileOutputStream("Data.data");
				ObjectOutputStream objektSchreiber = new ObjectOutputStream(dateiSchreiber)
			) {
				objektSchreiber.writeObject(saveData);
				objektSchreiber.flush();
//				System.out.println("Daten gespeichert!");
			}
	}
		
	
	
	/**
	 * @return Liest die Daten aus der Datei Data.data und gibt Sie als Objekt Data zurück.
	 * Die Einzelnen Felder können dann so angesprochen werden.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Data leseDaten() throws FileNotFoundException, IOException, ClassNotFoundException{
		try(
				InputStream dateiLeser = new FileInputStream("Data.data");
				ObjectInputStream objektLeser = new ObjectInputStream(dateiLeser)
				) {
				Data geleseneDaten = (Data) objektLeser.readObject();
//				System.out.println(geleseneDaten.getFeld1());
				return geleseneDaten;
			} 
	}
	
		
	//----------------------------------------------Getter- / Setter------------------------------------------
		
	
}
