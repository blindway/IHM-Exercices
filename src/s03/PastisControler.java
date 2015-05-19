package s03;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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
	private ProgressBar robust;
	@FXML
	private Tooltip tooltip;

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
		robuste(password.getText().length());
		
	}
	public void robuste(int longueur){
		if (longueur < 5){
			robust.setProgress(0.25);
		}else if(longueur >=5 && longueur < 8){
			robust.setProgress(0.5);
		}else if(longueur >=8 && longueur < 10){
			robust.setProgress(0.75);
		}else if(longueur >10 ){
			robust.setProgress(1.0);
		}
	}
}
