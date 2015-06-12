package s04.model;

public class BlackJackModel {
	private Card[] cards = new Card[312]; // 4 jeux de cartes de 52
	private Card[] dealtCards = new Card[312]; // Cartes tirées
	private Card[] mainCroupier = new Card[10];
	private Card[] mainJoueur = new Card[10];

	private int solde;
	private int mise;

	public int valeurMain(Card[] main) {

		return 0;
	}
	
	public boolean blackJack(int valeur){
		return false;
	}
	
	public void tireCarte(Card[] main ){
		
	}
}
