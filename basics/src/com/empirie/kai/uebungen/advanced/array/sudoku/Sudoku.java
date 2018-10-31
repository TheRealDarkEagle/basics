package com.empirie.kai.uebungen.advanced.array.sudoku;


public class Sudoku {
	
	public static void main(String[] args) {
		int a = 1;
		int x = 1;
		int b = 1;
		int y = 1;
		int v = 1;
		for(int j=1; j<10; j++){
			if(b == 4 || b == 7){
				y++;
				x = y;
				System.out.println("-------------------------");
			}
			System.out.print('|' + " ");
			a = x;
			for(int i=1; i<10; i++){
				if(a>=10){
					a = 1;
				}
				System.out.print(a+" ");
				a++;
				v++;
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

}