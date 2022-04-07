import java.util.Random;

public class Concurrency{
	private static class ThreadArrayLoop implements Runnable {
		public void run() {
			int sum = 0;
			int count = 0;
			Random r = new Random();
			int[] arr = new int[1000];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = r.nextInt((10 - 1) + 1) + 1;
				sum += arr[i];
				count++;
				System.out.println(Thread.currentThread().getId() + "\tSum: " + sum + "\tCount: " + count);
			}			
		} 
	}		
	
	public static void main(String[] args)  throws InterruptedException {
		Thread t1 = new Thread (new ThreadArrayLoop()); 
		t1.start();
		Thread t2 = new Thread (new ThreadArrayLoop());
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	} //End Main
} //End Class