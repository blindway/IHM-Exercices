package s02.controller;

import s02.model.MineHuntModel;
import s02.view.MineHuntView;

public class CtrlMineHunt {

	private MineHuntView view;
	private MineHuntModel model;

	public CtrlMineHunt(MineHuntView view) {
		super();
		this.view = view;
		model = new MineHuntModel(10, 10, 10);
	}

	// Insère le flag (coleur bleue)
	public void setFlag(int x, int y) {

		final String STYLE_PRESSED = "-fx-background-color: blue;";
		this.setStyle(STYLE_PRESSED);
	}

	// retourne si la case est flag ou non
	public boolean containFlag(int x, int y) {

		return isFlagged(x, y);
	}

	// retourne si la case est une mine on non
	public boolean containMine(int x, int y) {

		return isMined(x, y);
	}

	// Supprime le flag (couleur grise par défaut)
	public void deleteFlag(int x, int y) {

		final String STYLE_PRESSED = "-fx-background-color: grey;";
		this.setStyle(STYLE_PRESSED);

	}

	// Retourne le nombre d'erreurs
	public void GetErrors() {

		//

	}

	// Affiche le nombre de mines voisine
	public void showNeighborMines(int row, int col) {

	}

}
