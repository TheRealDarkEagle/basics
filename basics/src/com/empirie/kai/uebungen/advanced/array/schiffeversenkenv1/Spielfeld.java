package com.empirie.kai.uebungen.advanced.array.schiffeversenkenv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spielfeld{
	
	public static void main(String[] args){
		new Spielfeld();
		
	}
//Eigenschaften
	private Gebiet[][] feld;

//Konstruktor 
	public Spielfeld(){
		int xKoord=0;
		int yKoord=0;
		
		feld = new Gebiet[10][10];
//Anfangswert setzen für alle 100 Felder
		for(int i = 0; i < 10; i++){		//senkrecht
			for(int j = 0; j < 10; j++){	//waagerecht
				feld[j][i] = new Gebiet();
			}
		}
		feld[1][2].setzeSchiff();
		feld[2][2].setzeSchiff();
		feld[3][2].setzeSchiff();
		gibSpielfeldAufKonsoleAus();
		
		
		while(!gewonnen()) {
			schiesse(xKoord,yKoord);
			gibSpielfeldAufKonsoleAus();	
		}
		System.out.println("Sie haben GEWONNEN!!");
		
		
	}
	
//Methoden
	public String schiesse(int x, int y){
		System.out.println("Bitte geben Sie Ihre x-Koordinate zum schiessen ein!: ");
		x = readInt();					//X-Koordinate
		System.out.println("Bitte geben Sie Ihre Y-Koordinate zum schiessen ein!: ");
		y = readInt();					//Y-Koordinate
		if(feld[x][y].beschiesseFeld()){ 
			System.out.println("Getroffen!");
			return "Treffer";
		}
		else System.out.println("Daneben!");{
			return "Daneben";
		}
			
	}
	
	public void gibSpielfeldAufKonsoleAus(){
		System.out.println("\n  0 1 2 3 4 5 6 7 8 9"); //Leerzeile + Beschriftung
		for(int i = 0; i < 10; i++){
			System.out.print(i+" ");
			for(int j = 0; j < 10; j++){
				if(feld[j][i].isSchiff() && feld[j][i].isFeldWurdeBeschossen()){ 
					System.out.print("X"+" ");
				}
				else if(feld[j][i].isFeldWurdeBeschossen()){ 
						System.out.print("*"+" ");
				}
					else{ 
						System.out.print("-"+ " ");
				}
			}
			System.out.println(); 	//Zeilenwechsel
		}
	}
	
	public int counterSchiffGetroffen(int counterGetroffen){
		return counterGetroffen++;
	}
	
	public boolean gewonnen() {
		int anzahlSchiffe = 0;
		int anzahlGetroffeneSchiffe = 0;
		
		for(int y = 0; y < feld.length; y++) {
			for(int x = 0; x < feld[y].length; x++) {
				if(feld[y][x].isSchiff()) {
					anzahlSchiffe++;
					if(feld[y][x].isFeldWurdeBeschossen()) {
						anzahlGetroffeneSchiffe++;
					}
				}			
			}
		}
		
		if(anzahlSchiffe == anzahlGetroffeneSchiffe) {
			return true;
		}

		return false;
	}
	
	private static int readInt() {
		try {
			return Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (IOException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

}