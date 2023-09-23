package Objects;

public class Dealer extends Hand {
	private String name = "";
	
	public Dealer() {
		this.name = "*DEALER*";
		
	}
	
	/* Metodo temporal para tomar una carta del deck
	 * he imprimir en la consula.
	 */
	public Card cardToAir(Deck deck) {
		return deck.popCard();
	}
	
	public void cardToPlayer() {
		
	}
	
	public void cardToDealer() {
		
	}
}
