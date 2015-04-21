package s02.controller;

public class CtrlMineHunt {
	
	
	//Insère le flag (coleur bleue)
		public void setFlag(int x, int y){
			
		    final String STYLE_PRESSED = "-fx-background-color: blue;";
			this.setStyle(STYLE_PRESSED);
		}
		
		//retourne si la case est flag ou non
		public boolean containFlag(int x, int y){
			
			return isFlagged(x, y);
		}
		
		//retourne si la case est une mine on non
		public boolean containMine(int x, int y){
			
			return isMined(x, y);
		}
		
		//Supprime le flag (couleur grise par défaut)
		public void deleteFlag(int x, int y){
			
		    final String STYLE_PRESSED = "-fx-background-color: grey;";
			this.setStyle(STYLE_PRESSED);
			
		}
		
		//Incrémente le nombre d'erreurs
		public void addError(){
			
		  //
			
		}
		
		
		//Affiche le nombre de mines voisine
		public void showNeighborMines(){
			
		  //
			
		}

}
