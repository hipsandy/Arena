package com.hipsandy.rassi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumerExample {

	public static void main(String[] args) {
		Storage storage = new Storage();
		Thread pThread = new Thread(new Producer(storage));
		Thread cThread = new Thread(new Consumer(storage));
		pThread.start();
		cThread.start();
	}

}

class Producer implements Runnable {
	
	Storage storage = null;
	
	Producer(Storage storage) {
		this.storage = storage;
	}
	
	@Override
	public void run() {
		Random ran = new Random();
		while(true) {
			int i = ran.nextInt(100);
			try {
				storage.add(i);
			} catch (InterruptedException e) {
				System.out.println("Error: Couldn't add " + i);
			}
		}
		
	}
}


class Consumer implements Runnable {
	
	Storage storage = null;
	
	Consumer(Storage storage) {
		this.storage = storage;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				storage.remove();
			} catch (InterruptedException e) {
				System.out.println("Error: Couldn't remove element");
			}
		}
		
	}
}

class Storage {
	
	static final int MAX_ALLOWED = 5;
	
	List<Integer> store = new ArrayList<>();
	
	public synchronized void add(int i) throws InterruptedException {
		while(store.size() >= MAX_ALLOWED) {
			wait();
		}
		if (store.size() < MAX_ALLOWED) {
			store.add(i);
			System.out.println("+++ Added value: " + i);
			// Use this to test randomness of addding and removing
//			if (i % 2 == 0) {
//				wait(10);
//			}
			notifyAll();
		}
	}
	
	public synchronized int remove() throws InterruptedException {
		while(store.size() <= 0) {
			wait();
		}
		if (store.size() > 0) {
			int i = store.remove(store.size() - 1);
			System.out.println("--- Removed value: " + i);
			notifyAll();
			return i;
		}
		throw new RuntimeException("Wrong notify signal came in");
	}
	
}
