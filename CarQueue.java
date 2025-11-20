// CarQueue for Thread Lab
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue implements Runnable{
	// Create a queue
	private Queue<Integer> queue = new LinkedList<>();
	// Create randomizer
	private Random randomizer = new Random();
	// create constructor whcih adds 5-6 random directions
	public CarQueue() {
		for(int index = 0; index < 6; index++) {
		queue.add((randomizer.nextInt(4)));
		}
	}
	
	// addToQueue method
	public void addToQueue(){
		// create the runnable object
		Runnable r1 = new Runnable() {
		@Override
		public void run() {
			try {
				while(true) {
					synchronized(queue) {
						// random direction
						queue.add((randomizer.nextInt(4)));
					}
					// pause for 1 second
					Thread.sleep(1000);
				}
			} 
			catch(InterruptedException e) {
				System.out.println("Interruption has occured.");
			}
		}
	};
		// create thread
		Thread thread = new Thread(r1);
		thread.start();
	}
	// create deleteQueue method
	public int deleteQueue() {
		synchronized(queue) {
		if(!queue.isEmpty()) {
			return queue.remove();
			}
		}
		// return -1 if queue is empty
		return -1;
	}

	// just so class works
	@Override
	public void run() {
		//
	}
}
