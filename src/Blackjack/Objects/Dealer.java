package Objects;

public class Dealer extends Hand {
	private String name = "";

	
	public Dealer() {
		this.name = "DEALER";
		
	}
	
	/* Meted temporal para tomar una carta del deck
	 * he imprimir en la consula.
	 */
	public Card cardToAir(Deck deck) {
		return deck.popCard();
	}
	
	public void cardToPlayer(Player player, Deck deck) {
		Card c = deck.popCard();
		player.add(c);
		System.out.println("Card dealt to *" + player.getName() + "* is : " + c.toString() + " [Score: "+player.score()+"].");
	}
	
	public void cardToDealer(Deck deck) {
		Card c = deck.popCard();
		//this.add(c);
		this.add(new Card("Ah"));
		System.out.println("Card dealt to *" + this.name + "* is : " + c.toString() + " [Score: "+ this.score() +"].");
	}
	
	/*public void popCardFromDeck(Deck deck) {
		return deck.popCard();
	}*/
}
