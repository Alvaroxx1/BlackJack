package Blackjack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class Game {

	public static void main(String[] args) {
		
		ArrayList<Integer> IDs = new ArrayList<Integer>();
		IDs.add(1234);
		IDs.add(34234);
		IDs.add(23552);
		Collections.sort(IDs);
		IDs.remove(2);
		System.out.println(IDs);
		
		

	}

}
