package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.xml.bind.JAXBException;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.DataImport;
import model.JAXB;

public class DesignController {

	// ----------------------------------------------Felder---------------------------------------------------
	 
	@FXML ComboBox<String> CBB_Project1;
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

	public void test() throws FileNotFoundException, IOException, JAXBException {
		System.out.println("test gedrückt!");



		
	}
	
	
	public void test2() throws JAXBException{
		System.out.println("Test 2 gedrückt");

	}
	
	public void initialize(){

	}
		
	public void importProjects() throws IOException{
		DataImport.readCSV(new File(TF_ImportProjekte.getText()));
		ObservableList<String> abc = new ObservableList<String>() {

			@Override
			public boolean add(String e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void add(int index, String element) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean addAll(Collection<? extends String> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(int index, Collection<? extends String> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String get(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int indexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator<String> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int lastIndexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public ListIterator<String> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ListIterator<String> listIterator(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String remove(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String set(int index, String element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<String> subList(int fromIndex, int toIndex) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void addListener(InvalidationListener listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void removeListener(InvalidationListener listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean addAll(String... elements) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void addListener(ListChangeListener<? super String> listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void remove(int from, int to) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean removeAll(String... elements) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void removeListener(ListChangeListener<? super String> listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean retainAll(String... elements) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean setAll(String... elements) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean setAll(Collection<? extends String> col) {
				// TODO Auto-generated method stub
				return false;
			}

			
		};
		abc.addAll("jkfdsjks","kjdfsjfs");
		System.out.println("aus DataImport: "+ DataImport.getProjekte().get(4));
		System.out.println("Aus ABC: " +abc.size());
		CBB_Project1.setItems(new ObservableList<String>() {@Override
		public boolean addAll(Collection<? extends String> c) {
			// TODO Auto-generated method stub
			return false;
		}
		});
	}
	
	public void getFileChoosertoExport(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ExporttoCSV, 3);
	}
	
	public void getFileChooserImportProjects(){
		CronosFileChooser saveCSV = new CronosFileChooser(TF_ImportProjekte, 1);
	}
	//----------------------------------------------Getter- / Setter------------------------------------------
	
	
}
