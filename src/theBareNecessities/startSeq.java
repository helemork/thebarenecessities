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
	    		System.out.println("Ka vil du gj�r no?");
	    		System.out.println("1) G� til menyvalg for �velser");
	    		System.out.println("2) G� til menyvalg for treninger.");
	    		System.out.println("3) n�kka ainnja. Avslutt.");
	    		System.out.println("V�lg en av tallan over:");

	    		int choice = scanner.nextInt();
	    		
	    		if (choice == 1){
	    			Ovelse.ovelse();
	    		
	    		}
	    		else if (choice == 2){	
	        		Trening.tren();
	    		}
	    		else if (choice == 3){
	    			System.out.println("No skrur � m� av");
	    			scanner.close();
	    			System.exit(0);
	    		}	
	    	}
	    	
	    	
	    	
		
	}
}
