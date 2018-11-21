package work_from_home;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Hangman {

	/**
	 * TODO:
	 * Müssen die Globalen Variablen wirklich global sein? 
	 * 
	 *  Überarbeitung von ALLEN Ausgaben! überlegen welche ausgaben ich wirklich brauche und wie ich mein hangman "schneller" schreiben könnte bzw mir 
	 *  Code spare indem ich verschiedene Bereiche "zusammenfasse"
	 */
	
	//überarbeiten
	// wo brauchen wir computer wirklich? Macht es als Globale Variable Sinn?
	private ResolveHangman computer;
	private boolean isHumanPlaying = false;
	
	public Hangman(boolean isHumanPlaying) throws IOException {
		this.isHumanPlaying = isHumanPlaying;
	}
	
	
	/**
	 * Startpunkt der Klasse -> aufrufen aller anderen Methoden 
	 * @throws IOException 
	 */
	public void startGame() throws IOException {
		int win = 0;
		ArrayList<Character> alreadyUsedCharList = new ArrayList<Character>();
		if(!isHumanPlaying) {
			this.computer = new ResolveHangman();
		}
		int life =8;
		System.out.println("Bitte geben Sie Ihr Wort ein.");
		String wort = insertWordManuel();
		boolean wordBeginsUpperCase = isFirstCharUpperCase(wort);
		wort = toSmall(wort);
		char[] theWord = new char[wort.length()];
		for(int i=0;i<theWord.length;i++) {
			theWord[i]='.';
		}
		gameLogic(wort,theWord,life,alreadyUsedCharList, win, wordBeginsUpperCase);
	}
	
	/**
	 * Prüft ob erster Buchstabe groß oder kleingeschrieben ist
	 * @param wort
	 */
	private boolean isFirstCharUpperCase(String wort) {
		String posibilUpperChars ="ABCDEFGHIJKLMNOPQRSTUVWXYZÜÄÖ";
		Character firstChar = wort.charAt(0);
		for(int i =0;i<posibilUpperChars.length();i++) {
			if(firstChar.equals(posibilUpperChars.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Kleinschreibung des zu suchenden Wortes 
	 * @param wort
	 * @return
	 */
	private String toSmall(String wort) {
		wort = wort.toLowerCase();
		return wort;
	}
	
	/**
	 * befüllung der leeren Array Felder mit . -> wenn in array[i]=='.' darstellung durch _ 
	 * @param theWord
	 */
	//ausgabe überarbeiten 
	private void printOnScreen(char[] theWord, boolean wordBeginsUpperCase) {
		for(int i=0;i<theWord.length;i++) {
			if(theWord[i]!='.') {
				if(i==0) {
					if(wordBeginsUpperCase) {
						Character firstCharShouldBeUpperCase = theWord[0];
						firstCharShouldBeUpperCase = Character.toUpperCase(theWord[0]);
						theWord[0] = firstCharShouldBeUpperCase;
					}
				}
				System.out.print(theWord[i]+" ");
			}else {
				System.out.print("_ ");
				
			}
		}
		System.out.println();
	}

	/**
	 * Prüft bisher eingegebene Buchstaben ob zusammengesetzt gleich dem Suchwort.
	 * @param wort
	 * @param theWord
	 * @return
	 * @throws IOException 
	 */
	private int isWin(String wort,char[] theWord, boolean wordBeginsUpperCase) throws IOException {
		String guessedWord ="";
		for(int i=0;i<theWord.length;i++) {
			guessedWord = guessedWord+theWord[i];		
		}
		if(wort.toLowerCase().equals(guessedWord.toLowerCase())) {
			printOnScreen(theWord, wordBeginsUpperCase);
			return 1;
			
		}else {
			return 0;
			
		}
	}
	
	/**
	 * Aufruf aller Spielmethoden solange leben!=0
	 * @param wort
	 * @param theWord
	 * @return
	 * @throws IOException 
	 */
	private void gameLogic(String wort,char[] theWord, int life, ArrayList<Character> alreadyUsedCharList,int win, boolean wordBeginsUpperCase) throws IOException {
		while(life >= 1 && win == 0){
			System.out.println("Sie haben noch "+life+" Versuche");
			printOnScreen(theWord, wordBeginsUpperCase);
			System.out.println();
			Character toTest = ' ';
			if(isHumanPlaying) {
				System.out.println("Bitte geben Sie Ihren Buchstaben ein.");
				toTest = insertWordManuel().charAt(0);
			}else {
				System.out.println("Bitte warten... Buchstabe wird berechnet");
				toTest = computer.getChar(theWord);
			}
			
			String insertChar = toTest.toString();
			//prüfe ob buchstabe vorhanden
			if(wort.contains(insertChar)) {
				for(int i=0;i<wort.length();i++) {
					if(wort.charAt(i)==toTest) {
						theWord[i]=toTest;
					}
				}
				alreadyUsedChars(toTest,alreadyUsedCharList);
				
			}else {
				life -=1;
				alreadyUsedChars(toTest,alreadyUsedCharList);
//				gameLogic(wort,theWord, life,alreadyUsedCharList,win);
			}
			win = isWin(wort,theWord, wordBeginsUpperCase);
			visualOut(life, win);
		}
		if(life == 0) {
			System.out.println("Leider Verloren :(");
			return;
		}
		else if(win == 1) {
			System.out.println("GEWONNEN!");
			return;
		}
		if(!isHumanPlaying) {
		writeIntoWordGlossar(wort,wordBeginsUpperCase);
		}
		
		gameLogic(wort, theWord, life, alreadyUsedCharList, win, wordBeginsUpperCase);
	}
	
	/**
	 * Fügt Wort in Glossar hinzu
	 * @param wort
	 * @param wordBeginsUpperCase
	 * @throws IOException
	 */
	private void writeIntoWordGlossar(String wort, boolean wordBeginsUpperCase) throws IOException{
		if(wordBeginsUpperCase) {
			Character firstCharFromWord = wort.charAt(0);
			Character FirstCharIsUpperCase = Character.toUpperCase(firstCharFromWord);
			wort = wort.replaceFirst(firstCharFromWord.toString(), FirstCharIsUpperCase.toString());
			
		}
		FileWriter fw = new FileWriter ("D:\\Danz Kai Adrian empiriecom\\Hangman\\wortsammlung.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.newLine();
		bw.write(wort);
		bw.close();
		
	}


	private void alreadyUsedChars(char used, ArrayList<Character> alreadyUsedCharList) {
		if(alreadyUsedCharList.contains(used)) {
			System.out.println();
			System.out.println("Fehler! Buchstabe schon benutzt! Bitte versuchen Sie einen anderen Buchstaben");
			System.out.println();
			return;
		}
		alreadyUsedCharList.add(used);
		System.out.println();
		System.out.println("Ihre benutzten Buchstaben:");
		System.out.println(alreadyUsedCharList);
		System.out.println();
	}
	

	
	private void visualOut(int life, int isWin) {
		System.out.println(" ________");
		switch(isWin){
			case 0:
				switch(life) {
				case 8:
					System.out.println(" |");
					System.out.println(" |");
					System.out.println(" |");
					System.out.println(" |");
					System.out.println(" |");
					System.out.println("_|____");
					System.out.println("|     |___");
					break;
				case 7:
					System.out.println(" |      |");
					System.out.println(" |");
					System.out.println(" |");
					System.out.println(" |");
					System.out.println(" |");
					System.out.println("_|____");
					System.out.println("|     |___");
					break;
				case 6:
					System.out.println(" |      |");
					System.out.println(" |      0");
					System.out.println(" |");
					System.out.println(" |");
					System.out.println(" |");
					System.out.println("_|____");
					System.out.println("|     |___");
					break;
				case 5:
					System.out.println(" |      |");
					System.out.println(" |      0");
					System.out.println(" |      |");
					System.out.println(" |");
					System.out.println(" |");
					System.out.println("|     |___");
					break;
				case 4:
					System.out.println(" |      |");
					System.out.println(" |      0");
					System.out.println(" |     /|");
					System.out.println(" |");
					System.out.println(" |");
					System.out.println("_|____");
					System.out.println("|     |___");
					break;
				case 3:
					System.out.println(" |      |");
					System.out.println(" |      0");
					System.out.println(" |     /|");
					System.out.println(" |      |");
					System.out.println(" |");
					System.out.println("_|____");
					System.out.println("|     |___");
					break;
				case 2:
					System.out.println(" |      |");
					System.out.println(" |      0");
					System.out.println(" |     /|");
					System.out.println(" |      |");
					System.out.println(" |     /");
					System.out.println("_|____");
					System.out.println("|     |___");
					break;
				case 1:
					System.out.println(" |      |");
					System.out.println(" |      0");
					System.out.println(" |     /|");
					System.out.println(" |      |");
					System.out.println(" |     / \\");
					System.out.println("_|____");
					System.out.println("|     |___");
					break;
				case 0:
					System.out.println(" |      |");
					System.out.println(" |      X");
					System.out.println(" |     /|\\");
					System.out.println(" |      |");
					System.out.println(" |     / \\");
					System.out.println("_|____");
					System.out.println("|     |___");
					break;
				}
				break;
				
			case 1:
				System.out.println(" |      |");
				System.out.println(" |        ");
				System.out.println(" |        ");
				System.out.println(" |      0 ");
				System.out.println(" |     \\|/  ");
				System.out.println("_|____  |  ");
				System.out.println("|     |/_\\_");
				break;
		}
		System.out.println("|_________|");
	}

	/**
	 * Wort wird manuell eingefügt
	 * @return
	 * @throws IOException
	 */
	private String insertWordManuel() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String eingabe = br.readLine();
		return eingabe;
	}
	
}
	