package s02.view;

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

	// GridPane
	private GridPane grid = new GridPane();

	// Bottom buttons
	Button mines = new Button("Show Mines");
	Button newgame = new Button("New Game");

	// Labels
	Label title = new Label("MINEHUNT");
	Label click = new Label("NB Clicks: ");
	Label error = new Label("NB Errors: ");

	public void start(Stage mainStage) throws Exception {

		// events
		mines.setOnMouseClicked(ActionEvent -> {

			showMines();

		});

		// events
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

		// boeuf
		mainStage.setScene(new Scene(root));
		mainStage.show();
	}

	// Create the grid by the parameters
	public void createGrid(int x, int y) {

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				// By the specification CellButton
				CellButton btn = new CellButton(i, j);
				btn.setMinSize(30, 30);
				// btn.setrouge();
				btn.setOnMouseClicked(event -> {
					if (event.getButton() == MouseButton.PRIMARY) {
						//leftClickAction(i, j); //wtfff
					} else if (event.getButton() == MouseButton.SECONDARY) {
						//rightClickAction(i, j);
					}
				});

				grid.add(btn, i, j);
			}
		}

	}

	//Click gauche sur une case
	public void leftClickAction(int i, int j) {

		// si un flag est présent, enlève le flag de la case
		// sinon, met un flag sur la case
	}

	//Click droit sur une case
	public void rightClickAction(int i, int j) {

		// si une mine est présente...

		// si rien n'est présent

	}

	// Affiche l'emplacement des mines
	private void showMines() {

	}

}
