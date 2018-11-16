package work_from_home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResolveHangman {
	
	/**
	 * @TODO: 
	 * Überprüfen ob die Variablen die Global sind auch global sein müssen 
	 * 
	 * Variablen NICHT Static machen! 
	 * 
	 * Kommentare einfügen, wenn mehrere Operation in einer Methode ausgeführt werden, und erklären was gerade passiert
	 * 
	 * beziehungen zwischen den buchstaben einf�gen
	 * teste zweiten bis vorletzten buchstabe
	 * schaue davor und danach welche buchstaben dastehen
	 * speichere m�gliche variation in datei 
	 * wenn kein wort mehr in liste ist 
	 * gehe auf diese datei zur�ck 
	 * und schaue nach welche buchstaben man als besten f�r die leeren felder einsetzen k�nnte
	 * 
	 * z.b. Apf_ltasch_ wie oft kam bisher ein buchstabe nach einem f 
	 * wie oft kam bisher ein buchstabe nach einem h 
	 * wie oft kam bisher ein buchstabe vor w 
	 * anhand dessen buchstaben nehmen falls er noch nicht benutzt wurde  
	 *
	 * Genauigkeit erhöhen welche Listenelemente nicht entfernt  bzw entfernt werden
	 * Wenn der buchstabe öfter als 1x vorkommt - teste die restlichen stellen auch -> führt zu einer besseren Genauigkeit der Wörterauswahl 
	 */
	
	private String potencialChars = "abcdefghijklmnopqrstuvwxyzäöüß";
	private int[] countChars= new int[potencialChars.length()];
	private char[] amountOfCharsInWords = potencialChars.toCharArray();
	boolean checkedForLength = false; 
	private ArrayList<Character> usedChars = new ArrayList<Character>();
	private ArrayList<String> wordList;
	
	
	public ResolveHangman() throws IOException {
		this.wordList = this.loadWordsFromFile();
	}
	
	/**
	 * Trennt die Listenwörter voneinander und speichert sie in liste ab
	 * @param sb
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static ArrayList<String> splitWordsFromList(StringBuilder sb) throws FileNotFoundException, IOException {
		ArrayList<String> alSpli = new ArrayList<String>();
		int start = 0;
		int ende = 0;
		for(int i=0;i<sb.length();i++) {
			int zahl = sb.charAt(i);
				//13 = Zeilenumbruch
				if(zahl==13) {
				ende = i;
				String temp = sb.substring(start, ende);
				alSpli.add(temp);
			}
			//10 = Zeilenvorschub
			if(zahl==10) {
				start = i+1;
			}
			if(i==sb.length()-1) {
				//Wenn i am letzten buchstaben angekommen ist
				//ist dies mein letztes wort von anfang bis i+1
				ende = i+1;
				String temp = sb.substring(start, ende);
				alSpli.add(temp);
			}
		}
		return alSpli;
	}

	/**
	 * Läd alle Wörter aus Datei und gibt die aneinanderhängende Sammlunng an splitWordsFromList() weiter
	 * @return
	 * @throws IOException
	 */
	private ArrayList<String> loadWordsFromFile() throws IOException {
		try(InputStream is = new FileInputStream("D:\\Danz Kai Adrian empiriecom\\Hangman\\wortsammlung.txt")){
			byte[] buffer = new byte[1024];
			StringBuilder sb = new StringBuilder();
			
			int bytesRead = is.read(buffer);
			while(bytesRead > 0) {
				sb.append(new String(Arrays.copyOfRange(buffer, 0, bytesRead), "UTF-8"));
				bytesRead = is.read(buffer);
			}
		return (splitWordsFromList(sb));
		}
	}
	
	/**
	 * Findet den naechsten Buchstaben anhand aller Bekannten W�rter 
	 * @param theWord
	 * @return
	 */
	public char getChar(char[] theWord) {
		//Wenn usedChars == empty -> remove alle Einträge mit anderer Länge aus wordList
		if(usedChars.isEmpty()) {
			sortFromLength(theWord.length,wordList);
			return getCharToUse(amountOfCharsInWords);
		}else{
			countAndSort();
			testTheChar(theWord);
		}
		System.out.println(wordList);
		return getCharToUse(amountOfCharsInWords);
	}
	
	/**
	 * Prüfe ob zuletzt benutzter Buchstabe im Wort vorhanden war
	 * @param theWord
	 */
	private void testTheChar(char[] theWord) {
		Character lastUsed = usedChars.get(0);
		StringBuilder arrayIntoString = new StringBuilder();
		//Wenn letzter benutzter Buchstabe gleich  index 0 von theWord in groß ist groß ist 
		if(theWord[0]==Character.toUpperCase(lastUsed)) {
			Character checkFirstChar = theWord[0];
			lastUsed = checkFirstChar;
			// never 
			charExist(lastUsed=checkFirstChar, theWord);
		}else {
			for(int a=0; a<theWord.length;a++) {
				arrayIntoString = arrayIntoString.append(theWord[a]);
			}
			String hasTheWord = ""+arrayIntoString;
			hasTheWord.toLowerCase();
			if(hasTheWord.contains(lastUsed.toString())){
				charExist(lastUsed, theWord);
			}else {
				charDoesNotExist(lastUsed, theWord);
			}
		}
	}

	/**
	 * Entfernt alle Wörter, welche den zuletzt benutzten Buchstaben beinhalten
	 * @param charExist
	 * @param theWord
	 */
	private void charDoesNotExist(Character charExist,char[] theWord) {
		for(int a =0; a<wordList.size();a++) {
			Character lastUsed = Character.toUpperCase(charExist);
			if(wordList.get(a).contains(lastUsed.toString().toLowerCase()) || 
			   wordList.get(a).contains(lastUsed.toString())) {
					wordList.remove(a);
					a--;
			}
		}
	}
	

	/**
	 * Setzt alle Felder das Array countChars auf 0
	 */
	private void resetCounterFromcountCharacter() {
		for (int i = 0; i < countChars.length; i++) {
			countChars[i] = 0;
		}
	}
	
	/**
	 * Sucht aus der Liste alle w�rter mit der L�nge  des gesuchten Wortes heraus und l�scht die restlichen 
	 * @param lengthFromWord
	 * @param list
	 */
	private void sortFromLength(int lengthFromWord, ArrayList<String> list) {
		for (int i = 0; i < wordList.size(); i++) {
			int lengthWordInListe = wordList.get(i).length();
			if(lengthWordInListe!=lengthFromWord) {
				wordList.remove(i);
				i--;
			}
		}
		wordList.trimToSize();
		countAndSort();
	}
	
	/**
	 * Löscht alle Einträge der Liste, indenen der Buchstabe nicht an der selben Stelle vorhanden ist (ausgehend von dem ersten erscheinen des Buchstaben in theWord)
	 * @param charExist
	 * @TODO: Prüfe ob buchstabe vor stelle theWord vorkommt wenn ja remove aus liste  
	 */
	//Prüfe solange bis am letzten buchstaben angekommen 
	private void charExist(Character charExist,char[] theWord) {
		int indexOfChar=0;
		//Finde stelle des Buchstaben in theWord heraus
		for(int i =0;i<theWord.length;i++) {
			Character theWordCharAtIndex = theWord[i];
			if(theWordCharAtIndex==charExist) {
				indexOfChar = i;
				//teste ob eingesetzte stelle des buchstaben gleich der stelle im wort von wordList ist 
				for(int a=0;a<wordList.size();a++) {
					if(wordList.get(a).charAt(indexOfChar)!=charExist) {
						wordList.remove(a);
						a--;
					}
				}
			}
		}
		wordList.trimToSize();
		countAndSort();
	}
		
	/**
	 * aufrufen der Methoden: resetCounterFromDigitList,countCharacter,sortArrays
	 */
	private void countAndSort() {
		resetCounterFromcountCharacter();
		countCharacter(countChars,amountOfCharsInWords);
		sortArrays(countChars,amountOfCharsInWords);
	}
	
	
	/**
	 * Sucht anhand der Menge der Buchstaben in den Potentiellen W�rtern den h�ufigsten, noch nicht benutzten, Buchstaben heraus 
	 * @return char 
	 */
	private char getCharToUse(char[] amountOfCharsInAllWords) {
		int lastCharInArrayChars = amountOfCharsInAllWords.length-1;
		Character bestChar = amountOfCharsInAllWords[lastCharInArrayChars];
		String alreadyUsed = usedChars.toString();
		//solange buchstabe schon benutzt wurde -> teste nachfolgenden Buchstaben
		while(alreadyUsed.contains(bestChar.toString())){
			lastCharInArrayChars--;
			bestChar = amountOfCharsInAllWords[lastCharInArrayChars];
		}
		this.usedChars.add(0, bestChar);
		return bestChar;
	}
	
	/**
	 * Z�hlt alle Buchstaben durch die in der Liste vorhanden sind 
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
		int sizeOfList = wordList.size();
		StringBuilder sb = new StringBuilder(); 
		for(int a=0;a<sizeOfList;a++) {
			sb = sb.append(wordList.get(a));
		}
		String allWords = sb.toString();
		return allWords;
	}
	
	/**
	 * Sortiert countChars und allChars array nach h�ufigkeit hoechster zahl von CountChars (Via BubbleSort)
	 * @param countChars
	 * @param allChars
	 */
	private void sortArrays(int[] countChars, char[] allChars) {
		for(int o=0;o<allChars.length;o++) {
			for(int a=1;a<allChars.length;a++) {
				// wemm die Anzahl der vorkommenden Wörter unterschiedlich ist, dann tausche:
				if(countChars[a-1]>countChars[a]) {
					// die Anzahl miteinander
					int tempZahl = countChars[a];
					countChars[a] = countChars[a-1];
					countChars[a-1] = tempZahl;
					// die Buchstaben miteinander
					char tempChar = allChars[a];
					allChars[a] = allChars[a-1];
					allChars[a-1] = tempChar;
					
				}
			}
		}
	}
}