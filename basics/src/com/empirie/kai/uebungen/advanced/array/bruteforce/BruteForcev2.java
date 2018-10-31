package com.empirie.kai.uebungen.advanced.array.bruteforce;

public class BruteForcev2{
	
	//UNFERTIG!!!
//	private static int momentanerBuchstabe;
//	private static boolean istZahlGesetzt = false;
	private static int position = 1;
	private static int naechsterBuchstabe = 0;
	private static int sbMomentLaenge = 1;
//	private static int durchlauf = 0;
	private static int maxLaengePw = 6;
	private static String pw = "ash";
	private static StringBuffer sb = new StringBuffer(sbMomentLaenge); 
	private static char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	public static int passwortKnacken(int a, StringBuffer sb){
		sb.setLength(sbMomentLaenge);
//Wenn gleich dann return 1
		if(sbMomentLaenge==maxLaengePw+1){
			System.out.println("ERROR!");
			return 1;
//ansonsten
		}else{
//durchlauf meines alphabet 
			for(int index = 0; index < alphabet.length; index++){
//gebe durchlaufenden buchstaben in variable
				char puffer = alphabet[index];
				sb.setCharAt(0,puffer);
				System.out.println(sb);
//Wenn gleich return 1 
//ansonsten rufe funktion wieder auf 
				if(sb.toString().equals(pw)){
					System.out.println("Ihr Passwort wurde geknackt!");
					return 1;
				}
			}
//wenn letzter buchstabe auf z erhöhe länge 
			if(sb.charAt(sbMomentLaenge-1) == 'z'){
				naechsterBuchstabe = 0;
				sb.setCharAt(sbMomentLaenge-1,alphabet[0]);
				sbMomentLaenge++;
				sb.setLength(sbMomentLaenge);
				sb.setCharAt(sbMomentLaenge-1,alphabet[naechsterBuchstabe]);
			}
//Wenn länge von sb größer als 2
			if(sbMomentLaenge >2){
//dursuche sb nach z und setzte auf a wenn position und position-1 z ist 
				for(position = sbMomentLaenge-1;position >=1;position--){
					if(sb.charAt(position) == 'z'&& sb.charAt(position-1) == 'z'){
						sb.setCharAt(position,alphabet[0]);
						System.out.println("Dies enthaelt mein sb: "+sb);
						}
					}
//erhöhe buchstabe von position+1 um eins 
					for(int buchstabe=0;buchstabe<alphabet.length;buchstabe++){
							char temp = alphabet[buchstabe];
						if(sb.charAt(position+1) == temp){
							System.out.println("das ist mein temp: " + temp);
							sb.setCharAt(position+1,temp++);
						}
					}
				}		
//Wenn 0 auf z setzte 1 um eins nach oben wenn es nicht z ist 
//Wenn es z ist setze auf a und erhöhe rechts daneben um eins 
			if(sb.charAt(0) == 'z'){
				if(sb.charAt(1) != 'z'){	
					for(int buchstabe=0;buchstabe<alphabet.length;buchstabe++){
						if(sb.charAt(1) == alphabet[buchstabe]){
					System.out.println("Wert von Buchstabe: "+alphabet[buchstabe]);	
					System.out.println("SB" + sb);
							sb.setCharAt(1,alphabet[buchstabe+1]);
						}
					}
				}else{
					sb.setCharAt(1,alphabet[naechsterBuchstabe]);
				}
			}
		System.out.println("Nächster Versuch");
		return passwortKnacken(a+1,sb);
		}
	}
//Main-Methode	
	public static void main(String[] args){
		passwortKnacken(0,sb);
	}
}