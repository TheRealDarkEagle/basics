package com.empirie.kai.uebungen.advanced.array.sudoku.random;

import java.util.Random;

public class Sudoku2DRandom {

	
	public static void main(String[] args) {
		generiereSudoku();
	}
	
	
	private static void generiereSudoku() {
		int[][] sudoku = new int[9][9];
		for(int row = 0; row < sudoku.length; row++) {
			for(int line = 0; line < sudoku[row].length; line++) {
				boolean isValidRandomNumber = false;
				int tryCount = 0;
				while(!isValidRandomNumber) {
					int randomNumber = new Random().nextInt(9) + 1;
					if(!existsInRow(randomNumber, sudoku, row) && !existsInLine(randomNumber, sudoku, line) && !existsInField(randomNumber, sudoku, row, line)) {
						sudoku[row][line] = randomNumber;
						isValidRandomNumber = true;
					}
					tryCount ++;
					
					if(tryCount > 100) {
						row = 0;
						line = 0;
						sudoku = new int[9][9];
						isValidRandomNumber = true;
					}
				}
			}
		}
		
		
		boolean isValidRandomNumber = false;
		while(!isValidRandomNumber) {
			int randomNumber = new Random().nextInt(9) + 1;
			if(!existsInRow(randomNumber, sudoku, 0) && !existsInLine(randomNumber, sudoku, 0) && !existsInField(randomNumber, sudoku, 0, 0)) {
				sudoku[0][0] = randomNumber;
				isValidRandomNumber = true;
			}
		}
		
		
		printSudoku(sudoku);
	}
	
	
	private static boolean existsInRow(int randomNumber, int[][] sudoku, int row) {
		for(int line = 0; line < sudoku[row].length; line ++) {
			if(sudoku[row][line] == randomNumber) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean existsInLine(int randomNumber, int[][] sudoku, int line) {
		for(int row = 0; row < sudoku.length; row ++) {
			if(sudoku[row][line] == randomNumber) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean existsInField(int randomNumber, int[][] sudoku, int row, int line) {
		int maxFieldLength = 3;
		
		int endRow 	= ((row / maxFieldLength) + 1) * maxFieldLength;
		int endLine	= ((line / maxFieldLength) + 1) * maxFieldLength;
		
		for(int currentRow = (endRow - maxFieldLength); currentRow < endRow; currentRow++) {
			for(int currentLine = (endLine - maxFieldLength); currentLine < endLine; currentLine++) {
				if(randomNumber == sudoku[currentRow][currentLine]) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static void printSudoku(int[][] sudoku) {
		for(int i = 0; i < sudoku.length; i++ ) {
			for(int j = 0; j < sudoku[i].length; j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	
}