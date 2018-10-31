package com.empirie.kai.uebungen.advanced.array.schiffeversenken;

public class SchiffeVersenken{
	
	public static void main(String[] args){
		generiereFeld();

	}

//Erstellen des Spielfeldes
	private static void generiereFeld(){
		int feldBreite = 10; 	
		int feldLaenge = 10;
		int[][] spielFeld = new int[feldBreite][feldLaenge];
		for(int spalte = 0; spalte < spielFeld.length; spalte++){
			for(int zeile = 0; zeile < spielFeld[spalte].length; zeile++){
				//boolean schiffIstAufFeld = schiffGesetzt(spielFeld);
				//schiffeVersenken = new spielFeld[feldBreite][feldLaenge];  //momentan noch fehlerhaft 
			}
		}
		printFeld(spielFeld);
	}
	
//Setzen des Schiffes - manuell
	static boolean schiffGesetzt(int[][] spielFeld){
		
		spielFeld[2][2] = 1;
		spielFeld[2][3] = 1;
		spielFeld[2][4] = 1;
		return schiffIstAufFeld;

	}
	
	
//Ausgabe des leeren Spielfeldes 
	private static void printFeld(int[][] schiffeVersenken) {
		for(int i = 0; i < schiffeVersenken.length; i++ ) {
			for(int j = 0; j < schiffeVersenken[i].length; j++) {
				System.out.print(schiffeVersenken[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean schiffIstAufFeld = false;
	
}