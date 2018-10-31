package com.empirie.kai.uebungen.Rot13v1;


public class Root13v1{

	private String test = "Hallo dies ist ein Test"; 
	private char[] chr = test.toCharArray();
	private char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
										  'A','B','C','D','E','F','G','H','I','j','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};	 
	private int erhoehung = 13;
	private int b = 0;
	
					
//Methode
	public void verschluesseln(){
		System.out.println(test);
		System.out.println("Ihr Passwort wird verschluesselt... Bitte warten!");
//		this.test = test;
//		this.chr = chr;
//		this.alphabet = alphabet;
		boolean pruefen = false;
		for(int i= 0; i<chr.length; i++){
			int restMenge = 0;
			int differenz = 0;		
			int ende = 51;	
			b = 0;
			do{
//Wenn buchstabe klein ist anfang ist 0 ende ist 25 - wenn groß anfang ist 26 und ende ist 51
				if(chr[i]==alphabet[b]){
//Wenn buchstabe gefunden prüfe ob zwischen 0-25 (kleinbuchstabe) oder zwischen 26-51 (großbuchstabe)
					if(b<(ende/2)+1){
						if(b+erhoehung<(ende/2)+1){
							chr[i] = alphabet[b+erhoehung];
							pruefen = true;
							System.out.print(chr[i]);
							}else{
//b + erhöhung würde über 25 gehen ... errechne restwert und setze startpunkt auf 0 + differenz 
								restMenge = (ende/2)+1 - b;
								differenz = erhoehung - restMenge;
								b = 0;
								chr[i] = alphabet[b + differenz];
								System.out.print(chr[i]);
								pruefen = true;
							}
					}else if(b>(ende/2)){
						if(b+erhoehung<ende){
							chr[i] = alphabet[b+erhoehung];
							System.out.print(chr[i]);
							pruefen = true;
						}else{
//b + erhöhung würde über 25 gehen ... errechne restwert und setze startpunkt auf a + differenz 
							restMenge = ende - b;
							differenz = erhoehung - restMenge;
							b = (ende/2);
							chr[i] = alphabet[b + differenz];
							System.out.print(chr[i]);
							pruefen = true;
						}
					}
				} else if(chr[i] == ' '){
					System.out.print(chr[i]);
					pruefen = true;
				}else {
					b++;
					pruefen = false;
				}
			}while(pruefen != true);
		}
		System.out.println();
	}
//Methode
	public void entschluesseln(){
//		this.test = test;
//		this.chr = chr;
//		this.alphabet = alphabet;
		boolean pruefen = false;
		System.out.println("Ihr Passwort wird entschluesselt...Bitte warten!");
		for(int i= 0; i<chr.length; i++){
			int restMenge = 0;
			int differenz = 0;		
			int ende = 51;	
			b = 0;
			do{
//Wenn buchstabe klein ist anfang ist 0 ende ist 25 - wenn groß anfang ist 26 und ende ist 51
				if(chr[i]==alphabet[b]){
//Wenn buchstabe gefunden prüfe ob zwischen 0-25 (kleinbuchstabe) oder zwischen 26-51 (großbuchstabe)
					if(b<(ende/2)+1){
						if(b+erhoehung<(ende/2)+1){
							chr[i] = alphabet[b+erhoehung];
							pruefen = true;
							System.out.print(chr[i]);
							}else{
//b + erhöhung würde über 25 gehen ... errechne restwert und setze startpunkt auf 0 + differenz 
								restMenge = (ende/2)+1 - b;
								differenz = erhoehung - restMenge;
								b = 0;
								chr[i] = alphabet[b + differenz];
								System.out.print(chr[i]);
								pruefen = true;
							}
					}else if(b>(ende/2)){
						if(b+erhoehung<ende){
							chr[i] = alphabet[b+erhoehung];
							System.out.print(chr[i]);
							pruefen = true;
						}else{
//b + erhöhung würde über 25 gehen ... errechne restwert und setze startpunkt auf a + differenz 
							restMenge = ende - b;
							differenz = erhoehung - restMenge;
							b = (ende/2);
							chr[i] = alphabet[b + differenz];
							System.out.print(chr[i]);
							pruefen = true;
						}
					}
				} else if(chr[i] == ' '){
					System.out.print(chr[i]);
					pruefen = true;
				}else {
					b++;
					pruefen = false;
				}
			}while(pruefen != true);
		}
	}
}