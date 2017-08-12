package para_demo;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.println("Num Processors: " + Runtime.getRuntime().availableProcessors());
		
		for (int num_threads = 1; num_threads <= 16; num_threads++) {
			int num_items = 1000000000;
		
			Worker[] workers = new Worker[num_threads];
		
			long start = System.nanoTime();
		
			for (int i=0; i<num_threads; i++) {
				workers[i] = new Worker(num_items/num_threads);
				workers[i].start();
			}

			for (Worker w : workers) {
				try {
					w.join();
				} catch (InterruptedException e) {
				}
			}

			long end = System.nanoTime();
		
			System.out.println("Overall elapsed with " + num_threads + " threads: " + ((end-start)/1e9) + " seconds");
		}
	}
}

class Worker extends Thread {
	
	private int num_to_do;
	
	public Worker(int num_to_do) {
		this.num_to_do = num_to_do;
	}
	
	public void run() {
		Random rnd = new Random();
		for (int i=0; i<num_to_do; i++) {
			rnd.nextDouble();
		}
	}	
}
