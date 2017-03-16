package theBareNecessities;

import java.util.Scanner;

public class Trening {
		public static void tren() {
			
			Scanner scanner = new Scanner(System.in);
	    	while (true){
	    		System.out.println("Ka vil du gj�r no?");
	    		System.out.println("1) Vis treningslog for en gitt periode:");
	    		System.out.println("2) Registrer ny trening:");
	    		System.out.println("3) Legg til ny periode");
	    		System.out.println("4) tilbake");
	    		System.out.println("Velg et av tallene over:");
	    		int choice = scanner.nextInt();
	    		if (choice == 1){
	    			System.out.println(database.getAllPerioder());
	    			System.out.println("Velg periode ved � gi periodenummer som input:");
	    			int periode = scanner.nextInt();
	    			System.out.println("Du har valgt periode: "+ periode +"\n Treninger i perioden:\n");
	    			System.out.println(database.getAllTreningerIPeriode(periode));
	    		}
	    		else if (choice == 2){
	    			
	    			System.out.println(database.getAllPerioder());
	    			System.out.println("Velg periode � registrere treningen i:");
	    			int periode = scanner.nextInt();
	    			System.out.println("Du har valgt periode: " + periode);
	    			System.out.println("Hva slags trening er det?");
	        		System.out.println("1) Innetrening");
	        		System.out.println("2) Utetrening");
	        		System.out.println("V�lg en av tallan over:");
	        		choice = scanner.nextInt();
	        		
	        		System.out.println("Dato og tid for treningen: (Input format: [yyyy-mm-dd hh:mm:ss])");
	        		scanner.nextLine();
	        		String tid = scanner.nextLine();
	        		
	        		System.out.println("Varighet for treningen:");
	        		int varighet = scanner.nextInt();
	        		System.out.println("Dagsform for treningen:");
	        		int dagsform = scanner.nextInt();
	        		System.out.println("Prestasjon for treningen:");
	        		int prestasjon = scanner.nextInt();
	        		System.out.println("Notat:");
	        		scanner.nextLine();
	        		String notat = scanner.nextLine();
	        		
	        		
	        		if (choice == 1){
	        			System.out.println("Antall tilskuere:");
	            		int tilskuere = scanner.nextInt();
	            		System.out.println("Luftkvalitet:");
	            		int luftkva = scanner.nextInt();
	            		System.out.println(database.createInnetrening(tid, varighet, dagsform, prestasjon, notat, periode, tilskuere, luftkva));
	            		}
	        		
	        		else if (choice == 2){
	        			System.out.println("Temperatur i hele grader:");
	            		int temp = scanner.nextInt();
	            		System.out.println("V�rtype: (1=sol, 2=skyer, 3=regn, 4=sn�)");
	            		int ver = scanner.nextInt();
	            		
	            		System.out.println(database.createUtetrening(tid, varighet, dagsform, prestasjon, notat, periode, ver, temp));
	        		}
	        		
	        		
	        		
	    			
	    			
	    			
	    		}
	    		else if (choice == 3){
	    			System.out.println(database.getAllPerioder());
	    			System.out.println("Husk at perioder ikke kan overlappe.\nVil du opprette en periode? \n1) Ja\n2) Nei\n");
	    			choice = scanner.nextInt();
	    			
	    			
	    			if (choice == 1){
	        			System.out.println("Du har valgt � opprette en ny periode:\n N�r starter den:(Input format: [yyyy-mm-dd hh:mm:ss])");
	        			scanner.nextLine();
	        			String fra = scanner.nextLine();
	            		System.out.println("N�r slutter den: (Input format: [yyyy-mm-dd hh:mm:ss])");
	            		
	            		String til = scanner.nextLine();
	            		System.out.println("Hva er m�let ditt for perioden?");
	            		
	            		String goal = scanner.nextLine();
	            		System.out.println(database.createPeriode(fra,til,goal));
	            		}
	        		
	        		else if (choice == 2){
	        			System.out.println("Returnerer ... ");
	            		}
	    			
	    			
	    		}
	    		else if (choice == 4){
	    			System.out.println("G�r tilbake");
	    			startSeq.startUp();
	    			break;
	    		}
	    		
	    	}
	    	scanner.close();
	    	
			
		}
}
