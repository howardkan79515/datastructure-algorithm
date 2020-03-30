package thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemoClint {
	
	
	
	public static void main(String[] args) {
		List<String> outputScraper = new CopyOnWriteArrayList<>();	
		CountDownLatch countDownLatch = new CountDownLatch(5);
		ExecutorService exe = Executors.newFixedThreadPool(5);
		for(int i = 0 ; i < 5 ; i++) {
			Worker worker = new Worker(outputScraper, countDownLatch);
			exe.execute(worker);
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		outputScraper.add("Latch released");
		for(String value : outputScraper) {
			System.out.print(value);
		}
	}

}
