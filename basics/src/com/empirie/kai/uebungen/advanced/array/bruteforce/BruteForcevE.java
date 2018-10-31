package com.empirie.kai.uebungen.advanced.array.bruteforce;


public class BruteForcevE {
	
	public boolean pwCheck = false;
	private char[] allowedChars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private String pw = "test";
	
	public static void main(String[] args) {
		new BruteForcevE().crackIt();

	}
	
	private void crackIt() {
		int size = 1;
		while(size <= 4) {
			this.crack(size, "");
			size++;
		}
	}
	
	private void crack(int size, String temp) {
		if(size == 0) {
			System.out.println(temp);
			return;
		}
		if(pwCheck==true) {
			return;
		}else {
			for(int i = 0; i < allowedChars.length; i++ ) {
				String appended = temp + allowedChars[i];
				if(appended.equals(pw)) {
					pwCheck = true;
					System.out.println("Ihr Passwort wurde gehackt! " + appended);
					return;
				}
				this.crack(size - 1, appended);
			}
		}
	}
}