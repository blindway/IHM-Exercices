package s03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class PastisView extends Application {
	
	PastisControler ctrl = new PastisControler();
	IPastisModel mdl = new PastisModel();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PastisView.fxml"));
		BorderPane root = loader.load();
		loader.setController(ctrl);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Boeuf");
	}

	public static void main(String[] args) {
		Application.launch(args);
		
		
	}
	
}
