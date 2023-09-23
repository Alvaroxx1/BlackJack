package Blackjack;
//import Objects.*;

//import java.util.ArrayList;

import test.*;

import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
		
		Card mycard = new Card("4","h");

		System.out.println(mycard.toString());
		

		// Testgin Area
		Test test = new Test();
		test.player();
	}


}
