package com.infotech.singletion;

public class Singleton {
	private volatile static Singleton singleton;
	private Singleton() {
	}
	public static Singleton getInstance() {
		if (singleton == null) {
			// To make thread safe
			synchronized (Singleton.class) {
				// check again as multiple threads can reach above step
				if (singleton == null)
					singleton = new Singleton();
			}
		}
		return singleton;
	}
}