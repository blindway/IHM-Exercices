package s04.model;

public class BlackJackModel {
	private Card[] cards = new Card[52]; // 1 jeux de 52 cartes
	private Card[] dealtCards = new Card[52]; // Cartes tirées
	private Card[] mainCroupier = new Card[3];
	private Card[] mainJoueur = new Card[3];

	private int solde;
	private int mise;
	private int mancheGagne;
	private int mancheTotales;

	public int valeurMain(Card[] main) {

		return 0;
	}
	
	public boolean blackJack(int valeur){
		return false;
	}
	
	public void tireCarte(Card[] main ){
		
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
		this.mise = mise;
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
	
	
}
