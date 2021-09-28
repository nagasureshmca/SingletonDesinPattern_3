package com.infotech.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.infotech.singletion.Singleton;

public class Test {

	public static void main(String[] args) {
		ExecutorService executorService = null;
		try {
			 executorService = Executors.newFixedThreadPool(5);
			 
			 Runnable t1 = new Runnable() {
				
				@Override
				public void run() {
					for (int i = 1; i <=100; i++) {
						Singleton singleton = Singleton.getInstance();
						System.out.println(singleton.hashCode());
					}					
				}
			};
			
			Runnable t2 = new Runnable() {
				
				@Override
				public void run() {
					for (int i = 1; i <=100; i++) {
						Singleton singleton = Singleton.getInstance();
						System.out.println(singleton.hashCode());
					}					
				}
			};
			executorService.submit(t1);
			executorService.submit(t2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(executorService != null)
				executorService.shutdown();
		}
	}

}
