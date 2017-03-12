package theBareNecessities;

import java.util.Scanner;

import theBareNecessities.database;


class Main {
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	while (true){
    		System.out.println("Ka vil du gj�r no?");
    		System.out.println("1) vis aillj �velsain din");
    		System.out.println("2) l�gg te ny �velse");
    		System.out.println("3) n�kka ainnja. Avslutt.");
    		System.out.println("V�lg en av tallan over:");
    		int choice = scanner.nextInt();
    		if (choice == 1){
    			System.out.println(database.getAllOvelse()); 
    		}
    		else if (choice == 2){
    			System.out.println("Kossn type �velse ska det v�rra?");
        		System.out.println("1) oppvarming eller avslutnings�vels");
        		System.out.println("2) utholdenhets�vels");
        		System.out.println("3) styrke�vels eller kondisjons�vels");
        		System.out.println("4) n� ainnja");
        		System.out.println("V�lg en av tallan over:");
        		choice = scanner.nextInt();
        		
        		System.out.println("skriv inn navn p� �velse:");
        		scanner.nextLine();
        		String name = scanner.nextLine();
        		
        		System.out.println("skriv inn beskrivelse av �velsa:");
        		String description = scanner.nextLine();
        		
        		if (choice == 1){
        			System.out.println("skriv innj kor mang minutt det ska var:");
            		int duration = scanner.nextInt();
        			System.out.println(database.createOppvarming(name, 
        			description, 
        			duration));
        		}
        		
        		else if (choice == 2){
        			System.out.println("skriv inn kor langt det ska v�r:");
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
        			System.out.println("skriv inn notat om du har n�nn:");
            		String notat = scanner.nextLine();
            		System.out.println(database.createAnnet(name, description, notat));
        		}
    			
    			
    			
    		}
    		else if (choice == 3){
    			System.out.println("No skrur � m� av");
    			break;
    		};
    		
    	}
    	scanner.close();
    	
 
    	
    }
}