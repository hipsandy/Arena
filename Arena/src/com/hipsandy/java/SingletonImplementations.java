package com.hipsandy.java;

public class SingletonImplementations {

}

class Singleton1 {
	
	public static final Singleton1 INSTANCE = new Singleton1();
	
	private Singleton1() {}
	
	public void doSomething() {
		System.out.println("Doing something");
	}
}

class Singleton2 {
	
	private static final Singleton2 INSTANCE = new Singleton2();
	
	public static final Singleton2 getInstance() {
		// return new Singleton2(); // BIG WRONG !!!! RIDICULOUS TO DO THIS. THIS CREATES NEW INSTANCES.
		return INSTANCE;
	}
	
	private Singleton2() {}
	
	public void doSomething() {
		System.out.println("Doing something");
	}
}

enum Singleton3 {
	
	INSTANCE;
	
	public void doSomething() {
		System.out.println("Doing something");
	}
	
}
