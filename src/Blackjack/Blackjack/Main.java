package Blackjack;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static Boolean verbose = false; // for debugging option
	// public static void main (String[] args) {
	public static void main(String [] args) throws IOException, InterruptedException {
		// Creating a Game
		Game game = new Game(3, 1);
		game.rounds(); // max number of round on this game.

	}
	
    public static String scannerObjectString(/*Scanner scnr*/){
    	Scanner scnr = new Scanner(System.in);
        String s = scnr.nextLine();

		// this scanner should be closed and open when calling this method
		// but it is not working in that way.
		// scnr.close();
        return s;
    }

	public static void wait(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
	    catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
	    }
	}
    
	public static void test () {
		/* Here can be tested specific modules.
		*  Examples:
		*  
		*  TestJaime testj = new TestJaime();
		*  
		*  testj.card();
		*  test.player();
		*  test.hand();
		*  
		*  ---
		*  
		*  TestAlvaro testA = new TestAlvaro();
		*  testA.mostrarCartas();
		*/
	}
    // public static void CLS() throws IOException, InterruptedException {
    public static void CLS() {
		try
		{
			final String os = System.getProperty("os.name");

			System.out.println(os);
			
			if (os.contains("Windows"))
			{
				// Runtime.getRuntime().exec("cls");
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

			}
			else
			{
				Runtime.getRuntime().exec("clear");
			}
		}
		catch (IOException | InterruptedException ex) {}
	}

	public static String fixedLengthString(String string, int length) {
 	   return String.format("%1$"+length+ "s", string);
	}	
}
