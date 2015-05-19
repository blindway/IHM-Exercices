package s03;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class PastisControler {

	PastisModel mdl = new PastisModel();

	@FXML
	private TextField longueur;
	@FXML
	private CheckBox majuscules;
	@FXML
	private CheckBox minuscules;
	@FXML
	private CheckBox chiffres;
	@FXML
	private CheckBox charSpec;
	@FXML
	private CheckBox pronon;
	@FXML
	private CheckBox charAmbigus;
	@FXML
	private Button generate;
	@FXML
	private TextField password;

	@FXML
	public void handleGenerateButton() {
		mdl.setLength(Integer.valueOf(longueur.getText()));
		mdl.setLcLetters(minuscules.isSelected());
		mdl.setUcLetters(majuscules.isSelected());
		mdl.setDigits(chiffres.isSelected());
		mdl.setSymbols(charSpec.isSelected());
		mdl.setPronounceable(pronon.isSelected());
		mdl.setUnAmbiguous(charAmbigus.isSelected());
		password.setText(mdl.getNewPassword());
	}

}
