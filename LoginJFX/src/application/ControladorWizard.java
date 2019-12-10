package application;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ControladorWizard {
	
	@FXML
	private AnchorPane pane1;

	@FXML
	private AnchorPane pane2;

	@FXML
	private AnchorPane pane3;
	
	@FXML
	private AnchorPane pane4;

	@FXML
	private Label countlable;
	
	@FXML
	AnchorPane rootPane;
	
	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	public void initialize() {
		translateAnimation(0.1, pane2, 900);
		translateAnimation(0.1, pane3, 900);
		translateAnimation(0.1, pane4, 900);
	}

	int showSlide = 0;

	@FXML
	void nextAction() {

		if (showSlide == 0) {
			translateAnimation(0.5, pane2, -900);
			showSlide++; // showSlide=1
			countlable.setText("2/4");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane3, -900);
			showSlide++; // showSlide=2
			countlable.setText("3/4");
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane4, -900);
			showSlide++; // showSlide=2
			countlable.setText("4/4");
		} else {
			System.out.println("No more slides");
		}

	}

	@FXML
	void backAction() {

		if (showSlide == 0) {
			System.out.println("No more slides");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 900);
			showSlide--; // showSlide=0
			countlable.setText("1/4");
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 900);
			showSlide--; // showSlide=1
			countlable.setText("2/4");
		} else if (showSlide == 3) {
			translateAnimation(0.5, pane4, 900);
			showSlide--; // showSlide=2
			countlable.setText("3/4");
		}
	}
	
	@FXML
	private void cerrarVentana() {
		Stage thisStage = (Stage) rootPane.getScene().getWindow();
	    thisStage.close();	
	}
	
	@FXML
	public void showLogin() {
		try {
			cerrarVentana();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("loginCherry.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage homeStage = new Stage();
			homeStage.setTitle("Login");
			Scene scene = new Scene(page);
			homeStage.setScene(scene);
			homeStage.initStyle(StageStyle.UNDECORATED);
			homeStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
