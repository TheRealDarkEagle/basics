package com.empirie.kai.uebungen.advanced.array.bruteforce;

public class BruteForcev1{
	
	private static String pw= "c";
	private static int maxLaengePw = 4;
	private static StringBuffer sb = new StringBuffer(maxLaengePw);
	private static char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
											//   "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	static String pseudoPasswort="";
	int i;
	
//Methode
	public static int passwortKnacken(int i,StringBuffer sb){
		if(i == 0){
			System.out.println("ERROR" + sb);
			return 1;
		}else{
//Array zum ansprechen des alphabet
			for(int index=0;index<alphabet.length;index++){
				sb.setCharAt(i,alphabet[index]);
				System.out.println(sb);
				if(sb.toString().equals(pw)){
					System.out.println("Passwort wurde geknackt!");
					return 1;
				}
			}
			
			return passwortKnacken(i--,sb);
		}
	}
//Main-Methode	
	public static void main(String[] args){
		passwortKnacken(maxLaengePw,sb);
	}
}