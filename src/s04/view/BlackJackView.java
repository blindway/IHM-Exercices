package s04.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import s04.controller.BlackJackCtrl;

public class BlackJackView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BlackJackCtrl ctrl = new BlackJackCtrl();
		ctrl.initModel();
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

	public static void main(String[] args) {

		Application.launch(args);

	}

}
