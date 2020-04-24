package application;

import javafx.application.Application;


import javafx.stage.*;
import javafx.scene.*;
//import javafx.scene.control.*;
import javafx.fxml.*;
//import javafx.fxml.FXML;

public class Main extends Application {
	//@FXML
	//Button Play;
	//@FXML
	//Button Exit;
	//@FXML
	//Button Credits;

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainPage.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
