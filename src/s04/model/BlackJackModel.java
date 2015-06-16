package s04.model;

import java.util.Random;

import s04.controller.BlackJackCtrl;

public class BlackJackModel {
	private Card[] cards;
	private Card[] dealtCards; // Cartes tirées
	private Card[] mainCroupier; // main du croupier
	private Card[] mainJoueur; // main du joueur

	private int solde;
	private int mise;
	private int mancheGagne;
	private int mancheTotales;
	private Random random;
	private BlackJackCtrl ctrl;
	private boolean misee;

	public BlackJackModel(BlackJackCtrl ctrl) {
		this.ctrl = ctrl;
		cards = new Card[52]; // 1 jeux de 52 cartes
		random = new Random();
	}

	public void startGame() {
		solde = 300;
		ctrl.setLblSolde(Integer.toString(solde));
		mise = 0;
		ctrl.setLblArgMise(Integer.toString(mise));
		mancheGagne = 0;
		ctrl.setLblMGagnees(Integer.toString(mancheGagne));
		mancheTotales = 0;
		ctrl.setLblMPerdues(Integer.toString(mancheTotales - mancheGagne));
		startTurn();
		ctrl.setLblInfo("Misez et tirez les cartes");
	}

	public void actionJoueur() {
		if (Integer.valueOf(ctrl.getLblSolde()) == 0) {
			ctrl.griseAll();
		}
		if (mainJoueur[0] == null) {
			joueurTireCarte();
			croupierTireCarte();
			joueurTireCarte();
			blackJack(ctrl.valMainJ);
		} else if (mainJoueur[3] != null && mainJoueur[4] == null) {
			joueurTireCarte();
			blackJack(ctrl.valMainJ);
			busted(ctrl.valMainJ);
			actionCroupier();
		} else {
			joueurTireCarte();
			blackJack(ctrl.valMainJ);
			busted(ctrl.valMainJ);
		}
		// TODO par rapport à la methode, tester si la main du joueur est
		// pleine, si oui alors terminer le round (gagné, perdu ou égalité)
		// pt créer une méthode qui dit round terminé
	}

	public void actionCroupier() {
		while (ctrl.valMainC < ctrl.valMainJ) {
			croupierTireCarte();
			blackJack(ctrl.valMainC);
			busted(ctrl.valMainC);
		}
	}

	public void startTurn() {
		initCartes();
		ctrl.cleanImgCards();
		mainCroupier = new Card[4];
		mainJoueur = new Card[4];
		ctrl.degriseAll();
	}

	public void restart() {
		solde = 300;
		startTurn();
		ctrl.degriseAll();
	}

	public int valeurMain(Card[] main) {
		int count = 0;
		for (Card card : main) {
			if (card != null) {
				count = count + card.getValue();
			}
		}
		return count;
	}

	public void blackJack(int valeur) {
		if (valeur == 21) {
			ctrl.setLblInfo("BlackJack, vous avez gagné");
			ctrl.setLblSolde(String.valueOf(Integer.valueOf(ctrl.getLblSolde())
					+ 2 * mise));
			ctrl.griseAll();
			// TODO ICI il faut faire un popup disant gagné ou perdu, selon si
			// on teste le blackjack pour le joueur ou le croupier
			// lancer startturn seulement quand popup est fermé
			startTurn();
		}
	}

	public void busted(int valeur) {
		if (valeur > 21) {
			ctrl.setLblInfo("Busted, vous avez perdu");
			// TODO ici il faut faire un popup disant perdu.
			ctrl.griseAll();
			// lancer startturn seulement quand popup est fermé
			startTurn();
		}
	}

	public void joueurTireCarte() {
		boolean notNull = false;
		while (notNull != true) {
			int r = random.nextInt(52);
			if (cards[r] != null) {
				for (int i = 0; i < mainJoueur.length; i++) {
					if (mainJoueur[i] == null) {
						mainJoueur[i] = cards[r];
						ctrl.addCarteJoueur(cards[r]);
						cards[r] = null;
						break;
					}
				}
				notNull = true;
				ctrl.setLblValMainJ(String.valueOf(valeurMain(mainJoueur)));
				ctrl.valMainJ = valeurMain(mainJoueur);
			}
		}
	}

	public void croupierTireCarte() {
		boolean notNull = false;
		while (notNull != true) {
			int r = random.nextInt(52);
			if (cards[r] != null) {
				for (int i = 0; i < mainCroupier.length; i++) {
					if (mainCroupier[i] == null) {
						mainCroupier[i] = cards[r];
						ctrl.addCardCroupier((cards[r]));
						cards[r] = null;
						break;
					}
				}
				notNull = true;
				ctrl.setLblValMainC(String.valueOf(valeurMain(mainCroupier)));
				ctrl.valMainC = valeurMain(mainCroupier);
			}
		}
	}

	public void initCartes() {
		cards[0] = new Card(10,
				"s04/view/img/10_of_clubs_-_David_Bellot.svg.png");
		cards[1] = new Card(10,
				"s04/view/img/10_of_diamonds_-_David_Bellot.svg.png");
		cards[2] = new Card(10,
				"s04/view/img/10_of_hearts_-_David_Bellot.svg.png");
		cards[3] = new Card(10,
				"s04/view/img/10_of_spades_-_David_Bellot.svg.png");
		cards[4] = new Card(1, "s04/view/img/100px-01_of_clubs_A.svg.png");
		cards[5] = new Card(1, "s04/view/img/100px-01_of_diamonds_A.svg.png");
		cards[6] = new Card(1, "s04/view/img/100px-01_of_hearts_A.svg.png");
		cards[7] = new Card(1, "s04/view/img/100px-01_of_spades_A.svg.png");
		cards[8] = new Card(2, "s04/view/img/100px-02_of_clubs.svg.png");
		cards[9] = new Card(2, "s04/view/img/100px-02_of_diamonds.svg.png");
		cards[10] = new Card(2, "s04/view/img/100px-02_of_hearts.svg.png");
		cards[11] = new Card(2, "s04/view/img/100px-02_of_spades.svg.png");
		cards[12] = new Card(3, "s04/view/img/100px-03_of_clubs.svg.png");
		cards[13] = new Card(3, "s04/view/img/100px-03_of_diamonds.svg.png");
		cards[14] = new Card(3, "s04/view/img/100px-03_of_hearts.svg.png");
		cards[15] = new Card(3, "s04/view/img/100px-03_of_spades.svg.png");
		cards[16] = new Card(4, "s04/view/img/100px-04_of_clubs.svg.png");
		cards[17] = new Card(4, "s04/view/img/100px-04_of_diamonds.svg.png");
		cards[18] = new Card(4, "s04/view/img/100px-04_of_hearts.svg.png");
		cards[19] = new Card(4, "s04/view/img/100px-04_of_spades.svg.png");
		cards[20] = new Card(5, "s04/view/img/100px-05_of_clubs.svg.png");
		cards[21] = new Card(5, "s04/view/img/100px-05_of_diamonds.svg.png");
		cards[22] = new Card(5, "s04/view/img/100px-05_of_hearts.svg.png");
		cards[23] = new Card(5, "s04/view/img/100px-05_of_spades.svg.png");
		cards[24] = new Card(6, "s04/view/img/100px-06_of_clubs.svg.png");
		cards[25] = new Card(6, "s04/view/img/100px-06_of_diamonds.svg.png");
		cards[26] = new Card(6, "s04/view/img/100px-06_of_hearts.svg.png");
		cards[27] = new Card(6, "s04/view/img/100px-06_of_spades.svg.png");
		cards[28] = new Card(7, "s04/view/img/100px-07_of_clubs.svg.png");
		cards[29] = new Card(7, "s04/view/img/100px-07_of_diamonds.svg.png");
		cards[30] = new Card(7, "s04/view/img/100px-07_of_hearts.svg.png");
		cards[31] = new Card(7, "s04/view/img/100px-07_of_spades.svg.png");
		cards[32] = new Card(8, "s04/view/img/100px-08_of_clubs.svg.png");
		cards[33] = new Card(8, "s04/view/img/100px-08_of_diamonds.svg.png");
		cards[34] = new Card(8, "s04/view/img/100px-08_of_hearts.svg.png");
		cards[35] = new Card(8, "s04/view/img/100px-08_of_spades.svg.png");
		cards[36] = new Card(9, "s04/view/img/100px-09_of_clubs.svg.png");
		cards[37] = new Card(9, "s04/view/img/100px-09_of_diamonds.svg.png");
		cards[38] = new Card(9, "s04/view/img/100px-09_of_hearts.svg.png");
		cards[39] = new Card(9, "s04/view/img/100px-09_of_spades.svg.png");
		cards[40] = new Card(10, "s04/view/img/100px-Jack_of_clubs_fr.svg.png");
		cards[41] = new Card(10,
				"s04/view/img/100px-Jack_of_diamonds_fr.svg.png");
		cards[42] = new Card(10, "s04/view/img/100px-Jack_of_hearts_fr.svg.png");
		cards[43] = new Card(10, "s04/view/img/100px-Jack_of_spades_fr.svg.png");
		cards[44] = new Card(10, "s04/view/img/100px-King_of_clubs_fr.svg.png");
		cards[45] = new Card(10,
				"s04/view/img/100px-King_of_diamonds_fr.svg.png");
		cards[46] = new Card(10, "s04/view/img/100px-King_of_hearts_fr.svg.png");
		cards[47] = new Card(10, "s04/view/img/100px-King_of_spades_fr.svg.png");
		cards[48] = new Card(10, "s04/view/img/100px-Queen_of_clubs_fr.svg.png");
		cards[49] = new Card(10,
				"s04/view/img/100px-Queen_of_diamonds_fr.svg.png");
		cards[50] = new Card(10,
				"s04/view/img/100px-Queen_of_hearts_fr.svg.png");
		cards[51] = new Card(10,
				"s04/view/img/100px-Queen_of_spades_fr.svg.png");
		// dealtCards = new Card[52];
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public Card[] getDealtCards() {
		return dealtCards;
	}

	public void setDealtCards(Card[] dealtCards) {
		this.dealtCards = dealtCards;
	}

	public Card[] getMainCroupier() {
		return mainCroupier;
	}

	public void setMainCroupier(Card[] mainCroupier) {
		this.mainCroupier = mainCroupier;
	}

	public Card[] getMainJoueur() {
		return mainJoueur;
	}

	public void setMainJoueur(Card[] mainJoueur) {
		this.mainJoueur = mainJoueur;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public int getMise() {
		return mise;
	}

	public void setMise(int mise) {
		if (misee == false) {
			this.mise = mise;
			solde = solde - mise;
			ctrl.setLblSolde(solde + "");
			ctrl.griseMise();
		}
	}

	public void setMiseDouble(int mise) {
		this.mise = this.mise + mise;
		solde = solde - mise;
		ctrl.setLblSolde(solde + "");
	}

	public int getMancheGagne() {
		return mancheGagne;
	}

	public void setMancheGagne(int mancheGagne) {
		this.mancheGagne = mancheGagne;
	}

	public int getMancheTotales() {
		return mancheTotales;
	}

	public void setMancheTotales(int mancheTotales) {
		this.mancheTotales = mancheTotales;
	}

	public void aaa() {
		System.out.println("aaaaaa");
	}
}
