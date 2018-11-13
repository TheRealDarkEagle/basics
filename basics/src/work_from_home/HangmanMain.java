package work_from_home;

import java.util.Scanner;

public class HangmanMain {
	
	public static void main (String[] args) {
		// true wenn ein Mensch spielt, false wenn der Computer
		System.out.println("#################################################################");
		System.out.println();
		System.out.println();
		System.out.println("           Willkommen zu Hangman! Viel Spaß beim Spielen :)");
		System.out.println();
		System.out.println("Wer soll Spielen? Drücken Sie M fuer Mensch und C für Computer!");
		Scanner auswahl = new Scanner(System.in);
		String auswahlDesSpielers = auswahl.nextLine();
		auswahl.close();
		if(auswahlDesSpielers.length() != 1) {
			throw new IllegalArgumentException("Bitte geben Sie nur einen Buchstaben ein!");
		}
		if(auswahlDesSpielers.equals("M") || auswahlDesSpielers.equals("m")) {
			new Hangman(true).startGame();	
		}else if(auswahlDesSpielers.equals("C") || auswahlDesSpielers.equals("c")) {
			new Hangman(false).startGame();
		}
	}
}
