package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

	public static void display(String title, String message) {
		
		Stage errorWindow = new Stage();
		
		errorWindow.initModality(Modality.APPLICATION_MODAL);
		
		errorWindow.setTitle(title);
		errorWindow.setMinWidth(100);
		
		Label errorLabel = new Label();
		
		errorLabel.setText(message);
		
		Button closeButton = new Button("Close");
		
		closeButton.setOnAction(e -> errorWindow.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(errorLabel, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		errorWindow.setScene(scene);
		errorWindow.showAndWait();
			
		
	}

}
