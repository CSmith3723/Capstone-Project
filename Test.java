package application;

import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Test {

	public static void main(String[] args) {

		ObservableList<String> list = FXCollections.observableArrayList("Apollo Beach", "Brandon", "Carrollwood", "Lutz", "Northdale", "Oldsmar", "Westchase", "Wesley Chapel", "New Tampa", "Plant City", "Thonotosassa", "Town & Country", "Riverview", "Citrus Park", "Westshore", "South Tampa");
		Collections.sort(list);
		String city = "Brandon";
		int cityChoice = list.indexOf(city);
		
		HousingPrices oneBrAppt = new HousingPrices();
		
		System.out.println(oneBrAppt.get1BrAppt(cityChoice));
		System.out.println(oneBrAppt.get2BrAppt(cityChoice))
		;
	}

}
