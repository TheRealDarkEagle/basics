package work_from_home;

import java.util.ArrayList;
import java.util.Random;

public class ResolveHangman {
	
	String potencialChars = "abcdefghijklmnopqrstuvwxyz";
	int[] countChars= new int[potencialChars.length()];
	char[] allChars = potencialChars.toCharArray();
	static int life =8;
	ArrayList<Character> usedCharsList = new ArrayList<Character>();
	ArrayList<String> list = new ArrayList<String>();

	//hangman
	/**
	 * Startpunkt der Klasse -> aufrufen aller anderen Methoden 
	 */
	public void startGame() {
		listing();
		countAndSort();
		String wort = random();
		wort = toSmall(wort);
		char[] theWord = new char[wort.length()];
		for(int i=0;i<theWord.length;i++) {
			theWord[i]='.';
		}
		gameLogic(wort,theWord);
		
	}
	
	//hangman
	/**
	 * Aufruf aller Spielmethoden solange leben!=0
	 * @param wort
	 * @param theWord
	 * @return
	 */
	private String gameLogic(String wort,char[] theWord) {
		while(life != 0) {
			hangingManVisual(life);
			System.out.println("Sie haben noch "+life+" Versuche");
			printOnScreen(theWord);
			System.out.println();
			Character toTest = getChar();
			System.out.println("Bitte geben sie Ihren Buchstaben ein: "+toTest);
			String a = toTest.toString();
			//prüfe ob buchstabe vorhanden
			if(wort.contains(a)) {
				for(int i=0;i<wort.length();i++) {
					if(wort.charAt(i)==toTest) {
						theWord[i]=toTest;
					}
				}
				charExist(toTest);
				alreadyUsedChars(toTest);
				return isWin(wort,theWord);
			}else {
				life -=1;
				charDoesNotExist(toTest);
				alreadyUsedChars(toTest);
				return gameLogic(wort,theWord);
			}
		}
		hangingManVisual(life);
		System.out.println("Leider Verloren :(");
		return wort;
	}
	
	//hangman
	/**
	 * Kleinschreibung des zu suchenden Wortes 
	 * @param wort
	 * @return
	 */
	private static String toSmall(String wort) {
		wort = wort.toLowerCase();
		return wort;
	}
	
	//hangman
	/**
	 * befüllung der leeren Array Felder mit . -> wenn in array[i]=='.' darstellung durch _ 
	 * @param theWord
	 */
	private static void printOnScreen(char[] theWord) {
		for(int i=0;i<theWord.length;i++) {
			if(theWord[i]!='.') {
				System.out.print(theWord[i]+" ");
			}else {
				System.out.print("_ ");
				
			}
		}
	}

	//hangman
	/**
	 * Prüft bisher eingegebene Buchstaben ob zusammengesetzt gleich dem Suchwort.
	 * @param wort
	 * @param theWord
	 * @return
	 */
	private String isWin(String wort,char[] theWord) {
		String guessedWord ="";
		for(int i=0;i<theWord.length;i++) {
			guessedWord = guessedWord+theWord[i];		
		}
		if(wort.equals(guessedWord)) {
			printOnScreen(theWord);
			System.out.println();
			System.out.println("Gewonnen!");
			visualWin();
			return "";
			
		}else {
			return gameLogic(wort,theWord);
			
		}
	}
	
	
	//hangman
	/**
	 * Erstelle liste mit Wörtern der vorherigen Liste, in dessen der Buchstabe vorhanden ist 
	 * @param charExist
	 */
	private void charExist(Character charExist) {
		ArrayList<String> shadowList = new ArrayList<String>();
		shadowList.addAll(list);
		list.clear();
		for(int i=0;i<shadowList.size();i++) {
			if(shadowList.get(i).contains(charExist.toString())) {
				list.add(shadowList.get(i));
			}
		}
		list.trimToSize();
	}
	
	//solver
	/**
	 * "Leert" das Array countChars
	 */
	private void resetCounterFromDigitList() {
		for (int i = 0; i < countChars.length; i++) {
			countChars[i] = 0;
		}
	}
	
	//solver
	/**
	 * Erstelle Liste mit Wörtern der vorherigen Liste, in dessen der Buchstabe NICHT vorhanden ist 
	 * @param charDoesNotExist
	 */
	private void charDoesNotExist(Character charDoesNotExist) {
		ArrayList<String> shadowList = new ArrayList<String>();
		shadowList.addAll(list);
		list.clear();
		for(int i=0;i<shadowList.size();i++) {
			if(!shadowList.get(i).contains(charDoesNotExist.toString())) {
				list.add(shadowList.get(i));
			}
		}
		list.trimToSize();
	}
	
	//solver
	/**
	 * aufrufen der Methoden: resetCounterFromDigitList,countCharacter,sortArrays
	 */
	private void countAndSort() {
		resetCounterFromDigitList();
		countCharacter(countChars,allChars);
		sortArrays(countChars,allChars);
	}
	
	//solver 
	/**
	 * Sucht anhand der Wörterliste den nächhäufigst vorkommenden Buchstaben heraus 
	 * @return char 
	 */
	private char getChar() {
		countAndSort();
		int counter=0;
		int lengeCharArray = potencialChars.length()-1;
		System.out.println(allChars[lengeCharArray]);
		char bestChar = potencialChars.charAt(lengeCharArray);
		while(usedCharsList.contains(bestChar)) {
			
			bestChar = allChars[lengeCharArray-counter];
			counter++;
		}
		return bestChar;
	}
	
	//hangman
	/**
	 * Prüft ob Buchstabe schon eingegeben wurde
	 * @param used
	 */
	private void alreadyUsedChars(char used) {
		if(usedCharsList.contains(used)) {
			System.out.println();
			System.out.println("Fehler! Buchstabe schon benutzt! Bitte versuchen Sie einen anderen Buchstaben");
			System.out.println();
			return;
		}
		usedCharsList.add(used);
		System.out.println();
		System.out.println("Ihre benutzten Buchstaben:");
		for(int o=0;o<usedCharsList.size();o++) {
			System.out.print(usedCharsList.get(o)+" ");
		}
		System.out.println();
		System.out.println();
	}
	
	
	/**
	 * Zählt alle Buchstaben durch die in der Liste vorhanden sind 
	 * @param countChars
	 * @param allChars
	 */
	private void countCharacter(int[] countChars,char[] allChars) {
		String allWords = mergeWordList().toLowerCase();
		for(int i=0;i<allWords.length();i++) {
			for(int x=0;x<allChars.length;x++) {
				if(allChars[x]==allWords.charAt(i)) {
					countChars[x]++;
				}
			}
		}
	}
	
	/**
	 * Setzt alle wörter zu einem ganzen String zusammen
	 * @return
	 */
	private String mergeWordList() {
		int sizeOfList = list.size();
		StringBuilder sb = new StringBuilder(); 
		for(int a=0;a<sizeOfList;a++) {
			sb = sb.append(list.get(a));
		}
		String allWords = sb.toString();
		return allWords;
	}
	
	/**
	 * Sortiert countChars und allChars array nach häufigkeit der vorkommenden Buchstaben (Via BubbleSort)
	 * @param countChars
	 * @param allChars
	 */
	private void sortArrays(int[] countChars, char[] allChars) {
		for(int o=0;o<allChars.length;o++) {
			for(int a=1;a<allChars.length;a++) {
				if(countChars[a-1]>countChars[a]) {
					int tempZahl = countChars[a];
					char tempChar = allChars[a];
					countChars[a] = countChars[a-1];
					allChars[a] = allChars[a-1];
					countChars[a-1] = tempZahl;
					allChars[a-1] = tempChar;
					
				}
			}
		}
	}
	
	/**
	 * Liste mit möglichen Wörtern und heraussuchen eines per Zufall
	 * @return
	 */
	public void listing() {
		list.add("Stromaggregat");
		list.add("Computergehaeuse");
		list.add("Feuerwerk");
		list.add("Feuerwehr");
		list.add("Puzzleteil");
		list.add("Pizzateig");
		list.add("Gleichberechtigungsbeauftragter");
		list.add("Haengewandschrankhalterung");
		list.add("lokomotive");
		list.add("photovoltaikanlage");
		list.add("Autowaschanlage");
		list.add("Element");
		list.add("Wagenheber");
		list.add("Haarwurzel");
		list.add("develop");
		list.add("Anwendungsentwickler");
		list.add("Fachmann");
		list.add("Feuerwehrmann");
		list.add("Jahr");
		list.add("Uhr");
		list.add("Prozent");
		list.add("Million");
		list.add("Mensch");
		list.add("gehen");
		list.add("verschieden");
		list.add("Leben");
		list.add("allerdings");
		list.add("verstehen");
		list.add("Mutter");
		list.add("ueberhaupt");
		list.add("besonders");
		list.add("politisch");
		list.add("Gesellschaft");
		list.add("moeglichkeit");
		list.add("Unternehmen");
		list.add("buch");
		list.add("haben");
		list.add("ich");
		list.add("werden");
		list.add("sie");
		list.add("dies");
		list.add("Grundstuecksverkehrsgenehmigungszustaendigkeitsuebertragungsverordnung");
		list.add("Rindfleischetikettierungsueberwachungsaufgabenuebertragungsgesetz");
		list.add("Verkehrsinfrastrukturfinanzierungsgesellschaft");
		list.add("Gleichgewichtsdichtegradientenzentrifugation");
	}
	
	/**
	 * Erzeugen einer zufälligen Zahl zwischen 0 bis 10
	 * @param maxNumber
	 * @return
	 */
	private String random() {
		int maxNumber = list.size();
		Random wuerfel = new Random();
		int zahl = wuerfel.nextInt(maxNumber);
		String wort = list.get(zahl);
		return wort;
	}

	/**
	 * Erzeugen des Visuellen "Hangman" Fortschritt anhand von restlichen Leben
	 * @param life
	 */
	private void hangingManVisual(int life) {
		switch(life) {
		case 8:
			System.out.println(" ________");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|____");
			System.out.println("|     |___");
			System.out.println("|_________|");
			break;
		case 7:
			System.out.println(" ________");
			System.out.println(" |      |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|____");
			System.out.println("|     |___");
			System.out.println("|_________|");
			break;
		case 6:
			System.out.println(" ________");
			System.out.println(" |      |");
			System.out.println(" |      0");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|____");
			System.out.println("|     |___");
			System.out.println("|_________|");
			break;
		case 5:
			System.out.println(" ________");
			System.out.println(" |      |");
			System.out.println(" |      0");
			System.out.println(" |      |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|____");
			System.out.println("|     |___");
			System.out.println("|_________|");
			break;
		case 4:
			System.out.println(" ________");
			System.out.println(" |      |");
			System.out.println(" |      0");
			System.out.println(" |     /|");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("_|____");
			System.out.println("|     |___");
			System.out.println("|_________|");
			break;
		case 3:
			System.out.println(" ________");
			System.out.println(" |      |");
			System.out.println(" |      0");
			System.out.println(" |     /|");
			System.out.println(" |      |");
			System.out.println(" |");
			System.out.println("_|____");
			System.out.println("|     |___");
			System.out.println("|_________|");
			break;
		case 2:
			System.out.println(" ________");
			System.out.println(" |      |");
			System.out.println(" |      0");
			System.out.println(" |     /|");
			System.out.println(" |      |");
			System.out.println(" |     /");
			System.out.println("_|____");
			System.out.println("|     |___");
			System.out.println("|_________|");
			break;
		case 1:
			System.out.println(" ________");
			System.out.println(" |      |");
			System.out.println(" |      0");
			System.out.println(" |     /|");
			System.out.println(" |      |");
			System.out.println(" |     / \\");
			System.out.println("_|____");
			System.out.println("|     |___");
			System.out.println("|_________|");
			break;
		case 0:
			System.out.println(" ________");
			System.out.println(" |      |");
			System.out.println(" |      X");
			System.out.println(" |     /|\\");
			System.out.println(" |      |");
			System.out.println(" |     / \\");
			System.out.println("_|____");
			System.out.println("|     |___");
			System.out.println("|_________|");
			break;
		}
	}

	/**
	 * Visuell Hangman v.Gewonnen
	 */
	private void visualWin() {
		System.out.println(" ________");
		System.out.println(" |      |");
		System.out.println(" |        ");
		System.out.println(" |        ");
		System.out.println(" |      0 ");
		System.out.println(" |     \\|/  ");
		System.out.println("_|____  |  ");
		System.out.println("|     |/_\\_");
		System.out.println("|_________|");
		}
}
	