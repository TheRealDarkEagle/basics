package com.empirie.uebungen.advanced.permutation;
import java.util.Arrays;
/**
 * 
 * @author danzk
 * @version 1
 */
public class Permutation {

	private static int counter = 0;
	private static String wort = "abc";
	private static char[] array = wort.toCharArray();
	
	public static void main(String[] args) {
		System.out.println("Das permutierende Wort ist: "+ wort);
		permutation("", wort);	
	}
	
	private static void permutation(String prefix, String str) {
//		StringBuffer sb = new StringBuffer(wort);
		if(counter == 3) {
			System.out.println("Fertig");
		}else{
			for(int tausch=0;tausch<wort.length();tausch++) {
				//tausche buchstabe 0 mit 0-2 
				Character istA = 'a';  			//istA bekommt a und gibt es an tausch zurück
				array[0] = array[tausch];		//tausch erhält 0-3 und gibt buchstaben an erste stelle 
				array[tausch] = istA;
				//nehme ersten buchstaben und gebe an prefix
				prefix = Arrays.toString(array);
				//gebe an str die letzten beiden buchstaben 
				//str = 
				System.out.println(prefix + " " + wort);
				//tausche buchstaben in str
				
			}
			counter++;
			permutation(prefix,str);
		}
	}
}
