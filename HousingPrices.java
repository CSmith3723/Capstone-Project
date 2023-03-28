package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class HousingPrices {

String pricesFile = "Housing_Prices_Table.txt";
 


HousingPrices(){

}

public static String[][] ReadFileInto2DArray(String filepath, int numFields){
	
	 List<String> pricesList = new ArrayList<>();
	 
	 String delimiter = "-";
	 String currentLine;
	 
	 try {
		 
		 FileReader fr = new FileReader(filepath);
		 @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		 
		 while((currentLine = br.readLine()) != null)
		 {
			 pricesList.add(currentLine);
		 }
		 
		 int pricesListCount = pricesList.size();
		 
		 String arrayToReturn[][] = new String[pricesListCount][numFields];
		 String[] data;
		 
		 for(int i = 0; i < pricesListCount; i++) {
			 
			 data = pricesList.get(i).split(delimiter);
			 
			 for (int j = 0; j < data.length; j++) {
				 
				arrayToReturn[i][j] = data[j];
			}
		 }	 
		 
		 return arrayToReturn;
		 
		 
	} catch (Exception e) {
		System.out.println(e);
	    return null;
	}
}

String[][] housingPrices = ReadFileInto2DArray(pricesFile, 4);

public String get1BrAppt(int cityNum) {
	
	
	int i = cityNum;
	
	
		switch (i){
		case 0: return housingPrices[i][1];
		case 1: return housingPrices[i][1];
		case 2: return housingPrices[i][1];
		case 3: return housingPrices[i][1];
		case 4: return housingPrices[i][1];
		case 5: return housingPrices[i][1];
		case 6: return housingPrices[i][1];	
		case 7: return housingPrices[i][1];
		case 8: return housingPrices[i][1];
		case 9: return housingPrices[i][1];
		case 10: return housingPrices[i][1];
		case 11: return housingPrices[i][1];
		case 12: return housingPrices[i][1];
		case 13: return housingPrices[i][1];
		case 14: return housingPrices[i][1];
		case 15: return housingPrices[i][1];
		default: return "Location not chosen";
		}
	}



public String get2BrAppt(int cityNum) {
	int i = cityNum;
	
	switch (i){
	case 0: return housingPrices[i][2];
	case 1: return housingPrices[i][2];
	case 2: return housingPrices[i][2];
	case 3: return housingPrices[i][2];
	case 4: return housingPrices[i][2];
	case 5: return housingPrices[i][2];
	case 6: return housingPrices[i][2];	
	case 7: return housingPrices[i][2];
	case 8: return housingPrices[i][2];
	case 9: return housingPrices[i][2];
	case 10: return housingPrices[i][2];
	case 11: return housingPrices[i][2];
	case 12: return housingPrices[i][2];
	case 13: return housingPrices[i][2];
	case 14: return housingPrices[i][2];
	case 15: return housingPrices[i][2];
	default: return "Location not chosen";
		}

	}


public String getHouse(int cityNum) {
	int i = cityNum;
	switch (i){
	case 0: return housingPrices[i][3];
	case 1: return housingPrices[i][3];
	case 2: return housingPrices[i][3];
	case 3: return housingPrices[i][3];
	case 4: return housingPrices[i][3];
	case 5: return housingPrices[i][3];
	case 6: return housingPrices[i][3];	
	case 7: return housingPrices[i][3];
	case 8: return housingPrices[i][3];
	case 9: return housingPrices[i][3];
	case 10: return housingPrices[i][3];
	case 11: return housingPrices[i][3];
	case 12: return housingPrices[i][3];
	case 13: return housingPrices[i][3];
	case 14: return housingPrices[i][3];
	case 15: return housingPrices[i][3];
	default: return "Location not chosen";
		}
	}

}
