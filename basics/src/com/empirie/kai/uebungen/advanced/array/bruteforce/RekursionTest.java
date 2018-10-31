package com.empirie.kai.uebungen.advanced.array.bruteforce;

public class RekursionTest{
	private static int sum = 0;

	static int fakultaetRekursiv(int n) {
		if (n == 1){
			return 1;
		}else{		
			System.out.println(sum *= n);
			return fakultaetRekursiv(n - 1) * n;
		}

	}
	
	public static void main(String[] args){
		fakultaetRekursiv(5);
	}
}