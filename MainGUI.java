package application;

import java.lang.String;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class GUI extends Application{

	
	
	public static void main(String[] args) {
	launch(args);
	}
	
	ObservableList<String> list;
	GridPane grid = new GridPane();
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Cost of Living Calculator");
		
 		grid = createGridPane();
 		Button calculate = createCalculateButton();	
 		createCloseButton();
 		ImageView bayAreaMap = createNewMapZone();
 		ChoiceBox<String> areaList = createAreaList();		
		final String mainStyle = "design.css";


		//initializing scene
		Scene scene = new Scene(grid, 1100, 700);
		scene.getStylesheets().add(mainStyle);
		primaryStage.setScene(scene);
		primaryStage.show();
					
		
		//These labels are needed for button action, so cannot be set in a separate method. 
		Label expenseOutputLabel = new Label();
		Label areaOutputLabel = new Label();
		Label oneBRAppOutput = new Label();
		Label oneBRAfford = new Label();
		Label twoBRAppOutput = new Label();
		Label twoBRAfford = new Label();
		Label housePriceOutput = new Label();
		Label grossWageOutput = new Label();
		Label netWageOutput = new Label();
		
		GridPane.setConstraints(expenseOutputLabel, 4, 7);
		GridPane.setConstraints(areaOutputLabel, 4, 9);	
		GridPane.setConstraints(oneBRAppOutput, 3, 13);
		GridPane.setConstraints(oneBRAfford, 3, 14);
		GridPane.setConstraints(twoBRAppOutput, 3, 16);
		GridPane.setConstraints(twoBRAfford, 3, 17);
		GridPane.setConstraints(housePriceOutput, 3, 19);
		GridPane.setConstraints(grossWageOutput, 4, 6);
		GridPane.setConstraints(netWageOutput, 4, 8);

		oneBRAfford.getStyleClass().add("bold");
		twoBRAfford.getStyleClass().add("bold");
		
		//information input fields
		TextField wageInput = new TextField();
		wageInput.setPromptText("$/hr.");
		GridPane.setConstraints(wageInput, 1, 0);
		
		TextField expenseInput = new TextField();
		expenseInput.setPromptText("Expenses in $");
		GridPane.setConstraints(expenseInput, 3, 0);
		
		TextField avgHours = new TextField();
		avgHours.setPromptText("Average hrs./week");
		GridPane.setConstraints(avgHours, 3, 4);
		
		//adding elements to grid pane layout
		grid.getChildren().addAll(wageInput, oneBRAppOutput, grossWageOutput, oneBRAfford, twoBRAppOutput, 
				twoBRAfford, netWageOutput, housePriceOutput,expenseInput, avgHours, bayAreaMap, 
				expenseOutputLabel, areaOutputLabel);
				
		
		
		//Action handler for button to take user input, calculate information, and output it to labels
		calculate.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			
			
			public void handle(ActionEvent event) {
				try {
					
			isDouble(avgHours.getText(), wageInput.getText(), expenseInput.getText());
						
			grossWageOutput.setText("$" + grossMonthlyWage(avgHours.getText(), wageInput.getText()));
			
			netWageOutput.setText("$" + netMonthlyWage(wageInput.getText(), expenseInput.getText(), avgHours.getText()));
			
				}
					catch(NumberFormatException e){
				}
			
				
			//receive choice box input and set as string in output label
			getChoice(areaList);		
			String areaLabel = areaList.getValue();
			areaOutputLabel.setText(areaLabel);
			
			//receive expense input and set as string in output label
			String expenseOutput = expenseInput.getText();
			expenseOutputLabel.setText("$ " + expenseOutput);
			
			//create map object from custom maps class to display map image for chosen area
			Maps obj = new Maps();
			bayAreaMap.setImage(obj.displayMap(areaList));
			
			//get value of choice box as string, get index value of string, 
			//create HousingPrices obj, pass index value to method to retrieve price
			String areaChoiceInput = areaList.getValue();
			
			int areaChoiceValue = list.indexOf(areaChoiceInput);
			
			HousingPrices prices = new HousingPrices();
			oneBRAppOutput.setText("$ " + prices.get1BrAppt(areaChoiceValue));
			twoBRAppOutput.setText("$ " + prices.get2BrAppt(areaChoiceValue));
			housePriceOutput.setText("$ " + prices.getHouse(areaChoiceValue));
			
			String netIncome = netMonthlyWage(wageInput.getText(), expenseInput.getText(), avgHours.getText());

			oneBRAfford.setText(prices.affordability1BR(areaChoiceValue, netIncome));
			twoBRAfford.setText(prices.affordability2BR(areaChoiceValue, netIncome));
			
			
			}});
		
		
		
		//**********Style Elements*********//
		
		
		

		
		
	}
	

	
	//*****************************Methods***************************//



	private ChoiceBox<String> createAreaList() {
ChoiceBox<String> areaChoice = new ChoiceBox<>();
		
		///Create observable list to sort choice box entries		
		list = FXCollections.observableArrayList("Apollo Beach", "Brandon", "Carrollwood", 
				"Lutz", "Northdale", "Oldsmar", 
				"Westchase", "Wesley Chapel", "Plant City", 
				"Thonotosassa", "Town & Country", "Riverview", "Citrus Park", 
				"Westshore", "South Tampa");
		Collections.sort(list);
		areaChoice.setItems(list);
		
		GridPane.setConstraints(areaChoice, 1, 4);
		grid.getChildren().add(areaChoice);
		areaChoice.getStyleClass().add("glass-blue");

		return areaChoice;
		
	}


	private ImageView createNewMapZone() {
		//set base image for page, set constraints
				Image mapTampa = new Image("Base_Tampa_Google_Map.png");
				ImageView pic = new ImageView();
				pic.setImage(mapTampa);
				pic.setFitHeight(400);
				pic.setFitWidth(400);
				GridPane.setConstraints(pic, 0 ,8);
				GridPane.setRowSpan(pic, 13);
				GridPane.setColumnSpan(pic, 4);
				return pic;
	}



	private Button createCalculateButton() {
		Button calculate = new Button("Calculate");
		GridPane.setConstraints(calculate, 2, 6);
		grid.getChildren().add(calculate);
		calculate.getStyleClass().addAll("bold", "glass-blue");
		
		return calculate;
	}
	
	
	private Button createCloseButton() {
		Button close = new Button("Close");
		GridPane.setConstraints(close, 4, 0);
		grid.getChildren().add(close);
		close.getStyleClass().addAll("bold", "glass-blue");
		close.setOnAction(e -> {
				Platform.exit();
			});
		
		return close;
	}



	//method to validate input is double for wages and expenses
	private boolean isDouble(String avgHours, String wageInput, String expenseInput) {
		try {
			Double.parseDouble(avgHours);
			Double.parseDouble(wageInput);
			Double.parseDouble(expenseInput);
			
			return true;
		}catch(NumberFormatException e){
			AlertBox.display("Number Error","Please enter a valid number.");
			return false;
		}
		
		
	}
	
	//method to retrieve user choice from choice box menu
	private void getChoice(ChoiceBox<String> areaChoice) {
		areaChoice.getValue();
		
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
		double costs = Double.parseDouble(expenseInput);

		
		double weeklyWage = wage * hours; 
		double monthlyWage = weeklyWage * 4;
		double netMonthly = monthlyWage - costs;
		
		String netMonthlyOutput = String.valueOf(netMonthly);
				
		return netMonthlyOutput;
	}
	
	
	private GridPane createGridPane() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(10);
		
//		Button calculate = createCalculateButton();				
 		Button close = createCloseButton();
 		ChoiceBox<String> areaList = createAreaList();		
		
		Label hourlyWage = new Label("Hourly Wage*:");
		Label expenses = new Label("Monthly Expenses*:");
		Label areaLabel = new Label("Area:");		
		Label hours = new Label("Avg. weekly hours*:");
		Label requiredInput = new Label("*required information");
		Label oneBRAppPriceText = new Label("Median price for 1 BR Appt:");		
		Label monthlyExpenseText = new Label("Monthly Expenses:");
		Label areaOutputText = new Label("Area:");		
		Label netWageText = new Label("Net Income:");		
		Label wageTextLabel = new Label("Monthly Wages:");
		Label housePriceText = new Label("Median price for house:");
		Label twoBRAppPriceText = new Label("Median price for 2 BR Appt:");	
		
		Label twoBRAppOutput = new Label();
		Label twoBRAfford = new Label();
		Label housePriceOutput = new Label();	
		Label oneBRAfford = new Label();
		Label oneBRAppOutput = new Label();
		Label netWageOutput = new Label();
		Label areaOutputLabel = new Label();		
		Label expenseOutputLabel = new Label();
		
		GridPane.setConstraints(expenseOutputLabel, 4, 7);
		GridPane.setConstraints(areaOutputLabel, 4, 9);	
		GridPane.setConstraints(oneBRAppOutput, 3, 13);
		GridPane.setConstraints(oneBRAfford, 3, 14);
		GridPane.setConstraints(twoBRAppPriceText, 3, 15);
		GridPane.setConstraints(twoBRAppOutput, 3, 16);
		GridPane.setConstraints(twoBRAfford, 3, 17);
		GridPane.setConstraints(housePriceText, 3, 18);
		GridPane.setConstraints(housePriceOutput, 3, 19);
		GridPane.setConstraints(wageTextLabel, 3, 6);
		GridPane.setConstraints(hours, 2, 4);
		GridPane.setConstraints(hourlyWage, 0, 0);
		GridPane.setConstraints(expenses, 2, 0);
		GridPane.setConstraints(areaLabel, 0, 4);
		GridPane.setConstraints(requiredInput, 2, 5);
		GridPane.setConstraints(expenseOutputLabel, 4, 7);
		GridPane.setConstraints(monthlyExpenseText, 3, 7);
		GridPane.setConstraints(areaOutputText, 3, 9);
		GridPane.setConstraints(areaOutputLabel, 4, 9);	
		GridPane.setConstraints(oneBRAppPriceText, 3,12 );	
		GridPane.setConstraints(netWageText, 3, 8);
		
		netWageText.getStyleClass().add("underline");	
		hourlyWage.getStyleClass().add("underline");
		expenses.getStyleClass().add("underline");
		areaLabel.getStyleClass().add("underline");
		hours.getStyleClass().add("underline");	
		monthlyExpenseText.getStyleClass().add("underline");	
		areaOutputText.getStyleClass().add("underline");
		oneBRAppPriceText.getStyleClass().add("underline");
		wageTextLabel.getStyleClass().add("underline");
		twoBRAppPriceText.getStyleClass().add("underline");	
		housePriceText.getStyleClass().add("underline");	
		
		
	
		grid.getChildren().addAll(hourlyWage, oneBRAppPriceText, close, areaList, twoBRAppPriceText, housePriceText, oneBRAppOutput, 
				twoBRAppOutput, housePriceOutput,netWageOutput, wageTextLabel, 
				netWageText, expenses, areaLabel, hours, requiredInput, monthlyExpenseText, 
				areaOutputText, areaOutputLabel);
		
		return grid;
	}
	
	
	
}











	


