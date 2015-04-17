package e05;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;

public class LoginController {

	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button login;
	@FXML
	private Button cancel;
	@FXML
	private Label result;

	@FXML
	private void handleLoginButton(ActionEvent event) {
		if ((username.getText().equals("admin"))
				&& (password.getText().equals("admin"))) {
			Alert box = new Alert(AlertType.INFORMATION);
			box.setTitle("Authentification avec succès");
			box.setHeaderText("Authentification réussie!");
			box.setContentText("Vous êtes dès à présent connecté.");
			box.showAndWait();

			result.setText("Login avec succès!");
			result.setTextFill(Color.GREEN);
		} else {
			Alert mBox = new Alert(AlertType.ERROR);
			mBox.setTitle("Erreur d'authentification");
			mBox.setHeaderText("Authentification érronée!");
			mBox.setContentText("Vos informations d'authentification sont incorrectes.");
			mBox.showAndWait();

			result.setText("Login éronné");
			result.setTextFill(Color.RED);
		}
	}

	@FXML
	private void handleCancelButton(ActionEvent event) {
		Platform.exit();
	}

}
