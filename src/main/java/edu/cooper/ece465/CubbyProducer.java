package edu.cooper.ece465;

public class CubbyProducer extends Thread {
    private CubbyHole cubbyhole;
    private int number;
	private int numProduced;
 
    public CubbyProducer(CubbyHole c, int number) {
        cubbyhole = c;
		cubbyhole.addProducer();
        this.number = number;
		numProduced=0;
    }
 
    public void run() {
        for (int i = 0; i < ProducerConsumerTest.PROD_SIZE; i++) {
			numProduced++;
            cubbyhole.put(i);
            System.out.println("Producer #" + this.number
                               + " put: " + i);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
        }
		cubbyhole.subProducer();
		System.out.println("Producer #" + this.number + " produced: " + numProduced);
    }
}