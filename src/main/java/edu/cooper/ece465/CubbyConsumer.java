package edu.cooper.ece465;

public class CubbyConsumer extends Thread {
    private CubbyHole cubbyhole;
    private int number;
	private int numConsumed;

    public CubbyConsumer(CubbyHole c, int number) {
		numConsumed = 0;
        cubbyhole = c;
        this.number = number;
    }
 
    public void run() {
        int value = 0;
        while (!cubbyhole.isDone()) {
            value = cubbyhole.get();
			if(value != -1) { //value = -1 if contents of cubbyhole have been removed
				numConsumed++;
				System.out.println("Consumer #" + this.number
                               + " got: " + value);
			}
        }
		System.out.println("Consumer #" + this.number
						   + " consumed: " + numConsumed);

    }
}