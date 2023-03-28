package application;

import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;

public class Maps {


	
	public Image displayMap(ChoiceBox<String> areaChoice) {
		
		Image map = new Image("Base_Tampa_Google_Map.png");
		String area = areaChoice.getValue();
		
		switch(area) {

		case "Apollo Beach":
			map = new Image("Apollo_Beach_Google_Map.png");
			break;		
		case "Brandon":
			map = new Image("Brandon_Google_Map.png");
			break;	
		case "Carrollwood":
			map = new Image("Carrollwood_Google_Map.png");
			break;	
		case "Lutz":
			map = new Image("Lutz_Google_Map.png");
			break;	
		case "Oldsmar":
			map = new Image("Oldsmar_Google_Map.png");
			break;
		case "Northdale":
			map = new Image("Northdale_Google_Map.png");
			break;	
		case "Westchase":
			map = new Image("Westchase_Google_Map.png");
			break;
		case "Wesley Chapel":
			map = new Image("Wesley_Chapel_Google_Map.png");
			break;
		case "Plant City":
			map = new Image("Plant_City_Google_Map.png");
			break;
		case "Thonotosassa":
			map = new Image("Thonotosassa_Google_Map.png");
			break;
		case "Town & Country":
			map = new Image("Town_and_Country_Google_Map.png");
			break;		
		case "Riverview":
			map = new Image("Riverview_Google_Map.png");
			break;	
		case "Citrus Park":
			map = new Image("Citrus_Park_Google_Map.png");
			break;	
		case "Westshore":
			map = new Image("Westshore_Google_Map.png");
			break;
		case "South Tampa":
			map = new Image("South_Tampa_Google_Map.png");
			break;
		case "Temple Terrace":
			map = new Image("Temple_Terrace_Google_Map.png");
			break;
		case "Odessa":
			map = new Image("Odessa_Google_Map.png");
			break;
		
		}
		
		return map;
		
		}
		
		
	}

	
	
