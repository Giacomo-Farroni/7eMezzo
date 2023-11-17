package org.generation.italy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		
		
		// DICHIARAZIONE LISTE E VARIABILI
		
		ArrayList<String> mazzo=new ArrayList<>();
		ArrayList<Float> valori = new ArrayList<>();
		String[] semi= {"denari", "spade", "coppe", "bastoni"};
		HashSet<Integer> estratte = new HashSet<>();
		Random r = new Random();
		Scanner sc=new Scanner(System.in);
		String risposta; 
		
		
		
		// GENERO LE CARTE
		for (Integer i = 1; i < 11; i++) {
            mazzo.add(i + " bastoni");
            if (i > 7)
                valori.add(0.5f);
            		else
        				valori.add(i.floatValue());
        }

        for (Integer i = 1; i < 11; i++) {
            mazzo.add(i + " coppe");
            if (i > 7)
                valori.add(0.5f);
            		else
            			valori.add(i.floatValue());
        }

        for (Integer i = 1; i < 11; i++) {
            mazzo.add(i + " spade");
            if (i > 7)
                valori.add(0.5f);
            		else
            				valori.add(i.floatValue());
        }

        for (Integer i = 1; i < 11; i++) {
            mazzo.add(i + " denari");
            	if (i > 7)
            		valori.add(0.5f);
            			else
        					valori.add(i.floatValue());
        }
			
		// ESTRAZIONE CARTE 
        
		int pos;
		float punteggioGiocatore = 0;
		float punteggioBanco = 0;
		
	    System.out.println("Vuoi giocare a Sette e mezzo? Se si, ti do una carta!");
        risposta = sc.nextLine();
        
        if (risposta.equals("si")) 
	        	do {
	        		
	        		
		do {
					pos=r.nextInt(39); //da 0 a 39
					
			} while (estratte.contains(pos)); //non può più essere estratto
		estratte.add(pos);
		System.out.println("E uscito " + mazzo.get(pos+1));
		
		punteggioGiocatore = punteggioGiocatore + valori.get(pos+1);
		System.out.println("il tuo punteggio attuale è: " + punteggioGiocatore);
		
				if (punteggioGiocatore <= 7.5) {
						System.out.println("Vuoi un'altra carta? (si/no)");
						risposta = sc.nextLine();} 
				if(punteggioGiocatore > 7.5){
						System.out.println("Hai sballato");
						System.out.println("vince il banco");}
				
        	} while (risposta.equals("si") && punteggioGiocatore <= 7.5);
		 
		
		
		//TURNO DEL BANCO
	        
    if (risposta.equals("no"))
    	do {  	System.out.println("il banco estrae:");
        	
        		do {
    			
        			pos=r.nextInt(39); 		//da 0 a 39
        	
        		} while (estratte.contains(pos));
    				 estratte.add(pos); //non può più essere estratto   
    				 System.out.println("carta estratta dal banco: " + mazzo.get(pos + 1));
	    		
			punteggioBanco = punteggioBanco + valori.get(pos + 1);
	    		
	    		if (punteggioBanco <= 7.5) 
	    			System.out.println("il banco sta pensando");
	    		
	    		if(punteggioBanco <= 5)
	    			System.out.println("il banco estrae nuovamente!");
	    	
	    		if (punteggioBanco > 7.5) {
	    			System.out.println(punteggioBanco);;
	    			System.out.println("Il banco ha sballato");} 
	    	    		
			} while ( punteggioBanco < 5);
	        
	        if(punteggioBanco <= 7.5)
	        System.out.println("il banco sta col seguente punteggio: " + punteggioBanco);
	        else;
	    if(punteggioBanco >= punteggioGiocatore && punteggioBanco <= 7.5)
	    System.out.print("vince il banco");
	    if(punteggioGiocatore > punteggioBanco && punteggioGiocatore<= 7.5)
	    	System.out.println("vince il Giocatore");
	        
	        
         // FINE GIOCO
	     sc.close();
	        
	
	}
	
}
