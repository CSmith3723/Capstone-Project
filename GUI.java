package application;

import java.lang.String;
import java.util.Collections;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class GUI extends Application{

	
	
	public static void main(String[] args) {
	launch(args);
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Cost of Living Calculator");
		
		final String mainStyle = "design.css";
		
		//setting GridPane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		//User input labels
		Label hourlyWage = new Label("Hourly Wage*:");
		Label expenses = new Label("Monthly Expenses*:");
		Label areaLabel = new Label("Area:");		
		Label hours = new Label("Avg. hours worked*:");
		Label requiredInput = new Label("*required information");
		//Setting output labels
		
		Label wageTextLabel = new Label("Monthly Wages:");
		Label monthlyExpenseLabel = new Label("Monthly Expenses:");
		Label expenseOutputLabel = new Label();
		Label grossWageOutput = new Label();
		Label areaOutputText = new Label("Area:");
		Label areaOutputLabel = new Label();
		Label incomeTextLabel = new Label("Net Income:");
		Label netWageOutput = new Label();
		Label oneBRAppPriceText = new Label("Median price for 1 BR Appt:");
		Label twoBRAppPriceText = new Label("Median price for 2 BR Appt:");
		Label housePriceText = new Label("Median price for house:");
		Label oneBRAppOutput = new Label();
		Label twoBRAppOutput = new Label();
		Label housePriceOutput = new Label();
		
		//button to calculate inputs
		Button calculate = new Button("Calculate");	
			
		//button to close program
		Button close = new Button("Close");
		close.setOnAction(e -> {
			Platform.exit();
		});
		
		
		//information input fields
		TextField wageInput = new TextField();
		wageInput.setPromptText("$/hr.");
		TextField expenseInput = new TextField();
		expenseInput.setPromptText("Expenses in $");
		TextField avgHours = new TextField();
		avgHours.setPromptText("Average hrs./week");
		
		//area ChoiceBox
		ChoiceBox<String> areaChoice = new ChoiceBox<>();
		
		//Create observable list to sort choice box entries		
		ObservableList<String> list = FXCollections.observableArrayList("Apollo Beach", "Brandon", "Carrollwood", 
				"Lutz", "Northdale", "Oldsmar", 
				"Westchase", "Wesley Chapel", "Plant City", 
				"Thonotosassa", "Town & Country", "Riverview", "Citrus Park", 
				"Westshore", "South Tampa");
		Collections.sort(list);
		areaChoice.setItems(list);
		
		
		
		//set base image for page, set constraints
		Image mapTampa = new Image("Base_Tampa_Google_Map.png");
		ImageView pic = new ImageView();
		pic.setImage(mapTampa);
		pic.setFitHeight(400);
		pic.setFitWidth(400);
		GridPane.setConstraints(pic, 0 ,8);
		GridPane.setRowSpan(pic, 13);
		GridPane.setColumnSpan(pic, 4);
		
		
		//Action handler for taking user input and outputting it to labels
		calculate.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				try {
			
			//validate input is double, get double as string
			isDouble(avgHours,avgHours.getText());
			isDouble(wageInput, wageInput.getText());
			isDouble(expenseInput, expenseInput.getText());
			
			//output received text into label 
			grossWageOutput.setText(grossMonthlyWage(wageInput.getText(), avgHours.getText()));
			netWageOutput.setText(netMonthlyWage(wageInput.getText(), expenseInput.getText(), avgHours.getText()));
				}
					catch(NumberFormatException e){
				}
			
			//receive choice box input and set as string in output label
			getChoice(areaChoice);		
			String areaLabel = areaChoice.getValue();
			areaOutputLabel.setText(areaLabel);
			
			//receive expense input and set as string in output label
			String expenseOutput = expenseInput.getText();
			expenseOutputLabel.setText(expenseOutput);
			
			//create map object from custom maps class to display map image for chosen area
			Maps obj = new Maps();
			pic.setImage(obj.displayMap(areaChoice));
			
			//get value of choice box as string, get index value of string, 
			//create HousingPrices obj, pass index value to method to retrieve price
			String areaChoiceInput = areaChoice.getValue();
			int areaChoiceValue = list.indexOf(areaChoiceInput);
			HousingPrices prices = new HousingPrices();
			oneBRAppOutput.setText(prices.get1BrAppt(areaChoiceValue));
			twoBRAppOutput.setText(prices.get2BrAppt(areaChoiceValue));
			housePriceOutput.setText(prices.getHouse(areaChoiceValue));
			}});
		
		
		//grid pane constraints
		GridPane.setConstraints(wageInput, 1, 0);
		GridPane.setConstraints(expenseInput, 3, 0);
		GridPane.setConstraints(areaChoice, 1, 4);
		GridPane.setConstraints(hours, 2, 4);

		//Grid Pane constraints for output labels
		GridPane.setConstraints(hourlyWage, 0, 0);
		GridPane.setConstraints(expenses, 2, 0);
		GridPane.setConstraints(areaLabel, 0, 4);
		GridPane.setConstraints(requiredInput, 2, 5);
		GridPane.setConstraints(avgHours, 3, 4);
		GridPane.setConstraints(wageTextLabel, 3, 6);
		GridPane.setConstraints(grossWageOutput, 4, 6);
		GridPane.setConstraints(netWageOutput, 4, 8);
		GridPane.setConstraints(incomeTextLabel, 3, 8);
		GridPane.setConstraints(expenseOutputLabel, 4, 7);
		GridPane.setConstraints(monthlyExpenseLabel, 3, 7);
		GridPane.setConstraints(areaOutputText, 3, 9);
		GridPane.setConstraints(areaOutputLabel, 4, 9);		
		GridPane.setConstraints(oneBRAppPriceText, 3,12 );	
		GridPane.setConstraints(oneBRAppOutput, 3, 13);
		GridPane.setConstraints(twoBRAppPriceText, 3, 14);
		GridPane.setConstraints(twoBRAppOutput, 3, 15);
		GridPane.setConstraints(housePriceText, 3, 16);
		GridPane.setConstraints(housePriceOutput, 3, 17);
				
		
		//grid constraints for buttons
		GridPane.setConstraints(calculate, 2, 6);
		GridPane.setConstraints(close, 4, 0);
		
		//adding elements to grid pane layout
		grid.getChildren().addAll(hourlyWage, wageInput, expenses, expenseInput,areaLabel,areaChoice, calculate, 
				grossWageOutput, expenseOutputLabel, wageTextLabel, monthlyExpenseLabel, areaOutputText, 
				hours, avgHours, incomeTextLabel, areaOutputLabel, netWageOutput, pic, oneBRAppPriceText, 
				twoBRAppPriceText, housePriceText, oneBRAppOutput, twoBRAppOutput, housePriceOutput, requiredInput, close);
		
		//initializing scene
		Scene scene = new Scene(grid, 1000, 650);
		scene.getStylesheets().add(mainStyle);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	
	//method to validate input is double for wages and expenses
	private boolean isDouble(TextField input, String message) {
		try {
			double amount = Double.parseDouble(message);
			System.out.println(amount);
			return true;
		}catch(NumberFormatException e){
			AlertBox.display("Number Error","Please enter a valid number.");
			return false;
		}
	}
	
	//method to retrieve user choice from choice box menu
	private void getChoice(ChoiceBox<String> areaChoice) {
		String input =  areaChoice.getValue();
		System.out.println(input);
	}
	
	private String grossMonthlyWage(String wageInput, String avgHours) {
		double wage = Double.parseDouble(wageInput);
		double hours = Double.parseDouble(avgHours);
		
		double monthlyWage = (wage * hours) * 4;
		String grossMonthlyWage = String.valueOf(monthlyWage);
		return grossMonthlyWage;
	}
	
	private String netMonthlyWage(String wageInput, String expenseInput, String avgHours) {
		double wage = Double.parseDouble(wageInput);
		double hours = Double.parseDouble(avgHours);
		double weeklyWage = wage * hours; 
		double monthlyWage = weeklyWage * 4;
		double costs = Double.parseDouble(expenseInput);
		
		double netMonthly = monthlyWage - costs;
		String netMonthlyOutput = String.valueOf(netMonthly);
		return netMonthlyOutput;
	}
	
}












	


