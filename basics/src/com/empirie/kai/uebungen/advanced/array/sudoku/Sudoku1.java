package com.empirie.kai.uebungen.advanced.array.sudoku;


public class Sudoku1 {
   
    public static void main(String[] args) {

        int i,j,c;
        c = 0;
        for( j=1; j<10; j++){
            for( c=1; c<2; c++) {
                for( i=1; i<10; i++){
                    System.out.print(i + " ");  
				}
			}
		System.out.println();
		c++;
		}
    }
}