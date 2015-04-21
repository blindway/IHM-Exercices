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

	// Ouvre une case, retourne true si la case contient une mine et false si la case
	// est vide.
	public boolean open(int x, int y) {
		return model.open(x, y);
	}

	// Insère le flag (coleur bleue)
	public void setFlag(int x, int y, boolean isflagged) {
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

	// Retourne le nombre d'erreurs
	public void GetErrors() {

	}

	// Affiche le nombre de mines voisine
	public void showNeighborMines(int row, int col) {

	}

}
