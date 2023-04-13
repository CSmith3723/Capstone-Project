package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;



//class 
public class HousingPrices {
	
//calling file	
String pricesFile = "Housing_Prices_Table.txt";
 


//Constructor
HousingPrices(){

}


//Method to read file into a 2DArray
public static String[][] ReadFileInto2DArray(String filepath, int numFields){
	
	//new arraylist
	 List<String> pricesList = new ArrayList<>();
	 
	 //set delimiter
	 String delimiter = "-";
	 String currentLine;
	 
	 try {
		 
		 //new Filereader and bufferedreader
		FileReader fr = new FileReader(filepath);
		 @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		 
		 //while loop to continue until file done
		 while((currentLine = br.readLine()) != null)
		 {
			 pricesList.add(currentLine);
		 }
		 
		 int pricesListCount = pricesList.size();
		 
		 //creating 2D array to return
		 String arrayToReturn[][] = new String[pricesListCount][numFields];
		 String[] data;
		 
		 //nested for loops to work through file and set values in appropriate array positions
		 for(int i = 0; i < pricesListCount; i++) {
			 
			 data = pricesList.get(i).split(delimiter);
			 
			 for (int j = 0; j < data.length; j++) {
				 
				arrayToReturn[i][j] = data[j];
			}
		 }	 
		 
		 //return 2D array
		 return arrayToReturn;
		 
	//catch statement for potential null	 
	} catch (Exception e) {
		System.out.println(e);
	    return null;
	}
}


//creating 2D array and reading file into it
String[][] housingPrices = ReadFileInto2DArray(pricesFile, 4);


//***********************Methods for getting values based on associated index************************//

//method to return value in index 1 of any array in 2D array
public String get1BrAppt(int areaNum) {
	
	
	int i = areaNum;
	
		//switch statement to check which array in 2D array is needed and return value
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


//method to return value in index 2 of any array in 2D array

public String get2BrAppt(int areaNum) {
	
	int i = areaNum;
	
	//switch statement to check which array in 2D array is needed and return value
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

//method to return value in index 3 of any array in 2D array
public String getHouse(int areaNum) {
	
	int i = areaNum;
	
	//switch statement to check which array in 2D array is needed and return value
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


//**************************Methods for determining affordability***********************//

//method to generate message to user if 1 br appt is affordable based on net income
public String affordability1BR(int areaNum, String netWageOutput) {

			//get double values of net income and apartment price
			double netIncome = Double.parseDouble(netWageOutput);
			double oneBRPrice = Double.parseDouble(get1BrAppt(areaNum));
			
			//set limits to determine ranges
			double cannotAfford = oneBRPrice - 100;
			double canAfford = oneBRPrice + 100;
	
			//if else statements to return messages to user about if housing is affordable
			if (netIncome < cannotAfford)
				return "You cannot afford this apartment";
				
			else if (netIncome >= cannotAfford && netIncome <= canAfford)
				return "You may be able to afford this apartment";
			
			else 
				return "You can afford this apartment";
			
}

//method to generate message to user if 2 br appt is affordable based on net income
public String affordability2BR(int areaNum, String netWageOutput) {
	
	//get double values of net income and apartment price
	double netIncome = Double.parseDouble(netWageOutput);
	double twoBRPrice = Double.parseDouble(get2BrAppt(areaNum));
	
	//set limits to determine ranges
	double cannotAfford = twoBRPrice - 100;
	double canAfford = twoBRPrice + 100;

	//if else statements to return messages to user about if housing is affordable
	if (netIncome < cannotAfford)
		return "You cannot afford this apartment";
		
	else if (netIncome >= cannotAfford && netIncome <= canAfford)
		return "You may be able to afford this apartment";
	
	else 
		return "You can afford this apartment";
	
}

}
