package com.empirie.basics.taschenrechner;

public class Tester {

	public static void main(String[] args) {
		
		TaschenrechnerOperator to = new TaschenrechnerOperator();

		to.getResult("5/4");
		to.getResult("5(6+3-5)");
		to.getResult("6(5/6-5*5)(2+3-4)");
		to.getResult("9(2+3)*(4+6)");
		to.getResult("46*5(4+69-741/2.5)");
		to.getResult("-1+(8*9-3/5(4+(5)-3/8)-5)/-2");
		to.getResult("1-2");
		to.getResult("8/(-2(3))");    
		to.getResult(" 2*-25.5");    
		to.getResult("-2-(-6)");    
		to.getResult("6-5+8.333332-15");    
		to.getResult("2+25");    
		to.getResult("1(1*(2+3))");
		to.getResult("-2+((-6-3)-2)");    //-> hier endlos schleife
		to.getResult("(8 + 2) / 5  ");   // -> hier fehler
		to.getResult("2*3-5 + ((8 - (3 + 2) / 3 ) * 1 + 2 / 1) -15"); // hier fehler    
		to.getResult("2*(-2+((-6-3)-2)/2-3+(-5-2*5))");   // -> endlos schleife
		to.getResult("(1/4-3/2)+(9*7/2)*(4+5)");
		to.getResult("2/4((4-6+8*5)/4(4+5-6))");
	}
}