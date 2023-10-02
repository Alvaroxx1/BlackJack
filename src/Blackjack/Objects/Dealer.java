package Objects;

import java.util.Scanner;

public class Dealer extends Hand {
	private String name = "";
	private static Scanner in = new Scanner(System.in);

	public Dealer() {
		this.name = "DEALER";
		
	}
	
	public void cardToPlayer(Player player, Deck deck) {
		Card c = deck.popCard();
		player.add(c);
		System.out.println("Card dealt to *" + player.getName() + "* is : " + c.toString() + " [Score: "+player.score()+"].");
	}
	
	public void cardToDealer(Deck deck) {
		Card c = deck.popCard();
		this.add(c);
		//this.add(new Card("Ah"));
		System.out.println("Card dealt to *" + this.name + "* is : " + c.toString() + " [Score: "+ this.score() +"].");
	}

	public void askHitOrStand(Player player, Scanner IN) {
		System.out.println("*** Choose your action ***");
		System.out.println("***    [hit, stand]    ***");
		System.out.println("");
		
		//String chooseAction = "hit";
		//String chooseAction = "stand";
		
		String chooseAction = "";
		
	    IN.close();
		
		IN = new Scanner(System.in);
		chooseAction = IN.next(); 
		IN.close();
		
		
		
		//int x = inputclass.in.nextInt();
		
		System.out.println("El valor de x es: " + chooseAction);
		
		//player.setAction(chooseAction);
		System.out.println("Your action: " + player.getAction());
		//inputclass.in.close();
		
	}

}

//class inputclass
//{
//    static Scanner in = new Scanner(System.in);
//}
