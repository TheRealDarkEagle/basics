package com.empirie.kai.uebungen.advanced.oop.pfandautomat.flaschen;


public class Pfandflasche extends Flasche {

	private Wert wert;
	
	public Pfandflasche(String marke, String volumen, Wert wert){
		super(marke, volumen);
		this.wert = wert;
	}
	
	public Wert getWert() {
		return this.wert;
	}

}