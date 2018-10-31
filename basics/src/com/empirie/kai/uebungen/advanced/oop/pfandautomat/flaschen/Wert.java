package com.empirie.kai.uebungen.advanced.oop.pfandautomat.flaschen;


public class Wert{

	private double pfand;
	private String waehrung;
	
//Methode
	public Wert(double pfand){
		this.pfand = pfand;
		this.waehrung = "Cent";
	}
	
	public double getPfand() {
		return this.pfand;
	}
	
	public String getWaehrung() {
		return this.waehrung;
	}
}