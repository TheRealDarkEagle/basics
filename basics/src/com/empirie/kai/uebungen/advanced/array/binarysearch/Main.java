package com.empirie.kai.uebungen.advanced.array.binarysearch;

/**
*	Binary Search 
*	erstellen eines arrays 
* 	befüllung mit zufällig generierten Zahlen 
* 	Sortierung der Zahlen 
*	Ausgabe des Index-Wertes der gesuchten Zahl 
*
*	@author Kai Danz
* 	@version final
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) {
		arrayBuild();
	}
	
	
	public static void arrayBuild(){	
		int[] array = new int[20];
//Initialisierung des Arrays
		for(int j=0;j<array.length;j++){
			array[j] = new Random().nextInt(100) + 1;
			System.out.print(array[j]+" ");
		}
		System.out.println();
//Eingabe der gesuchten Zahl
		System.out.println("Bitte geben Sie ihre gesuchte Zahl ein: ");
		int x = readInt();
		
		BinarySearch binary = new BinarySearch();
		int[] sortedArray = binary.sortArray(array);
		int arrayStart = 0; 
		int arrayEnde = sortedArray.length;
		int suchIndex = binary.search(arrayStart, arrayEnde, sortedArray, x);
		System.out.println("Der gesuchte Wert liegt an Stelle: " + suchIndex);
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