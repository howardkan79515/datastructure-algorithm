package queue;

public class MyCircularQueue {
	
	public static void main (String[] args) {
		MyCircularQueue queue = new MyCircularQueue(3);
//		queue.enQueue(1);
//		queue.enQueue(2);
//		queue.enQueue(3);
//		queue.enQueue(4);
//		queue.Rear();
//		queue.deQueue();
//		queue.enQueue(5);
//		queue.enQueue(6);
//		queue.enQueue(7);
//		queue.enQueue(8);
//		queue.deQueue();
//		
//		queue.enQueue(3);
//		queue.Front();
//		queue.deQueue();
//		queue.enQueue(3);
//		queue.deQueue();
//		
//		queue.Front();
//		queue.enQueue(1);
//		queue.enQueue(2);
//		queue.enQueue(3);
//		queue.enQueue(4);
//		queue.Rear();
		
		queue.enQueue(2);
		queue.Rear();
		queue.Front();
		queue.deQueue();
		queue.Front();
		queue.deQueue();
		queue.Front();
		queue.enQueue(4);
		queue.enQueue(2);
		queue.enQueue(2);
		queue.enQueue(3);

	}
	
	int[] queue; 
	
	int tail;
	
	int head;
	
	 /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.tail = 0;
        this.head = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
    	if(isFull()) {
    		return false;
    	}
    	if(tail == queue.length && head != 0) {
    		tail = 0;
    		queue[tail] = value;
    		tail++;
    		return true;
    	}
    	queue[tail] = value;
    	tail++;
		return true;       
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
    	if(tail == head) {
    		return false;
    	}
    	queue[head] = 0;
    	head++;
		return true;        
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if(tail == head) {
    		return -1;
    	}
    	int result = queue[head];
		return result;        
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	int result = queue[tail-1];
		return result;
        
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
    	if(tail == head) {
    		return true;
    	}
		return false;
        
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
    	if(head == (tail+1) || tail == queue.length && head == 0) {
    		return true;
    	}
		return false;       
    }

}
