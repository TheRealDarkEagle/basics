package com.empirie.kai.uebungen.advanced.array.bruteforce;

public class BruteForce {

	private static String pw = "tester";
	private static String[] alphabet = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
													 "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	int i = 0;
	
//Methode 
	public static void passwortKnacken(String string){
		String pwGefunden = "Passwort = ";
		StringBuffer sb = new StringBuffer();
		if(sb.toString().equals(pw)){
			
		}else{
			for(int a=0;a<alphabet.length;a++){
				String stringA = alphabet[a];
				for(int b=0;b<alphabet.length;b++){
					String stringB = alphabet[b];
					for(int c=0;c<alphabet.length;c++){
						String stringC = alphabet[c];
						for(int d=0;d<alphabet.length;d++){
							String stringD = alphabet[d];
							for(int e=0;e<alphabet.length;e++){
								String stringE = alphabet[d];
								for(int f=0;f<alphabet.length;f++){
									String stringF = alphabet[f];
									sb.append(pwGefunden);
									sb.append(stringA);
									sb.append(stringB);
									sb.append(stringC);
									sb.append(stringD);
									sb.append(stringE);
									sb.append(stringF);
									System.out.println(sb + " ");
								}
							}
						}
					}
				}
			}
			
		}
	}
//Main-Methode	
	public static void main(String[] args){
		passwortKnacken(pw);
	}
}


