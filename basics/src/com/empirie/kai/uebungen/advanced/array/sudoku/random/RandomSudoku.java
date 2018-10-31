package com.empirie.kai.uebungen.advanced.array.sudoku.random;


import java.util.Random;
public class RandomSudoku {
	
	public static void main(String[] args) {
//		int a = 1;
		int x = 1;
		int b = 1;
		int y = 1;
		int v = 1;
		int r = randomNumber();
//initialisieren der Horizontalen Spalte 
		for(int j=1; j<10; j++){
			if(b == 4 || b == 7){
			y++;
			x = y;
			System.out.println("-------------------------");
			}
			System.out.print('|' + " ");
//Initialisieren der Vertikalen Spalte
			for(int i=1; i<10; i++){
//Eingabe der Werte
				System.out.print(r+" ");
				v++;
				r++;
				if(r==10){
					r=1;
				}
				if(v>=4){
					System.out.print("|"+ " ");
				v = 1;
				}
			}
			x = x + 3;		
			System.out.println();
			b++;
		}
	}
	private static int randomNumber() {
        return new Random().nextInt(10) + 1;
    } 

}