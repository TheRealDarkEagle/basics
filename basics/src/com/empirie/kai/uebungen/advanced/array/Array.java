package com.empirie.kai.uebungen.advanced.array;
/**	
*	Erstellen eines Arrays 	
*	zuweisung zufaelliger Zahlen 
*	Sortierung via BubbleSort (selbst programmiert)
*	
*	@author kai Danz 
*	@version final
*/

import java.util.Random;
public class Array {
	
	public static void main(String[] args){
		int i;
//Initialisierung und Zuweisung des Array
		int meinArray[] = new int[8];
		for(i=0; i<meinArray.length;i++){
			meinArray[i] = randomNumber();
//Ausgabe des Array
			System.out.print(meinArray[i]+" ");
		}
		System.out.println();
//Sortierung
		for(int x=0;x<meinArray.length;x++){
			for(i=1;i<meinArray.length;i++){
				if(meinArray[i-1]>meinArray[i]){
					int a = meinArray[i];
					meinArray[i] = meinArray[i-1];
					meinArray[i-1] = a;
				}	
			}
		}
//Ausgabe des Sortierten Arrays
		for(i=0;i<meinArray.length;i++){
		System.out.print(meinArray[i]+" ");
		}
		
	}
	private static int randomNumber() {
        return new Random().nextInt(100) + 1;
    } 
}

