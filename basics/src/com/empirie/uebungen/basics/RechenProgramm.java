package com.empirie.uebungen.basics;
public class RechenProgramm {

	public static void main(String[] args){
	
			// Variablenname = zahlEins
			// Typ = int
			// Wert = 5
			

			
			// Variablenname = meinTaschenrechner
			// Typ = Taschenrechner
			// Wert = neues Objekt vom Typ Taschenrechner
			
			Taschenrechner meinTaschenrechner = new Taschenrechner();
			
			double doubleEins = 10;
			//Ausgabe der Methoden(Funktionen)des erstellten Objektes "TaschenRechner"
			System.out.println(meinTaschenrechner.addition(doubleEins,20));
			System.out.println(meinTaschenrechner.subtraktion(doubleEins,20));
			System.out.println(meinTaschenrechner.multiplikation(doubleEins,20));
			System.out.println(meinTaschenrechner.division(doubleEins,20));
			
	}
}