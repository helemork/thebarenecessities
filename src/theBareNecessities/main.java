package theBareNecessities;

import java.util.Scanner;

import theBareNecessities.database;


class Main {
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	while (true){
    		System.out.println("Ka vil du gjør no?");
    		System.out.println("1) vis aillj øvelsain din");
    		System.out.println("2) lægg te ny øvelse");
    		System.out.println("3) nåkka ainnja. Avslutt.");
    		System.out.println("Vælg en av tallan over:");
    		int choice = scanner.nextInt();
    		if (choice == 1){
    			System.out.println(database.getAllOvelse()); 
    		}
    		else if (choice == 2){
    			System.out.println("Kossn type øvelse ska det værra?");
        		System.out.println("1) oppvarming eller avslutningsøvels");
        		System.out.println("2) utholdenhetsøvels");
        		System.out.println("3) styrkeøvels eller kondisjonsøvels");
        		System.out.println("4) nå ainnja");
        		System.out.println("Vælg en av tallan over:");
        		choice = scanner.nextInt();
        		
        		System.out.println("skriv inn navn på øvelse:");
        		scanner.nextLine();
        		String name = scanner.nextLine();
        		
        		System.out.println("skriv inn beskrivelse av øvelsa:");
        		String description = scanner.nextLine();
        		
        		if (choice == 1){
        			System.out.println("skriv innj kor mang minutt det ska var:");
            		int duration = scanner.nextInt();
        			System.out.println(database.createOppvarming(name, 
        			description, 
        			duration));
        		}
        		
        		else if (choice == 2){
        			System.out.println("skriv inn kor langt det ska vær:");
            		float lengde = scanner.nextFloat();
        			System.out.println(database.createUtholdenhet(name, description, lengde));
        		}
        		
        		
        		else if (choice == 3){
        			System.out.println("Kor myttji belastning (heiltallj):");
        			int belastning = scanner.nextInt();
        			System.out.println("Kor mang repitisjona (heiltallj):");
        			int Antallrepitisoner = scanner.nextInt();
        			System.out.println("Kor mang sett (heiltallj):");
        			int Antallsett = scanner.nextInt();
        			System.out.println(database.createKondisjonStyrke(name, description, belastning, Antallrepitisoner, Antallsett));
        		}
        		

        		
        		else if (choice == 4){
        			System.out.println("skriv inn notat om du har nånn:");
            		String notat = scanner.nextLine();
            		System.out.println(database.createAnnet(name, description, notat));
        		}
    			
    			
    			
    		}
    		else if (choice == 3){
    			System.out.println("No skrur æ mæ av");
    			break;
    		};
    		
    	}
    	scanner.close();
    	
 
    	
    }
}