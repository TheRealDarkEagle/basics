package com.empirie.kai.uebungen.advanced.oop.pfandautomat.flaschen;

public class Glas extends Pfandflasche {

	public Glas(String marke, String volumen){
		super(marke, volumen, new Wert(0.08));

	}
}