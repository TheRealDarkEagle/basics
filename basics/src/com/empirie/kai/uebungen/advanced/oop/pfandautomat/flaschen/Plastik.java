package com.empirie.kai.uebungen.advanced.oop.pfandautomat.flaschen;

public class Plastik extends Pfandflasche {

	public Plastik(String marke, String volumen){
		super(marke, volumen, new Wert(0.25));
	}

}