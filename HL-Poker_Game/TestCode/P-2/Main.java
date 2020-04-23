package application;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

	private Image applicationIcon;
	private Engl main;
	private Fran fran;
	private Stage verification;
	private Pane root2, root1;
	private Label risk, language;
	private Scene scene;
	private Rectangle2D bounds;
	private Button anglais, french, yes, non;

	@Override
	public void start(Stage primaryStage) {

		// Déclaration de multiples variables importantes
		main = new Engl();
		fran = new Fran();
		verification = new Stage();
		root2 = new Pane();
		root1 = new Pane();

		// Button anglais
		anglais = new Button("Anglais");
		anglais.setLayoutY(80);
		anglais.setLayoutX(135);
		anglais.setOnAction(e -> {
			primaryStage.close();
			verification.show();
		});

		// Button français
		french = new Button("Français");
		french.setLayoutY(80);
		french.setLayoutX(30);
		french.setOnAction(e -> {
			fran.start(primaryStage);
			verification.close();
		});

		// 'Label' de risque
		risk = new Label("Veux-tu vraiment\nrisquer la chance\nde perdre ton\nfrançais??");
		risk.setLayoutX(15);

		// Button oui
		yes = new Button("yes");
		yes.setOnAction(e -> {
			main.start(primaryStage);
			verification.close();
		});
		yes.setLayoutX(30);
		yes.setLayoutY(145);

		// Button non
		non = new Button("NON!");
		non.setOnAction(e -> {
			verification.close();
			anglais.setDisable(true);
			primaryStage.show();
		});
		non.setLayoutX(135);
		non.setLayoutY(135);

		// Création de la page de vérification
		root2.getChildren().addAll(risk, yes, non);
		verification.setTitle("NON!");
		verification.setScene(new Scene(root2, 230, 190));

		// 'Label' du titre sur la page principale
		language = new Label("Choisissez votre langue");
		language.setLayoutY(20);
		language.setLayoutX(8);

		// Mets l'icon de l'application
		applicationIcon = new Image(getClass().getResourceAsStream("poker.png"));
		primaryStage.getIcons().add(applicationIcon);

		// Lien du CSS pour l'application && définie les 'ID' pour les objets
		Application.setUserAgentStylesheet(getClass().getResource("application.css").toExternalForm());
		yes.setId("no");
		language.setId("lang1");
		risk.setId("ahh");
		root2.setId("back");
		root1.setId("back");
		
		// Création de la page principale
		root1.getChildren().addAll(language, french, anglais);
		scene = new Scene(root1, 230, 140);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Poker");
		primaryStage.setResizable(false);
		primaryStage.show();

		// 'Stage' vais être toujours centré
		bounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX((bounds.getWidth() - primaryStage.getWidth()) / 2);
		primaryStage.setY((bounds.getHeight() - primaryStage.getHeight()) / 2);
		verification.setX((bounds.getWidth() - primaryStage.getWidth()) / 2);
		verification.setY((bounds.getHeight() - primaryStage.getHeight()) / 2);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
