package queue;

import java.util.Arrays;

public class MyCircularQueue {
	
	public static void main(String[] args) {
		MyCircularQueue queue = new MyCircularQueue(3);
		System.out.print(queue.Rear());
		System.out.print(queue.Front());
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		queue.enQueue(8);
	}
	
	int[] queue;
	
	int head = 1;
	
	int tail = 1;
	

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k+1];
        Arrays.fill(queue, -1);
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
    	if(isFull()) {
    		return false;   
    	}
    	queue[tail] = value; 
    	if(tail < queue.length-1) {
    		tail++;
    	} else {
    		tail = 0;
    	}
		return true;       
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
    	if(head == tail) { 
    		return false;
    	}
    	queue[head] = -1;
    	if(head < queue.length-1) {
    		head++;
    	} else {
    		head = 0;
    	}
		return true;       
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if(isEmpty()) {
    		return -1;
    	}
		return queue[head];       
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if(isEmpty()) {
    		return -1;
    	}
    	int index = tail == 0 ? 
    			queue.length-1 : tail-1;
		return queue[index];        
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
    	if(head == tail) {
    		return true;
    	}
		return false;       
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
    	if(((tail+1) % queue.length) == head) {
    		return true;
    	}
		return false;
        
    }
}
