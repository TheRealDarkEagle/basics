package com.empirie.kai.uebungen.advanced.array.binarysearch;

public class BinarySearch{
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

	public int[] sortArray (int[] unsortedArray){
		
//Sortierung des Arrays (bubble sort)
		for(int x=0; x<unsortedArray.length;x++){
			for(int y=1; y<unsortedArray.length;y++){
				if(unsortedArray[y]<unsortedArray[y-1]){
					int puffer = unsortedArray[y-1];
					unsortedArray[y-1] = unsortedArray[y];
					unsortedArray[y] = puffer;
				}
			}
		}
// ist hier sortiert
		for(int a=0;a<unsortedArray.length;a++){	
			System.out.print(unsortedArray[a]+" ");
		}
		return unsortedArray;
	}
	
	public int search(int anfang, int ende, int[] searchArray, int searchNumber){
		int i = 0;
		while(i < 1000){
			int arrayMitte = ((anfang + ende) / 2);
//schaue nach ob durchsucht = gesucht 
			if(searchArray[arrayMitte] == searchNumber){
				return arrayMitte+1;
//Wenn gesuchter Wert kleiner als Durchsuchten Wert 
			}
			else if(searchNumber < searchArray[arrayMitte]){
				ende = arrayMitte;
				return this.search(anfang, ende, searchArray, searchNumber);
			}
//Wenn gesuchter Wert größer als Durchsuchten Wert 
			else if(searchNumber>searchArray[arrayMitte] ){
				anfang = arrayMitte;
				return this.search(anfang, ende, searchArray, searchNumber);
			}
			i++;
		}
		return i;
	}
}