package application;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.fxml.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainController extends Application implements EventHandler<ActionEvent>{
	private Scene scene2;
	private Scene scene3;
    private Stage primaryStage;
	@FXML
	Button Play;
	@FXML
	Button Exit;
	@FXML
	Button Credits;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("view/PlayPage.fxml"));
		Parent root2 = loader2.load();
	    scene2 = new Scene(root2, 800, 800);
		FXMLLoader loader3 = new FXMLLoader(getClass().getResource("view/CreditsPage.fxml"));
		Parent root3 = loader3.load();
		scene3 = new Scene(root3, 800, 800);
	}

	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub
/*
		Play.setOnAction(e -> primaryStage.setScene(scene2));
		Credits.setOnAction(e -> primaryStage.setScene(scene3));
		Exit.setOnAction(e -> primaryStage.close());*/
	}


}
