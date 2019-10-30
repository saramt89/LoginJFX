package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		
		try {
			
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("loginCherry.fxml"));
            AnchorPane pane=loader.load();
            Scene scene=new Scene(pane);
            scene.getStylesheets().addAll(Main.class.getResource("application.css").toExternalForm());
            stage.setTitle("signin");
            stage.setScene(scene);
            stage.show();			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
