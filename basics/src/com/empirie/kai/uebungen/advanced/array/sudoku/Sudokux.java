package com.empirie.kai.uebungen.advanced.array.sudoku;


import java.util.Random;

public class Sudokux{
	public static void main(String[] args){
		int[][] sudoku = new int[9][9];
        int feldZahl = randomNumber();
		existiertInZeile(feldZahl, sudoku);
		 for(int spalte = 0; spalte < sudoku.length; spalte++) {
            for(int zeile = 0; zeile < sudoku[spalte].length; zeile++) {
                sudoku[spalte][zeile] = feldZahl;
				existiertInZeile(feldZahl, sudoku);
				feldZahl++;
				// wenn die feldzahl > 9 dann setze sie auf eins
				if(feldZahl>9){
					feldZahl = 1;
				}
			 }
           // feldzahl erhöhen um 3
		   feldZahl += 3;
		   // prüfe erneut ob feldzahl > 9 wenn ja dann verändern
		   if(feldZahl>9){
			   feldZahl = feldZahl - 8;
		   }
		 }
		//Ausgabe
        for(int spalte = 0; spalte < sudoku.length; spalte++) {
            for(int zeile = 0; zeile < sudoku[0].length; zeile++) {
				System.out.print(sudoku[spalte][zeile]+ " ");
            }
            System.out.println();
        }
	}
	
	private static boolean existiertInZeile(int zahl, int[][] array) {
		
		return false;
	}

	private static int randomNumber() {
    return new Random().nextInt(10) + 1;
    } 
}