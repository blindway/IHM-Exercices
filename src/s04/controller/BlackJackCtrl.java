package s04.controller;

import s04.model.BlackJackModel;
import s04.model.Card;
import s04.view.BlackJackView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlackJackCtrl {
	BlackJackView view;
	BlackJackModel model;

	@FXML
	private ImageView imgCarteC1;

	@FXML
	private ImageView imgCarteJ1;

	@FXML
	private Label lblValMainC;

	@FXML
	private Label lblValMainJ;

	@FXML
	private ImageView imgCarteJ2;

	@FXML
	private ImageView imgCarteC2;

	@FXML
	private ImageView imgCarteC3;

	@FXML
	private ImageView imgCarteJ3;

	@FXML
	private ImageView imgCarteC4;

	@FXML
	private ImageView imgCarteJ4;

	@FXML
	private ImageView imgCarteC5;

	@FXML
	private ImageView imgCarteJ5;

	@FXML
	private Label lblMPerdues;

	@FXML
	private Label lblMGagnees;

	@FXML
	private Label lblSolde;

	@FXML
	private Label lblArgMise;

	@FXML
	private Label lblInfo;

	@FXML
	private Button btn5;

	@FXML
	private Button btn10;

	@FXML
	private Button btn25;

	@FXML
	private Button btn50;

	@FXML
	private Button btn100;

	@FXML
	private Button btnCarte;

	@FXML
	private Button btnDoubler;

	@FXML
	private Button btnRester;

	private int countCartesJ;
	private int countCartesC;
	public int valMainC;
	public int valMainJ;

	public BlackJackCtrl() {
		model = new BlackJackModel(this);
		lblSolde = new Label("0");
		lblArgMise = new Label("0");
		lblMGagnees = new Label("0");
		lblMPerdues = new Label("0");
		lblValMainC = new Label("Valeur Main");
		lblValMainJ = new Label("Valeur Main");
		lblInfo = new Label("");
		imgCarteC1 = new ImageView();
		imgCarteC2 = new ImageView();
		imgCarteC3 = new ImageView();
		imgCarteC4 = new ImageView();
		imgCarteC5 = new ImageView();
		imgCarteJ1 = new ImageView();
		imgCarteJ2 = new ImageView();
		imgCarteJ3 = new ImageView();
		imgCarteJ4 = new ImageView();
		imgCarteJ5 = new ImageView();
		btn10 = new Button();
		btn100 = new Button();
		btn25 = new Button();
		btn5 = new Button();
		btn50 = new Button();
		btnCarte = new Button();
		btnDoubler = new Button();
		btnRester = new Button();
		countCartesC = 0;
		countCartesJ = 0;
		startBlackJack();
	}

	public void startBlackJack() {
		model.startGame();
	}

	public void popUpMisez() {
		// TODO FINIR ICI
		// popup qui dit qu'il faut miser pour jouer.
	}

	@FXML
	void handleRecommencerButton() {
		model.restart();
	}

	@FXML
	void handleReglesButton(ActionEvent event) {

		System.out.println("aaa");
	}

	@FXML
	void handleCarteButton(ActionEvent event) {
		model.actionJoueur();
		model.setMise(Integer.valueOf(lblArgMise.getText()));
	}

	@FXML
	void handleDoublerButton() {
		model.actionJoueur();
		model.setMiseDouble(Integer.valueOf(lblArgMise.getText()));
	}

	@FXML
	void handleResterButton() {
		model.actionCroupier();
	}

	@FXML
	void handle5Button() {
		int result = Integer.valueOf(getLblArgMise()) + 5;
		if (!checkSolde(result)) {
			result = Integer.valueOf(getLblSolde());
		}
		setLblArgMise(String.valueOf(result));
	}

	@FXML
	void handle10Button() {
		int result = Integer.valueOf(getLblArgMise()) + 10;
		if (!checkSolde(result)) {
			result = Integer.valueOf(getLblSolde());
		}
		setLblArgMise(String.valueOf(result));
	}

	@FXML
	void handle25Button() {
		int result = Integer.valueOf(getLblArgMise()) + 25;
		if (!checkSolde(result)) {
			result = Integer.valueOf(getLblSolde());
		}
		setLblArgMise(String.valueOf(result));
	}

	@FXML
	void handle50Button() {
		int result = Integer.valueOf(getLblArgMise()) + 50;
		if (!checkSolde(result)) {
			result = Integer.valueOf(getLblSolde());
		}
		setLblArgMise(String.valueOf(result));
	}

	@FXML
	void handle100Button() {
		int result = Integer.valueOf(getLblArgMise()) + 100;
		if (!checkSolde(result)) {
			result = Integer.valueOf(getLblSolde());
		}
		setLblArgMise(String.valueOf(result));
	}

	boolean checkSolde(int value) {
		boolean result = false;
		if (Integer.valueOf(getLblSolde()) >= value) {
			result = true;
		}
		return result;
	}

	public void addCarteJoueur(Card card) {
		countCartesJ++;
		Image img;
		switch (countCartesJ) {
		case 1:
			img = new Image(card.getImagePath());
			imgCarteJ1.setImage(img);
			break;
		case 2:
			img = new Image(card.getImagePath());
			imgCarteJ2.setImage(img);
			break;
		case 3:
			img = new Image(card.getImagePath());
			imgCarteJ3.setImage(img);
			break;
		case 4:
			img = new Image(card.getImagePath());
			imgCarteJ4.setImage(img);
			break;
		case 5:
			img = new Image(card.getImagePath());
			imgCarteJ5.setImage(img);
			break;
		}
	}

	public void addCardCroupier(Card card) {
		Image img;
		switch (countCartesC) {
		case 0:
			img = new Image(card.getImagePath());
			imgCarteC1.setImage(img);
			break;
		case 1:
			img = new Image(card.getImagePath());
			imgCarteC2.setImage(img);
			break;
		case 2:
			img = new Image(card.getImagePath());
			imgCarteC3.setImage(img);
			break;
		case 3:
			img = new Image(card.getImagePath());
			imgCarteC4.setImage(img);
			break;
		case 4:
			img = new Image(card.getImagePath());
			imgCarteC5.setImage(img);
			break;
		}
		countCartesC++;
	}

	public void cleanImgCards() {
		imgCarteC1.setImage(null);
		imgCarteC2.setImage(null);
		imgCarteC3.setImage(null);
		imgCarteC4.setImage(null);
		imgCarteC5.setImage(null);
		imgCarteJ1.setImage(null);
		imgCarteJ2.setImage(null);
		imgCarteJ3.setImage(null);
		imgCarteJ4.setImage(null);
		imgCarteJ5.setImage(null);
		lblValMainC.setText("0");
		lblValMainJ.setText("0");
		valMainC = 0;
		valMainJ = 0;
		countCartesC = 0;
		countCartesJ = 0;
		lblArgMise.setText("0");
		degriseMise();
	}

	public void griseMise() {
		btn5.setDisable(true);
		btn10.setDisable(true);
		btn25.setDisable(true);
		btn50.setDisable(true);
		btn100.setDisable(true);
	}

	public void griseAll() {
		griseMise();
		btnCarte.setDisable(true);
		btnDoubler.setDisable(true);
		btnRester.setDisable(true);
	}

	public void degriseMise() {
		btn5.setDisable(false);
		btn10.setDisable(false);
		btn25.setDisable(false);
		btn50.setDisable(false);
		btn100.setDisable(false);
	}

	public void degriseAll() {
		degriseMise();
		btnCarte.setDisable(false);
		btnDoubler.setDisable(false);
		btnRester.setDisable(false);
	}

	public void setImgCarteC1(ImageView imgCarteC1) {
		this.imgCarteC1 = imgCarteC1;
	}

	public void setImgCarteJ1(ImageView imgCarteJ1) {
		this.imgCarteJ1 = imgCarteJ1;
	}

	public void setLblValMainC(String valMainC) {
		lblValMainC.setText(valMainC);
	}

	public void setLblValMainJ(String valMainJ) {
		lblValMainJ.setText(valMainJ);
	}

	public void setImgCarteJ2(ImageView imgCarteJ2) {
		this.imgCarteJ2 = imgCarteJ2;
	}

	public void setImgCarteC2(ImageView imgCarteC2) {
		this.imgCarteC2 = imgCarteC2;
	}

	public void setImgCarteC3(ImageView imgCarteC3) {
		this.imgCarteC3 = imgCarteC3;
	}

	public void setImgCarteJ3(ImageView imgCarteJ3) {
		this.imgCarteJ3 = imgCarteJ3;
	}

	public void setImgCarteC4(ImageView imgCarteC4) {
		this.imgCarteC4 = imgCarteC4;
	}

	public void setImgCarteJ4(ImageView imgCarteJ4) {
		this.imgCarteJ4 = imgCarteJ4;
	}

	public void setImgCarteC5(ImageView imgCarteC5) {
		this.imgCarteC5 = imgCarteC5;
	}

	public void setImgCarteJ5(ImageView imgCarteJ5) {
		this.imgCarteJ5 = imgCarteJ5;
	}

	public void setLblMPerdues(String mPerdues) {
		lblMPerdues.setText(mPerdues);
	}

	public void setLblMGagnees(String mGagnees) {
		lblMGagnees.setText(mGagnees);
	}

	public void setLblSolde(String solde) {
		lblSolde.setText(solde);
	}

	public void setLblArgMise(String argMise) {
		lblArgMise.setText(argMise);
	}

	public void setLblInfo(String info) {
		lblArgMise.setText(info);
	}

	public String getLblArgMise() {
		return lblArgMise.getText();
	}

	public String getLblSolde() {
		return lblSolde.getText();
	}

}
