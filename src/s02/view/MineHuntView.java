package s02.view;

import s02.controller.CtrlMineHunt;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MineHuntView extends Application {

	// Boxes
	private VBox root = new VBox(20);
	private VBox vgrid = new VBox(30);
	private HBox htitle = new HBox(30);
	private HBox hinfo = new HBox(30);
	private HBox hclick = new HBox(30);
	private HBox herror = new HBox(30);
	private HBox hbutton = new HBox(30);

	// Position des cases
	int px = 0;
	int py = 0;

	// GridPane
	private GridPane grid = new GridPane();

	// Bottom buttons
	Button mines = new Button("Show Mines");
	Button newgame = new Button("New Game");

	// Labels
	Label title = new Label("MINEHUNT");
	Label click = new Label("NB Clicks: ");
	Label error = new Label("NB Errors: ");

	private CtrlMineHunt ctrl;

	public MineHuntView() {
		ctrl = new CtrlMineHunt(this);
	}

	public void start(Stage mainStage) throws Exception {

		// events sur le bouton pour afficher les mines
		mines.setOnMouseClicked(ActionEvent -> {

			showMines();

		});

		// events sur le bouton pour réinitialiser le jeu
		newgame.setOnMouseClicked(ActionEvent -> {

			// réinitialise le jeu
			// init new game
		});

		// Stage
		mainStage.setTitle("MineHunt App");
		mainStage.setMinWidth(500);
		mainStage.setMinHeight(500);
		mainStage.setResizable(true);

		// Appropriation
		root.getChildren().add(htitle);
		root.getChildren().add(hinfo);
		hinfo.getChildren().add(hclick);
		hinfo.getChildren().add(herror);
		root.getChildren().add(vgrid);
		root.getChildren().add(hbutton);

		// Positions
		htitle.setAlignment(Pos.CENTER);
		hinfo.setAlignment(Pos.CENTER);
		hclick.setAlignment(Pos.CENTER_LEFT);
		herror.setAlignment(Pos.CENTER_RIGHT);
		grid.setAlignment(Pos.CENTER);
		hbutton.setAlignment(Pos.BOTTOM_RIGHT);

		// Creation of the grid
		createGrid(10, 10);
		// Space between buttons in the grid
		grid.setHgap(1);
		grid.setVgap(1);

		// background
		Background bgMine = new Background(new BackgroundFill(
				Color.LIGHTYELLOW, CornerRadii.EMPTY, null));
		root.setBackground(bgMine);

		// Police et ajout du text
		title.setFont(Font.font("SansSerif", 44));
		title.setTextFill(Color.RED);

		// Insertion
		htitle.getChildren().add(title);
		hinfo.getChildren().add(click);
		hinfo.getChildren().add(error);
		hbutton.getChildren().add(mines);
		hbutton.getChildren().add(newgame);
		vgrid.getChildren().add(grid);

		// show
		mainStage.setScene(new Scene(root));
		mainStage.show();
	}

	public void setCtrl(CtrlMineHunt ctrl) {
		this.ctrl = ctrl;
	}

	// Create the grid by the parameters
	public void createGrid(int x, int y) {

		// Parcourt selon la taille
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				// By the specification CellButton
				CellButton btn = new CellButton(i, j);
				btn.setMinSize(30, 30);
				// btn.setrouge();
				btn.setOnMouseClicked(event -> {
					if (event.getButton() == MouseButton.PRIMARY) {
						// Click gauche
						leftClickAction(px, py);
					} else if (event.getButton() == MouseButton.SECONDARY) {
						// Click droit
						rightClickAction(px, py);
					}
				});
				// Création de la grille de bouton
				grid.add(btn, i, j);
				// Incrément position y
				py++;
			}
			// Incrémente position x
			px++;
		}

	}

	// Click gauche sur une case
	// si un flag est présent, enlève le flag de la case
	// sinon, met un flag sur la case
	public void leftClickAction(int i, int j) {
		boolean mine = ctrl.open(i, j);
		if (mine) {
			// methode affiche mine sur la case et met � jour le label errors.
		} else {
			int minesNeighbor = ctrl.showNeighborMines(i, j);
			// methode affiche bouton cliqu� avec le nombre de mines voisines ou
			// sans rien si aucune mines.
		}
	}

	// Click droit sur une case
	// si une mine est présent --> ajoute une erreur
	// sinon, affiches les mines voisines
	public void rightClickAction(int i, int j) {
		if (ctrl.containFlag(i, j)) {
			ctrl.setFlag(i, j, false);
			// methode qui enleve l'image du flag du bouton.
		} else {
			ctrl.setFlag(i, j, true);
			// Methode qui met l'image du flag sur le bouton.
		}
	}

	// Affiche l'emplacement des mines
	private void showMines() {

		// xxx
	}

	public void gameOver() {
		// bloque tous les boutons et affiche une alerte indiquant que le jeu
		// est termin�.
	}

}
