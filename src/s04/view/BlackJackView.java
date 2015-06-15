package s04.view;

import s02.controller.CtrlMineHunt;
import s04.controller.BlackJackCtrl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BlackJackView extends Application {

	static BlackJackCtrl ctrl;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(
				"BlackJackView.fxml"));
		Pane root = loader.load();
		loader.setController(ctrl);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);

		primaryStage.setResizable(false);
		primaryStage.setTitle("BlackJack");
		primaryStage.getIcons().add(new Image("s04/view/img/pico.png"));

		primaryStage.show();

	}

	public void showRules(){
		System.out.println("hello");
	}
	
	
	public static void main(String[] args) {
		
		Application.launch(args);
		
		
	}

}
