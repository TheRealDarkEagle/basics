package com.empirie.basics.fibonacci;

public class FibonacciZahlen{

	public static void main(String[] args){
	int a = 1;
	int b = 0;
	int c = 0;
		for(int x = 1; x <10; x++){
		b = a + c;
		System.out.println(a + "+" + c + "=" + b);
		c = b + a;
		System.out.println(a + "+" + b + "=" + c);
		a = b + c;
		System.out.println(c + "+" + b + "=" + a);
		}
	}
}