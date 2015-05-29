package s04.view;

import s04.controller.BlackJackCtrl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BlackJackView extends Application{
	
	BlackJackCtrl ctrl = new BlackJackCtrl();

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BlackJackView.fxml"));
		BorderPane root = loader.load();
		loader.setController(ctrl);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("BlackJack");
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
