package main;

import singleton.Singleton;

public class App {

	public static void main(String[] args) {
		
		//Singleton singleton = new Singleton();
		
		Singleton sing = Singleton.getInstancia();
		
		System.out.println(sing);
		
		
		sing = Singleton.getInstancia();
		
		System.out.println(sing);
		
	}
	
}
