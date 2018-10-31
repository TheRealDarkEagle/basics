package com.empirie.kai.uebungen.Palindrom;

public class Palindrom{

	
	public static int checker(String wort){
		if(wort.length()<=1){
			System.out.println("Glueckwunsch! Ihr Wort ist ein Palindrom");
			return 1;
		}else{
//teste ob erster und letzter buchstabe gleich ist 
			if(wort.toLowerCase().charAt(0) == wort.toLowerCase().charAt(wort.length()-1)){
			}else{
				System.out.println("ERROR! Kein Palindrom!!");
				return -1;
			}
//nehme den substring von den restlichen buchstaben
			return checker(wort.substring(1,wort.length()-1)); 
		}
	}
//Main-Methode
	public static void main(String[] args){
		checker("Otto");
	}
}