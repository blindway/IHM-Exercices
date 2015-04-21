package s02.model;

import java.util.Random;

public class MineHuntModel implements IMineHuntModel {

	int gridraw;
	int gridcol;
	int mines;
	int errors;
	int leftToOpen;
	Case[][] grid;
	Random random;

	// Constructeur qui reçoit en paramètre le nombre de lignes, de colonnes et
	// de mines.
	public MineHuntModel(int gridraw, int gridcol, int mines) {
		this.gridraw = gridraw;
		this.gridcol = gridcol;
		this.mines = mines;
		random = new Random();
	}

	// Retourne un emplacement aléatoire dans le tableau pour une mine.
	private String randomizeMine() {
		int randRawMine = random.nextInt(gridraw);
		int randColMine = random.nextInt(gridcol);
		return randRawMine + ";" + randColMine;
	}

	// Vérifie si l'emplacement de la mine générée est un emplacement libre,
	// sinon regénère des mines jusqu'à qu'il trouve un emplacement libre.
	// Retourne l'emplacement de la mine.
	private int[] randomMineOK() {
		String[] tab = new String[2];
		int[] tabResultat = new int[2];
		boolean res = true;

		while (res) {
			tab = randomizeMine().split(";");
			int rawi = Integer.valueOf(tab[0]);
			int coli = Integer.valueOf(tab[1]);
			if (!grid[rawi][coli].getContainMine()) {
				res = false;
				tabResultat[0] = rawi;
				tabResultat[1] = coli;
			}
		}
		return tabResultat;
	}

	// Teste si la case contient une mine, si oui elle incrémente les erreurs et
	// retourne true.
	public boolean isMine(int row, int col) {
		boolean resultat = false;
		if (grid[row - 1][col - 1].getContainMine()) {
			errors++;
			resultat = true;
		}
		return resultat;
	}

	// Initialise une nouvelle partie, en créant la grille et en posant des
	// mines aléatoirement.
	@Override
	public void initNewGame(int minesNb) {
		int tab[] = new int[2];
		grid = new Case[gridraw][gridcol];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = new Case(false, false, false);
			}
		}
		for (int i = 0; i < minesNb; i++) {
			tab = randomMineOK();
			grid[tab[0]][tab[1]].setMine(true);
		}
		leftToOpen = (gridraw * gridcol) - mines;
	}

	// Retourne le nombre de colonnes.
	@Override
	public int gridWidth() {
		return gridcol;
	}

	// Retourne le nombre de lignes.
	@Override
	public int gridHeight() {
		return gridraw;
	}

	// Retourne le nombre de mines.
	@Override
	public int mines() {
		return mines;
	}

	// Retourne le nombre d'erreurs.
	@Override
	public int errors() {
		return errors;
	}

	// Retourne le nombre de mines voisine de la case à l'emplacement donné.
	// parametre row va de 1 à rowMax, idem pour col.
	@Override
	public int neighborMines(int row, int col) {
		int neighborMines = 0;
		if (row - 1 == 0 && col - 1 == 0) {
			if (grid[row][col - 1].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 1][col].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][col].getContainMine()) {
				neighborMines++;
			}
		} else if (row - 1 > 0 && col - 1 == 0) {
			if (grid[row - 2][col - 1].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 2][col].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 1][col].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][col].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][col - 1].getContainMine()) {
				neighborMines++;
			}
		} else if (row - 1 == gridraw - 1 && col - 1 == 0) {
			if (grid[row - 2][col - 1].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 2][col].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 1][col].getContainMine()) {
				neighborMines++;
			}
		} else if (row - 1 == gridraw - 1 && col - 1 > 0) {
			if (grid[row - 1][col - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 2][col - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 2][col - 1].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 2][col].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 1][col].getContainMine()) {
				neighborMines++;
			}
		} else if (row - 1 == gridraw - 1 && col - 1 == gridcol - 1) {
			if (grid[gridraw - 1][gridcol - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[gridraw - 2][gridcol - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[gridraw - 2][gridcol - 1].getContainMine()) {
				neighborMines++;
			}
		} else if (row - 1 > 0 && col - 1 == gridcol - 1) {
			if (grid[row - 2][col - 1].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 2][col - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 1][col - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][col - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][col - 1].getContainMine()) {
				neighborMines++;
			}
		} else if (row - 1 == 0 && col - 1 == gridcol - 1) {
			if (grid[row - 1][gridcol - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][gridcol - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][gridcol - 1].getContainMine()) {
				neighborMines++;
			}
		} else if (row - 1 == 0 && col - 1 > 0) {
			if (grid[row - 1][col - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][col - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][col - 1].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][col].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 1][col].getContainMine()) {
				neighborMines++;
			}
		} else if (row - 1 > 0 && col - 1 > 0) {
			if (grid[row - 2][col - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 2][col - -1].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 2][col].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 1][col - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row - 1][col].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][col - 2].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][col - 1].getContainMine()) {
				neighborMines++;
			}
			if (grid[row][col].getContainMine()) {
				neighborMines++;
			}
		}
		return neighborMines;
	}

	// Dit si une case à l'emplacement donné est ouverte.
	@Override
	public boolean isOpen(int row, int col) {
		return grid[row - 1][col - 1].isOpened();
	}

	// Dit si une case à l'emplacement donné est flagguée.
	@Override
	public boolean isFlagged(int row, int col) {
		return grid[row - 1][col - 1].isFlagged();
	}

	// Teste si le jeu est terminé.
	@Override
	public boolean isGameOver() {
		if (leftToOpen == 0)
			return true;
		return false;
	}

	// Ouvre une case à l'emplacement donné en paramètre.
	@Override
	public boolean open(int row, int col) {
		boolean resultat = false;
		if (!grid[row - 1][col - 1].isOpened()) {
			grid[row - 1][col - 1].setOpened(true);
			leftToOpen--;
			resultat = true;
		}
		return resultat;
	}

	// Met le flag selon la spécification à une case de l'emplacement donné en
	// paramètre.
	@Override
	public void setFlagState(int row, int col, boolean state) {
		grid[row - 1][col - 1].setFlag(state);
	}

}
