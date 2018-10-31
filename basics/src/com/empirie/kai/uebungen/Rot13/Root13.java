package com.empirie.kai.uebungen.Rot13;


public class Root13{
	
	private String test = "hallo my"; 
	private char[] chr = test.toCharArray();
	private char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private int b = 0;
//private char[] chr = new char[testCharArray];
	private int erhoehung = 13;
	
//Methode
	public void verschluesseln(){
//		this.chr = chr;
//		this.alphabet = alphabet;
		int differenz;
		int restMenge; 
		boolean pruefen = false;
		System.out.println(test);
//Abgleich des chr arrays mit alphabet array 
		for(int i = 0; i<chr.length;i++){
			do{
//Wenn chr[i] gleich mit alphabet[b] ist dann
				if(chr[i]==alphabet[b]){
//wenn buchstabe + 13 kleiner ist als 26  
					if(b+erhoehung<alphabet.length){
						chr[i] = alphabet[b + erhoehung];
						System.out.print(chr[i]);
						pruefen = true;
						b = 0;
					}else {
						restMenge =  alphabet.length - b;
						differenz = erhoehung - restMenge;
						b = 0;
						chr[i] = alphabet[b + differenz];
						System.out.print(chr[i]);					
						pruefen = true;
						b = 0;
					}
//Wenn b nicht 27 ist 
				}else if(b != alphabet.length){
					b++;
					System.out.println(b);
					pruefen = false;
//funktioniert noch nicht mit leerzeichen 
				}else if(chr[i] == ' '){
					chr[i] = ' ';
					System.out.print(chr[i]);
					b = 0;
					pruefen = true;
				}
			}while(pruefen != true);
		}
			System.out.println();
			System.out.println("Ihr Passwort wurde erfolgreich verschluesselt!");
	}
//Methode 
	public void entschluesseln(){
//		this.chr = chr;
//		this.alphabet = alphabet;
		int differenz;
		int restMenge; 
		boolean pruefen = false;
		for(int i=0; i < chr.length; i++){
			do{
//Wenn chr[i] gleich mit alphabet[b] ist dann
				if(chr[i]==alphabet[b]){
//wenn buchstabe + 13 kleiner ist als 26  
					if(b+erhoehung<26){
						chr[i] = alphabet[b + erhoehung];
						System.out.print(chr[i]);
						pruefen = true;
						b = 0;
					}else {
						restMenge =  alphabet.length - b;
						differenz = erhoehung - restMenge;
						b = 0;
						chr[i] = alphabet[b + differenz];
						System.out.print(chr[i]);					
						pruefen = true;
						b = 0;
					}
//Wenn b nicht 27 ist 
				}else if(b != alphabet.length){
					b++;
					pruefen = false;
//funktioniert noch nicht mit leerzeichen 
				}else{
					chr[i] = ' ';
					System.out.print(chr[i]);
					b = 0;
					pruefen = true;
				}
			}while(pruefen != true);
		}
			System.out.println();
			System.out.println("Ihr Passwort wurde erfolgreich entschluesselt!");
	}
}
