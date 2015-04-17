package s02.model;

import java.util.Random;

public class MineHuntModel implements IMineHuntModel {

	int gridraw;
	int gridcol;
	int mines;
	int errors;
	Case[][] grid;
	Random random;

	// Constructeur qui re�oit en param�tre le nombre de lignes, de colonnes et
	// de mines.
	public MineHuntModel(int gridraw, int gridcol, int mines) {
		this.gridraw = gridraw;
		this.gridcol = gridcol;
		this.mines = mines;
		random = new Random();
	}

	// Retourne un emplacement al�atoire dans le tableau pour une mine.
	private String randomizeMine() {
		int randRawMine = random.nextInt(gridraw);
		int randColMine = random.nextInt(gridcol);
		return randRawMine + ";" + randColMine;
	}

	// V�rifie si l'emplacement de la mine g�n�r�e est un emplacement libre,
	// sinon reg�n�re des mines jusqu'� qu'il trouve un emplacement libre.
	// Retourne l'emplacement de la mine.
	private int[] randomMineOK() {
		String[] tab = new String[2];
		int[] tabResultat = new int[2];
		boolean res = false;

		while (res) {
			tab = randomizeMine().split(";");
			int rawi = Integer.valueOf(tab[0]);
			int coli = Integer.valueOf(tab[1]);
			if (!grid[rawi][coli].getContainMine()) {
				res = true;
				tabResultat[0] = rawi;
				tabResultat[1] = coli;
			}
		}
		return tabResultat;
	}

	// Initialise une nouvelle partie, en cr�ant la grille et en posant des
	// mines al�atoirement.
	@Override
	public void initNewGame(int minesNb) {
		int tab[] = new int[2];
		grid = new Case[gridraw - 1][gridcol - 1];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = new Case(false, false, false);
			}
		}
		for (int i = 0; i < minesNb; i++) {
			tab = randomMineOK();
			grid[tab[0]][tab[1]].setMine(true);
		}
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

	// Retourne le nombre de mines voisine de la case � l'emplacement donn�.
	@Override
	public int neighborMines(int row, int col) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Dit si une case � l'emplacement donn� est ouverte.
	@Override
	public boolean isOpen(int row, int col) {
		return grid[row - 1][col - 1].isOpened();
	}

	// Dit si une case � l'emplacement donn� est flaggu�e.
	@Override
	public boolean isFlagged(int row, int col) {
		return grid[row - 1][col - 1].isFlagged();
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	// Ouvre une case � l'emplacement donn� en param�tre.
	@Override
	public boolean open(int row, int col) {
		boolean resultat = false;
		if (!grid[row - 1][col - 1].isOpened()) {
			grid[row - 1][col - 1].setOpened(true);
			resultat = true;
		}
		return resultat;
	}

	// Met le flag selon la sp�cification � une case de l'emplacement donn� en
	// param�tre.
	@Override
	public void setFlagState(int row, int col, boolean state) {
		grid[row - 1][col - 1].setFlag(state);
	}

}
