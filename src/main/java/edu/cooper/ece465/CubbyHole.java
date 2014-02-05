package edu.cooper.ece465;

public class CubbyHole {
    private int contents;
    private boolean available = false;
	private static int numProds = 0;
 
	public synchronized void addProducer() {
		numProds++;
		notifyAll();
	}
	public synchronized void subProducer() {
		numProds--;
		notifyAll();
	}
	
	public synchronized boolean isDone() {
		return numProds==0;
	}
	
    public synchronized int get() {
        while (!isDone() && available == false) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        available = false;
        notifyAll();
		int ret = contents;
		contents = -1;
        return ret;
    }
 
    public synchronized void put(int value) {
        while (!isDone() && available == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        contents = value;
        available = true;
        notifyAll();
    }
}