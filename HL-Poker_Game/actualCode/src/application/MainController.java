package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.fxml.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainController implements EventHandler<ActionEvent>{
	private Scene scene2;
	private Scene scene3;
   
	@FXML
	private Button Play;
	@FXML
	private Button Exit;
	@FXML
	private Button Credits;
	
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("view/PlayPage.fxml"));
		Parent root2 = loader2.load();
	    scene2 = new Scene(root2, 800, 800);
		FXMLLoader loader3 = new FXMLLoader(getClass().getResource("view/CreditsPage.fxml"));
		Parent root3 = loader3.load();
		scene3 = new Scene(root3, 800, 800);
		Play.setOnAction(this);
		Exit.setOnAction(this);
		Credits.setOnAction(this);
	}

	@Override
	public void handle(ActionEvent event) {
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		// TODO Auto-generated method stub
		if(event.getSource() == Play) {
			window.setScene(scene2);
			window.show();
		}
		if(event.getSource() == Exit) {
			window.close();
		}
		if(event.getSource() == Credits) {
			window.setScene(scene3);
			window.show();
		}
	}


}
