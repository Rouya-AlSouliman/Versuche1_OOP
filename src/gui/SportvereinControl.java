package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Sportverein;
import business.SportvereinModel;
import javafx.stage.Stage;

public class SportvereinControl {

	
	private SportvereinModel sportvereinModel;
	private SportvereinView sportvereinView;
	public SportvereinControl(Stage primaryStage ) {
		super();
		this.sportvereinModel = new SportvereinModel();
		this.sportvereinView = new SportvereinView(this, sportvereinModel, primaryStage);
	}
	
	 public void leseAusDatei(String typ){
	    	try {
	    		if("csv".equals(typ)){
	      			BufferedReader ein = new BufferedReader(new FileReader("Sportverein.csv"));
	      				sportvereinView.zeigeInformationsfensterAn(
	      	  	   			"Der Sportverein wurde gelesen!");
	      		}
	       		else{
	       			sportvereinView.zeigeInformationsfensterAn(
		   				"Txt Noch nicht implementiert!");
		   		}
	    	}
			catch(IOException exc){
				sportvereinView.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				sportvereinView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		}
			
		public void schreibeSportvereineInCsvDatei() {
			try {
				sportvereinModel.schreibeSportvereineInCsvDatei();
				sportvereinView.zeigeInformationsfensterAn(
		   			"Die Sportvereine wurden gespeichert!");
			}	
			catch(IOException exc){
				sportvereinView.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				sportvereinView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}

	

	    public void nehmeSportvereinAuf(){
	    	try{ 
	    		this.sportvereinModel.setSportverein( new Sportverein(
	    				sportvereinView.getTxtName().getText(), 
	    				sportvereinView.getTxtOrt().getText(),
	   	            Integer.parseInt(sportvereinView.getTxtAnzahlMitglieder().getText()),
	   	        	Integer.parseInt(sportvereinView.getTxtAnzahlEhemaligerMitglieder().getText()),
	   	        	sportvereinView.getTxtSportarten().getText().split(";")));
	    		sportvereinView.zeigeInformationsfensterAn("Der Sportverein wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		sportvereinView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }
	   
	
	
	
}
