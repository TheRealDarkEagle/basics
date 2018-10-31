package com.empirie.kai.uebungen.advanced.array.schiffeversenkenv1;

public class Gebiet{
		
//Eigenschaften
	private boolean feldWurdeBeschossen;
	private boolean schiffIstAufFeld;
	
//Konstruktor
	public Gebiet(){
		feldWurdeBeschossen	= false;
		schiffIstAufFeld	= false;
	}
	
//Methoden 
	public boolean beschiesseFeld(){
		feldWurdeBeschossen	= true;
		if(schiffIstAufFeld){
	
			return true;
		}
		else return false;
	}

	public void setzeSchiff(){
		schiffIstAufFeld	= true;
	}
	
	public boolean isFeldWurdeBeschossen(){
		return feldWurdeBeschossen;
	}
	
	public boolean isSchiff(){
		return schiffIstAufFeld;
	}
	
} 
//Ende der Klasse