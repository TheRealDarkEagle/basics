package com.empirie.kai.uebungen.advanced.oop.pfandautomat;

import com.empirie.kai.uebungen.advanced.oop.pfandautomat.flaschen.*;
import java.util.Random;

public class PfandAutomat {

	public PfandAutomat(){

//Randomizer
		int x = new Random().nextInt(50) + 1;
//Array Flaschen anlegen
		Flasche[] pfandFlaschen = new Flasche[x];
		double summe = 0.00;

//Array in dem die Flaschen erstellt werde und "einwerfe"
		for(int i=0;i<pfandFlaschen.length;i++){
			int erzeugteFlasche = new Random().nextInt(100)+1;
			Flasche neueFlasche;
			if(erzeugteFlasche < 20){
				neueFlasche = new Plastik("Vio", "1.0 L");
			}else if(erzeugteFlasche < 40){
				neueFlasche = new Cola("0.5 L");
			}else if(erzeugteFlasche < 60){
				neueFlasche = new Fanta("0.5 L");
			} else if(erzeugteFlasche < 80){
				neueFlasche = new Becks("0.3 L");
			} else { 
				neueFlasche = new Weizen("0.5 L");
			}  
			
//wenn trinkflasche gebe aus:
//Ausgabe: Flasche nicht im Sortiment, bitte eine neue Flasche einwerfen!
			System.out.println(neueFlasche.getWert()+"\t"+neueFlasche.getPfand()+"\t"+ neueFlasche.getMarke()+"\t"+neueFlasche.getVolumen());
			//summe += neueFlasche.getWert()+neueFlasche.getPfand() * 100;
		}
		System.out.println();
		System.out.println("--------------");
		System.out.println();
		System.out.println("Summe = " + summe / 100 + " " +"Euro");
	}
}