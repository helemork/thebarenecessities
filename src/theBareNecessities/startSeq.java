/*
 * The Bare Necessities
 * Start sequence that also runs every time you navigate back to the main menu, sends you to Trening or Ovelse
 * 
 * Group50
 * */


package theBareNecessities;

import java.util.Scanner;

public class startSeq {
	
		public static void startUp() {
			

	    	Scanner scanner = new Scanner(System.in);
	    	while (true){
	    		System.out.println("Ka vil du gjør no?");
	    		System.out.println("1) Gå til menyvalg for øvelser");
	    		System.out.println("2) Gå til menyvalg for treninger.");
	    		System.out.println("3) nåkka ainnja. Avslutt.");
	    		System.out.println("Vælg en av tallan over:");

	    		int choice = scanner.nextInt();
	    		
	    		if (choice == 1){
	    			Ovelse.ovelse();
	    		
	    		}
	    		else if (choice == 2){	
	        		Trening.tren();
	    		}
	    		else if (choice == 3){
	    			System.out.println("No skrur æ mæ av");
	    			scanner.close();
	    			System.exit(0);
	    		}	
	    	}
	    	
	    	
	    	
		
	}
}
