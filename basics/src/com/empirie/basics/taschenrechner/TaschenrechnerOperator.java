package com.empirie.basics.taschenrechner;

public class TaschenrechnerOperator {
	/**
	 * Start des Taschenrechner´s
	 * @param task
	 * @return
	 */
	public String getResult(String task) {
		if(isValid(task)) {
			task = task.replaceAll(" ", "");
			System.out.print(task);
			task = setMultiplyPoint(task);
			System.out.print(" = ");
			System.out.println(extractInParentheses(task));
		}else {
			System.out.println("Fehler bei Ihrer Eingabe! Bitte Ueberpruefen!: "+ task);
		}
		return task;
	}
	/**
	 * Prüft die Eingabe auf gleiche Menge der Klammernpaare
	 * @param task
	 * @return
	 */
	private boolean isValid(String task) {
 		int counter = 0;
		char[] isValidArray = task.toCharArray();
		for(int i=0;i<isValidArray.length;i++) {
			if(isValidArray[i] == '(') {
				counter++;
			}else if(isValidArray[i] == ')'){
				counter--;
			}
		}if(counter == 0) {
			
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Gibt alles zwischen letzter ( und erster ) an searchForOperator weiter
	 * @param task
	 * @return
	 */
	private String extractInParentheses(String task){
		if(task.contains("(")||task.contains("+")||task.contains("-")||task.contains("*")||task.contains("/")){
			if(task.contains("(")) {													
				int openParentheses = task.lastIndexOf('(');															// letzte (
				int endingParentheses = task.indexOf(")", openParentheses);													// erste )
				String beforeParentheses = task.substring(0, openParentheses);												// alles vor letzter (
				String inParentheses = task.substring(openParentheses+1, endingParentheses);										// inhalt der Klammer
				String afterParentheses = task.substring(endingParentheses+1, task.length());								// alles nach erster ) 
				//Wenn Operator vorhanden und - nicht an erster Stelle
				if(inParentheses.contains("/")||
				   inParentheses.contains("*")||
				   inParentheses.contains("-")||
				   inParentheses.contains("+")&&
				   inParentheses.charAt(0)!='-') {
 					return extractInParentheses(task=beforeParentheses+extractInParentheses(searchForOperator(inParentheses))+afterParentheses);
				}
	 			return extractInParentheses(beforeParentheses+searchForOperator(inParentheses)+afterParentheses);
	 			//Wenn ein Operator vorhanden ist 
			}else if(task.contains("/")||
					 task.contains("*")||
					 task.contains("-")||
					 task.contains("+")){
				//Prüft ob Minus ein Vorzeichen ist und alleine steht
				if(task.charAt(0)=='-'){
					if(indexOfOperator(task)!=0) {
						return extractInParentheses(searchForOperator(task));
					}
					return task;
				}
				return extractInParentheses(searchForOperator(task));	
			}else {
				return task;
			}
		}
		return task;
	}
	/**
	 * Setzen des * vor geöffneter Klammer wenn kein anderer Operator vorhanden sein sollte
	 * @param task
	 * @return
	 */
	private String setMultiplyPoint(String task) {
		for(int i= 1;i<task.length();i++) {
			char openParentheses = task.charAt(i);
			if(openParentheses=='(') {
				char beforePhrase = task.charAt(i-1);

				/**  
				 * 		@todo - kann man hier ggf. kürzer abfragen ob "zuPruefen" eine Zahl ist oder nicht?  
				 */
				if(beforePhrase != '+'&&
				   beforePhrase != '-'&&
				   beforePhrase != '*'&&
				   beforePhrase != '/'&&
				   beforePhrase != '('  ){
					String beforeOpenParentheses = task.substring(0, i);		
					String afterOpenParentheses = task.substring(i, task.length());
					return setMultiplyPoint(task = beforeOpenParentheses+"*"+afterOpenParentheses);
				}
			}
		}
		return task;
	}
	/**
	 * Durchsucht Aufgabe auf Operator 
	 * @param task
	 * @return
	 */
	private String searchForOperator(String task) {
		if(task.contains("*")||task.contains("/")) {
			for(int i=1;i<task.length();i++) {
				if(task.charAt(i)=='*') {																						
					task = calculate(task,"*",i);
					return task;
				}else if(task.charAt(i)=='/'){																					
					task = calculate(task,"/",i);
					return task;
				}
			}
		}else if(task.contains("+")||task.contains("-")) {
			for(int i=1;i<task.length();i++) {
				if(task.charAt(i)=='+') {																						
					task = calculate(task,"+",i);
					return task;
				}else if(task.charAt(i)=='-'){																				
					task = calculate(task,"-",i);
					return task;
				}
			}
		}
		return task;
	}
	/**
	 * "Extrahiert" die linke zahl von Operator 
	 * @param task
	 * @param istOperator
	 * @return
	 */
	private String leftNumber(String task, int istOperator) {
		String left = task.substring(0, istOperator);
		for(int a = left.length()-1;a>-1;a--){
 			char zahlenStart=left.charAt(a);
 			if(zahlenStart=='*'||zahlenStart=='/'||zahlenStart=='+'||zahlenStart=='-' && a!=0) {
				left = left.substring(a+1, left.length());
				return left;
 			}else if(left.charAt(a)=='-' && left.charAt(a+1)=='-') {
 				return left= left.substring(a, left.length());
 			}
		}
		return left;
	}
		
	/**
	 * "Extrahiert" die rechte Zahl von Operator
	 * @param task
	 * @param istOperator
	 * @return
	 */
	private String rightNumber(String task, int istOperator) {
		String rightSide = task.substring(istOperator+1, task.length());
		int indexOfOperator = indexOfOperator(rightSide);
		if(indexOfOperator!=0) {
			rightSide = rightSide.substring(0, indexOfOperator);
			return rightSide;
			}
		return rightSide;
	}

	/**
	 * Berechnet linkeZahl mit rechteZahl -> gibt summe als String zurück
	 * @param task
	 * @param operator
	 * @param indexOperator
	 * @return
	 */
	private String calculate(String task, String operator, int indexOperator) {
		double summe;
		double numberLeftSide = Double.parseDouble(leftNumber(task,indexOperator));									// -> linke zahl  
		double numberRightSide = Double.parseDouble(rightNumber(task,indexOperator));								// -> rechte zahl 
		switch(operator) {
		case "*":
			summe = numberLeftSide*numberRightSide;
			break;
		case "/":
			summe = numberLeftSide/numberRightSide;
			break;
		case "+":
			summe = numberLeftSide+numberRightSide;
			break;
		case "-":
			summe = numberLeftSide-numberRightSide;
			break;
		default: 
			return task;
		} 
		//zuschneiden des Strings - einsetzen des Ergebnis
		String sumString = Double.toString(summe);
		String leftFactor = leftNumber(task,indexOperator);
		String rightFactor = rightNumber(task,indexOperator);
		int lengthLeft = leftFactor.length();
		int lengthRight = rightFactor.length()+1;
		String beforeLeftNumber = task.substring(0, indexOperator-(lengthLeft));
		String afterRightNumber = task.substring(indexOperator+(lengthRight));
		return task = beforeLeftNumber + sumString + afterRightNumber;		
	}
	/**
	 * durchsucht task nach Operator und gibt Stelle dessen zurück
	 * @param task
	 * @return
	 */
	private int indexOfOperator(String task) {
		for(int i = 1; i<task.length(); i++) {
			if(task.charAt(i)=='*'||
			   task.charAt(i)=='/'||
			   task.charAt(i)=='+'||
			   task.charAt(i)=='-') {
					return i;
			}
		}
		return 0;
	}
}