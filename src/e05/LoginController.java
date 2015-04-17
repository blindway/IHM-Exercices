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
			box.setTitle("Authentification avec succ�s");
			box.setHeaderText("Authentification r�ussie!");
			box.setContentText("Vous �tes d�s � pr�sent connect�.");
			box.showAndWait();

			result.setText("Login avec succ�s!");
			result.setTextFill(Color.GREEN);
		} else {
			Alert mBox = new Alert(AlertType.ERROR);
			mBox.setTitle("Erreur d'authentification");
			mBox.setHeaderText("Authentification �rron�e!");
			mBox.setContentText("Vos informations d'authentification sont incorrectes.");
			mBox.showAndWait();

			result.setText("Login �ronn�");
			result.setTextFill(Color.RED);
		}
	}

	@FXML
	private void handleCancelButton(ActionEvent event) {
		Platform.exit();
	}

}
