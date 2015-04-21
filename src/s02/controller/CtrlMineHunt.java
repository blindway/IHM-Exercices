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
	public void setFlag(int x, int y, boolean isflagged) {
		model.setFlagState(x, y, isflagged);
	}

	// Ouvre une case, retourne true si la case contient une mine et false si la
	// case est vide.
	public boolean open(int x, int y) {
		return model.open(x, y);
	}

	// retourne si la case est flag ou non
	public boolean containFlag(int x, int y) {
		return model.isFlagged(x, y);
	}

	// Retourne le nombre d'erreurs
	public int GetErrors() {
		return model.errors();
	}

	// Affiche le nombre de mines voisine
	public int showNeighborMines(int row, int col) {
		return model.neighborMines(row, col);
	}

}
