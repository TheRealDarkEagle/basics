package com.empirie.kai.uebungen.advanced.oop.pfandautomat.flaschen;

public class Flasche{

	private String marke;
	private String volumen;
	
//Methode
	public Flasche(String marke, String volumen) {
		this.marke = marke;
		this.volumen = volumen;
	}
	
	public String getMarke(){
		return this.marke;
	}
	
	public String getVolumen(){
		return this.volumen;
	}

	public Object getWert() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getPfand() {
		// TODO Auto-generated method stub
		return null;
	}
}