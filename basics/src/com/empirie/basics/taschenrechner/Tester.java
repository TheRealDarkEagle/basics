package com.empirie.basics.taschenrechner;

public class Tester {

	public static void main(String[] args) {
		TaschenrechnerOperator to = new TaschenrechnerOperator();
		to.isValid("5/4");
		to.isValid("5(6+3-5)");
		to.isValid("6(5/6-5*5)*(2+3-4)");
		to.isValid("9(2+3)*(4+6)");
		to.isValid("46*5(4+69-741/2.5)");
		to.isValid("-1+(8*9-3/5(4+(5)-3/8)-5)/-2");
		to.isValid("1-2");
        to.isValid("8/(-2(3))");    
        to.isValid(" 2*-25.5");    
        to.isValid("-2-(-6)");    
        to.isValid("6-5+8.333332-15");    
        to.isValid("2+25");    
        to.isValid("1(1*(2+3))");
        
        System.out.println("Test Ausgabe");
        
        
        to.isValid("-2+((-6-3)-2)");    //-> hier endlos schleife
		to.isValid("(8 + 2) / 5  ");   // -> hier fehler
		to.isValid("2*3-5 + ((8 - (3 + 2) / 3 ) * 1 + 2 / 1) -15"); // hier fehler    
       // to.isValid("2*(-2+((-6-3)-2)/2-3+(-5-2*5))");   // -> endlos schleife
		}

}
